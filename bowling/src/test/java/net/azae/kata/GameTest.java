package net.azae.kata;


import org.testng.Assert;
import org.testng.annotations.Test;

public class GameTest {

    @Test
    public void score_for_frame_should_return_pins_knocked_by_first_round() {
        Game game = new Game();
        game.roll(7);
        Assert.assertEquals(game.scoreOfFrame(1), 7);
    }

    @Test
    public void score_for_frame_should_return_pins_knocked_by_first_try() {
        Game game = new Game();
        playToFrame(game, 2);
        game.roll(7);
        Assert.assertEquals(game.scoreOfFrame(2), 7);
    }

    @Test
    public void score_for_frame_should_return_sum_of_pins_knocked_by_two_try() {
        Game game = new Game();
        roll(game, 7, 1);
        Assert.assertEquals(game.scoreOfFrame(1), 8);
    }

    @Test
    public void score_for_frame_with_spare() {
        Game game = new Game();
        roll(game, 7, 3, 5);
        Assert.assertEquals(game.scoreOfFrame(1), 15);
    }

    @Test
    public void score_for_frame_with_strike() {
        Game game = new Game();
        roll(game, 10, 3, 5);
        Assert.assertEquals(game.scoreOfFrame(1), 18);
    }

    @Test
    public void score_for_frame_with_3_strikes() {
        Game game = new Game();
        roll(game, 10, 10, 5);
        Assert.assertEquals(game.scoreOfFrame(1), 25);
    }

    @Test
    public void after_strike_next_roll_is_for_next_frame() {
        Game game = new Game();
        roll(game, 10, 3);
        Assert.assertEquals(game.scoreOfFrame(2), 3);
    }

    @Test
    public void third_roll_is_for_next_frame() {
        Game game = new Game();
        roll(game, 1, 3, 5);
        Assert.assertEquals(game.scoreOfFrame(2), 5);
    }

    @Test
    public void score_of_last_frame_with_strike_is_sum_of_3_roll() {
        Game game = new Game();
        playToFrame(game, 10);
        roll(game, 10, 3, 6);
        Assert.assertEquals(game.scoreOfFrame(10), 19);
    }

    @Test
    public void score_of_last_frame_with_3_strikes_is_30() {
        Game game = new Game();
        playToFrame(game, 10);
        roll(game, 10, 10, 10);
        Assert.assertEquals(game.scoreOfFrame(10), 30);
    }

    @Test
    public void score_of_frame_8_with_2_strikes() {
        Game game = new Game();
        playToFrame(game, 8);
        roll(game, 10, 10, 5);
        Assert.assertEquals(game.scoreOfFrame(8), 25);
    }

    private void playToFrame(Game game, int frame) {
        for (int i=2; i< frame * 2 ; i++) {
            game.roll(0);
        }
    }

    @Test
    public void score_should_return_sum_of_frame_score() {
        Game game = new Game();
        roll(game, 1, 4, 4, 5);
        Assert.assertEquals(game.score(), 14);
    }

    @Test
    public void score_should_return_sum_of_all_frame_score() {
        Game game = new Game();
        roll(game, 1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6);
        Assert.assertEquals(game.score(), 133);
    }


    @Test
    public void toString_must_be_same_as_README() {
        Game game = new Game();
        roll(game, 1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6);
        String expected = "| 1 4 | 4 5 | 6 / | 5 / | X   | 0 1 | 7 / | 6 / | X   | 2 / 6 |\n" +
                "| 5   | 14  | 29  | 49  | 60  | 61  | 77  | 97  | 117 | 133   |";
        Assert.assertEquals(game.toString(), expected);
    }

    private void roll(Game game, int... rolls) {
        for (int pin : rolls) {
            game.roll(pin);
        }
    }

}
