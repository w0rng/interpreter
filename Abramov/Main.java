package Abramov;

import java.io.File;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\U\\Desktop\\Interpreter\\Abramov\\test.IMP");
        Scanner sc = new Scanner(file);
        String code = "";
        while (sc.hasNextLine()) {
            code += sc.nextLine();
        }
        sc.close();
        Lexer lexer = new Lexer(code);
        Parser parser = new Parser(lexer);
        Interpreter interpreter = new Interpreter(parser);
        interpreter.interpret();
        // System.out.println(interpreter.interpret());
    }
}