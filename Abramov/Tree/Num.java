package Abramov.Tree;

import Abramov.Token;

public class Num extends Node {

    public Num(Token token) {
        super(token);
    }

    public int getValue() {
        return Integer.parseInt(token.value);
    }
}