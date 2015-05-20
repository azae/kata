package net.azae.kata;

import java.text.ParseException;

class Main {

    public static void main(String[] args) throws ParseException {
        check(0x80f4, Original.encryptCrc(345, "12/05"));
        check(0x80f4, Solution.encryptCrc(345, "12/05"));
    }

    static void check(int expected, int got) {
        assert expected == got: "Expected " + Integer.toHexString(expected) + ", got " + Integer.toHexString(got);
    }

}

