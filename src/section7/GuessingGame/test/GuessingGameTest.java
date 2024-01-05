package src.section7.GuessingGame.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.section7.GuessingGame.main.GuessingGame;


public class GuessingGameTest {

  private GuessingGame game;

  @Before
  public void setUp() {
    game = new GuessingGame();
  }

  @Test
  public void testSimpleWinSituation() {
    GuessingGame game = new GuessingGame();
    int randomNum = game.getRandomNumber();
    String message = game.guess(randomNum);
    assertEquals("You got it", message);
  }
  
  @Test
  public void testSimpleLoseSituation() {
    GuessingGame game = new GuessingGame();
    String message = game.guess(-5);
    assertEquals("You didn't get it", message);
  }

  @Test
  public void testRandomNumberGeneration() {
    int[] rndNumCount = new int[11];
    for (int counter = 0; counter < 50; counter++) {
      GuessingGame game = new GuessingGame();
      int randomNum = game.getRandomNumber();
      rndNumCount[randomNum] = 1;
    }

    int sum = 0;
    for (int counter = 0; counter < 11; counter++) {
      sum += rndNumCount[counter];
    }
    assertEquals(10, sum);
  }
}
