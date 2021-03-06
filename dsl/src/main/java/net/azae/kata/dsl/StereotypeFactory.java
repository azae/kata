package net.azae.kata.dsl;

import com.google.common.collect.Iterables;
import net.azae.kata.util.ClosureUtils;

import java.util.List;
import java.util.function.Consumer;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;

public final class StereotypeFactory {

    private StereotypeFactory() {
    }

    public static class StereotypeBuilder {
        final List<Skill> skills = newArrayList();

        Stereotype build(final String name) {
            return new Stereotype(name, skills);
        }
    }

    public static Consumer<StereotypeBuilder> skills(final Skill... skills) {
        return builder -> Iterables.addAll(builder.skills, asList(skills));
    }

    @SafeVarargs
    public static Stereotype stereotype(final String name, final Consumer<StereotypeBuilder>... actions) {
        return ClosureUtils.processAll(new StereotypeBuilder(), asList(actions)).build(name);
    }
}
