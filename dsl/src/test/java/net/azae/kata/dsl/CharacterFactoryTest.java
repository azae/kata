package net.azae.kata.dsl;

import org.junit.Test;

import static com.google.common.collect.Iterables.getOnlyElement;
import static net.azae.kata.dsl.AttributeFactory.attribute;
import static net.azae.kata.dsl.CharacterFactory.*;
import static net.azae.kata.dsl.StereotypeFactory.stereotype;
import static org.junit.Assert.assertEquals;

public class CharacterFactoryTest {

    @Test
    public void testCreateEmptyCharacter() {
        assertEquals("Mister X", character("Mister X").getName());
    }

    @Test
    public void testCreateCharacterWithRace() {
        assertEquals("Human", character("Mister X", race("Human")).getRace());
    }

    @Test
    public void testCreateCharacterWithStereotype() {
        final Stereotype warrior = stereotype("Warrior");
        assertEquals(warrior, character("Mister X", is(warrior)).getStereotype());
    }

    @Test
    public void testCreateCharacterWithAttributes() {
        final Attribute force = attribute("Force", "2D");
        assertEquals(force, getOnlyElement(character("Mister X", attributes(force)).getAttributes()));
    }


}
