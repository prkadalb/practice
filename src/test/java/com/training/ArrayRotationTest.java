package com.training;

import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayRotationTest {
  @DataProvider(name = "arrayRotationProvider")
  public Object[][] sortDataProvider() {
    return new Object[][] {
      {new Integer[] {0, 1, 2, 3, 4}, 0, new Integer[] {0, 1, 2, 3, 4}},
      {new Integer[] {0, 1, 2, 3, 4}, 1, new Integer[] {1, 2, 3, 4, 0}},
      {new Integer[] {0, 1, 2, 3, 4}, 2, new Integer[] {2, 3, 4, 0, 1}},
      {new Integer[] {0, 1, 2, 3, 4}, 3, new Integer[] {3, 4, 0, 1, 2}},
      {new Integer[] {0, 1, 2, 3, 4}, 4, new Integer[] {4, 0, 1, 2, 3}},
      {new Integer[] {0, 1, 2, 3, 4}, 5, new Integer[] {0, 1, 2, 3, 4}},
      {new Integer[] {0, 1, 2, 3, 4}, 6, new Integer[] {1, 2, 3, 4, 0}},
    };
  }

  @Test(dataProvider = "arrayRotationProvider")
  public void testArrayRotation(Integer[] input, int rotation, Integer[] expectedOutput) {
    Integer[] actualOutput = Arrays.copyOf(input, input.length);
    ArrayRotation.rotateArray(actualOutput, rotation);
    Assert.assertEquals(
        actualOutput,
        expectedOutput,
        Arrays.deepToString(input) + " ==" + rotation + "==> " + Arrays.deepToString(actualOutput));
  }
}
