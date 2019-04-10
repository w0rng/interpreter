package Abramov;

import java.util.HashMap;
import java.util.Map;

import Abramov.Tree.*;

public class Interpreter {
    Parser parser;
    private static Map<String, Integer> Scope = new HashMap<String, Integer>();

    boolean start = true;

    public Interpreter(Parser parser) {
        this.parser = parser;
    }

    private void dropError() {
        System.err.println("Ошибка интерпретации");
        System.exit(-1);
    }

    int visitUnOp(UnaryOperator node) {
        switch (node.token.type) {
        case PLUS:
            return visit(node.right);
        case MINUS:
            return -visit(node.right);
        default:
            return 0;
        }
    }

    int visitBinOp(BinaryOperator node) {
        switch (node.token.type) {
        case PLUS:
            return visit(node.left) + visit(node.right);
        case MINUS:
            return visit(node.left) - visit(node.right);
        case MUL:
            return visit(node.left) * visit(node.right);
        case DIV:
            return visit(node.left) / visit(node.right);
        default:
            return 0;
        }

    }

    void visitCompound(Compound node) {
        for (Node child : node.get()) {
            visit(child);
        }
    }

    void visitAssign(Assign node) {
        String varName = node.left.token.value;
        if (Scope.containsKey(varName))
            Scope.remove(varName);
        Scope.put(varName, visit(node.right));
    }

    int visitVar(Var node) {
        String name = node.token.value;
        if (!Scope.containsKey(name))
            dropError();
        int val = Scope.get(name);
        return val;
    }

    int visitNum(Num node) {
        return node.getValue();
    }

    void visitProgClass(ProgClass func) {
        visit(func.children);
    }

    int visit(Node node) {
        switch (node.getClass().getSimpleName()) {
        case "ProgClass":
            visitProgClass((ProgClass) node);
            return 0;
        case "Assign":
            visitAssign((Assign) node);
            return 0;
        case "BinaryOperator":
            return visitBinOp((BinaryOperator) node);
        case "Compound":
            visitCompound((Compound) node);
            return 0;
        case "Num":
            return visitNum((Num) node);
        case "UnaryOperator":
            return visitUnOp((UnaryOperator) node);
        case "Var":
            return visitVar((Var) node);
        default:
            return 0;
        }
    }

    int interpret() {
        Node tree = parser.parse();
        visit(tree);
        System.out.println(Scope.toString());
        return 0;
    }
}