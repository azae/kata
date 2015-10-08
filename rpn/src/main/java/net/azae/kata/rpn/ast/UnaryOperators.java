package net.azae.kata.rpn.ast;

public enum UnaryOperators {
    NEG,
    SQRT;

    public static String render(final UnaryOperators op) {
        switch (op) {
            case NEG:
                return "NEG";
            case SQRT:
                return "SQRT";
        }
        throw new IllegalArgumentException(op.name());
    }
}
