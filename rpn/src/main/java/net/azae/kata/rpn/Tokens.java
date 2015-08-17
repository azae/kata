package net.azae.kata.rpn;

import java.util.Stack;
import java.util.function.BinaryOperator;

import static java.lang.Math.sqrt;
import static java.util.Collections.max;

enum Tokens implements Token {
    LITERAL("\\d+") {
        public int process(final String atom, final Stack<Integer> stack) {
            return Integer.valueOf(atom);
        }
    },
    PLUS("\\+") {
        public int process(final String atom, final Stack<Integer> stack) {
            return binary(stack, (x, y) -> x + y);
        }
    },
    MINUS("-") {
        public int process(final String atom, final Stack<Integer> stack) {
            return binary(stack, (x, y) -> x - y);
        }
    },
    MULTIPLY("\\*") {
        public int process(final String atom, final Stack<Integer> stack) {
            return binary(stack, (x, y) -> x * y);
        }
    },
    DIVIDE("/") {
        public int process(final String atom, final Stack<Integer> stack) {
            return binary(stack, (x, y) -> x / y);
        }
    },
    SQRT("SQRT") {
        public int process(final String atom, final Stack<Integer> stack) {
            return (int) sqrt(stack.pop());
        }
    },
    MAX("MAX") {
        public int process(final String atom, final Stack<Integer> stack) {
            try {
                return max(stack);
            } finally {
                stack.clear();
            }
        }
    };

    private final String pattern;

    Tokens(final String pattern) {
        this.pattern = pattern;
    }

    public boolean matches(final String atom) {
        return atom.matches(pattern);
    }

    private static int binary(final Stack<Integer> stack, final BinaryOperator<Integer> function) {
        final int y = stack.pop();
        final int x = stack.pop();
        return function.apply(x, y);
    }
}
