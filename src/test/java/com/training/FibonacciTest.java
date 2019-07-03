package com.training;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FibonacciTest {
  @DataProvider(name = "fibDataProvider")
  public Object[][] fibDataProvider() {
    return new Object[][] {
      {0, 0},
      {1, 1},
      {2, 1},
      {3, 2},
      {4, 3},
      {5, 5},
      {6, 8},
      {7, 13},
      {8, 21},
    };
  }

  @Test(dataProvider = "fibDataProvider")
  public void testNonRecursiveFib(int input, int output) {
    Fibonacci fib = new Fibonacci();
    Assert.assertEquals(fib.fib(input), output);
  }

  @Test(dataProvider = "fibDataProvider")
  public void testDoubleRecursiveFib(int input, int output) {
    Fibonacci fib = new Fibonacci();
    Assert.assertEquals(fib.fibUsingDoubleRecursion(input), output);
  }

  @Test(dataProvider = "fibDataProvider")
  public void testSingleRecursiveFib(int input, int output) {
    Fibonacci fib = new Fibonacci();
    Assert.assertEquals(fib.fibUsingSingleRecursion(input), output);
  }
}
