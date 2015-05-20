package net.azae.kata;

import java.text.ParseException;

class Main {

    public static void main(String[] args) throws ParseException {
    	check(345, "12/05");
    	check(278, "01/09");
    }

    static void check(int value, String date) throws ParseException {
    	int expected = Original.encryptCrc(value, date);
    	int got = Solution.encryptCrc(value, date);
        if (expected != got) {
        	System.out.println("Failed. Red. Expected " + Integer.toHexString(expected) + ", got " + Integer.toHexString(got));
        } else {
        	System.out.println("OK. Green.");
        }
    }
}

