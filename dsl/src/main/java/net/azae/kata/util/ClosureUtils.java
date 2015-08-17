package net.azae.kata.util;


import java.util.function.Consumer;

import static java.util.Arrays.asList;

public final class ClosureUtils {
    private ClosureUtils() {
    }

    public static <T> T processAll(final T subject, final Consumer<T>... consumers) {
        return processAll(subject, asList(consumers));
    }

    public static <T> T processAll(final T subject, final Iterable<Consumer<T>> consumers) {
        for (final Consumer<T> action : consumers) {
            if (action != null) {
                action.accept(subject);
            }
        }
        return subject;
    }

    public static <T> Consumer<T> compose(final Consumer<T>... closures) {
        return compose(asList(closures));
    }

    public static <T> Consumer<T> compose(final Iterable<Consumer<T>> closures) {
        return element -> processAll(element, closures);
    }
}
