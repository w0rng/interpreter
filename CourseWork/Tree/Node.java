package CourseWork.Tree;

import CourseWork.Token;

// Класс, от которого наследуются все другие типы узлов
// Необходим, чтобы можно было работать с узлами разных типов в одним методах
public class Node {
    // Токен узла
    public Token token;

    // Конструктор
    public Node(Token token) {
        this.token = token;
    }

    // Конструктор
    public Node() {
    }

    // Метод, необходимый для отладки
    public String toString() {
        return "Node(\n\t" + token + "\n)";
    }

}