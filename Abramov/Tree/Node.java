package Abramov.Tree;

import Abramov.Token;

public class Node {
    public Token token;

    public Node(Token token) {
        this.token = token;
    }

    public Node() {
    }

    public String toString() {
        return "Node(\n\t" + token + "\n)";
    }

}