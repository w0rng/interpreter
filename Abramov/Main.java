package Abramov;

class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer("2 -- (-2)");
        Parser parser = new Parser(lexer);
        Interpreter interpreter = new Interpreter(parser);
        System.out.println(interpreter.interpret());
    }
}