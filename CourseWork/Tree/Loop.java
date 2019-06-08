package CourseWork.Tree;

// Класс, отвечающий за циклы
public class Loop extends Node {
    // Условние
    public Node condition;
    // Вложенные эллементы
    public Node children;

    // Конструктор
    public Loop(Node condition, Node children) {
        this.condition = condition;
        this.children = children;
    }
}