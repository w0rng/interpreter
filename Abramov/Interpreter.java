package Abramov;

import Abramov.Token.TokenTypes;

class Interpreter {
    Parser parser;

    public Interpreter(Parser parser) {
        this.parser = parser;
    }

    int visit_UnOp(Node node) {
        if (node.token.type == TokenTypes.PLUS)
            return visit(node.right);
        else
            return -visit(node.right);
    }

    int visit_BinOp(Node node) {
        switch (node.token.type) {
        case PLUS:
            return visit(node.left) + visit(node.right);
        case MINUS:
            return visit(node.left) - visit(node.right);
        case MUL:
            return visit(node.left) * visit(node.right);
        case DIV:
            return visit(node.left) / visit(node.right);
        default:
            return 0;
        }
    }

    int visit(Node node) {
        if (node.token.type == TokenTypes.INT)
            return (int) node.token.value;
        else if (node.left != null)
            return visit_BinOp(node);
        else
            return visit_UnOp(node);
    }

    int interpret() {
        Node tree = parser.parse();
        return visit(tree);
    }
}