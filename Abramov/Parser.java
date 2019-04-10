package Abramov;

import java.util.ArrayList;

import Abramov.TokenTypes.Types;
import Abramov.Tree.*;

class Parser {
    private Token currentToken;
    private Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        currentToken = lexer.getNextToken();
    }

    private void dropError(String wanted, String received) {
        System.err.println("Неверный синтаксис\n" + "Хотел " + wanted + ", получил " + received);
        System.exit(-1);
    }

    private void want(TokenTypes.Types tokenType) {
        if (currentToken.type == tokenType)
            currentToken = lexer.getNextToken();
        else {
            dropError(tokenType.name(), currentToken.type.name());
        }
    }

    private Node program() {
        Token token = currentToken;
        want(Types.CLASS);
        String funcName = variable().token.value;
        ProgClass clss = new ProgClass(token, funcName, compound_statement());
        want(Types.EOF);
        return clss;
    }

    private Node compound_statement() {
        want(Types.LBRACE);
        Node[] nodes = statement_list();
        want(Types.RBRACE);

        Compound root = new Compound();
        for (Node node : nodes) {
            root.add(node);
        }
        return root;
    }

    private Node[] statement_list() {
        ArrayList<Node> result = new ArrayList<Node>();
        result.add(statement());
        while (currentToken.type == Types.SEMI) {
            want(Types.SEMI);
            result.add(statement());
        }
        return result.toArray(Node[]::new);

    }

    private Node statement() {
        switch (currentToken.type) {
        case LBRACE:
            return compound_statement();
        case ID:
            return assignment_statement();
        default:
            return new Node();
        }
    }

    private Node assignment_statement() {
        Node left = variable();
        Token token = currentToken;
        want(Types.ASSIGN);
        return new Assign(left, token, expr());
    }

    private Node variable() {
        Var node = new Var(currentToken);
        want(Types.ID);
        return node;
    }

    private Node factor() {
        Token token = currentToken;
        switch (token.type) {
        case PLUS:
        case MINUS:
            want(token.type);
            return new UnaryOperator(token, factor());
        case INT:
            want(token.type);
            return new Num(token);
        case LPAREN:
            want(token.type);
            Node node = expr();
            want(Types.RPAREN);
            return node;
        default:
            return variable();
        }
    }

    private Node term() {
        Node node = factor();
        while (currentToken.type == Types.DIV || currentToken.type == Types.MUL) {
            Token token = currentToken;
            want(token.type);
            node = new BinaryOperator(node, token, factor());
        }
        return node;
    }

    private Node expr() {
        Node node = term();
        while (currentToken.type == Types.PLUS || currentToken.type == Types.MINUS) {
            Token token = currentToken;
            want(token.type);
            node = new BinaryOperator(node, token, term());
        }
        return node;
    }

    Node parse() {
        Node node = program();
        if (currentToken.type != Types.EOF)
            dropError(Types.EOF.name(), currentToken.type.name());
        return node;
    }
}