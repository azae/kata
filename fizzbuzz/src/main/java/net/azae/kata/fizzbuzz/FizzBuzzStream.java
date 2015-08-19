package net.azae.kata.fizzbuzz;

import java.util.function.Predicate;

import static java.lang.Integer.valueOf;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.of;

public class FizzBuzzStream implements FizzBuzz {
    public static final String[] VALUES = new String[]{"", "", "", "Fizz", "", "Buzz", "", "", "", ""};

    public String compute(final String input) {
        final String result = of(3, 5, 7).filter(isDivisible(valueOf(input))).map(v -> VALUES[v]).collect(joining());
        return result.isEmpty() ? input : result;
    }

    private static Predicate<Integer> isDivisible(final int number) {
        return n -> number % n == 0;
    }
}
