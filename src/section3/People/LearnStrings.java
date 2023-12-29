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


    String myText5 = "Four score and seven years ago";
    System.out.println(myText5.contains("seven"));

    String text1 = "this is my text1";
    String text2 = "this is my text2";
    System.out.println(text1 + " " + text2 + " hello");

    System.out.println(text1.concat(" my string literal"));

    String finalString = new StringBuilder().append(text1).append(text2).toString();
    System.out.println(finalString);

    String otherFinalString = new StringBuffer().append(text1).append(" ").append(text2).toString();
    System.out.println(otherFinalString);

    System.out.format("%s %s\n", text1, text2);
    String oneMoreFinalString = String.format("%s %s", text1, text2);
    System.out.println(oneMoreFinalString);

    String myText6 = "for score and seven years ago";
    System.out.println(myText6.length());
    char[] chars = myText6.toCharArray();
    int index = 4;
    if (index < myText6.length()) {
      System.out.println(chars[index]);
    }
    String myText7 = "for";
    String secondText = "score";
    StringBuilder builder = new StringBuilder(myText7.length() + secondText.length())
        .append(myText7)
        .append(secondText);
    System.out.println(builder.toString());

    String myText8 = "apple";
    String firstPart = myText8.substring(0, 1);
    String secondParrt = myText8.substring(1);
    String myNewText = firstPart.toUpperCase().concat(secondParrt);
    System.out.println(myNewText);

    String myText9 = "abcabc";
    System.out.println(myText9.indexOf("a", 3));
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
