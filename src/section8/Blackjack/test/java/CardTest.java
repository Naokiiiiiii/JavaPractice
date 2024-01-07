package src.section8.Blackjack.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.section8.Blackjack.main.java.Card;
import src.section8.Blackjack.main.java.Rank;
import src.section8.Blackjack.main.java.Suit;

public class CardTest {
  @Test
  public void canGetValueOfATwoCard() {
    Card card1 = new Card(Suit.DIAMONDS, Rank.TWO);
    assertEquals(2, card1.getValue());
  }

  @Test
  public void canGetValueOfAThreeCard() {
    Card card1 = new Card(Suit.DIAMONDS, Rank.THREE);
    assertEquals(3, card1.getValue());
  }

  @Test
  public void canGetValueOfAnAceCard() {
    Card card1 = new Card(Suit.DIAMONDS, Rank.ACE);
    assertEquals(1, card1.getValue());
  }

  @Test
  public void canGetValueOfAJackCard() {
    Card card1 = new Card(Suit.DIAMONDS, Rank.JACK);
    assertEquals(10, card1.getValue());
  }

  @Test
  public void canGetValueOfAKingCard() {
    Card card1 = new Card(Suit.DIAMONDS, Rank.KING);
    assertEquals(10, card1.getValue());
  }
}
