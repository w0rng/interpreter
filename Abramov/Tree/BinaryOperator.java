package Abramov.Tree;

import Abramov.Token;

public class BinaryOperator extends Node {
    public Node left, right;
    public Token operator;

    public BinaryOperator(Node left, Token operator, Node right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
}