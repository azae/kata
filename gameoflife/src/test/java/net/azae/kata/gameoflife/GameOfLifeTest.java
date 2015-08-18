package net.azae.kata.gameoflife;

import org.junit.Test;

import static net.azae.kata.gameoflife.Board.board;
import static net.azae.kata.gameoflife.GameOfLife.evolve;
import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    @Test
    public void testEmptyBoard() {
        assertEvolve(1,
                "  ....  ....  ",
                "  ....  ....  ",
                "  ....  ....  ",
                "  ....  ....  "
        );
    }

    @Test
    public void testOneCell() {
        assertEvolve(2,
                "  ....  ....  ....  ",
                "  .*..  ....  ....  ",
                "  ....  ....  ....  ",
                "  ....  ....  ....  "
        );
    }

    @Test
    public void testOneGeneration() {
        assertEvolve(2,
                "  ....  ....  ....  ",
                "  .**.  .**.  .**.  ",
                "  .*..  .**.  .**.  ",
                "  ....  ....  ....  "
        );
    }

    @Test
    public void testStableScenario() {
        assertEvolve(1,
                "  ....  ....  ",
                "  .**.  .**.  ",
                "  .**.  .**.  ",
                "  ....  ....  "
        );
    }

    @Test
    public void testBeehiveScenario() {
        assertEvolve(1,
                "  ......  ......  ",
                "  ..**..  .*...*",
                "  .*..*.  .*..*.  ",
                "  ..**..  *...*.  ",
                "  ......  ......  ");
    }

    @Test
    public void testLoafScenario() {
        assertEvolve(1,
                "  ......  ......  ",
                "  ..**..  ..*...  ",
                "  .*..*.  .*.*..  ",
                "  ..*.*.  .*..*.  ",
                "  ...*..  ..**..  ",
                "  ......  ......  ");
    }

    @Test
    public void testBoatScenario() {
        assertEvolve(1,
                "  .....  .....  ",
                "  .**..  .**..  ",
                "  .*.*.  .*.*.  ",
                "  ..*..  ..*..  ",
                "  .....  .....  ");
    }

    private static void assertEvolve(final int generations, final String... data) {
        Board current = extractBoard(data, 0);
        for (int i = 1; i <= generations; i++) {
            current = evolve(current);
            assertEquals(extractBoard(data, i), current);
        }
    }

    private static Board extractBoard(final String[] data, final int inex) {
        final int height = data.length;
        final StringBuilder builder = new StringBuilder();
        for (String d : data) {
            builder.append(d.trim().split("\\s+")[inex].trim());
        }
        final int width = builder.length() / height;
        return board(width, height, builder.toString());
    }
}
