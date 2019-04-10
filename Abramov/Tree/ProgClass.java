package Abramov.Tree;

import Abramov.Token;

public class ProgClass extends Node {
    public String name;
    public Node children;

    public ProgClass(Token token, String name, Node children) {
        super(token);
        this.name = name;
        this.children = children;
    }
}