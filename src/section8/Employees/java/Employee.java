package src.section8.Employees.java;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee implements IEmployee {
  protected String lastName;
  protected String firstName;
  protected LocalDate dob;

  private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
  private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
  protected final Pattern peoplePat = Pattern.compile(peopleRegex);
  protected final Matcher peopleMat;
  DateTimeFormatter atFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

  public Employee(String personText) {
    peopleMat = peoplePat.matcher(personText);
    if (peopleMat.find()) {
      this.lastName = peopleMat.group("lastName");
      this.firstName = peopleMat.group("firstName");
      this.dob = LocalDate.from(atFormatter.parse(peopleMat.group("dob")));
    }
  }

  public int getSalary() {
    return 0;
  };

  @Override
  public String toString() {
    return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary()));
  }
}
