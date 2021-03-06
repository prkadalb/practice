package com.training;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest {
  @DataProvider(name = "factorialDataProvider")
  public Object[][] sortDataProvider() {
    return new Object[][] {
      {0, 1},
      {1, 1},
      {2, 2},
      {5, 5 * 4 * 3 * 2 * 1},
      {12, 479001600}
    };
  }

  @Test(dataProvider = "sortDataProvider")
  public void testFactorialByRecursion(int input, int output) {
    Factorial factorial = new Factorial();
    Assert.assertEquals(factorial.factorialUsingRecursion(input), output);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFactorialByRecursionOfInvalidInput() {
    Factorial factorial = new Factorial();
    factorial.factorialUsingRecursion(-1);
  }

  @Test
  public void testFactorialByRecursionOfLargeNumber() {
    Factorial factorial = new Factorial();
    Assert.assertEquals(factorial.factorialUsingRecursion(20), 2432902008176640000l);
  }

  @Test(dataProvider = "sortDataProvider")
  public void testFactorial(int input, int output) {
    Factorial factorial = new Factorial();
    Assert.assertEquals(factorial.factorial(input), output);
  }

  @Test
  public void testFactorialOfLargeNumber() {
    Factorial factorial = new Factorial();
    Assert.assertEquals(factorial.factorial(20), 2432902008176640000l);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFactorial() {
    Factorial factorial = new Factorial();
    factorial.factorial(-1);
  }
}
