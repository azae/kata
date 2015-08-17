package net.azae.kata.rpn;

import org.junit.Test;

import java.util.NoSuchElementException;

import static net.azae.kata.rpn.RPNCalculator.compute;
import static org.junit.Assert.assertEquals;

public class RPNCalculatorTest {

    @Test
    public void testConst() {
        assertEquals(1, compute("1"));
    }

    @Test
    public void testAdd() {
        assertEquals(5, compute("2 3 +"));
    }

    @Test
    public void testSub() {
        assertEquals(6, compute("9 3 -"));
    }

    @Test
    public void testMul() {
        assertEquals(6, compute("2 3 *"));
    }

    @Test
    public void testDiv() {
        assertEquals(2, compute("6 3 /"));
    }

    @Test
    public void testComplexExpression() {
        assertEquals(3, compute("4 2 + 3 -"));
        assertEquals(141, compute("3 5 8 * 7 + *"));
    }

    @Test
    public void testSqrt() {
        assertEquals(2, compute("4 SQRT"));
    }

    @Test
    public void testMax() {
        assertEquals(12, compute("10 2 3 8 12 MAX"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testError() {
        compute("a");
    }

}
