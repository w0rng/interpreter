package Abramov;

import Abramov.Token.TokenTypes;

class Lexer {

    String text;
    int pos;
    char currentChar;

    public Lexer(String text) {
        this.text = text.replaceAll("\\s", "");
        pos = 0;
        currentChar = text.charAt(pos);
    }

    private void dropError() {
        System.err.println("Неправильный символ");
    }

    private void getNextChar() {
        pos++;
        if (pos > text.length() - 1)
            currentChar = '\u0000';
        else
            currentChar = text.charAt(pos);
    }

    private int integer() {
        String result = "";
        while (Character.isDigit(currentChar) && currentChar != '\u0000') {
            result += currentChar;
            getNextChar();
        }
        return Integer.valueOf(result);
    }

    Token getNextToken() {
        while (currentChar != '\u0000') {
            if (Character.isDigit(currentChar)) {
                return new Token<Integer>(TokenTypes.INT, integer());
            } else if (currentChar == '+') {
                getNextChar();
                return new Token<String>(TokenTypes.PLUS, "+");
            } else if (currentChar == '-') {
                getNextChar();
                return new Token<String>(TokenTypes.MINUS, "-");
            } else if (currentChar == '*') {
                getNextChar();
                return new Token<String>(TokenTypes.MUL, "*");
            } else if (currentChar == '/') {
                getNextChar();
                return new Token<String>(TokenTypes.DIV, "/");
            } else if (currentChar == '(') {
                getNextChar();
                return new Token<String>(TokenTypes.LPAREN, "(");
            } else if (currentChar == ')') {
                getNextChar();
                return new Token<String>(TokenTypes.RPAREN, ")");
            }
            dropError();
        }
        return new Token<Integer>(TokenTypes.EOF, 0);
    }
}