package src.section8.Blackjack.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.section8.Blackjack.main.java.Suit;

public class SuitTest {
  @Test
  public void heartPrintsHeart() {
    assertEquals('\u2665', Suit.HEARTS.toString());
  }
}
