package net.azae.kata.gameoflife;

import org.junit.Test;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
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

    private static void assertEvolve(final int generations, final String... lines) {
        Board current = extractBoard(lines, 0);
        for (int i = 1; i <= generations; i++) {
            current = evolve(current);
            assertEquals(extractBoard(lines, i), current);
        }
    }

    private static Board extractBoard(final String[] lines, final int inex) {
        final int height = lines.length;
        final String data = stream(lines).map(String::trim).map(s -> s.split("\\s+")[inex]).collect(joining());
        final int width = data.length() / height;
        return board(width, height, data);
    }
}
