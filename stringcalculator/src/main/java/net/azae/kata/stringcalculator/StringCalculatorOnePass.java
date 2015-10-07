package net.azae.kata.stringcalculator;

import com.google.common.base.Joiner;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

public class StringCalculatorOnePass {

    public static double add(final String operands) {
        if (operands.isEmpty()) {
            return 0;
        }
        final Collection<Double> negatives = newArrayList();
        double sum = 0;
        for (final String operand : split(operands)) {
            final double value = toDouble(operand);
            if (value < 0) {
                negatives.add(value);
            }
            sum += value;
        }
        if (negatives.isEmpty())
            return sum;
        else {
            throw new IllegalArgumentException("Negative not allowed: " + Joiner.on(", ").join(negatives));
        }
    }

    private static String[] split(final String operands) {
        if (operands.startsWith("//")) {
            if (operands.charAt(3) != '\n') {
                throw new IllegalArgumentException();
            }
            return operands.substring(4).split("[" + operands.charAt(2) + "\n]", -1);
        }
        return operands.split("[,\n]", -1);
    }

    private static double toDouble(final String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Double.valueOf(value);
    }

    private StringCalculatorOnePass() {
    }
}
