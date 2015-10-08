package net.azae.kata.rpn.ast;

public class UnaryOperatorNode implements Node {
    private final UnaryOperators operator;
    private final Node child;

    public UnaryOperatorNode(final UnaryOperators operator, final Node child) {
        this.operator = operator;
        this.child = child;
    }

    public UnaryOperators getOperator() {
        return operator;
    }

    public Node getChild() {
        return child;
    }

    public void accept(final NodeVisitor visitor) {
        visitor.visitUnaryOperator(this);
    }
}
