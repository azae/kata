package net.azae.kata.rpn.ast;

import org.testng.annotations.Test;

import static net.azae.kata.rpn.ast.NodeFactory.*;
import static net.azae.kata.rpn.ast.RenderRpn.render;
import static org.testng.Assert.assertEquals;

public class RenderRpnTest {

    @Test
    public void should_render_literal() {
        assertEquals(render(literal(4)), "4");
    }

    @Test
    public void should_render_addition() {
        assertEquals(render(add(literal(4), literal(3))), "4 3 +");
    }

    @Test
    public void should_render_subtraction() {
        assertEquals(render(sub(literal(4), literal(3))), "4 3 -");
    }

    @Test
    public void should_render_multiplication() {
        assertEquals(render(mul(literal(4), literal(3))), "4 3 *");
    }

    @Test
    public void should_render_division() {
        assertEquals(render(div(literal(4), literal(3))), "4 3 /");
    }

    @Test
    public void should_render_sqrt() {
        assertEquals(render(sqrt(literal(4))), "4 SQRT");
    }

    @Test
    public void should_render_complex_ast() {
        assertEquals(render(add(sub(literal(4), literal(3)), literal(1))), "4 3 - 1 +");
    }
}
