package net.azae.kata.rpn.ast;

public class LiteralNode implements Node {
    private final String value;

    public LiteralNode(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void accept(final NodeVisitor visitor) {
        visitor.visitLiteral(this);
    }
}
