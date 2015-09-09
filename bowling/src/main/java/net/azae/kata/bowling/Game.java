package net.azae.kata.bowling;

import com.google.common.collect.Lists;

import java.util.List;

public class Game {
    public static final int TOTAL_PINS = 10;
    public static final int FRAMES = 10;
    private final List<Integer> rolls = Lists.newArrayList();

    public void roll(final int pins) {
        rolls.add(pins);
    }

    public int score() {
        int frameIndex = 0;
        int score = 0;

        for (int frame = 0; frame < FRAMES; frame++) {
            if (isStrike(frameIndex)) {
                score += TOTAL_PINS + strikeBonus(frameIndex);
                frameIndex += 1;
            } else if (isSpare(frameIndex)) {
                score = TOTAL_PINS + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += frameScore(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(final int frame) {
        return rolls.get(frame) == TOTAL_PINS;
    }

    private boolean isSpare(final int frame) {
        return frameScore(frame) == TOTAL_PINS;
    }

    private int frameScore(final int frame) {
        return rolls.get(frame) + rolls.get(frame + 1);
    }

    private int strikeBonus(final int frame) {
        return rolls.get(frame + 1) + rolls.get(frame + 2);
    }

    private int spareBonus(final int frame) {
        return rolls.get(frame + 2);
    }
}
