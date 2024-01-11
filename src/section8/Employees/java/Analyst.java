package src.section8.Employees.java;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee implements IEmployee {
  private int projectCount = 0;

  private final String analystRegex = "\\w+=(?<projectCount>\\w+)";
  private final Pattern analystPat = Pattern.compile(analystRegex);
  
  DateTimeFormatter atFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

  public Analyst(String personText) {
    super(personText);
    Matcher progMat = analystPat.matcher(peopleMat.group("details"));
    if (progMat.find()) {
      this.projectCount = Integer.parseInt(progMat.group("projectCount"));
    }
  }
  
  public int getSalary() {
    return 2500 + projectCount * 2;
  }
}
