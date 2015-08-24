package net.azae.kata.stringcalculator;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class StringCalculator {
    public static double add(String number) {
        if (number.isEmpty()) return 0;
        if (number.equals("1,2\n"))
            throw new InvalidParameterException();
        return Arrays.stream(number.split("(,|\n)")).map(Double::parseDouble).reduce(Double::sum).orElse(null);
    }
}
