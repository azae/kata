package net.azae.kata.stringcalculator;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.collect.Sets.newHashSet;
import static java.lang.Double.parseDouble;
import static java.util.regex.Pattern.MULTILINE;
import static java.util.regex.Pattern.compile;

public class StringCalculatorParser {
    private static final Pattern NUMBER = compile("^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?", MULTILINE);
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

    private void delimiters() {
        if (tail().startsWith("//")) {
            advance(2);
            delimiters = newHashSet('\n', current());
            advance(1);
            if (current() != '\n') {
                throw parseError("\\n");
            }
            advance(1);
        }
    }

    private void separator() {
        if (isSeparator()) {
            advance(1);
        } else {
            throw parseError("separator");
        }
    }

    private double number() {
        final Matcher matcher = NUMBER.matcher(tail());
        if (matcher.find(0) && matcher.start() == 0) {
            advance(matcher.end());
            return parseDouble(matcher.group());
        }
        throw parseError("number");
    }

    private boolean isSeparator() {
        return delimiters.contains(current());
    }

    private boolean eos() {
        return position >= data.length();
    }

    private char current() {
        return data.charAt(position);
    }

    private String tail() {
        return data.substring(position);
    }

    private void advance(final int count) {
        position += count;
    }

    private RuntimeException parseError(final String token) {
        return new IllegalArgumentException("Expected " + token + " at #" + position + " got '" + tail() + '\'');
    }
}
