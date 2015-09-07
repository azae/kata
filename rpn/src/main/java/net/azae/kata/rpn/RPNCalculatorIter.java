package net.azae.kata.rpn;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public final class RPNCalculatorIter {
    private RPNCalculatorIter() {
    }


    public static double compute(final String expression) {
        final List<String> elements = newArrayList(expression.split("\\s+"));
        if (elements.isEmpty()) {
            return 0;
        }
        int index = 0;
        while (index < elements.size()) {
            final Actions action = Actions.match(elements.get(index));
            if (action != null) {
                final List<String> sublist = elements.subList(0, index + 1);
                action.process(sublist);
                index = sublist.size();
            } else {
                index++;
            }
        }
        return Double.valueOf(elements.get(0));
    }

    private enum Actions {
        PLUS("+"::equals, elements -> (binary(elements, (x, y) -> x + y))),
        MINUS("-"::equals, elements -> (binary(elements, (x, y) -> x - y))),
        MULTIPLY("*"::equals, elements -> (binary(elements, (x, y) -> x * y))),
        DIVIDE("/"::equals, elements -> (binary(elements, (x, y) -> x / y))),
        SQRT("SQRT"::equals, elements -> (unary(elements, Math::sqrt))),
        MAX("MAX"::equals, elements -> (nary(elements, Collections::max)));

        final Predicate<String> pattern;
        final Function<List<String>, String> operation;

        Actions(final Predicate<String> pattern, final Function<List<String>, String> operation) {
            this.pattern = pattern;
            this.operation = operation;
        }

        static Actions match(final String element) {
            return stream(Actions.values()).filter(a -> a.pattern.test(element)).findFirst().orElse(null);
        }

        private void process(final List<String> elements) {
            removeLast(elements);
            elements.add(operation.apply(elements));
        }

        private static String binary(final List<String> elements, final BinaryOperator<Double> function) {
            final double y = Double.valueOf(removeLast(elements));
            final double x = Double.valueOf(removeLast(elements));
            return String.valueOf(function.apply(x, y));
        }

        private static String unary(final List<String> elements, final Function<Double, Double> function) {
            return String.valueOf(function.apply(Double.valueOf(removeLast(elements))));
        }

        private static String nary(final Collection<String> elements, final Function<List<Double>, Double> function) {
            return String.valueOf(function.apply(removeAll(elements).stream().map(Double::valueOf).collect(toList())));
        }

        private static Collection<String> removeAll(final Collection<String> elements) {
            final Collection<String> result = newArrayList(elements);
            elements.clear();
            return result;
        }

        private static String removeLast(final List<String> elements) {
            return elements.remove(elements.size() - 1);
        }
    }
}
