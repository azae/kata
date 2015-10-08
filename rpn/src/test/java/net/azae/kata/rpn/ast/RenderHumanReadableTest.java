package net.azae.kata.rpn.ast;

import org.testng.annotations.Test;

import static net.azae.kata.rpn.ast.NodeFactory.*;
import static net.azae.kata.rpn.ast.RenderHumanReadable.render;
import static org.testng.Assert.assertEquals;

public class RenderHumanReadableTest {
    @Test
    public void should_render_integer_literal() {
        assertEquals(render(literal(4)), "4");
    }

    @Test
    public void should_render_double_literal() {
        assertEquals(render(literal(4.25)), "4.25");
    }

    @Test
    public void should_render_addition() {
        assertEquals(render(add(literal(4), literal(3))), "4 + 3");
    }


    @Test
    public void should_render_subtraction() {
        assertEquals(render(sub(literal(4), literal(3))), "4 - 3");
    }

    @Test
    public void should_render_multiplication() {
        assertEquals(render(mul(literal(4), literal(3))), "4 * 3");
    }

    @Test
    public void should_render_division() {
        assertEquals(render(div(literal(4), literal(3))), "4 / 3");
    }

    @Test
    public void should_render_sqrt() {
        assertEquals(render(sqrt(literal(4))), "SQRT(4)");
    }

    @Test
    public void should_render_neg() {
        assertEquals(render(neg(literal(4))), "NEG(4)");
    }

    @Test
    public void should_render_ast_when_parenthesis_not_needed() {
        assertEquals(render(add(mul(literal(4), literal(3)), literal(1))), "4 * 3 + 1");
    }

    @Test
    public void should_render_ast_when_parenthesis_required() {
        assertEquals(render(mul(add(literal(4), literal(3)), literal(5))), "(4 + 3) * 5");
    }

    @Test
    public void should_render_ast_sqrt_should_not_have_double_parenthesis() {
        assertEquals(render(mul(sqrt(add(literal(4), literal(3))), literal(5))), "SQRT(4 + 3) * 5");
    }
}
