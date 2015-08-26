package net.azae.kata.stringcalculator;

import java.security.InvalidParameterException;

public class StringCalculatorOnePass {
    public static double add(final String operands) {
        if (operands.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (final String operand : operands.split("(,|\n)")) {
            sum += toDouble(operand);
        }
        return sum;
    }

    private static double toDouble(final String value) {
        if (value.isEmpty()) {
            throw new InvalidParameterException();
        }
        return Double.valueOf(value);
    }

    private StringCalculatorOnePass() {
    }
}
