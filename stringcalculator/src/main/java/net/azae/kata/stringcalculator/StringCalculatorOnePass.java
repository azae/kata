package net.azae.kata.stringcalculator;

import java.security.InvalidParameterException;

public class StringCalculatorOnePass {
    public static double add(final String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (final String operand : numbers.split("(,|\n)")) {
            if (operand.isEmpty()) {
                throw new InvalidParameterException();
            }
            sum += Double.valueOf(operand);
        }
        return sum;
    }

    private StringCalculatorOnePass() {
    }
}
