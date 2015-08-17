package net.azae.kata.dsl;

public final class AttributeFactory {
    private AttributeFactory() {
    }

    public static Attribute attribute(final String name, final String value) {
        return new Attribute(name, value);
    }
}
