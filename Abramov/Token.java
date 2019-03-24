package Abramov;

public class Token<Type> {

    public enum TokenTypes {
        EOF, ERR, INT, PLUS, MINUS, MUL, DIV, LPAREN, RPAREN
    }

    public TokenTypes type;
    public Type value;

    public Token(TokenTypes type, Type value) {
        this.type = type;
        this.value = value;
    }

    public String str() {
        return String.format("Token(%s:%s)", type.name(), value.toString());
    }
}