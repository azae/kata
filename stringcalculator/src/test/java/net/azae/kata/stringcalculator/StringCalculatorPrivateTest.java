package net.azae.kata.stringcalculator;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;

import static net.azae.kata.stringcalculator.StringCalculator.add;
import static org.testng.Assert.assertEquals;

public class StringCalculatorPrivateTest {
    @Test
    public void test_count_separator() {
        Assert.assertEquals(0,StringCalculator.countSeparators("1"));
        Assert.assertEquals(1,StringCalculator.countSeparators("1,2"));
        Assert.assertEquals(2,StringCalculator.countSeparators("1,2\n"));
    }

}
