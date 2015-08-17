package net.azae.kata.dsl;

import org.junit.Test;

import static net.azae.kata.dsl.AttributeFactory.attribute;
import static org.junit.Assert.assertEquals;

public class AttributeFactoryTest {

    @Test
    public void testNameOnAttributeCreation() {
        assertEquals("Force", attribute("Force", "4D").getName());
    }

    @Test
    public void testValueOnAttributeCreation() {
        assertEquals("4D", attribute("Force", "4D").getValue());
    }
}
