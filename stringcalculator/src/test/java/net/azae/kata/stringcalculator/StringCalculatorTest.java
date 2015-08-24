package net.azae.kata.stringcalculator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringCalculatorTest {
    @Test
    public void add_should_return_0_when_input_is_empty () {
        Assert.assertEquals(0.0,StringCalculator.add(""));
    }
}
