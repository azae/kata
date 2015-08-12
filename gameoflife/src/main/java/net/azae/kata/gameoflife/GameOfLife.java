package net.azae.kata.gameoflife;

import static net.azae.kata.gameoflife.Status.DEAD;
import static net.azae.kata.gameoflife.Status.LIVE;

public class GameOfLife {
    private GameOfLife() {
    }

    public static Board evolve(final Board input) {
        final StringBuilder builder = new StringBuilder();
        for (int x = 0; x < input.width; x++) {
            for (int y = 0; y < input.height; y++) {
                if (computeStatus(input.cell(x, y), input.livingNeighborsCount(x, y)) == LIVE) {
                    builder.append('*');
                } else {
                    builder.append('.');
                }
            }
        }
        return Board.board(input.width, input.height, builder.toString());
    }

    public static Status computeStatus(final Status status, final int livingNeighbors) {
        switch (status) {
            case LIVE:
                return livingNeighbors == 2 || livingNeighbors == 3 ? LIVE : DEAD;
            case DEAD:
                return livingNeighbors == 3 ? LIVE : DEAD;
        }
        return DEAD;
    }
}
