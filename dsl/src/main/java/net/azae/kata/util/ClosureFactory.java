package net.azae.kata.util;

import com.google.common.base.Predicate;

import java.util.Collection;

public final class ClosureFactory {
    private ClosureFactory() {
    }

    public static <T> Closure<T> collect(final Collection<T> collector) {
        return new Closure<T>() {
            public void process(final T element) {
                collector.add(element);
            }
        };
    }

    public static <T> Closure<T> processif(final Predicate<T> predicate, final Closure<T> closure) {
        return new Closure<T>() {
            public void process(final T element) {
                if (predicate.apply(element)) {
                    closure.process(element);
                }
            }
        };
    }
}
