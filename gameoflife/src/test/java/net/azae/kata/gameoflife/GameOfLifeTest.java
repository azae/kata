package net.azae.kata.gameoflife;

import org.junit.Test;

import static net.azae.kata.gameoflife.Board.board;
import static net.azae.kata.gameoflife.GameOfLife.evolve;
import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    @Test
    public void testEmptyBoard() {
        assertEvolve(1,
                "....", "....",
                "....", "....",
                "....", "....",
                "....", "...."
        );
    }

    @Test
    public void testOneCell() {
        assertEvolve(2,
                "....", "....", "....",
                ".*..", "....", "....",
                "....", "....", "....",
                "....", "....", "...."
        );
    }

    @Test
    public void testOneGeneration() {
        assertEvolve(2,
                "....", "....", "....",
                ".**.", ".**.", ".**.",
                ".*..", ".**.", ".**.",
                "....", "....", "...."
        );
    }

    @Test
    public void testStableScenario() {
        assertEvolve(1,
                "....", "....",
                ".**.", ".**.",
                ".**.", ".**.",
                "....", "...."
        );
    }

    @Test
    public void testBeehiveScenario() {
        assertEvolve(1,
                "......", "......",
                "..**..", ".*...*",
                ".*..*.", ".*..*.",
                "..**..", "*...*.",
                "......", "......");
    }

    @Test
    public void testLoafScenario() {
        assertEvolve(1,
                "......", "......",
                "..**..", "..*...",
                ".*..*.", ".*.*..",
                "..*.*.", ".*..*.",
                "...*..", "..**..",
                "......", "......");
    }

    @Test
    public void testBoatScenario() {
        assertEvolve(1,
                ".....", ".....",
                ".**..", ".**..",
                ".*.*.", ".*.*.",
                "..*..", "..*..",
                ".....", ".....");
    }

    private static void assertEvolve(final int generations, final String... data) {
        final int step = generations + 1;
        final int height = data.length / step;
        final int width = data[0].length();
        Board current = extractBoard(width, height, data, 0, step);
        for (int i = 1; i <= generations; i++) {
            current = evolve(current);
            assertEquals(extractBoard(width, height, data, i, step), current);
        }
    }

    private static Board extractBoard(final int width, final int height, final String[] data, final int starting, final int step) {
        final StringBuilder builder = new StringBuilder();
        for (int i = starting; i < data.length; i += step) {
            builder.append(data[i]);
        }
        return board(width, height, builder.toString());
    }
}
