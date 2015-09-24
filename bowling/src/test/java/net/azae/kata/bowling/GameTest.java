package net.azae.kata.bowling;

import org.testng.annotations.Test;

import java.util.function.Consumer;

import static org.testng.Assert.assertEquals;

public class GameTest {

    @Test
    public void ensure_score_is_zero_when_no_pin() {
        assertEquals(scoreOf(repeat(20, roll(0))), 0);
    }

    @Test
    public void ensure_score_is_sum_of_pin_when_no_bonnus() {
        assertEquals(scoreOf(repeat(20, roll(1))), 20);
    }

    @Test
    public void ensure_score_take_spare_bonus() {
        assertEquals(scoreOf(spare(5), roll(2), repeat(17, roll(0))), 14);
    }

    @Test
    public void ensure_score_take_strike_bonus() {
        assertEquals(scoreOf(strike(), roll(3), roll(2), repeat(18, roll(0))), 20);
    }

    @Test
    public void compute_max_score() {
        assertEquals(scoreOf(repeat(12, strike())), 300);
    }

    private static Consumer<Game> repeat(final int count, final Consumer<Game> action) {
        return game ->
        {
            for (int i = 0; i < count; i++) {
                action.accept(game);
            }
        };
    }

    private static Consumer<Game> strike() {
        return roll(10);
    }

    private static Consumer<Game> spare(final int first) {
        return roll(first).andThen(roll(10 - first));
    }

    private static Consumer<Game> roll(final int pins) {
        return game -> game.roll(pins);
    }

    @SafeVarargs
    private static int scoreOf(final Consumer<Game>... actions) {
        final Game game = new Game();
        for (final Consumer<Game> action : actions) {
            action.accept(game);
        }
        return game.score();
    }
}
