package src.section8.Employees.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    String people = """
        Flinstone, Fred, 1/1/1900, Programmer
        Rubble, Barney, 2/2/1905, Manager
        Flinstone, Wilma, 3/3/1910, Analyst
        Rubble, Betty, 4/4/1915, CEO
        """;

    String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)\\n";
    Pattern pat = Pattern.compile(regex);
    Matcher mat = pat.matcher(people);

    int totalSalary = 0;
    while (mat.find())
    {
      totalSalary += switch (mat.group("role")) {
        case "Programer" -> 3000;
        case "Manager" -> 3500;
        case "Analyst" -> 5000;
        case "CEO" -> 5000;
        default -> 0;
      };
    }
  }
}
