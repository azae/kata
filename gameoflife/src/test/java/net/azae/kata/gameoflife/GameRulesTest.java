package net.azae.kata.gameoflife;

import org.junit.Test;

import static net.azae.kata.gameoflife.GamesRules.computeStatus;
import static net.azae.kata.gameoflife.Status.DEAD;
import static net.azae.kata.gameoflife.Status.LIVE;
import static org.junit.Assert.assertEquals;

public class GameRulesTest {

    @Test
    public void ensureLiveZoneWithLessThanTwoLivingNeighborsDies() {
        aCell(LIVE).withLivingNeighbors(0).becomes(DEAD);
        aCell(LIVE).withLivingNeighbors(1).becomes(DEAD);
    }

    @Test
    public void ensureLiveZoneWithMoreThanThreeLivingNeighborsDies() {
        aCell(LIVE).withLivingNeighbors(4).becomes(DEAD);
        aCell(LIVE).withLivingNeighbors(5).becomes(DEAD);
        aCell(LIVE).withLivingNeighbors(6).becomes(DEAD);
        aCell(LIVE).withLivingNeighbors(7).becomes(DEAD);
        aCell(LIVE).withLivingNeighbors(8).becomes(DEAD);
    }

    @Test
    public void ensureLiveZoneWithTwoOrThreeLivingNeighborsStaysAlive() {
        aCell(LIVE).withLivingNeighbors(2).stays(LIVE);
        aCell(LIVE).withLivingNeighbors(3).stays(LIVE);
    }

    @Test
    public void ensureDeadZoneWithThreeLivingNeighborsBecomesLive() {
        aCell(DEAD).withLivingNeighbors(3).becomes(LIVE);
    }

    @Test
    public void ensureDeadZoneWithNotThreeLivingNeighborsStaysDead() {
        aCell(DEAD).withLivingNeighbors(0).stays(DEAD);
        aCell(DEAD).withLivingNeighbors(1).stays(DEAD);
        aCell(DEAD).withLivingNeighbors(2).stays(DEAD);
        aCell(DEAD).withLivingNeighbors(4).stays(DEAD);
        aCell(DEAD).withLivingNeighbors(5).stays(DEAD);
        aCell(DEAD).withLivingNeighbors(6).stays(DEAD);
        aCell(DEAD).withLivingNeighbors(7).stays(DEAD);
        aCell(DEAD).withLivingNeighbors(8).stays(DEAD);
    }

    interface OracleDefinition {
        void becomes(final Status expected);

        void stays(final Status expected);
    }

    interface LivingNeighborsDefinition {
        OracleDefinition withLivingNeighbors(final int count);
    }

    private static LivingNeighborsDefinition aCell(final Status initial) {
        return count -> new OracleDefinition() {
            public void becomes(final Status expected) {
                assertStatus(initial, count, expected);
            }

            public void stays(final Status expected) {
                assertStatus(initial, count, expected);
            }
        };
    }

    private static void assertStatus(final Status initial, final int livingNeighbors, final Status expected) {
        assertEquals(expected, computeStatus(initial, livingNeighbors));
    }
}
