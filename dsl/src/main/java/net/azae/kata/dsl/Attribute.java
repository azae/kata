package net.azae.kata.dsl;

public class Attribute {
    private final String name;
    private String value;

    public Attribute(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
