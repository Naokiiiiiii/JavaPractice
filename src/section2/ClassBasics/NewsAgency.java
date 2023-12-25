package src.section2.ClassBasics;

import java.time.LocalDate;

import src.section2.ClassBasics.business.Company;
import src.section2.ClassBasics.business.FactoryWorker;

class NewsAgency {
  Company company;
  FactoryWorker worker;

  public void accessMethod() {
    Person person = new Person();
    person.lastName = "Smith";
    person.dob = LocalDate.now();
  }
}
