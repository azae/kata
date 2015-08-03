package net.azae.kata.dsl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class Character {
    private final String name;
    private final String race;
    private final Stereotype stereotype;
    private final List<Skill> skills = Lists.newArrayList();
    private final List<Item> items = Lists.newArrayList();

    public Character(final String name, final String race, final Stereotype stereotype, final Iterable<Skill> skills, final Iterable<Item> items) {
        this.name = name;
        this.race = race;
        this.stereotype = stereotype;
        Iterables.addAll(this.skills, skills);
        Iterables.addAll(this.items, items);
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

    public List<Skill> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
