package net.azae.kata.stringcalculator;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class StringCalculator {
    public static double add(final String input) {
        if (input.isEmpty()) return 0;
        final long numbersOfOperands = countOperands(input);
        final long numbersOfSeparators = countSeparators(input);
        if (numbersOfOperands <= numbersOfSeparators)
            throw new InvalidParameterException();
        return Arrays.stream(input.split("(,|\n)")).map(Double::parseDouble).reduce(Double::sum).orElse(null);
    }

    static long countSeparators(final String number) {
        return number.length() - number.replace(",", "").replace("\n", "").length();
    }

    static long countOperands(final String number) {
        return Arrays.stream(number.split("(,|\n)")).count();
    }

    private StringCalculator() {
    }
}
