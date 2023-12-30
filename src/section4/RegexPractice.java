package src.section4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {
  public static void main(String[] args) {
    System.out.println("aat".matches("[^cCb]at"));

    String regex = "(?:(?<countryCode>\\d{3})[-,]*)(\\d{3}[-\\s]+)(\\d{3,4})";
    String phoneNumber = "232-333-2365";

    System.out.println("321222- 1231".matches(regex));

    Pattern pat = Pattern.compile(regex);
    Matcher mat = pat.matcher(phoneNumber);
    
    if (mat.matches()) {
      System.out.format("CountryCode: %s\n", mat.group("countryCode"));
      System.out.println(mat.group(2));
      System.out.println(mat.group(3));
      System.out.println(mat.group(0));
    }
  }
}
