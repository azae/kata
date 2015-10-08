package net.azae.kata.rpn.ast;

public enum UnaryOperators {
    NEG,
    SQRT, SQUARE;

    public static String render(final UnaryOperators op) {
        switch (op) {
            case NEG:
                return "NEG";
            case SQUARE:
                return "²";
            case SQRT:
                return "SQRT";
        }
        throw new IllegalArgumentException(op.name());
    }
}
