package net.azae.kata.stringcalculator;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class StringCalculatorOnePass {

    public static double add(final String operands) {
        if (operands.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (final String operand : split(operands)) {
            sum += toDouble(operand);
        }
        return sum;
    }

    public static double addWithStream(final String operands) {
        if (operands.isEmpty()) {
            return 0;
        }
        return Arrays.stream(split(operands)).mapToDouble(v -> toDouble(v)).sum();
    }

    private static String[] split(final String operands) {
        if (operands.startsWith("//")) {
            if (operands.charAt(3) != '\n') {
                throw new InvalidParameterException();
            }
            return operands.substring(4).split("[" + operands.charAt(2) + "\n]", -1);
        }
        return operands.split("[,\n]", -1);
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
