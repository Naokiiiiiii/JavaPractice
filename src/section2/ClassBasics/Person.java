package src.section2.ClassBasics;

public class Person {

  private String middleName = "Christopher";

  public void sayHello() {
    System.out.println("Hello");
  }

  public void saySomething(String message) {
    System.out.println(message);
  }
  
  public char getMiddleInitial() {
    return middleName.charAt(0);
  }

  public int add(int num1, int num2) {
    return num1 + num2;
  }

  public void test(int num1, int num2, String[] words) {
  }
  
  public void test2(int num1, int num2, String... words) {
    System.out.println(words.length);
  }

  public static void main(String[] args) {
    Person p1 = new Person();
    p1.sayHello();
    p1.saySomething("My groovy message");
    p1.saySomething("Here's something else to say");
    char middleInitial = p1.getMiddleInitial();
    System.out.println(middleInitial);
    System.out.println(p1.add(10, 2));
    String[] words = new String[] { "one", "two", "theree" };
    p1.test(3, 5, words);
    p1.test2(3, 5, "one", "two", "three");
  }
}
