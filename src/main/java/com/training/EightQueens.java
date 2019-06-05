package com.training;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {

  public static void main(String[] args) {
    List<Integer> solutions = new EightQueens().solve();

    List<Integer> bruteForceSolutions = new EightQueens().solveByBruteForce();
    boolean errorsExist = false;
    for (int solution : solutions) {
      if (bruteForceSolutions.contains(solution)) {
        System.out.println("CORRECT: " + solution);
      } else {
        errorsExist = true;
        System.out.println("WRONG: " + solution);
      }
    }
    for (int solution : bruteForceSolutions) {
      if (!solutions.contains(solution)) {
        errorsExist = true;
        System.out.println("MISSING: " + solution);
      }
    }
    if (!errorsExist) {
      System.out.println(
          "The algorithm is correct. " + bruteForceSolutions.size() + " unique solutions found");
    } else {
      System.out.println("The algorithm is wrong. See mismatches above");
    }
  }

  public List<Integer> solve() {
    return solveByBruteForceRecursive();
  }

  public List<Integer> solveByBruteForceRecursive() {
    List<Integer> solutions = new ArrayList<>();
    int[] solution = new int[8];
    placeQueenIntoSolution(solutions, solution, 0);
    return solutions;
  }

  private void placeQueenIntoSolution(List<Integer> solutions, int[] solution, int rowIdx) {
    if (rowIdx > 7) {
      solutions.add(toIntZeroIndexed(solution));
      return;
    }
    nextColumn:
    for (int colIdx = 0; colIdx < 8; colIdx++) {
      for (int prevRowIdx = 0; prevRowIdx < rowIdx; prevRowIdx++) {
        if (solution[prevRowIdx] == colIdx) {
          continue nextColumn;
        }
        if (solution[prevRowIdx] + (rowIdx - prevRowIdx) == colIdx) {
          continue nextColumn;
        }
        if (solution[prevRowIdx] - (rowIdx - prevRowIdx) == colIdx) {
          continue nextColumn;
        }
      }
      solution[rowIdx] = colIdx;
      placeQueenIntoSolution(solutions, solution, rowIdx + 1);
    }
  }

  public List<Integer> solveByBruteForce() {
    List<Integer> solutions = new ArrayList<>();
    for (int c0 = 0; c0 < 8; c0++) { // column of the first row
      for (int c1 = 0; c1 < 8; c1++) { // column of the second row
        if (collision(0, c0, 1, c1)) {
          continue;
        }
        for (int c2 = 0; c2 < 8; c2++) {
          if (collision(0, c0, 2, c2) || collision(1, c1, 2, c2)) {
            continue;
          }
          for (int c3 = 0; c3 < 8; c3++) {
            if (collision(0, c0, 3, c3) || collision(1, c1, 3, c3) || collision(2, c2, 3, c3)) {
              continue;
            }
            for (int c4 = 0; c4 < 8; c4++) {
              if (collision(0, c0, 4, c4)
                  || collision(1, c1, 4, c4)
                  || collision(2, c2, 4, c4)
                  || collision(3, c3, 4, c4)) {
                continue;
              }
              for (int c5 = 0; c5 < 8; c5++) {
                if (collision(0, c0, 5, c5)
                    || collision(1, c1, 5, c5)
                    || collision(2, c2, 5, c5)
                    || collision(3, c3, 5, c5)
                    || collision(4, c4, 5, c5)) {
                  continue;
                }
                for (int c6 = 0; c6 < 8; c6++) {
                  if (collision(0, c0, 6, c6)
                      || collision(1, c1, 6, c6)
                      || collision(2, c2, 6, c6)
                      || collision(3, c3, 6, c6)
                      || collision(4, c4, 6, c6)
                      || collision(5, c5, 6, c6)) {
                    continue;
                  }
                  for (int c7 = 0; c7 < 8; c7++) {
                    if (collision(0, c0, 7, c7)
                        || collision(1, c1, 7, c7)
                        || collision(2, c2, 7, c7)
                        || collision(3, c3, 7, c7)
                        || collision(4, c4, 7, c7)
                        || collision(5, c5, 7, c7)
                        || collision(6, c6, 7, c7)) {
                      continue;
                    }
                    solutions.add(
                        toInt(
                            new int[] {
                              c0 + 1, c1 + 1, c2 + 1, c3 + 1, c4 + 1, c5 + 1, c6 + 1, c7 + 1
                            }));
                  }
                }
              }
            }
          }
        }
      }
    }
    return solutions;
  }

  private static boolean collision(int row1, int col1, int row2, int col2) {
    if (row1 == row2) return true;
    if (col1 == col2) return true;
    int delta = row2 - row1;
    int diagonalColumn1OnRow2 = col1 + delta;
    if (diagonalColumn1OnRow2 == col2) return true;
    int diagonalColumn2OnRow2 = col1 - delta;
    if (diagonalColumn2OnRow2 == col2) return true;
    return false;
  }

  private static int toInt(int[] cols) {
    return (int)
        (cols[0] * 1e7
            + cols[1] * 1e6
            + cols[2] * 1e5
            + cols[3] * 1e4
            + cols[4] * 1e3
            + cols[5] * 1e2
            + cols[6] * 1e1
            + cols[7]);
  }

  private static int toIntZeroIndexed(int[] cols) {
    return (int)
        ((cols[0] + 1) * 1e7
            + (cols[1] + 1) * 1e6
            + (cols[2] + 1) * 1e5
            + (cols[3] + 1) * 1e4
            + (cols[4] + 1) * 1e3
            + (cols[5] + 1) * 1e2
            + (cols[6] + 1) * 1e1
            + (cols[7] + 1));
  }
}
