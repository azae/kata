package net.azae.kata.rpn;

import java.util.Collections;
import java.util.Stack;

import static java.util.Arrays.stream;

public final class RPNCalculator {

    interface Operator {
        int compute(final String atom, final Stack<Integer> stack);
    }

    enum Operators implements Operator {
        LITERAL("\\d+") {
            public int compute(final String atom, final Stack<Integer> stack) {
                return Integer.valueOf(atom);
            }
        },
        PLUS("\\+") {
            public int compute(final String atom, final Stack<Integer> stack) {
                return stack.pop() + stack.pop();
            }
        },
        MINUS("-") {
            public int compute(final String atom, final Stack<Integer> stack) {
                final int a = stack.pop();
                final int b = stack.pop();
                return b - a;
            }
        },
        MULTIPLY("\\*") {
            public int compute(final String atom, final Stack<Integer> stack) {
                return stack.pop() * stack.pop();
            }
        },
        DIVIDE("/") {
            public int compute(final String atom, final Stack<Integer> stack) {
                final int a = stack.pop();
                final int b = stack.pop();
                return b / a;
            }
        },
        SQRT("SQRT") {
            public int compute(final String atom, final Stack<Integer> stack) {
                return (int) Math.sqrt(stack.pop());
            }
        },
        MAX("MAX") {
            public int compute(final String atom, final Stack<Integer> stack) {
                final int result = Collections.max(stack);
                stack.clear();
                return result;
            }
        },
        ERROR(".*") {
            public int compute(final String atom, final Stack<Integer> stack) {
                throw new RuntimeException("Unknwon operator " + atom);
            }
        };

        private final String pattern;

        Operators(final String pattern) {
            this.pattern = pattern;
        }

        public boolean matches(final String atom) {
            return atom.matches(pattern);
        }
    }


    private RPNCalculator() {
    }

    public static int compute(final String expression) {
        final Stack<Integer> stack = new Stack<>();
        stream(expression.split(" ")).forEachOrdered(atom -> processAtom(atom, stack));
        return stack.pop();
    }

    private static void processAtom(final String atom, final Stack<Integer> stack) {
        for (final Operators operator : Operators.values()) {
            if (operator.matches(atom)) {
                stack.add(operator.compute(atom, stack));
                return;
            }
        }
    }
}
