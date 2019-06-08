package CourseWork.Tree;

import CourseWork.Token;

// Класс, отвечающий за цифры
public class Num extends Node {

    // Конструктор
    public Num(Token token) {
        super(token);
    }

    // Метод получения значения
    public int getValue() {
        return Integer.parseInt(token.value);
    }
}