package com.training;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NumberPatternTest {

  @DataProvider(name = "numberPatternProvider")
  public Object[][] sortDataProvider() {
    return new Object[][] {
      {0, 0, 1},
      {1, 0, 1},
      {1, 1, 1},
      {4, 2, 6},
      {4, 3, 4},
      {5, 2, 10},
      {5, 3, 10},
      {6, 0, 1},
      {6, 1, 6},
      {6, 2, 15},
      {6, 3, 20},
      {6, 4, 15},
      {6, 5, 6},
      {6, 6, 1},
    };
  }

  @Test(dataProvider = "numberPatternProvider")
  public void testNumberPatternGenerator(int r, int c, int v) {
    NumberPattern pattern = new NumberPattern();
    Assert.assertEquals(pattern.getCellVall(r, c), v);
  }
}
