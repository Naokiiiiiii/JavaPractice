package src.section8.Employees.java;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee {
  protected String lastName;
  protected String firstName;
  protected LocalDate dob;
  private static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
  private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
  public static final Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
  protected final Matcher peopleMat;
  DateTimeFormatter atFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

  protected Employee() {
    peopleMat = null;
    lastName = "N/A";
    firstName = "N/A";
    dob = null;
  }

  protected Employee(String personText) {
    peopleMat = PEOPLE_PAT.matcher(personText);
    if (peopleMat.find()) {
      this.lastName = peopleMat.group("lastName");
      this.firstName = peopleMat.group("firstName");
      this.dob = LocalDate.from(atFormatter.parse(peopleMat.group("dob")));
    }
  }

  public static final IEmployee createEmployee(String employeeText) {
    Matcher peopleMat = Employee.PEOPLE_PAT.matcher(employeeText);
    class MyLocalClass extends Employee {
      public int getSalary() {
        return 5;
      }
    }
    if (peopleMat.find()) {
      return switch (peopleMat.group("role")) {
        case "Programmer" -> new Programmer(employeeText);
        case "Manager" -> new Manager(employeeText);
        case "Analyst" -> new Analyst(employeeText);
        case "CEO" -> new CEO(employeeText);
        default -> () -> 0;
      };
    } else {
      return () -> 0;
    }
  }

  public abstract int getSalary();

  public double getBonus() {
    return getSalary() * 1.10;
  }

  @Override
  public String toString() {
    return String.format("%s, %s: %s - %s", lastName, firstName, moneyFormat.format(getSalary()),
        moneyFormat.format(getBonus()));
  }
  
  private static final class DummyEmployee extends Employee implements IEmployee {
    @Override
    public int getSalary() {
      return 0;
    }
  }

  public record Jumper(String firstName, String lastName) {
  }
}
