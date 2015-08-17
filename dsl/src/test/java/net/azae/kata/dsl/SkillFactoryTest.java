package net.azae.kata.dsl;

import org.junit.Test;

import static net.azae.kata.dsl.SkillFactory.skill;
import static org.junit.Assert.assertEquals;

public class SkillFactoryTest {

    @Test
    public void testNameOnSkillCreation() {
        assertEquals("Riding", skill("Riding", "Agility", "1D").getName());
    }

    @Test
    public void testAttributeOnSkillCreation() {
        assertEquals("Agility", skill("Riding", "Agility", "1D").getAttribute());
    }

    @Test
    public void testValueOnSkillCreation() {
        assertEquals("1D", skill("Riding", "Agility", "1D").getValue());
    }
}
