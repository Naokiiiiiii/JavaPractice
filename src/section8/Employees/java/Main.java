package src.section8.Employees.java;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    String peopleText = """
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2500,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=4000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=5000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=6000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=7000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=9000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmerzzzzz, {locpd=10000,yoe=10,iq=140}
            Flinstone2, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
            Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
            Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
            Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
            Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
            Rubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
            Rubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
            Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
            Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
            Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;

    String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
    Pattern peoplePat = Pattern.compile(peopleRegex);
    Matcher peopleMat = peoplePat.matcher(peopleText);

    String progRegex = "\\w+\\=(?<locpd>\\w+)\\,\\w+\\=(?<yoe>\\w+)\\,\\w+\\=(?<iq>\\w+)";
    Pattern coderPat = Pattern.compile(progRegex);

    String mgrRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
    Pattern mgrPat = Pattern.compile(mgrRegex);

    String analystRegex = "\\w+=(?<projectCount>\\w+)";
    Pattern analystPat = Pattern.compile(analystRegex);

    String ceoRegex = "\\w+=(?<avgStockPrice>\\w+)";
    Pattern ceoPat = Pattern.compile(ceoRegex);

    int totalSalary = 0;
    while (peopleMat.find())
    {
      totalSalary += switch (peopleMat.group("role")) {
        case "Programmer" -> {
          Programmer programmer = new Programmer(peopleMat.group());
          System.out.println(programmer.toString());
          yield programmer.getSalary();
        }
        case "Manager" -> {
          String details = peopleMat.group("details");
          Matcher mgrMat = mgrPat.matcher(details);
          int salary = 0;
          if (mgrMat.find()) {
            int orgSize = Integer.parseInt(mgrMat.group("orgSize"));
            int directReports = Integer.parseInt(mgrMat.group("dr"));
            salary = 3500 + orgSize * directReports;
          } else {
            salary = 3500;
          }
          String lastName = peopleMat.group("lastName");
          String firstNAme = peopleMat.group("firstName");
          System.out.printf("%s, %s: %s\n", lastName, firstNAme, NumberFormat.getCurrencyInstance().format(salary));
          yield salary;
        }
        case "Analyst" -> {
          String details = peopleMat.group("details");
          Matcher analystMat = analystPat.matcher(details);
          int salary = 0;
          if (analystMat.find()) {
            int projectCount = Integer.parseInt(analystMat.group("projectCount"));
            salary = 2500 + projectCount * 2;
          } else {
            salary = 2500;
          }
          String lastName = peopleMat.group("lastName");
          String firstNAme = peopleMat.group("firstName");
          System.out.printf("%s, %s: %s\n", lastName, firstNAme, NumberFormat.getCurrencyInstance().format(salary));
          yield salary;
        }
        case "CEO" -> {
          String details = peopleMat.group("details");
          Matcher ceoMat = ceoPat.matcher(details);
          int salary = 0;
          if (ceoMat.find()) {
            int avgStockPrice = Integer.parseInt(ceoMat.group("avgStockPrice"));
            salary = 5000 * avgStockPrice;
          } else {
            salary = 5000;
          }
          String lastName = peopleMat.group("lastName");
          String firstNAme = peopleMat.group("firstName");
          System.out.printf("%s, %s: %s\n", lastName, firstNAme, NumberFormat.getCurrencyInstance().format(salary));
          yield salary;
        }
        default -> 0;
      };
    }
    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
    System.out.printf("The total prayment should be %s%n", currencyInstance.format(totalSalary));
  }
}
