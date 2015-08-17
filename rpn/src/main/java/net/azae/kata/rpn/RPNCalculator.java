package net.azae.kata.rpn;

import java.util.NoSuchElementException;
import java.util.Stack;

public final class RPNCalculator {
    public static int compute(final String expression) {
        final Stack<Integer> stack = new Stack<>();
        for (final String atom : expression.split(" ")) {
            stack.add(tokenize(atom).process(atom, stack));
        }
        return stack.pop();
    }

    private static Token tokenize(final String atom) {
        for (final Tokens token : Tokens.values()) {
            if (token.matches(atom)) {
                return token;
            }
        }
        throw new NoSuchElementException(atom);
    }

    private RPNCalculator() {
    }
}
