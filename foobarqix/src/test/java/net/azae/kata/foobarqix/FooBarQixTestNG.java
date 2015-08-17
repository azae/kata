package net.azae.kata.foobarqix;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static net.azae.kata.foobarqix.FooBarQix.*;
import static org.testng.Assert.assertEquals;


public class FooBarQixTestNG {

    @DataProvider(name = "divisors")
    public static Object[][] divisors() {
        return new Object[][]{
                {"3", values(3)},
                {"5", values(5)},
                {"7", values(7)},
                {"105", values(3, 5, 7)},
        };
    }

    @Test(dataProvider = "divisors")
    public void testDivisors(final String value, final Integer[] expected) {
        final Collection<Integer> result = toDivisors(value).collect(toList());
        assertEquals(expected, result.toArray(new Integer[result.size()]));
    }

    @DataProvider(name = "digits")
    public static Object[][] digits() {
        return new Object[][]{
                {"3", values(3)},
                {"53", values(5, 3)},
                {"1996", values(1, 9, 9, 6)},
        };
    }

    @Test(dataProvider = "digits")
    public void testDigits(final String value, final Integer[] expected) {
        final Collection<Integer> result = toDigits(value).collect(toList());
        assertEquals(expected, result.toArray(new Integer[result.size()]));
    }


    @DataProvider(name = "valuesToString")
    public static Object[][] valuesToString() {
        return new Object[][]{
                {values(0), "*"},
                {values(1), ""},
                {values(3), "Foo"},
                {values(5), "Bar"},
                {values(7), "Qix"},
                {values(3, 5), "FooBar"},
        };
    }

    @Test(dataProvider = "valuesToString")
    public void testTranslateValuesToFooBarQix(final Integer[] values, final String expected) {
        assertEquals(expected, translateToFooBarQix(stream(values)));
    }

    @Test
    public void testReturnsGivenNumberByDefault() {
        assertEquals("1", compute("1"));
        assertEquals("2", compute("2"));
    }

    @Test
    public void testWhenInputIsDivisibleByThree() {
        assertEquals("Foo", compute("6"));
        assertEquals("Foo", compute("9"));
    }

    @Test
    public void testWhenInputContainsThree() {
        assertEquals("Foo", compute("13"));
        assertEquals("FooFoo", compute("433"));
    }

    @Test
    public void testWhenInputIsDivisibleByFive() {
        assertEquals("Bar*", compute("10"));
    }

    @Test
    public void testWhenInputContainsFive() {
        assertEquals("Bar", compute("59"));
        assertEquals("BarBar", compute("1559"));
    }

    @Test
    public void testWhenInputIsDivisibleBySeven() {
        assertEquals("Qix", compute("49"));
    }

    @Test
    public void testWhenInputContainsSeven() {
        assertEquals("Qix", compute("47"));
        assertEquals("QixQix", compute("677"));
    }

    @Test
    public void testComplexCases() {
        assertEquals("FooBarBar", compute("15"));
        assertEquals("FooQix", compute("21"));
        assertEquals("FooFooFoo", compute("33"));
    }

    @Test
    public void testWhenInputContainsZero() {
        assertEquals("1*1", compute("101"));
        assertEquals("FooFoo*Foo", compute("303"));
        assertEquals("FooBarQix*Bar", compute("105"));
        assertEquals("FooQix**", compute("10101"));
    }

    static Integer[] values(final Integer... expected) {
        return expected;
    }
}
