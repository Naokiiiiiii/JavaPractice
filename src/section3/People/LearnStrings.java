package src.section3.People;

public class LearnStrings {
  public static void main(String[] args) {
    String fruit = "apple";
    String anotherFruit = "apple";
    String vegerable = new String("broccoli");
    String anotherVegerable = new String("broccoli");

    System.out.println(fruit == anotherFruit);
    System.out.println(vegerable == anotherVegerable);

    String myText = "abcdefg";
    System.out.println(myText.toUpperCase());

    String myText2 = "ABCGEFG";
    System.out.println(myText2.toLowerCase());
  }
}
