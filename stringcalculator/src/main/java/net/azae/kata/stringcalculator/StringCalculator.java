package net.azae.kata.stringcalculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {
    public static double add(String number) {
        if (number.isEmpty()) return 0;
        return Arrays.stream(number.split(",")).map(Double::parseDouble).reduce(Double::sum).orElse(null);
    }
}
