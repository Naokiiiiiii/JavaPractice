package src.section7.GuessingGame.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.section7.GuessingGame.main.GuessingGame;


public class GuessingGameTest {

  private static final int GAME_RANDOMNESS_RETRIES = 100;
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
    assertEquals("You got it in 1 try", message);
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
    for (int counter = 0; counter < GAME_RANDOMNESS_RETRIES; counter++) {
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

  private void makeThreeWrongGuesses() {
    game.guess(-3);
    game.guess(-3);
    game.guess(-3);
  }

  @Test
  public void testFourWrongGuesses() {
    makeThreeWrongGuesses();
    String message = game.guess(-3);
    assertEquals("You didn't it and you've had 4 tries. Game over.", message);
  }

  @Test
  public void testTenWrongGuesses() {
    game.guess(-3);
    game.guess(-3);
    game.guess(-3);
    game.guess(-3);
    game.guess(-3);
    game.guess(-3);
    game.guess(-3);
    game.guess(-3);
    game.guess(-3);
    String message = game.guess(-3);
    assertEquals("Sorry, you are limited to only 4 tries. Your game is over.", message);
  }

  @Test
  public void testThreeWrongGuessesAndOneCorrect() {
    makeThreeWrongGuesses();
    int correctAnswer = game.getRandomNumber();
    String message = game.guess(correctAnswer);
    assertEquals("You got it in 4 tries", message);
  }

  @Test
  public void testTwoWrongGuessesAndOneCorrect() {
    game.guess(-3);
    game.guess(-3);
    int correctAnswer = game.getRandomNumber();
    String message = game.guess(correctAnswer);
    assertEquals("You got it in 3 tries", message);
  }
}
