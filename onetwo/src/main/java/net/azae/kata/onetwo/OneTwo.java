package net.azae.kata.onetwo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class OneTwo {
    public static final String[] DIGITS = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static String convertInLetter(String input) {
        return mapArrayToNames(countOccurences(input));
    }

    private static List<Integer> countOccurences(String input) {
        int countLastNumber = 0;
        int[] numbers = convertStringNumberToInteger(input);
        int lastNumber = numbers[0];
        List<Integer> results = new ArrayList<>();
        for (int currentNumber : numbers) {
            if (lastNumber == currentNumber) {
                if (countLastNumber == 9) {
                    addPairToList(countLastNumber, lastNumber, results);
                    countLastNumber = 1;
                } else {
                    countLastNumber++;
                }
            } else {
                addPairToList(countLastNumber, lastNumber, results);
                lastNumber = currentNumber;
                countLastNumber = 1;
            }
        }
        addPairToList(countLastNumber, lastNumber, results);
        return results;
    }

    private static String mapArrayToNames(List<Integer> results) {
        return results.stream().map(i -> DIGITS[i]).collect(Collectors.joining(" "));
    }

    private static int[] convertStringNumberToInteger(String input) {
        return stream(input.split("")).mapToInt(Integer::valueOf).toArray();
    }

    private static void addPairToList(int countLastNumber, int lastNumber, List<Integer> results) {
        results.add(countLastNumber);
        results.add(lastNumber);
    }

    public static String convertToNumber(String input) {
        String[] atoms = input.split(" ");
        String result = "";
        for (int i = 0; i < atoms.length; i += 2) {
            result += appendNumberXTimes(getIntFromNumber(atoms[i]), getIntFromNumber(atoms[i + 1]));
        }
        return result;
    }

    private static String appendNumberXTimes(int count, int number) {
        StringBuilder result = new StringBuilder();
        for (int v = 1; v <= count; v++) {
            result.append(number);
        }
        return result.toString();
    }

    private static int getIntFromNumber(String atom) {
        for (int i = 0; i < DIGITS.length; i++) {
            if (DIGITS[i].equals(atom))
                return i;
        }
        return -1;
    }
}