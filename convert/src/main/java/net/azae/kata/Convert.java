package net.azae.kata;

import java.util.*;

public class Convert {
    public static final char[] NUM_0_9 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static String[] TEXT_0_9 = new String[]{"zéro", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf"};
    public static String[] TEXT_10_19 = new String[]{"dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix sept", "dix huit", "dix neuf"};
    public static String[] TEXT_10_90 = new String[]{"", "dix", "vingt", "trente", "quarante", "cinquante", "soixante", "soixante", "quatre vingt", "quatre vingt"};
    public static String[] TEXT_10_99 = new String[]{"", " et un", " deux", " trois", " quatre", " cinq", " six", " sept", " huit", " neuf"};
    public static String[] TEXT_1000 = new String[]{"", "mille", "million", "milliard", "billion", "billiar", "trillion", "trilliard", "quadrillion", "quadrilliard"};
    private static Map<Character, String> num2text09;
    private static Map<Character, String> num2text1019;
    private static Map<Character, String> num2text1090;
    private static Map<Character, String> num2text1099;

    /**
     * Returns a text version of a number passed as input.
     *
     * @param input The number to convert to text.
     * @return Text version of the number.
     */
    public static String num2text(String input) {
        if (num2text09 == null)
            loadNum2text();
        if (!isNumeric(input))
            return null;
        List<String> byThreeDigits = splitByThreeDigits(input);
        StringBuilder output = new StringBuilder();
        for (int i = byThreeDigits.size() - 1; i >= 0; i--) {
            String textual = renderThreeDigits(byThreeDigits.get(i));
            if (!"zéro".equals(textual) || byThreeDigits.size() <= 1) {
                output.append(" ");
                if (!"un".equals(textual) || i == 0) {
                    output.append(textual).append(" ");
                }
                output.append(TEXT_1000[i]);
            }
        }
        return output.toString().trim();
    }

    private static List<String> splitByThreeDigits(String input) {
        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder(input).reverse();
        for (int i = 0; i < (sb.length() - 1) / 3 + 1; i++) {
            output.add(new StringBuilder(sb.substring(i * 3, i * 3 + 3 > sb.length() ? sb.length() : i * 3 + 3)).reverse().toString());
        }
        return output;
    }

    private static boolean isNumeric(String input) {
        Set<Character> keySet = num2text09.keySet();
        for (int i = 0; i < input.length(); i++)
            if (!keySet.contains(input.charAt(i)))
                return false;
        return true;
    }

    private static String renderThreeDigits(String input) {
        if (input.length() == 1)
            return num2text09.get(input.charAt(0));
        if (input.length() == 2) {
            return renderTwoDigits(input);
        }
        if (input.length() == 3) {
            String textualTwoDigits = renderTwoDigits(input.substring(1, 3));
            switch (input.charAt(0)) {
                case '0':
                    return textualTwoDigits;
                case '1':
                    return renderHundred(textualTwoDigits);
                default:
                    return num2text09.get(input.charAt(0)) + " " + renderHundred(textualTwoDigits);
            }
        }
        return null;
    }

    private static String renderHundred(String textualTwoDigits) {
        String cent;
        if ("zéro".equals(textualTwoDigits)) cent = "cent";
        else cent = "cent " + textualTwoDigits;
        return cent;
    }

    private static String renderTwoDigits(String input) {
        if (input.length() == 2) {
            if (input.charAt(0) == '7' || input.charAt(0) == '9')
                return num2text1090.get(input.charAt(0)) + " " + num2text1019.get(input.charAt(1));
            else if (input.charAt(0) == '1')
                return num2text1019.get(input.charAt(1));
            else if (input.charAt(0) == '0')
                return num2text09.get(input.charAt(1));
            else
                return num2text1090.get(input.charAt(0)) + "" + num2text1099.get(input.charAt(1));
        }
        return null;
    }

    private static void loadNum2text() {
        num2text09 = new HashMap<Character, String>();
        for (int i = 0; i < NUM_0_9.length; i++)
            num2text09.put(NUM_0_9[i], TEXT_0_9[i]);
        num2text1019 = new HashMap<Character, String>();
        for (int i = 0; i < NUM_0_9.length; i++)
            num2text1019.put(NUM_0_9[i], TEXT_10_19[i]);
        num2text1090 = new HashMap<Character, String>();
        for (int i = 0; i < NUM_0_9.length; i++)
            num2text1090.put(NUM_0_9[i], TEXT_10_90[i]);
        num2text1099 = new HashMap<Character, String>();
        for (int i = 0; i < NUM_0_9.length; i++)
            num2text1099.put(NUM_0_9[i], TEXT_10_99[i]);
    }

}
