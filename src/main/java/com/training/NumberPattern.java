package com.training;

/**
 * Number pattern for CellVal(RowNum, ColNum) = CellVal(RowNum - 1, ColNum - 1) + CellVal(RowNum -
 * 1, ColNum)
 *
 * <pre>
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 * 1 6 15 20 15 6 1
 * </pre>
 */
public class NumberPattern {

  /**
   * @param nRowNum - The row number at which the pattern value is required
   * @param nColNum - The column number at which the pattern value is required
   * @return - The pattern value at the given row/column
   */
  public int getCellVall(final int nRowNum, final int nColNum) {

    int[] values = new int[nRowNum + 2]; // each row has nRowNum + 2 columns

    for (int currentRowNum = 0; currentRowNum <= nRowNum; currentRowNum++) {

      for (int currentColNum = currentRowNum + 1; currentColNum >= 0; currentColNum--) {

        if (currentColNum == 0 || currentColNum == currentRowNum) {
          values[currentColNum] = 1;
        } else {
          values[currentColNum] = values[currentColNum] + values[currentColNum - 1];
        }
      }
    }

    return values[nColNum];
  }
}
