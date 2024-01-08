package src.section8.Employees.java;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee {
  private int linesOfCode = 0;
  private int yearsOfExp = 0;
  private int iq = 0;

  private final String progRegex = "\\w+\\=(?<locpd>\\w+)\\,\\w+\\=(?<yoe>\\w+)\\,\\w+\\=(?<iq>\\w+)";
  private final Pattern coderPat = Pattern.compile(progRegex);
  
  DateTimeFormatter atFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

  public Programmer(String personText) {
    super(personText);
    Matcher progMat = coderPat.matcher(peopleMat.group("details"));
    if (progMat.find()) {
      this.linesOfCode = Integer.parseInt(progMat.group("locpd"));
      this.yearsOfExp = Integer.parseInt(progMat.group("yoe"));
      this.iq = Integer.parseInt(progMat.group("iq"));
    }
  }

  public int getSalary() {
    return 3000 + linesOfCode * yearsOfExp * iq;
  }
}
