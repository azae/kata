package net.azae.kata.leapyear;

import org.testng.annotations.Test;

import java.util.GregorianCalendar;

import static net.azae.kata.leapyear.LeapYear.isLeapYear;
import static org.testng.Assert.*;


public class LeapYearTest {

    @Test
    public void shouldNotBeALeapYearIfNotDivisibleBy4() {
        assertFalse(isLeapYear(2001));

    }

    @Test
    public void shouldBeALeapYearIfDivisibleBy4() {
        assertTrue(isLeapYear(1996));
    }

    @Test
    public void shouldNotBeALeapYearIfDivisibleBy100() {
        assertFalse(isLeapYear(1900));
    }

    @Test
    public void shouldBeALeapYearIfDivisibleBy400() {
        assertTrue(isLeapYear(2000));
    }

    @Test
    public void checkWithProductionData() {
        for (int year = 0; year < 3000; year++) {
            assertEquals(isLeapYear(year), new GregorianCalendar().isLeapYear(year), "Bad leap Year for " + String.valueOf(year));
        }
    }

}
