package net.azae.kata.gameoflife;

import com.google.common.base.Joiner;

import static net.azae.kata.gameoflife.Status.DEAD;
import static net.azae.kata.gameoflife.Status.LIVE;

public final class Board {
    private final String data;
    public final int height;
    public final int width;

    public static Board board(final String... lines) {
        return new Board(lines[0].length(), lines.length, Joiner.on("").join(lines));
    }

    public static Board board(final int width, final int height, final String data) {
        return new Board(width, height, data);
    }

    private Board(final int width, final int height, final String data) {
        this.data = data;
        this.height = height;
        this.width = width;
    }

    public Status cell(final int x, final int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return DEAD;
        } else {
            return data.charAt(width * y + x) == '.' ? DEAD: LIVE;
        }
    }

    public boolean isLive(final int x, final int y) {
        return cell(x, y) == LIVE;
    }

    public int livingNeighborsCount(final int x, final int y) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if ((dx != 0 || dy != 0) && isLive(x + dx, y + dy)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return data.equals(((Board) other).data);

    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        return "Board{data='" + data + "'}";
    }
}
