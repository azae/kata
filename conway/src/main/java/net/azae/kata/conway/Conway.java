package net.azae.kata.conway;

import com.google.common.collect.Lists;

import java.util.Collection;

import static java.util.stream.Collectors.joining;

public class Conway {
    private Conway() {
    }

    public static String conway(final String input) {
        final Collection<String> collector = Lists.newArrayList();
        String current = null;
        int count = 1;
        for (final String atom : input.split(" ")) {
            if (current == null) {
                current = atom;
            } else if (atom.equals(current)) {
                count++;
            } else {
                collect(collector, current, count);
                current = atom;
                count = 1;
            }
        }
        collect(collector, current, count);
        return collector.stream().collect(joining(" "));
    }

    private static void collect(final Collection<String> collector, final String current, final int count) {
        collector.add(String.valueOf(count));
        collector.add(current);
    }

}
