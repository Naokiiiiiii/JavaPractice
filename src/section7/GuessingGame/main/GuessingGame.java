package src.section7.GuessingGame.main;

import java.util.Random;

public class GuessingGame {

  private final int randomNumber = new Random().nextInt(10) + 1;

  public String guess(int guessedNumber) {
    return guessedNumber == getRandomNumber() ? "You got it" : "You didn't get it";
  }

  public int getRandomNumber() {
    return randomNumber;
  }
}
