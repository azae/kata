package net.azae.kata.stringcalculator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Function;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;

public class StringCalculatorTest {


    @DataProvider(name = "implementations")
    public static Object[][] implementations() {
        return stream(Implementations.values()).map(v -> new Object[]{v}).collect(toList()).toArray(new Object[][]{});
    }

    @Test(dataProvider = "implementations")
    public void add_should_return_0_when_input_is_empty(final StringCalculator calculator) {
        assertAdd(calculator, "", 0.0);
    }

    @Test(dataProvider = "implementations")
    public void add_should_return_number_when_input_is_single_number(final StringCalculator calculator) {
        assertAdd(calculator, "1", 1.0);
        assertAdd(calculator, ".5", 0.5);
        assertAdd(calculator, "2.1", 2.1);
    }

    @Test(dataProvider = "implementations")
    public void add_should_return_sum_when_input_are_2_numbers_separated_by_comma(final StringCalculator calculator) {
        assertAdd(calculator, "1,3", 4.0);
        assertAdd(calculator, "1.1,3.3", 4.4);

    }

    @Test(dataProvider = "implementations")
    public void add_should_return_sum_when_input_are_more_than_2_numbers_separated_by_comma(final StringCalculator calculator) {
        assertAdd(calculator, "1,2,1", 4.0);
        assertAdd(calculator, "1,2,1,1", 5.0);
    }

    @Test(dataProvider = "implementations")
    public void add_should_return_sum_when_input_are_more_than_2_numbers_separated_by_newline(final StringCalculator calculator) {
        assertAdd(calculator, "1,2\n1", 4.0);
        assertAdd(calculator, "1,2\n1\n1", 5.0);
    }

    @Test(dataProvider = "implementations", expectedExceptions = IllegalArgumentException.class)
    public void add_should_throw_exception_when_input_is_invalid_1(final StringCalculator calculator) {
        assertAdd(calculator, "1,2\n", 3.0);
    }

    @Test(dataProvider = "implementations", expectedExceptions = IllegalArgumentException.class)
    public void add_should_throw_exception_when_input_is_invalid_2(final StringCalculator calculator) {
        assertAdd(calculator, "1\n,", 1.0);
    }

    @Test(dataProvider = "implementations", expectedExceptions = IllegalArgumentException.class)
    public void add_should_throw_exception_when_input_is_invalid_3(final StringCalculator calculator) {
        assertAdd(calculator, "1\n,3", 4.0);
    }

    @Test(dataProvider = "implementations", expectedExceptions = IllegalArgumentException.class)
    public void add_should_throw_exception_when_input_is_invalid_4(final StringCalculator calculator) {
        assertAdd(calculator, "//s;1s2s1s1", 5.0);
    }


    @Test(dataProvider = "implementations")
    public void add_should_return_sum_when_delimiter_is_specified(final StringCalculator calculator) {
        assertAdd(calculator, "//;\n1;2;1", 4.0);
        assertAdd(calculator, "//?\n1?2?1?1", 5.0);
        assertAdd(calculator, "//s\n1s2s1s1", 5.0);
    }

    public static void assertAdd(final StringCalculator calculator, final String actual, final double expected) {
        assertEquals(calculator.add(actual), expected, 0.001);
    }

    private interface StringCalculator {
        double add(String input);
    }

    private enum Implementations implements StringCalculator {
        ONE_PASS(StringCalculatorOnePass::add),
        PARSER(StringCalculatorParser::add),
        STREAM(StringCalculatorStream::add);

        private final Function<String, Double> action;

        Implementations(final Function<String, Double> action) {
            this.action = action;
        }

        public double add(final String input) {
            return action.apply(input);
        }
    }
}
