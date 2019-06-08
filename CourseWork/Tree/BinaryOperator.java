package CourseWork.Tree;

import CourseWork.Token;

// Класс отвечает за все бинарные опреаторы
// Сложение, вычитание и т.д.
public class BinaryOperator extends Node {
    // Элементы слева и справа от опреатора
    public Node left, right;

    // Конструктор
    public BinaryOperator(Node left, Token token, Node right) {
        super(token);
        this.left = left;
        this.right = right;
    }
}