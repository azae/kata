package net.azae.kata.gameoflife;

import org.junit.Test;

import static net.azae.kata.gameoflife.Board.board;
import static net.azae.kata.gameoflife.GameOfLife.evolve;
import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    @Test
    public void testEmptyBoard() {
        assertEquals(board("....", "....", "....", "...."), evolve(board("....", "....", "....", "....")));
    }

    @Test
    public void testOneCell() {
        assertEquals(board("....", "....", "....", "...."), evolve(board("....", ".*..", "....", "....")));
    }
}
