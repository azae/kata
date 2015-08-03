package net.azae.kata.dsl;

public final class SkillFactory {

    private SkillFactory() {
    }

    public static Skill skill(final String name, final String attribute, final String value) {
        return new Skill(name, attribute, value);
    }
}
