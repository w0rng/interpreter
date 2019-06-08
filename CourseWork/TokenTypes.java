package CourseWork;

import java.util.HashMap;
import java.util.Map;
import CourseWork.Token;

// Данный класс отвечат за токены
public class TokenTypes {
    private static Map<String, Token> Tokens = new HashMap<String, Token>();

    // Список всех токенов
    public static enum Types {
        EOF, INT, PLUS, LPLUS, MINUS, MUL, LMUL, DIV, MORE, LESS, LPAREN, RPAREN, LBRACE, RBRACE, ID, ASSIGN, SEMI, IF,
        WHILE, PRINT, SCAN,
    }

    // Слова, с которыми ассоциируются токены
    public TokenTypes() {
        Tokens.put("+", new Token(Types.PLUS, "+"));
        Tokens.put("-", new Token(Types.MINUS, "-"));
        Tokens.put("*", new Token(Types.MUL, "*"));
        Tokens.put("/", new Token(Types.DIV, "/"));

        Tokens.put("&", new Token(Types.LMUL, "&"));
        Tokens.put("|", new Token(Types.LPLUS, "|"));
        Tokens.put(">", new Token(Types.MORE, ">"));
        Tokens.put("<", new Token(Types.LESS, "<"));

        Tokens.put("(", new Token(Types.LPAREN, "("));
        Tokens.put(")", new Token(Types.RPAREN, ")"));
        Tokens.put("{", new Token(Types.LBRACE, "{"));
        Tokens.put("}", new Token(Types.RBRACE, "}"));

        Tokens.put("\0", new Token(Types.EOF, "\0"));
        Tokens.put("=", new Token(Types.ASSIGN, "="));
        Tokens.put(";", new Token(Types.SEMI, ";"));

        Tokens.put("if", new Token(Types.IF, "if"));
        Tokens.put("while", new Token(Types.WHILE, "while"));
        Tokens.put("print", new Token(Types.PRINT, "print"));
        Tokens.put("scan", new Token(Types.SCAN, "scan"));
    }

    // Получение объкута тоукна по его названию
    public static Token get(String key) {
        return Tokens.get(key);
    }

    // Получение всех названий токенов
    public static String[] getKeys() {
        return Tokens.keySet().toArray(new String[0]);
    }

    // Проверка, существуюет ли токен
    public static boolean contain(String key) {
        return Tokens.containsKey(key);
    }
}