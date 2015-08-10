package net.azae.kata.foobarqix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FooBarQixTest {

    @Test
    public void testReturnsGivenNumberByDefault() {
        assertEquals("1", FooBarQix.compute("1"));
        assertEquals("2", FooBarQix.compute("2"));
    }

    @Test
    public void testWhenInputIsDivisibleByThree() {
        assertEquals("Foo", FooBarQix.compute("6"));
        assertEquals("Foo", FooBarQix.compute("9"));
    }

    @Test
    public void testWhenInputContainsThree() {
        assertEquals("Foo", FooBarQix.compute("13"));
        assertEquals("FooFoo", FooBarQix.compute("433"));
    }

    @Test
    public void testWhenInputIsDivisibleByFive() {
        assertEquals("Bar*", FooBarQix.compute("10"));
    }

    @Test
    public void testWhenInputContainsFive() {
        assertEquals("Bar", FooBarQix.compute("59"));
        assertEquals("BarBar", FooBarQix.compute("1559"));
    }

    @Test
    public void testWhenInputIsDivisibleBySeven() {
        assertEquals("Qix", FooBarQix.compute("49"));
    }

    @Test
    public void testWhenInputContainsSeven() {
        assertEquals("Qix", FooBarQix.compute("47"));
        assertEquals("QixQix", FooBarQix.compute("677"));
    }

    @Test
    public void testComplexCases() {
        assertEquals("FooBarBar", FooBarQix.compute("15"));
        assertEquals("FooQix", FooBarQix.compute("21"));
        assertEquals("FooFooFoo", FooBarQix.compute("33"));
    }

    @Test
    public void testWhenInputContainsZero() {
        assertEquals("1*1", FooBarQix.compute("101"));
        assertEquals("FooFoo*Foo", FooBarQix.compute("303"));
        assertEquals("FooBarQix*Bar", FooBarQix.compute("105"));
        assertEquals("FooQix**", FooBarQix.compute("10101"));
    }


}
