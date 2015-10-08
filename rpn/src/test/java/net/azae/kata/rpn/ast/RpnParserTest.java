package net.azae.kata.rpn.ast;

import org.testng.annotations.Test;

import static net.azae.kata.rpn.ast.RenderRpn.render;
import static org.testng.Assert.assertEquals;

public class RpnParserTest {
    @Test
    public void should_parse_literal() {
        assertEquals(parse("4"), "4");
    }

    @Test
    public void should_parse_addition() {
        assertEquals(parse("4 3 +"), "4 3 +");
    }

    @Test
    public void should_parse_subtraction() {
        assertEquals(parse("4 3 -"), "4 3 -");
    }

    @Test
    public void should_parse_multiplication() {
        assertEquals(parse("4 3 *"), "4 3 *");
    }

    @Test
    public void should_parse_division() {
        assertEquals(parse("4 3 /"), "4 3 /");
    }

    @Test
    public void should_parse_sqrt() {
        assertEquals(parse("4 SQRT"), "4 SQRT");
    }

    @Test
    public void should_parse_neg() {
        assertEquals(parse("4 NEG"), "4 NEG");
    }

    @Test
    public void should_parse_complex_expression_with_operators_at_the_end() {
        assertEquals(parse("1 2 3 4 5 + - * /"), "1 2 3 4 5 + - * /");
    }

    @Test
    public void should_parse_complex_expression_with_operators_mixed_between_operands() {
        assertEquals(parse("1 2 + 3 - 4 * 5 /"), "1 2 + 3 - 4 * 5 /");
    }

    private static String parse(final String input) {
        return render(new RpnParser().parse(input));
    }
}
