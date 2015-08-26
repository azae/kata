package net.azae.kata.stringcalculator;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class StringCalculatorStream {

    public static double add(String input) {
        if (input.isEmpty()) return 0;
        String numbers;
        if (input.startsWith("//"))
            numbers = input.substring(4).replace(input.substring(2, 3), ",");
        else
            numbers = input.replace("\n", ",");

        return Arrays.stream(numbers.split(",")).map((v) -> {
            if (v.isEmpty()) throw new InvalidParameterException();
            else return Double.parseDouble(v);
        }).reduce(Double::sum).orElse(null);
    }

}
