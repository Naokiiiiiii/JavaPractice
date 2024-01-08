package src.section8.Employees.java;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO implements Employee {
  private String lastName;
  private String firstName;
  private LocalDate dob;
  private int avgStockPrice = 0;

  private final String ceoRegex = "\\w+=(?<avgStockPrice>\\w+)";
  private final Pattern ceoPat = Pattern.compile(ceoRegex);
  private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
  private final Pattern peoplePat = Pattern.compile(peopleRegex);
  private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

  DateTimeFormatter atFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

  public CEO(String personText) {
    Matcher peopleMat = peoplePat.matcher(personText);
    if (peopleMat.find()) {
      this.lastName = peopleMat.group("lastName");
      this.firstName = peopleMat.group("firstName");
      this.dob = LocalDate.from(atFormatter.parse(peopleMat.group("dob")));
      ceoPat.matcher(peopleMat.group("details"));
      Matcher ceoMat = ceoPat.matcher(peopleMat.group("details"));
      if (ceoMat.find()) {
        this.avgStockPrice = Integer.parseInt(ceoMat.group("avgStockPrice"));
      }
    }
  }

  public int getSalary() {
    return 5000 * avgStockPrice;
  }

  @Override
  public String toString() {
    return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary()));
  }
}
