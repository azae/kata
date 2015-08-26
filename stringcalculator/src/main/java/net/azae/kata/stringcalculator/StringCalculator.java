package net.azae.kata.stringcalculator;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class StringCalculator {
    public static double add(final String number) {
        if (number.isEmpty()) return 0;
        final long numbersOfOperandes = countOperandes(number);
        final long numbersOfSeparators = countSeparators(number);
        if (numbersOfOperandes <= numbersOfSeparators)
            throw new InvalidParameterException();
        return Arrays.stream(number.split("(,|\n)")).map(Double::parseDouble).reduce(Double::sum).orElse(null);
    }

    static long countSeparators(final String number) {
        return number.length() - number.replace(",", "").replace("\n", "").length();
    }

    static long countOperandes(final String number) {
        return Arrays.stream(number.split("(,|\n)")).count();
    }

    private StringCalculator() {
    }
}
