package CourseWork.Tree;

// Класс отвечающий за стравнения
public class Condition extends Node {
    // Условие сравнения
    public Node condition;
    // Вложенные элементы, которые будут выполняться
    public Node children;

    // Консруктор
    public Condition(Node condition, Node children) {
        this.condition = condition;
        this.children = children;
    }
}