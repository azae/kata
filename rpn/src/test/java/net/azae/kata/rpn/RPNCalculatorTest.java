package net.azae.kata.rpn;

import org.testng.Assert;
import org.testng.annotations.Test;

import static net.azae.kata.rpn.RPNCalculator.compute;

public class RPNCalculatorTest {

    @Test
    public void testConstant() {
        assertComputeEquals(1, "1");
        assertComputeEquals(0.6, "0.6");
    }

    @Test
    public void testAdd() {
        assertComputeEquals(5, "2 3 +");
    }

    @Test
    public void testSub() {
        assertComputeEquals(6, "9 3 -");
    }

    @Test
    public void testMul() {
        assertComputeEquals(6, "2 3 *");
    }

    @Test
    public void testDiv() {
        assertComputeEquals(2, "6 3 /");
        assertComputeEquals(0.5, "1 2 /");
    }

    @Test
    public void testComplexExpression() {
        assertComputeEquals(3, "4 2 + 3 -");
        assertComputeEquals(141, "3 5 8 * 7 + *");
    }

    @Test
    public void testSqrt() {
        assertComputeEquals(2, "4 SQRT");
    }

    @Test
    public void testMax() {
        assertComputeEquals(12, "10 2 3 8 12 MAX");
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testError() {
        compute("a");
    }

    @Test
    public void testSpecialsSeparators() {
        assertComputeEquals(7, "1\n4    2\t + +");
    }

    private static void assertComputeEquals(final double expected, final String input) {
        Assert.assertEquals(expected, compute(input), 0.001);
    }
}
