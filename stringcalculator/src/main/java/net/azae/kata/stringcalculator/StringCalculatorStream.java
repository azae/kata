package net.azae.kata.stringcalculator;

import java.util.Arrays;

public class StringCalculatorStream {

    public static double add(String input) {
        if (input.isEmpty()) return 0;
        String numbers;
        if (input.startsWith("//")) {
            numbers = input.substring(4).replace(extractSeparator(input), ",");
            checkFormat(input);
        } else {
            numbers = input.replace("\n", ",");
        }

        return Arrays.stream(numbers.split(",", -1)).map((v) -> {
            if (v.isEmpty()) throw new IllegalArgumentException();
            else return Double.parseDouble(v);
        }).reduce(Double::sum).orElse(null);
    }

    private static String extractSeparator(String input) {
        return input.substring(2, 3);
    }

    private static void checkFormat(String input) {
        if (! input.substring(3,4).equals("\n")) {
            throw new IllegalArgumentException();
        }
    }
}
