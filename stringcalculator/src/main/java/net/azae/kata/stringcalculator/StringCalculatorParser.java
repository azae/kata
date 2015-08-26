package net.azae.kata.stringcalculator;

import java.util.Collection;

import static com.google.common.collect.Sets.newHashSet;
import static java.lang.Double.parseDouble;

public class StringCalculatorParser {
    private final String data;
    private int position = 0;
    private Collection<Character> delimiters = newHashSet(',', '\n');

    StringCalculatorParser(final String data) {
        this.data = data;
    }

    public static double add(final String operands) {
        return new StringCalculatorParser(operands).add();
    }

    private double add() {
        delimiters();
        if (eos()) return 0;

        double sum = number();
        while (!eos()) {
            separator();
            sum += number();
        }
        return sum;
    }

    private boolean eos() {
        return position >= data.length();
    }

    private boolean isSeparator() {
        return delimiters.contains(data.charAt(position));
    }

    private void delimiters() {
        if (data.startsWith("//", position)) {
            advance(2);
            delimiters = newHashSet('\n', data.charAt(position));
            advance(1);
            if (data.charAt(position) != '\n') {
                throw new IllegalArgumentException("delimiter error at: " + position);
            }
            advance(1);
        }
    }

    private void separator() {
        if (isSeparator()) {
            advance(1);
        } else {
            throw new IllegalArgumentException("separator error at: " + position);
        }
    }

    private double number() {
        final int start = position;
        while (!eos() && !isSeparator()) {
            advance(1);
        }
        try {
            return parseDouble(data.substring(start, position));
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("number error at: " + start, e);
        }
    }

    private void advance(final int count) {
        position += count;
    }
}
