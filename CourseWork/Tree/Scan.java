package CourseWork.Tree;

// Класс, отвечающий за метод чтения из консоли
public class Scan extends Node {
    // Переменная, в которую надо записать
    public Node param;

    // Конструктор
    public Scan(Node param) {
        this.param = param;
    }
}