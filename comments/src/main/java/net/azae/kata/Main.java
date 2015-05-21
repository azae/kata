package net.azae.kata;

import java.text.ParseException;

class Main {

    public static void main(String[] args) throws ParseException {
        check(0x0000, "12/05");
        check(0x0001, "01/08");
        check(0x3408, "12/05");
    	check(0xFFFF, "01/07");
    }

    static void check(int value, String date) throws ParseException {
    	int expected = Original.encryptCrc(value, date);
    	int got = Solution.encryptCrc(value, date);
        if (expected != got) {
        	System.out.println("Failed. Red: Expected " + hex(expected) + ", got " + hex(got));
        } else {
        	System.out.println("OK. Green: " + hex(got));
        }
    }

    public static String hex(int value) {
        return String.format("0x%4s", Integer.toHexString(value)).replace(" ", "0");
    }

}

