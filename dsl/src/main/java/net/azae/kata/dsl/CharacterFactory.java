package net.azae.kata.dsl;

import com.google.common.collect.Lists;
import net.azae.kata.util.Closure;
import net.azae.kata.util.ClosureUtils;

import java.util.List;

import static java.util.Arrays.asList;

public final class CharacterFactory {

    public static class CharacterBuilder {
        String name;
        String race;
        Stereotype stereotype;
        final List<Skill> skills = Lists.newArrayList();
        final List<Item> items = Lists.newArrayList();

        public Character build() {
            return new Character(name, race, stereotype, skills, items);
        }
    }

    public static Closure<CharacterBuilder> name(final String value) {
        return new Closure<CharacterBuilder>() {
            public void process(final CharacterBuilder builder) {
                builder.name = value;
            }
        };
    }

    public static Closure<CharacterBuilder> race(final String value) {
        return new Closure<CharacterBuilder>() {
            public void process(final CharacterBuilder builder) {
                builder.race = value;
            }
        };
    }

    public static Closure<CharacterBuilder> stereotype(final Stereotype value) {
        return new Closure<CharacterBuilder>() {
            public void process(final CharacterBuilder builder) {
                builder.stereotype = value;
            }
        };
    }

    public static Character character(final Closure<CharacterBuilder>... actions) {
        return ClosureUtils.processAll(new CharacterBuilder(), asList(actions)).build();
    }
}
