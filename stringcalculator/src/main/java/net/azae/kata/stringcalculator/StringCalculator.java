package net.azae.kata.stringcalculator;

public class StringCalculator {
    public static double add(String number) {
        String[] numbers = number.split(",");
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return Double.parseDouble(number);
        return Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
    }
}
