package src.section3.People;

public class LearnStrings {
  public static void main(String[] args) {
    String fruit = "apple";
    String anotherFruit = "apple";
    String vegerable = new String("broccoli");
    String anotherVegerable = new String("broccoli");

    System.out.println(fruit == anotherFruit);
    System.out.println(vegerable == anotherVegerable);
  }
}
