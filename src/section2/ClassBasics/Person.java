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

  public static void main(String[] args) {
    Person p1 = new Person();
    p1.sayHello();
    p1.saySomething("My groovy message");
    p1.saySomething("Here's something else to say");
    char middleInitial = p1.getMiddleInitial();
    System.out.println(middleInitial);
    System.out.println(p1.add(10, 2));
  }

}
