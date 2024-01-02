package src.section6;

public class ForLoopExample {
  public static void main(String[] args) {
    int counter;
    for (counter = 0; counter < 10; counter++) {
      System.out.printf("Counter is %d%n", counter);
    }

    String[] fruits = { "apple", "orange", "pear", "plum" };
    for (String fruit : fruits) {
      System.out.println(fruit);
    }
  }
}
