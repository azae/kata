package net.azae.kata.rpn.ast;

public enum UnaryOperators {
    SQRT;

    public static String render(final UnaryOperators op) {
        switch (op) {
            case SQRT:
                return "SQRT";
        }
        throw new IllegalArgumentException(op.name());
    }
}
