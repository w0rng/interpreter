package Abramov;

import java.util.Arrays;
import Abramov.Tree.*;
import Abramov.Tree.Number;
import Abramov.Token.TokenTypes;

class Parser {
    private Token currentToken;
    private Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        currentToken = lexer.getNextToken();
    }

    private void dropError() {
        System.err.println("Неверный синтаксис");
        System.exit(-1);
    }

    private void want(TokenTypes tokenType) {
        if (currentToken.type == tokenType)
            currentToken = lexer.getNextToken();
        else
            dropError();
    }

    private Node factor() {
        Token token = currentToken;
        if (token.type == TokenTypes.PLUS) {
            want(TokenTypes.PLUS);
            return new UnaryOperator(token, factor());
        } else if (token.type == TokenTypes.MINUS) {
            want(TokenTypes.MINUS);
            return new UnaryOperator(token, factor());
        } else if (token.type == TokenTypes.INT) {
            want(TokenTypes.INT);
            return new Number(token);
        } else if (token.type == TokenTypes.LPAREN) {
            want(TokenTypes.LPAREN);
            Node node = expr();
            want(TokenTypes.RPAREN);
            return node;
        } else {
            dropError();
            return null;
        }
    }

    private Node term() {
        Node node = factor();
        while (currentToken.type == TokenTypes.DIV || currentToken.type == TokenTypes.MUL) {
            Token token = currentToken;
            if (token.type == TokenTypes.MUL)
                want(TokenTypes.MUL);
            else if (token.type == TokenTypes.DIV)
                want(TokenTypes.DIV);
            node = new BinaryOperator(node, token, factor());
        }
        return node;
    }

    private Node expr() {
        Node node = term();
        while (currentToken.type == TokenTypes.PLUS || currentToken.type == TokenTypes.MINUS) {
            Token token = currentToken;
            if (token.type == TokenTypes.PLUS)
                want(TokenTypes.PLUS);
            else if (token.type == TokenTypes.MINUS)
                want(TokenTypes.MINUS);
            node = new BinaryOperator(node, token, term());
        }
        return node;
    }

    Node parse() {
        return expr();
    }
}