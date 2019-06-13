package CourseWork;

import java.io.File;
import java.util.Scanner;

// Главный класс программы
class Main {

    public static void main(String[] args) throws Exception {
        // Считывание файла из аргументов командой строки
        Scanner sc = new Scanner(new File(args[0]));
        String code = "";
        while (sc.hasNextLine())
            code += sc.nextLine();
        sc.close();
        // Создание объекта лексара
        Lexer lexer = new Lexer(code);
        // Создание объекта парсера
        Parser parser = new Parser(lexer);
        // Создание объекта интерпретатора
        Interpreter interpreter = new Interpreter(parser);
        // Интерпретирование программы
        interpreter.interpret();
    }
}

