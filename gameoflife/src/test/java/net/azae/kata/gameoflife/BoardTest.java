package net.azae.kata.gameoflife;

import org.junit.Test;

import static net.azae.kata.gameoflife.Board.board;
import static org.junit.Assert.assertEquals;

public class BoardTest {
    @Test
    public void testLivingNeighbors_NoNeighbors() {
        assertEquals(0, livingNeighborsCountOfX(
                "...",
                ".x.",
                "..."));
    }

    @Test
    public void testLivingNeighbors_North() {
        assertEquals(1, livingNeighborsCountOfX(
                ".#.",
                ".x.",
                "..."));
    }

    @Test
    public void testLivingNeighbors_NorthEast() {
        assertEquals(1, livingNeighborsCountOfX(
                "..#",
                ".x.",
                "..."));
    }

    @Test
    public void testLivingNeighbors_East() {
        assertEquals(1, livingNeighborsCountOfX(
                "...",
                ".x#",
                "..."));
    }

    @Test
    public void testLivingNeighbors_SouthEast() {
        assertEquals(1, livingNeighborsCountOfX(
                "...",
                ".x.",
                "..#"));
    }

    @Test
    public void testLivingNeighbors_South() {
        assertEquals(1, livingNeighborsCountOfX(
                "...",
                ".x.",
                ".#."));
    }

    @Test
    public void testLivingNeighbors_SouthWest() {
        assertEquals(1, livingNeighborsCountOfX(
                "...",
                ".x.",
                "#.."));
    }

    @Test
    public void testLivingNeighbors_West() {
        assertEquals(1, livingNeighborsCountOfX(
                "...",
                "#x.",
                "..."));
    }

    @Test
    public void testLivingNeighbors_NorthWest() {
        assertEquals(1, livingNeighborsCountOfX(
                "#..",
                ".x.",
                "..."));
    }

    @Test
    public void exampleWithTwoLivingNeighbors() {
        assertEquals(2, livingNeighborsCountOfX(
                ".#.",
                ".x.",
                ".#."));
    }

    @Test
    public void exampleWithThreeLivingNeighbors() {
        assertEquals(3, livingNeighborsCountOfX(
                ".##",
                ".x.",
                ".#."));
    }

    @Test
    public void exampleWithFourLivingNeighbors() {
        assertEquals(4, livingNeighborsCountOfX(
                ".#.",
                "#x#",
                ".#."));
    }

    @Test
    public void exampleWithFiveLivingNeighbors() {
        assertEquals(5, livingNeighborsCountOfX(
                "##.",
                "#x#",
                ".#."));
    }

    @Test
    public void exampleWithSixLivingNeighbors() {
        assertEquals(6, livingNeighborsCountOfX(
                "###",
                "#x#",
                ".#."));
    }

    @Test
    public void exampleWithSevenLivingNeighbors() {
        assertEquals(7, livingNeighborsCountOfX(
                "###",
                "#x#",
                ".##"));
    }

    @Test
    public void exampleWithHeightLivingNeighbors() {
        assertEquals(8, livingNeighborsCountOfX(
                "###",
                "#x#",
                "###"));
    }

    @Test
    public void testLivingNeighbors_CountOnlyImmediateNeighbors() {
        assertEquals(0, livingNeighborsCountOfX(
                "#####",
                "#...#",
                "#.x.#",
                "#...#",
                "#####"));
    }

    @Test
    public void testLivingNeighbors_Bug01() {
        assertEquals(1, livingNeighborsCountOfX(
                "......",
                "..##.x",
                ".#..#.",
                "..##..",
                "......",
                "......"));
    }

    private static int livingNeighborsCountOfX(final String... data) {
        int x = 0;
        int y = 0;
        for (; y < data.length; y++) {
            x = data[y].indexOf('x');
            if (x >= 0) {
                break;
            }
        }
        return board(data).livingNeighborsCount(x, y);
    }
}
