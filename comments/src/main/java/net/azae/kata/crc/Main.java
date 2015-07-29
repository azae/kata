package net.azae.kata.crc;

import java.text.ParseException;

class Main {
    public static void main(final String[] args) throws ParseException {
        check(0x0000, "12/05");
        check(0x0001, "01/08");
        check(0x3408, "12/05");
        check(0xFFFF, "01/07");
    }

    private static void check(final int value, final String date) throws ParseException {
        final int expected = Original.encryptCrc(value, date);
        final int got = Solution.encryptCrc(value, date);
        if (expected == got) {
            System.out.println("OK. Green: " + hex(got));
        } else {
            System.out.println("Failed. Red: Expected " + hex(expected) + ", got " + hex(got));
        }
    }

    private static String hex(final int value) {
        return String.format("0x%4s", Integer.toHexString(value)).replace(" ", "0");
    }

    private Main() {
    }
}

