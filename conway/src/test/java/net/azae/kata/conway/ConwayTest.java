package net.azae.kata.conway;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConwayTest {

    @Test
    public void testConway() {
        assertEquals("1 1", Conway.conway("1"));
        assertEquals("2 1", Conway.conway("1 1"));
        assertEquals("1 2 1 1", Conway.conway("2 1"));
    }
}
