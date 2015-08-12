package net.azae.kata.gameoflife;

import org.junit.Test;

import static net.azae.kata.gameoflife.Board.board;
import static org.junit.Assert.assertEquals;

public class BoardTest {
    @Test
    public void testLivingNeighbors_NoNeighbors() {
        assertEquals(0, board("....", "....", "....", "....").livingNeighborsCount(1, 1));
    }

    @Test
    public void testLivingNeighbors_One() {
        assertEquals(1, board(".*..", "....", "....", "....").livingNeighborsCount(1, 1));
        assertEquals(1, board("....", "*...", "....", "....").livingNeighborsCount(1, 1));
        assertEquals(1, board("....", "..*.", "....", "....").livingNeighborsCount(1, 1));
        assertEquals(1, board("....", "....", ".*..", "....").livingNeighborsCount(1, 1));
    }

    @Test
    public void testLivingNeighbors_Two() {
        assertEquals(2, board(".*..", "....", ".*..", "....").livingNeighborsCount(1, 1));
    }

    @Test
    public void testLivingNeighbors_Four() {
        assertEquals(4, board(".*..", "*.*.", ".*..", "....").livingNeighborsCount(1, 1));
    }

}
