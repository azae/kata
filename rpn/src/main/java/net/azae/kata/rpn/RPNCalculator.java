package net.azae.kata.rpn;

import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;

import java.util.Collection;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import static java.lang.Math.sqrt;
import static java.util.Arrays.stream;
import static java.util.Collections.max;

public final class RPNCalculator {
    private RPNCalculator() {
    }

    public static double compute(final String expression) {
        final Stack<Double> stack = new Stack<>();
        for (final String atom : expression.split("\\s+")) {
            StackActions.process(atom, stack);
        }
        return stack.pop();
    }

    private enum StackActions {
        LITERAL(atom -> Doubles.tryParse(atom) != null, (atom, stack) -> stack.push(Double.valueOf(atom))),
        PLUS("+"::equals, (atom, stack) -> stack.push(binary(stack, (x, y) -> x + y))),
        MINUS("-"::equals, (atom, stack) -> stack.push(binary(stack, (x, y) -> x - y))),
        MULTIPLY("*"::equals, (atom, stack) -> stack.push(binary(stack, (x, y) -> x * y))),
        DIVIDE("/"::equals, (atom, stack) -> stack.push(binary(stack, (x, y) -> x / y))),
        SQRT("SQRT"::equals, (atom, stack) -> stack.push(sqrt(stack.pop()))),
        MAX("MAX"::equals, (atom, stack) -> stack.push(max(popAll(stack))));

        final Predicate<String> pattern;
        final BiConsumer<String, Stack<Double>> operation;

        StackActions(final Predicate<String> pattern, final BiConsumer<String, Stack<Double>> operation) {
            this.pattern = pattern;
            this.operation = operation;
        }

        static void process(final String atom, final Stack<Double> stack) {
            stream(StackActions.values()).filter(a -> a.pattern.test(atom)).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(atom)).operation.accept(atom, stack);
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
}
