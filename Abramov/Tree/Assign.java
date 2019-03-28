package Abramov.Tree;

import Abramov.Token;

public class Assign extends Node {
    public Node left, right;

    public Assign(Node left, Token token, Node right) {
        super(token);
        this.left = left;
        this.right = right;
    }
}