package com.training;

/**
 * Finds Fibonacci numbers
 *
 * <pre>
 *     The 0th Fibonacci number is 0. 1st Fibonacci number is 1.
 *     Thereafter every Fibonacci number is derived by adding the two Fibonacci numbers before it.
 *      i.e.,
 *      Fib(0) = 0
 *      Fib(1) = 1
 *      Fib(n) = Fib(n-1) + Fib(n-2)
 * </pre>
 */
public class Fibonacci {

  /**
   * Computes Fibonacci numbers without using recursion
   *
   * @param n - Index of the Fibonacci number to return
   * @return Fib(n)
   */
  public int fib(int n) {
    if (n < 0) throw new IllegalArgumentException("Fibonacci at a negative index is undefined");
    if (n == 0) return 0;
    if (n == 1) return 1;
    int fibNMinusTwo = 0;
    int fibNMinusOne = 1;
    int result = 0;
    for (int i = 2; i <= n; i++) {
      result = fibNMinusTwo + fibNMinusOne;
      fibNMinusTwo = fibNMinusOne;
      fibNMinusOne = result;
    }
    return result;
  }

  /**
   * Computes Fibonacci numbers using two recursive calls
   *
   * @param n - Index of the Fibonacci number to return
   * @return Fib(n)
   */
  public int fibUsingDoubleRecursion(int n) {
    if (n < 0) throw new IllegalArgumentException("Fibonacci at a negative index is undefined");
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibUsingDoubleRecursion(n - 1) + fibUsingDoubleRecursion(n - 2);
  }

  /**
   * Computes Fibonacci numbers using a single recursive call
   *
   * @param n - Index of the Fibonacci number to return
   * @return Fib(n)
   */
  public int fibUsingSingleRecursion(int n) {
    if (n < 0) throw new IllegalArgumentException("Fibonacci at a negative index is undefined");
    if (n == 0) return 0;
    if (n == 1) return 1;
    // numStepsLeft is n-1 because for n=2, there's a single step left
    return fibUsingSingleRecursion(n - 1, 1, 0);
  }

  private int fibUsingSingleRecursion(int numStepsLeft, int fibNMinusOne, int fibNMinusTwo) {
    if (numStepsLeft == 1) return fibNMinusOne + fibNMinusTwo;
    return fibUsingSingleRecursion(numStepsLeft - 1, fibNMinusOne + fibNMinusTwo, fibNMinusOne);
  }
}
