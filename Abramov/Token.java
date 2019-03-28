package Abramov;

public class Token {

    public TokenTypes.Types type;
    public String value;

    public Token(TokenTypes.Types type, String value) {
        this.type = type;
        this.value = value;
    }

    public String toString() {
        return "Token(" + type.name() + " : '" + value.toString() + "')";
    }
}