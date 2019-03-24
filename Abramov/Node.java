package Abramov;

class Node {
    Node left, right;
    Token token;

    // Binare operators
    public Node(Node left, Token operator, Node right) {
        this.left = left;
        this.token = operator;
        this.right = right;
    }

    // unary operators
    public Node(Token operator, Node right) {
        this.token = operator;
        this.right = right;
    }

    // Numbers
    public Node(Token token) {
        this.token = token;
    }
}