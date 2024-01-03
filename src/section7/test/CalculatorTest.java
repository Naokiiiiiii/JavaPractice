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
}