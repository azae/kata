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

    @Test
    public void add_should_return_number_when_input_is_single_number () {
        assertAdd(1.0, "1");
    }

    @Test
    public void add_should_return_sum_when_input_are_2_numbers_separated_by_comma () {
        assertAdd(4.0, "1,3");
        assertAdd(4.4, "1.1,3.3");

    }

    @Test
    public void add_should_return_sum_when_input_are_more_than_2_numbers_separated_by_comma () {
        assertAdd(4.0, "1,2,1");
        assertAdd(5.0, "1,2,1,1");
    }

    @Test
    public void add_should_return_sum_when_input_are_more_than_2_numbers_separated_by_newline () {
        assertAdd(4.0, "1,2\n1");
        assertAdd(5.0, "1,2\n1\n1");
    }
    public void assertAdd(double expected, String actual) {
        assertEquals(expected, add(actual));
    }
}
