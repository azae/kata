package net.azae.kata.bowling;

import org.testng.annotations.Test;

import java.util.function.Consumer;

import static org.testng.Assert.assertEquals;

public class GameTest {

    @Test
    public void ensure_score_is_zero_when_no_pin() {
        assertEquals(scoreOf(rolls(20, 0)), 0);
    }

    @Test
    public void ensure_score_is_sum_of_pin_when_no_bonnus() {
        assertEquals(scoreOf(rolls(20, 1)), 20);
    }

    @Test
    public void ensure_score_take_spare_bonus() {
        assertEquals(scoreOf(spare(5), roll(2), rolls(17, 0)), 14);
    }

    @Test
    public void ensure_score_take_strike_bonus() {
        assertEquals(scoreOf(strike(), roll(3), roll(2), rolls(18, 0)), 20);
    }

    @Test
    public void compute_max_score() {
        assertEquals(scoreOf(strikes(12)), 300);
    }

    private static Consumer<Game> strikes(final int count) {
        return game ->
        {
            for (int i = 0; i < count; i++) {
                game.roll(10);
            }
        };
    }

    private static Consumer<Game> strike() {
        return game -> game.roll(10);
    }

    private static Consumer<Game> spare(final int pins) {
        return game -> {
            game.roll(pins);
            game.roll(10 - pins);
        };
    }

    private static Consumer<Game> roll(final int pins) {
        return game -> game.roll(pins);
    }

    private static Consumer<Game> rolls(final int count, final int pins) {
        return game -> {
            for (int i = 0; i < count; i++) {
                game.roll(pins);
            }
        };
    }

    private static int scoreOf(final Consumer<Game>... actions) {
        final Game game = new Game();
        for (final Consumer<Game> action : actions) {
            action.accept(game);
        }
        return game.score();
    }
}
