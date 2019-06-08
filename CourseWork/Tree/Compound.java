package CourseWork.Tree;

import java.util.ArrayList;

// Класс отвечающих за вложенные элементы
public class Compound extends Node {
    // Список вложенных элементов
    ArrayList<Node> children = new ArrayList<Node>();

    // Добалвение вложенных элементов
    public void add(Node node) {
        children.add(node);
    }

    // Проучение списка элементов
    public Node[] get() {
        return children.toArray(new Node[0]);
    }
}