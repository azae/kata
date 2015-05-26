package net.azae.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertRefactored {

    /**
     * Returns a text version of a number passed as input.
     *
     * @param input The number to convert to text.
     * @return Text version of the number.
     */
    public static String num2text(final String input) {
        if (!isNumeric(input))
            return null;
        final List<String> byThreeDigits = splitByThreeDigits(input);
        final StringBuilder result = new StringBuilder();
        for (int block = byThreeDigits.size() - 1; block >= 0; block--) {
            final String textual = renderThreeDigits(byThreeDigits.get(block));
            if (!"zéro".equals(textual) || byThreeDigits.size() == 1) {
                result.append(" ");
                if (!"un".equals(textual) || block == 0) {
                    result.append(textual);
                    if (block != 0) result.append(" ");
                }
                result.append(MAGNITUDE_TO_TEXT[block]);
            }
        }
        return result.toString().trim();
    }

    private static List<String> splitByThreeDigits(final String value) {
        final String reversed = reverse(value);
        final List<String> result = new ArrayList<>();
        for (int i = 0; i < (reversed.length() - 1) / 3 + 1; i++) {
            result.add(reverse(reversed.substring(i * 3, Math.min(i * 3 + 3, reversed.length()))));
        }
        return result;
    }

    private static String reverse(final String value) {
        return new StringBuilder(value).reverse().toString();
    }

    private static boolean isNumeric(String value) {
        return value.matches("^\\d+$");
    }

    private static String renderThreeDigits(String value) {
        switch (value.length()) {
            case 1:
                return DIGIT_TO_TEXT.get(value.charAt(0));
            case 2:
                return renderTwoDigits(value);
            case 3:
                String twoDigits = renderTwoDigits(value.substring(1, 3));
                if (value.charAt(0) == '0')
                    return twoDigits;
                return renderHundred(value.charAt(0), twoDigits);
            default:
                return null;
        }
    }

    private static String renderHundred(final char hundred, final String tens) {
        final String end = "zéro".equals(tens) ? "cent" : "cent " + tens;
        return hundred == '1' ? end : DIGIT_TO_TEXT.get(hundred) + " " + end;
    }

    private static String renderTwoDigits(String input) {
        if (input.length() == 2) {
            if (input.charAt(0) == '7' || input.charAt(0) == '9')
                return TENS_TO_TEXT.get(input.charAt(0)) + " " + N_10_19_TO_TEXT.get(input.charAt(1));
            else if (input.charAt(0) == '1')
                return N_10_19_TO_TEXT.get(input.charAt(1));
            else if (input.charAt(0) == '0')
                return DIGIT_TO_TEXT.get(input.charAt(1));
            else
                return TENS_TO_TEXT.get(input.charAt(0)) + "" + UNIT_TO_TEXT.get(input.charAt(1));
        }
        return null;
    }

    public static final String[] MAGNITUDE_TO_TEXT = new String[]{
            "",
            "mille", "million", "milliard",
            "billion", "billiar", "trillion",
            "trilliard", "quadrillion", "quadrilliard"};

    private static final Map<Character, String> DIGIT_TO_TEXT = new HashMap<Character, String>() {
        {
            put('0', "zéro");
            put('1', "un");
            put('2', "deux");
            put('3', "trois");
            put('4', "quatre");
            put('5', "cinq");
            put('6', "six");
            put('7', "sept");
            put('8', "huit");
            put('9', "neuf");
        }
    };

    private static final Map<Character, String> N_10_19_TO_TEXT = new HashMap<Character, String>() {
        {
            put('0', "dix");
            put('1', "onze");
            put('2', "douze");
            put('3', "treize");
            put('4', "quatorze");
            put('5', "quinze");
            put('6', "seize");
            put('7', "dix sept");
            put('8', "dix huit");
            put('9', "dix neuf");
        }
    };

    private static final Map<Character, String> UNIT_TO_TEXT = new HashMap<Character, String>() {
        {
            put('0', "");
            put('1', " et un");
            put('2', " deux");
            put('3', " trois");
            put('4', " quatre");
            put('5', " cinq");
            put('6', " six");
            put('7', " sept");
            put('8', " huit");
            put('9', " neuf");
        }
    };

    private static final Map<Character, String> TENS_TO_TEXT = new HashMap<Character, String>() {
        {
            put('1', "dix");
            put('2', "vingt");
            put('3', "trente");
            put('4', "quarante");
            put('5', "cinquante");
            put('6', "soixante");
            put('7', "soixante");
            put('8', "quatre vingt");
            put('9', "quatre vingt");
        }
    };
}
