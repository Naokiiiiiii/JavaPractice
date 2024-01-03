package src.section7.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.section7.main.Calculator;

public class CalculatorTest {

  private Calculator calc;

  @Before
  public void setUp() {
    calc = new Calculator();
  }

  @Test
  public void canAddZeroPlusZero() {
    int sum = calc.add(0, 0);
    assertEquals(0, sum);
  }

  @Test
  public void canAddOnePlusOne() {
    int sum = calc.add(1, 1);
    assertEquals(2, sum);
  }

  @Test
  public void canAddMaxIntPlusOne() {
    int sum = calc.add(Integer.MAX_VALUE, 1);
    System.out.println(sum);
    assertEquals(Integer.MAX_VALUE + 1, sum);
  }

  @Test
  public void annuityExample() {
    String answer = calc.calcAnnuity("22000", 7, ".06", 1);
    assertEquals("$184,664.43", answer);
  }

  @Test
  public void annuityPractice2() {
    String answer = calc.calcAnnuity("1200", 10, ".08", 4);
    assertEquals("$72,482.38", answer);
  }
}