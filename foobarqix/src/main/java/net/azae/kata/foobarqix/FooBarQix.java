package net.azae.kata.foobarqix;

import java.util.function.Predicate;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

public final class FooBarQix {

    private FooBarQix() {
    }

    public static String compute(final String value) {
        return computeWithStream(value);
    }

    public static final String[] VALUES = new String[]{"*", "", "", "Foo", "", "Bar", "", "Qix", "", ""};

    public static String computeWithStream(final String value) {
        final String result = concat(
                of(3, 5, 7).filter(isDivisible(valueOf(value))),
                stream(value.split("")).map(Integer::valueOf)
        ).map(v -> VALUES[v]).collect(joining());

        if (result.matches("\\**")) {
            return value.replace('0', '*');
        } else {
            return result;
        }
    }

    private static Predicate<Integer> isDivisible(final int number) {
        return n -> number % n == 0;
    }

    public static String computeV1(final String value) {
        final int number = parseInt(value);
        final StringBuilder builder = new StringBuilder();
        addWhenDivisible(number, 3, "Foo", builder);
        addWhenDivisible(number, 5, "Bar", builder);
        addWhenDivisible(number, 7, "Qix", builder);
        boolean substitute = builder.length() == 0;
        for (final char c : value.toCharArray()) {
            switch (c) {
                case '3':
                    builder.append("Foo");
                    substitute = false;
                    break;
                case '5':
                    builder.append("Bar");
                    substitute = false;
                    break;
                case '7':
                    builder.append("Qix");
                    substitute = false;
                    break;
                case '0':
                    builder.append('*');
                    break;
            }
        }
        if (substitute) {
            return value.replace('0', '*');
        } else {
            return builder.toString();
        }
    }

    private static void addWhenDivisible(final int value, final int number, final String literal, final StringBuilder builder) {
        if (value % number == 0) {
            builder.append(literal);
        }
    }
}
