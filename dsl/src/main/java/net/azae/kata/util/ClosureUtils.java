package net.azae.kata.util;


import static java.util.Arrays.asList;

public final class ClosureUtils {
    private ClosureUtils() {
    }

    public static <T> T processAll(final T subject, final Closure<T>... closures) {
        return processAll(subject, asList(closures));
    }

    public static <T> T processAll(final T subject, final Iterable<Closure<T>> closures) {
        for (final Closure<T> action : closures) {
            if (action != null) {
                action.process(subject);
            }
        }
        return subject;
    }

    public static <T> Closure<T> nop() {
        return new Closure<T>() {
            public void process(final T element) {
                // do nothing
            }
        };
    }

    public static <T> Closure<T> compose(final Closure<T>... closures) {
        return compose(asList(closures));
    }

    public static <T> Closure<T> compose(final Iterable<Closure<T>> closures) {
        return new Closure<T>() {
            public void process(final T element) {
                processAll(element, closures);
            }
        };
    }
}
