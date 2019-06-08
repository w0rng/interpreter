package CourseWork.Tree;

// Класс отвечающий за метод вывода в консоль
public class Print extends Node {
    // Значения, которые надо вывести
    public Node param;

    // Конструктор
    public Print(Node param) {
        this.param = param;
    }
}