package net.azae.kata.rpn.ast;

import org.testng.annotations.Test;

import static net.azae.kata.rpn.ast.EvaluatorDouble.evaluate;
import static net.azae.kata.rpn.ast.NodeFactory.*;
import static org.testng.Assert.assertEquals;

public class EvaluatorDoubleTest {
    public static final double DELTA = 0.001;

    @Test
    public void should_evaluate_literal() {
        assertEquals(evaluate(literal(4)), 4.0, DELTA);
    }

    @Test
    public void should_evaluate_addition() {
        assertEquals(evaluate(add(literal(4), literal(3))), 7, DELTA);
    }

    @Test
    public void should_evaluate_subtraction() {
        assertEquals(evaluate(sub(literal(4), literal(3))), 1, DELTA);
    }

    @Test
    public void should_evaluate_multiplication() {
        assertEquals(evaluate(mul(literal(4), literal(3))), 12, DELTA);
    }

    @Test
    public void should_evaluate_division() {
        assertEquals(evaluate(div(literal(6), literal(2))), 3, DELTA);
    }

    @Test
    public void should_evaluate_sqrt() {
        assertEquals(evaluate(sqrt(literal(4))), 2, DELTA);
    }

    @Test
    public void should_evaluate_square() {
        assertEquals(evaluate(square(literal(4))), 16, DELTA);
    }

    @Test
    public void should_render_neg() {
        assertEquals(evaluate(neg(literal(4))), -4, DELTA);
    }

    @Test
    public void should_evaluate_complex_expression() {
        assertEquals(evaluate(mul(add(literal(5), sqrt(literal(4))), sub(literal(5), literal(3)))), 14, DELTA);
    }
}
