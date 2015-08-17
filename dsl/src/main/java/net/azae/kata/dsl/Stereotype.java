package net.azae.kata.dsl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class Stereotype {
    private final String name;
    private final List<Skill> skills = Lists.newArrayList();

    public Stereotype(final String name, final Iterable<Skill> skills) {
        this.name = name;
        Iterables.addAll(this.skills, skills);
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return Collections.unmodifiableList(skills);
    }
}
