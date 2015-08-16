package net.azae.kata.gameoflife;

import static net.azae.kata.gameoflife.Status.DEAD;
import static net.azae.kata.gameoflife.Status.LIVE;

public final class GamesRules {

    public static Status computeStatus(final Status status, final int livingNeighbors) {
        switch (status) {
            case LIVE:
                return livingNeighbors == 2 || livingNeighbors == 3 ? LIVE : DEAD;
            case DEAD:
                return livingNeighbors == 3 ? LIVE : DEAD;
        }
        return DEAD;
    }

    private GamesRules() {
    }
}
