package net.azae.kata.rpn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RPNCalculatorTest {

    @Test
    public void testConst() {
        assertEquals(1, RPNCalculator.compute("1"));
    }

    @Test
    public void testAdd() {
        assertEquals(5, RPNCalculator.compute("2 3 +"));
    }

    @Test
    public void testSub() {
        assertEquals(6, RPNCalculator.compute("9 3 -"));
    }

    @Test
    public void testMul() {
        assertEquals(6, RPNCalculator.compute("2 3 *"));
    }

    @Test
    public void testDiv() {
        assertEquals(2, RPNCalculator.compute("6 3 /"));
    }

    @Test
    public void testComplexExpression() {
        assertEquals(3, RPNCalculator.compute("4 2 + 3 -"));
        assertEquals(141, RPNCalculator.compute("3 5 8 * 7 + *"));
    }

    @Test
    public void testSqrt() {
        assertEquals(2, RPNCalculator.compute("4 SQRT"));
    }

    @Test
    public void testMax() {
        assertEquals(12, RPNCalculator.compute("10 2 3 8 12 MAX"));
    }

}
