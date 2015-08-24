package net.azae.kata.stringcalculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {
    public static double add(String number) {
        Double[] numbers = Arrays.stream(number.split(",")).map(Double::parseDouble).toArray(Double[]::new);
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];
        return numbers[0] + numbers[1];
    }
}
