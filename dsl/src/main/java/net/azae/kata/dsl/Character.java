package net.azae.kata.dsl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class Character {
    private final String name;
    private final String race;
    private final Stereotype stereotype;
    private final List<Attribute> attributes = Lists.newArrayList();
    private final List<Skill> skills = Lists.newArrayList();

    public Character(final String name, final String race, final Stereotype stereotype, final Iterable<Attribute> attributes, final Iterable<Skill> skills) {
        this.name = name;
        this.race = race;
        this.stereotype = stereotype;
        Iterables.addAll(this.attributes, attributes);
        Iterables.addAll(this.skills, skills);
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public Stereotype getStereotype() {
        return stereotype;
    }

    public List<Attribute> getAttributes() {
        return Collections.unmodifiableList(attributes);
    }

    public List<Skill> getSkills() {
        return Collections.unmodifiableList(skills);
    }
}
