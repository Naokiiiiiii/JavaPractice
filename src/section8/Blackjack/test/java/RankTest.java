package src.section8.Blackjack.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.section8.Blackjack.main.java.Rank;

public class RankTest {
  @Test
  public void getValueOfKing() {
    assertEquals(10, Rank.KING.getValue());
  }
}
