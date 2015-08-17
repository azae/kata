package net.azae.kata.foobarqix;

import java.util.function.Predicate;
import java.util.stream.Stream;

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
        final String result = translateToFooBarQix(concat(toDivisors(value), toDigits(value)));
        if (result.matches("\\**")) {
            return value.replace('0', '*');
        } else {
            return result;
        }
    }

    static String translateToFooBarQix(final Stream<Integer> stream) {
        return stream.map(v -> VALUES[v]).collect(joining());
    }

    static Stream<Integer> toDigits(final String value) {
        return stream(value.split("")).map(Integer::valueOf);
    }

    static Stream<Integer> toDivisors(final String value) {
        return of(3, 5, 7).filter(isDivisible(valueOf(value)));
    }

    private static Predicate<Integer> isDivisible(final int number) {
        return n -> number % n == 0;
    }
}
