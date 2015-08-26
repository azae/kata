package net.azae.kata.stringcalculator;

import org.testng.annotations.Test;

import static net.azae.kata.stringcalculator.StringCalculatorParser.add;
import static org.testng.Assert.assertEquals;

public class StringCalculatorStreamTest {
    @Test
    public void add_should_return_0_when_input_is_empty() {
        assertAdd(0.0, "");
    }

    @Test
    public void add_should_return_number_when_input_is_single_number() {
        assertAdd(1.0, "1");
    }

    @Test
    public void add_should_return_sum_when_input_are_2_numbers_separated_by_comma() {
        assertAdd(4.0, "1,3");
        assertAdd(4.4, "1.1,3.3");

    }

    @Test
    public void add_should_return_sum_when_input_are_more_than_2_numbers_separated_by_comma() {
        assertAdd(4.0, "1,2,1");
        assertAdd(5.0, "1,2,1,1");
    }

    @Test
    public void add_should_return_sum_when_input_are_more_than_2_numbers_separated_by_newline() {
        assertAdd(4.0, "1,2\n1");
        assertAdd(5.0, "1,2\n1\n1");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void add_should_throw_exception_when_input_is_invalid_1() {
        assertAdd(3.0, "1,2\n");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void add_should_throw_exception_when_input_is_invalid_2() {
        assertAdd(1.0, "1\n,");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void add_should_throw_exception_when_input_is_invalid_3() {
        assertAdd(4.0, "1\n,3");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void add_should_throw_exception_when_input_is_invalid_4() {
        assertAdd(4.0, "//s;1s2s1s1");
    }


    @Test
    public void add_should_return_sum_when_delimiter_is_specified() {
        assertAdd(4.0, "//;\n1;2;1");
        assertAdd(5.0, "//?\n1?2?1?1");
        assertAdd(5.0, "//s\n1s2s1s1");
    }

    public void assertAdd(double expected, String actual) {
        assertEquals(add(actual), expected);
    }

}
