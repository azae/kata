package net.azae.kata;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int currentFrameNumber = 0;
    private List<Frame> frames = new ArrayList<>();

    public Game() {
        initFrames();
    }

    public void roll(int pins) {
        frames.get(currentFrameNumber).roll(pins);
        if (frames.get(currentFrameNumber).isClosed())
            currentFrameNumber++;
    }

    private void initFrames() {
        while (frames.size() < 10) {
            frames.add(new Frame());
        }
        frames.get(9).setLast();
    }

    public int score() {
        int score = 0;
        for (int i = 0; i < 10; i++) {
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
        return frames.size() > numFrame + 1;
    }

    private int buildStrikeBonusForFrame(int numFrame) {
        Frame nextFrame = frames.get(numFrame + 1);

        int bonus;
        bonus = nextFrame.getStrikeBonus();
        if (nextFrame.isStrike()) {
            if (nextFrameExist(numFrame +1)) {
                bonus += frames.get(numFrame + 2).getSpareBonus();
            }
        }
        return bonus;
    }

    protected void setFrameAndRound(int frame, int round) {
        this.currentFrameNumber = frame;
        frames.get(currentFrameNumber).setRound(round);
    }

    public String toString() {
        String ret = getRollsAsString();
        ret += getIncrementalScoreAsString();

        return ret;
    }

    private String getIncrementalScoreAsString() {
        String ret = "|";

        int incrementalScore = 0;
        for (int i = 0; i < 9; i++) {
            incrementalScore += scoreOfFrame(i);
            ret += String.format(" %-3d ", incrementalScore) + "|";
        }
        incrementalScore += scoreOfFrame(9);
        ret += String.format(" %-5d ", incrementalScore) + "|";
        return ret;
    }

    private String getRollsAsString() {
        String ret = "|";
        for (int i = 0; i < 10; i++) {
            ret += frames.get(i).detail() + "|";
        }

        ret += "\n";
        return ret;
    }

}
