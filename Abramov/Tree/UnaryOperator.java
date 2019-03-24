package Abramov.Tree;

import Abramov.Token;

public class UnaryOperator extends Node {
    public Node right;
    public Token operator;

    public UnaryOperator(Token operator, Node right) {
        this.operator = operator;
        this.right = right;
    }
}