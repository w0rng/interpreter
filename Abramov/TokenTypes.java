package Abramov;

import java.util.HashMap;
import java.util.Map;
import Abramov.Token;

public class TokenTypes {
    private static Map<String, Token> Tokens = new HashMap<String, Token>();

    public static enum Types {
        EOF, INT, PLUS, MINUS, MUL, DIV, LPAREN, RPAREN, LBRACE, RBRACE, ID, ASSIGN, SEMI, CLASS
    }

    public TokenTypes() {
        Tokens.put("\0", new Token(Types.EOF, "\0"));
        Tokens.put("+", new Token(Types.PLUS, "+"));
        Tokens.put("-", new Token(Types.MINUS, "-"));
        Tokens.put("*", new Token(Types.MUL, "*"));
        Tokens.put("/", new Token(Types.DIV, "/"));
        Tokens.put("(", new Token(Types.LPAREN, "("));
        Tokens.put(")", new Token(Types.RPAREN, ")"));
        Tokens.put("{", new Token(Types.LBRACE, "{"));
        Tokens.put("}", new Token(Types.RBRACE, "}"));
        Tokens.put("=", new Token(Types.ASSIGN, "="));
        Tokens.put(";", new Token(Types.SEMI, ";"));
        Tokens.put("class", new Token(Types.CLASS, "class"));
    }

    public static Token get(String key) {
        return Tokens.get(key);
    }

    public static String[] getKeys() {
        return Tokens.keySet().toArray(String[]::new);
    }

    public static boolean contain(String key) {
        return Tokens.containsKey(key);
    }
}