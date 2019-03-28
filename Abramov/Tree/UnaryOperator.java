package Abramov.Tree;

import Abramov.Token;

public class UnaryOperator extends Node {
    public Node right;

    public UnaryOperator(Token token, Node right) {
        super(token);
        this.right = right;
    }
}