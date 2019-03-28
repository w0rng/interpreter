package Abramov;

import Abramov.TokenTypes.Types;

class Lexer {

    String text;
    int pos;
    char currentChar;
    TokenTypes tokenTypes = new TokenTypes();

    public Lexer(String text) {
        this.text = text.replaceAll("\\s", "");
        pos = 0;
        currentChar = text.charAt(pos);
    }

    private void dropError() {
        System.err.println("Не верный символ в позиции " + (pos + 1));
        System.exit(-1);
    }

    private char NextChar() {
        pos++;
        if (pos > text.length() - 1)
            return '\0';
        else
            return text.charAt(pos);
    }

    private void getNextChar() {
        currentChar = NextChar();
    }

    private String integer() {
        String result = "";
        while (Character.isDigit(currentChar) && currentChar != '\0') {
            result += currentChar;
            getNextChar();
        }
        return result;
    }

    private Token id() {
        String result = "";
        while (currentChar != '\0' && Character.isLetterOrDigit(currentChar)) {
            result += currentChar;
            getNextChar();
        }
        if (TokenTypes.contain(result))
            return TokenTypes.get(result);
        else
            return new Token(Types.ID, result);
    }

    Token getNextToken() {
        while (currentChar != '\0') {
            if (currentChar == ' ') {
                continue;
            } else if (Character.isLetter(currentChar)) {
                return id();
            } else if (Character.isDigit(currentChar)) {
                return new Token(Types.INT, integer());
            } else if (TokenTypes.contain(Character.toString(currentChar))) {
                Token tmp = TokenTypes.get(Character.toString(currentChar));
                getNextChar();
                return tmp;
            } else
                dropError();
        }
        return new Token(Types.EOF, "\0");
    }
}