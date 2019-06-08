package CourseWork.Tree;

import CourseWork.Token;

// Унарный опреатор
public class UnaryOperator extends Node {
    // Эллемент, над которым совершается действие
    public Node right;

    // Конструктор
    public UnaryOperator(Token token, Node right) {
        super(token);
        this.right = right;
    }
}