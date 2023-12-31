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
  }
}
