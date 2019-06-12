package com.training;

/**
 * Computes the Factorial
 *
 * <p>Factorial is defined for non-negative numbers
 *
 * <pre>
 * factorial(n) = 1, if n=0
 *                n * factorial(n - 1)
 * </pre>
 */
public class Factorial {

  /**
   * Finds the factorial of a number from 0-12 using recursion.
   *
   * @param n - number whose factorial is to be found. Should be less than or equal to 12
   * @return - Factorial of the specified number n
   * @throws IllegalArgumentException if n is negative or n is more than 12
   */
  public int factorialUsingRecursion(int n) {
    if (n < 0 || n > 12) {
      throw new IllegalArgumentException("Input should be a non-negative number less than 100");
    }
    if (n == 1 || n == 0) {
      return 1; // Factorial of 0 is 1 by definition of factorial
    }
    return n * factorialUsingRecursion(n - 1);
  }

  /**
   * Finds the factorial of a number using a non-recursive method
   *
   * @param n - number whose factorial is to be found
   * @return - Factorial of the specified number n
   * @throws IllegalArgumentException if n is negative
   */
  public long factorial(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Factorial is not defined for negative numbers");
    }
    long factorial = 1;
    while (n > 1) {
      factorial = factorial * n--;
    }
    return factorial;
  }
}
