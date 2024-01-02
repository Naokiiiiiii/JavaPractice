package src.section6;

import java.util.Random;

public class GuessIt {
  public static void main(String[] args) {
    int randomInt = new Random().nextInt(3) + 1;
    System.out.println(randomInt);
    
    if (randomInt == 3 ) {
      System.out.println("three");
    } else if(randomInt == 2) {
      System.out.println("two");
    } else {
      System.out.println("one");
    }

    switch (randomInt) {
      case 1:
        System.out.println("switch 1");
        break;
      case 2:
        System.out.println("switch 2");
        break;
      default:
        break;
    }

    String card = "ace";
    int currentTotalValue = 10;

    int currentValue = switch (card) {
      case "king", "queen", "jack" -> 10;
      case "ace" -> {
        if (currentTotalValue < 11) {
          yield 11;
        } else {
          yield 1;
        }
      }
      default -> Integer.parseInt(card);
    };
    System.out.printf("Current Card Value: %d%n", currentValue);
    System.out.printf("Total value; %d%n", currentTotalValue * currentValue);

    int randomNum = new Random().nextInt(10) + 1;
    String guessNumText = null;
    while (!"q".equals(guessNumText)) {
      guessNumText = System.console().readLine("Please guess a number between 1 and 10 inclusively: ");
      if (guessNumText.matches("\\d{1,2}")) {
        int guessNum = Integer.parseInt(guessNumText);
        if (guessNum == randomNum) {
          System.out.printf("The random number was %d. You got it!%n", randomNum);
          return;
        } else {
          System.out.printf("The random number was %d. You didn't get it!%n", randomNum);
        }
      }
    }
  }
}
