package src.section4;

public class RegexPractice {
  public static void main(String[] args) {
    System.out.println("aat".matches("[^cCb]at"));
    System.out.println("321222- 1231".matches("\\d{3}[-,]*\\d{3}[-\\s]+\\d{3,4}"));
  }
}
