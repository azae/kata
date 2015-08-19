package net.azae.kata.leapyear;

public class LeapYear {

    private static final int GREGORIAN_CUTOVER_YEAR = 1582;

    public static boolean isLeapYear(final int year) {
        if (isDivisibleBy(year, 4)) {
            if (year < GREGORIAN_CUTOVER_YEAR) {
                return true;
            }
            return !isDivisibleBy(year, 100) || isDivisibleBy(year, 400);
        }
        return false;
    }

    static boolean isDivisibleBy(final int year, final int divisor) {
        return year % divisor == 0;
    }

    private LeapYear() {
    }
}
