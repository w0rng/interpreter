package Abramov;

import Abramov.Tree.*;
import Abramov.Tree.Number;
import Abramov.Token.TokenTypes;

public class Interpreter {
    Parser parser;

    public Interpreter(Parser parser) {
        this.parser = parser;
    }

    int visit_UnOp(UnaryOperator node) {
        if (node.operator.type == TokenTypes.PLUS)
            return visit(node.right);
        else
            return -visit(node.right);
    }

    int visit_BinOp(BinaryOperator node) {
        switch (node.operator.type) {
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

    int visit_num(Number node) {
        return node.value;
    }

    int visit(Node node) {
        if (node instanceof Number)
            return visit_num((Number) node);
        else if (node instanceof BinaryOperator)
            return visit_BinOp((BinaryOperator) node);
        else
            return visit_UnOp((UnaryOperator) node);
    }

    int interpret() {
        Node tree = parser.parse();
        return visit(tree);
    }
}