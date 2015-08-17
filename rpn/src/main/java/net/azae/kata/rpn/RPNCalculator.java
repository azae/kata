package net.azae.kata.rpn;

import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import static java.lang.Math.sqrt;
import static java.util.Collections.max;

public final class RPNCalculator {
    public static double compute(final String expression) {
        final Stack<Double> stack = new Stack<>();
        for (final String atom : expression.split("\\s+")) {
            findActionFor(atom).process(atom, stack);
        }
        return stack.pop();
    }

    private static StackActions findActionFor(final String atom) {
        for (final StackActions token : StackActions.values()) {
            if (token.matches(atom)) {
                return token;
            }
        }
        throw new NoSuchElementException(atom);
    }

    @SuppressWarnings("unused")
    enum StackActions {
        LITERAL(atom -> Doubles.tryParse(atom) != null, (atom, stack) -> stack.push(Double.valueOf(atom))),
        PLUS("+"::equals, (atom, stack) -> stack.push(binary(stack, (x, y) -> x + y))),
        MINUS("-"::equals, (atom, stack) -> stack.push(binary(stack, (x, y) -> x - y))),
        MULTIPLY("*"::equals, (atom, stack) -> stack.push(binary(stack, (x, y) -> x * y))),
        DIVIDE("/"::equals, (atom, stack) -> stack.push(binary(stack, (x, y) -> x / y))),
        SQRT("SQRT"::equals, (atom, stack) -> stack.push(sqrt(stack.pop()))),
        MAX("MAX"::equals, (atom, stack) -> stack.push(max(popAll(stack))));

        private final Predicate<String> pattern;
        private final BiConsumer<String, Stack<Double>> action;

        StackActions(final Predicate<String> pattern, final BiConsumer<String, Stack<Double>> action) {
            this.pattern = pattern;
            this.action = action;
        }

        public boolean matches(final String atom) {

            return pattern.test(atom);
        }

        public void process(final String atom, final Stack<Double> stack) {
            action.accept(atom, stack);
        }

        private static double binary(final Stack<Double> stack, final BinaryOperator<Double> function) {
            final double y = stack.pop();
            final double x = stack.pop();
            return function.apply(x, y);
        }

        private static Collection<Double> popAll(final Collection<Double> stack) {
            final Collection<Double> result = Lists.newArrayList(stack);
            stack.clear();
            return result;
        }
    }

    private RPNCalculator() {
    }
}
