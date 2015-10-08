package net.azae.kata.rpn.ast;

public enum BinaryOperators {
    ADD,
    DIV,
    MUL,
    SUB;

    public static String render(final BinaryOperators operator) {
        switch (operator) {
            case ADD:
                return "+";
            case DIV:
                return "/";
            case MUL:
                return "*";
            case SUB:
                return "-";
        }
        throw new IllegalArgumentException(operator.name());
    }
}
