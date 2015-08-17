package net.azae.kata.dsl;

public class Skill {
    private final String name;
    private final String attribute;
    private String value;

    public Skill(final String name, final String attribute, final String value) {
        this.name = name;
        this.attribute = attribute;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
