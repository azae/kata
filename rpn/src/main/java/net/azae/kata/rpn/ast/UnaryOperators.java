package net.azae.kata.rpn.ast;

public enum UnaryOperators {
    NEG,
    SQRT, SQUARE;

    public static String render(final UnaryOperators op) {
        switch (op) {
            case NEG:
                return "~";
            case SQUARE:
                return "²";
            case SQRT:
                return "√";
        }
        throw new IllegalArgumentException(op.name());
    }
}
