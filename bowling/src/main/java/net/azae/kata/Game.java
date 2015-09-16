package net.azae.kata;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private int currentFrameNumber = 1;
    private Map<Integer, Frame> frames = new HashMap<>();

    public Game() {
        initFrames();
    }

    public void roll(int pins) {
        frames.get(currentFrameNumber).roll(pins);
        if (frames.get(currentFrameNumber).isClosed())
            currentFrameNumber++;
    }

    private void initFrames() {
        for (int i = 1; i <= 10; i++) {
            frames.put(i, new Frame());
        }
        frames.get(10).setLast();
    }

    public int score() {
        int score = 0;
        for (int i = 1; i <= 10; i++) {
            score += scoreOfFrame(i);
        }
        return score;
    }

    protected int scoreOfFrame(int numFrame) {
        Frame frame = frames.get(numFrame);
        int bonus = 0;
        if (nextFrameExist(numFrame)) {
            if (frame.isStrike()) {
                bonus = buildStrikeBonusForFrame(numFrame);
            }
            if (frame.isSpare()) {
                Frame nextFrame = frames.get(numFrame + 1);
                bonus = nextFrame.getSpareBonus();
            }
        }

        return frame.pins() + bonus;
    }

    private boolean nextFrameExist(int numFrame) {
        return frames.containsKey(numFrame + 1);
    }

    private int buildStrikeBonusForFrame(int numFrame) {
        Frame nextFrame = frames.get(numFrame + 1);

        int bonus;
        bonus = nextFrame.getStrikeBonus();
        if (nextFrame.isStrike()) {
            if (nextFrameExist(numFrame + 1)) {
                bonus += frames.get(numFrame + 2).getSpareBonus();
            }
        }
        return bonus;
    }

    public String toString() {
        String ret = getRollsAsString();
        ret += getIncrementalScoreAsString();

        return ret;
    }

    private String getIncrementalScoreAsString() {
        String ret = "|";

        int incrementalScore = 0;
        for (int i = 1; i < 10; i++) {
            incrementalScore += scoreOfFrame(i);
            ret += String.format(" %-3d ", incrementalScore) + "|";
        }
        incrementalScore += scoreOfFrame(10);
        ret += String.format(" %-5d ", incrementalScore) + "|";
        return ret;
    }

    private String getRollsAsString() {
        String ret = "|";
        for (int i = 1; i <= 10; i++) {
            ret += frames.get(i).detail() + "|";
        }

        ret += "\n";
        return ret;
    }

}
