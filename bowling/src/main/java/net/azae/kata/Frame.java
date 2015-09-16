package net.azae.kata;

import java.util.stream.IntStream;

public class Frame {
    int[] rounds = new int[3];
    int currentRound = 0;
    boolean isLastFrame = false;

    public void roll(int pins) {
        rounds[currentRound] = pins;
        currentRound++;
    }

    public boolean isClosed() {
        if (isLastFrame && currentRound <= 2) {
            return false;
        }
        return isStrike() || isSpare() || currentRound > 1;
    }

    public boolean isStrike() {
        return rounds[0] == 10;
    }

    public void setRound(int round) {
        currentRound = round;
    }

    public boolean isSpare() {
        return rounds[0] + rounds[1] == 10 && rounds[0] < 10;
    }

    public int pins() {
        return IntStream.of(rounds).sum();
    }

    public int getStrikeBonus() {
        return rounds[0] + rounds[1];
    }

    public int getSpareBonus() {
        return rounds[0];
    }

    public String detail() {
        String rolls = "";
        if (isStrike())
            rolls = " X   ";
        else if (isSpare())
            rolls = " " + rounds[0] + " / ";
        else
            rolls = " " + rounds[0] + " " + rounds[1] + " ";
        if (rounds[2] == 0)
            return rolls;
        else
            return rolls + rounds[2] + " ";
    }

    public void setLast() {
        isLastFrame = true;
    }
}
