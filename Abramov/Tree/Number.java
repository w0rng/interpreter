package Abramov.Tree;

import Abramov.Token;

public class Number extends Node {

    public int value;

    public Number(Token token) {
        value = (int) token.value;
    }
}