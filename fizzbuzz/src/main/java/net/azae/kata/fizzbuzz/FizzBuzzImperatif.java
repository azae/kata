package net.azae.kata.fizzbuzz;

public class FizzBuzzImperatif implements FizzBuzz {

    public String compute(final String input) {
        final Integer value = Integer.valueOf(input);
        final StringBuilder builder = new StringBuilder();
        if (isDivisibleBy(value, 3))
            builder.append("Fizz");
        if (isDivisibleBy(value, 5))
            builder.append("Buzz");
        if (builder.length() == 0)
            return input;
        else
            return builder.toString();
    }

    static boolean isDivisibleBy(final int value, final int divisor) {
        return value % divisor == 0;
    }
}
