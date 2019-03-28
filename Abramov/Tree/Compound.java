package Abramov.Tree;

import java.util.ArrayList;

public class Compound extends Node {
    ArrayList<Node> children = new ArrayList<Node>();

    public Compound() {
    }

    public void add(Node node) {
        children.add(node);
    }

    public Node[] get() {
        return children.toArray(Node[]::new);
    }
}