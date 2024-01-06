package src.section7.GuessingGame.main;

import java.util.Random;

public class GuessingGame {

  private final int randomNumber = new Random().nextInt(10) + 1;
  private int counter = 0;

  public String guess(int guessedNumber) {
    counter++;
    String tryText = counter == 1 ? "try" : "tries";
    String winningMsg = String.format("You got it in %d %s", counter, tryText);
    String response = null;
    if (counter == 4 && guessedNumber != getRandomNumber()) {
      response = String.format("You didn't it and you've had %d %s. Game over.", counter, tryText);
    } else if (counter > 4) {
      response = "Sorry, you are limited to only 4 tries. Your game is over.";
    } else {
      String tooHighLowText = null;
      if (guessedNumber < getRandomNumber()) {
        tooHighLowText = "- you're too low";
      } else if (guessedNumber > getRandomNumber()) {
        tooHighLowText = "- you're too high";
      } else {
        tooHighLowText = "";
      }
      String loseText = String.format("You didn't get it %s ", tooHighLowText).trim();
      response = guessedNumber == getRandomNumber() ? winningMsg : loseText;
    }
    return response;
  }

  public int getRandomNumber() {
    return randomNumber;
  }
}
