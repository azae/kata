package net.azae.kata.rpn.ast;

public class BinaryOperatorNode implements Node {
    private final BinaryOperators operator;
    private final Node left;
    private final Node right;

    public BinaryOperatorNode(final BinaryOperators operator, final Node left, final Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public BinaryOperators getOperator() {
        return operator;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void accept(final NodeVisitor visitor) {
        visitor.visitBinaryOperator(this);
    }
}
