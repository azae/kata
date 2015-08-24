package net.azae.kata.stringcalculator;

import org.testng.Assert;
import org.testng.annotations.Test;

import static net.azae.kata.stringcalculator.StringCalculator.add;
import static org.testng.Assert.assertEquals;

public class StringCalculatorTest {
    @Test
    public void add_should_return_0_when_input_is_empty () {
        assertAdd(0.0, "");
    }

    public void assertAdd(double expected, String actual) {
        assertEquals(expected, add(actual));
    }
}
