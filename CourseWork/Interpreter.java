package CourseWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import CourseWork.Tree.*;

// Класс отвечает за интерпретацию синтаксического дерева
public class Interpreter {

    Parser parser; // Объект парсера
    // Буфер для пременных
    // Названию сопоставляется значение
    private static Map<String, Float> Scope = new HashMap<String, Float>();

    // Конструктор
    public Interpreter(Parser parser) {
        this.parser = parser;
    }

    // Вывод ошибок
    private void dropError() {
        System.err.println("Ошибка интерпретации");
        System.exit(-1);
    }

    // Интерпретация унарных операторов
    float visitUnOp(UnaryOperator node) {
        switch (node.token.type) {
        case PLUS:
            return visit(node.right);
        case MINUS:
            return -visit(node.right);
        default:
            return 0;
        }
    }

    // Интерпретация бинарных операторов
    float visitBinOp(BinaryOperator node) {
        switch (node.token.type) {
        case PLUS:
            return visit(node.left) + visit(node.right);
        case MINUS:
            return visit(node.left) - visit(node.right);
        case MUL:
            return visit(node.left) * visit(node.right);
        case DIV:
            return visit(node.left) / visit(node.right);
        case MORE:
            return (visit(node.left) > visit(node.right)) ? 1 : 0;
        case LESS:
            return (visit(node.left) < visit(node.right)) ? 1 : 0;
        default:
            return 0;
        }

    }

    // Интерпретация вложеных элементов
    float visitCompound(Compound node) {
        for (Node child : node.get())
            visit(child);
        return 0;
    }

    // Интерпретация равно
    float visitAssign(Assign node) {
        // Получаем название пременной
        String varName = node.left.token.value;
        // Записывем его в букфер и интерпретируем правую часть равно
        Scope.put(varName, visit(node.right));
        return 0;
    }

    // Интерпретация пременных
    float visitVar(Var node) {
        // Получаем название пременной
        String name = node.token.value;
        // Если в буфере нет такого, дропаем ошибку
        if (!Scope.containsKey(name))
            dropError();
        // Возвращаем значение
        return Scope.get(name);
    }

    // Интерпретация числе
    float visitNum(Num node) {
        return node.getValue();
    }

    // Интерпретация условий
    float visitCondition(Condition cond) {
        if (visit(cond.condition) != 0)
            visit(cond.children);
        return 0;
    }

    // Интерпретация циклов
    float visitLoop(Loop loop) {
        if (visit(loop.condition) != 0) {
            visit(loop.children);
            visitLoop(loop);
        }
        return 0;
    }

    // Интерпретация метода вывода в консоль
    float visitPrint(Print node) {
        Print f = (Print) node;
        Var v = (Var) f.param;
        System.out.print(visitVar(v));
        return 0;
    }

    // Интерпретация методы чтения из сконсоли
    float visitScan(Scan node) {
        Scan f = (Scan) node;
        Var v = (Var) f.param;
        System.out.print(v.token.value + " = ");
        Scanner in = new Scanner(System.in);
        float tmp = in.nextInt();
        Scope.put(v.token.value, tmp);
        in.close();
        return 0;
    }

    // Метод отвечает за определение типа узла
    // Тип определяется по названию класса
    // Как только тип определн, объект узла передается в метод, который умеет его
    // обрабатывнить
    float visit(Node node) {
        switch (node.getClass().getSimpleName()) {
        case "Assign":
            return visitAssign((Assign) node);
        case "BinaryOperator":
            return visitBinOp((BinaryOperator) node);
        case "Compound":
            return visitCompound((Compound) node);
        case "Num":
            return visitNum((Num) node);
        case "UnaryOperator":
            return visitUnOp((UnaryOperator) node);
        case "Var":
            return visitVar((Var) node);
        case "Condition":
            return visitCondition((Condition) node);
        case "Loop":
            return visitLoop((Loop) node);
        case "Print":
            return visitPrint((Print) node);
        case "Scan":
            return visitScan((Scan) node);
        default:
            return 0;
        }
    }

    // Метод начала интерпретации
    void interpret() {
        Node tree = parser.parse();
        visit(tree);
    }
}