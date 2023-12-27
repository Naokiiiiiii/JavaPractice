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

    String mytext3 = "a";
    System.out.println(mytext3.isBlank());

    String myText4 = "here's my awesome firf text";
    System.out.println(myText4.replace("firf", "nice"));

    String firstName = "   Jake   ";
    System.out.format("'%s'", firstName.strip());

    String firstName2 = """
                  first line here
                        second line here
        third line here
        """;
    System.out.format("'%s'", firstName2.stripIndent());

    System.out.format("'%s'", split(firstName));

    String middleName = "Christopher";

    int length = middleName.length();
    if (length > 9) {
      System.out.println(middleName.charAt(9));
    }

    String firstWord = "Apple";
    String secondWord = "apple";

    System.out.println(compareToIgnoreCase(firstWord, secondWord));

  }

  public static String split(String text) {
    return text.replace(" ", "");
  }

  public static int compareToIgnoreCase(String text1, String text2) {
    String lowerText1 = text1.toLowerCase();
    String lowerText2 = text2.toLowerCase();
    return lowerText1.compareTo(lowerText2);
  }
}
