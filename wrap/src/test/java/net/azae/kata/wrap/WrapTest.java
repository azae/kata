package net.azae.kata.wrap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class WrapTest {
    /*
	Il était une fois un gentilhomme qui épousa, en secondes noces, une femme, la
	plus hautaine et la plus fière qu’on eût jamais vue. Elle avait deux filles de
	son humeur, et qui lui ressemblaient en toutes choses. Le mari avait, de son
	côté, une jeune fille, mais d’une douceur et d’une bonté sans exemple : elle
	tenait cela de sa mère, qui était la meilleure personne du monde.
	*/

    //private final WrapRecursive wrap = new WrapRecursive();
    //private final WrapTailRecursive wrap = new WrapTailRecursive();
    private final WrapLoop2 wrap = new WrapLoop2();

    @Test
    public void test_wrap_short_line() {
        assertEquals("Il était une fois un gentilhomme qui épousa", wrap.wrapLine("Il était une fois un gentilhomme qui épousa", 80));
        assertEquals("en secondes noces", wrap.wrapLine("en secondes noces", 80));
    }

    @Test
    public void test_wrap_one_time() {
        String expected =
                "Il était une fois un gentilhomme qui épousa, en secondes noces, une femme, la\n" +
                        "plus hautaine et la plus fière qu’on eût jamais vue.";
        String actual =
                "Il était une fois un gentilhomme qui épousa, en secondes noces, une femme, la " +
                        "plus hautaine et la plus fière qu’on eût jamais vue.";

        assertEquals(expected, wrap.wrapLine(actual, 80));
    }

    @Test
    public void test_wrap_many_times() {
        String expected =
                "Il était une fois un gentilhomme qui épousa, en secondes noces, une femme, la\n" +
                        "plus hautaine et la plus fière qu’on eût jamais vue. Elle avait deux filles de\n" +
                        "son humeur, et qui lui ressemblaient en toutes choses. Le mari avait, de son\n" +
                        "côté, une jeune fille, mais d’une douceur et d’une bonté sans exemple : elle\n" +
                        "tenait cela de sa mère, qui était la meilleure personne du monde.";
        String actual =
                "Il était une fois un gentilhomme qui épousa, en secondes noces, une femme, la " +
                        "plus hautaine et la plus fière qu’on eût jamais vue. Elle avait deux filles de " +
                        "son humeur, et qui lui ressemblaient en toutes choses. Le mari avait, de son " +
                        "côté, une jeune fille, mais d’une douceur et d’une bonté sans exemple : elle " +
                        "tenait cela de sa mère, qui était la meilleure personne du monde.";
        assertEquals(expected, wrap.wrapLine(actual, 80));
    }


}
