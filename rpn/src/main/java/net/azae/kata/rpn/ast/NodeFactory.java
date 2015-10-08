package net.azae.kata.rpn.ast;

public class NodeFactory {
    public static Node literal(final long value) {
        return literal(Long.toString(value));
    }

    public static Node literal(final double value) {
        return literal(Double.toString(value));
    }

    public static Node literal(final String value) {
        return new LiteralNode(value);
    }

    public static Node add(final Node left, final Node right) {
        return binary(BinaryOperators.ADD, left, right);
    }

    public static Node div(final Node left, final Node right) {
        return binary(BinaryOperators.DIV, left, right);
    }

    public static Node mul(final Node left, final Node right) {
        return binary(BinaryOperators.MUL, left, right);
    }

    public static Node neg(final Node child) {
        return unary(UnaryOperators.NEG, child);
    }

    public static Node sqrt(final Node child) {
        return unary(UnaryOperators.SQRT, child);
    }

    private static Node unary(final UnaryOperators operator, final Node child) {
        return new UnaryOperatorNode(operator, child);
    }

    public static Node sub(final Node left, final Node right) {
        return binary(BinaryOperators.SUB, left, right);
    }

    public static Node binary(final BinaryOperators op, final Node left, final Node right) {
        return new BinaryOperatorNode(op, left, right);
    }

    private NodeFactory() {
    }
}
