package com.training;

/** Rotates arrays */
public class ArrayRotation {

  /**
   * @param array - The array to rotate (left rotation)
   * @param nRotationCount - The number of indices by which to rotate
   * @param <T> - Type of the array elements
   */
  public static <T> void rotateArray(T[] array, int nRotationCount) {
    // 0 1 2 3 4 5 6 7 8 9
    // a b c d e f g h i j
    // c d e f g h i j a b <= Desired result for nRotationCount = 2
    // Find out where a should finally go to. It is 8
    // Put a in 8, and copy whatever is present at 8 to a temporary variable (save the index too)
    // a b c d e f g h a j  [tmp1 = i, tmp1Idx = 8]
    // Find out where the temporary variable should finally go to (i). It is 6
    // Put i in 6, and copy whatever is at 6 into the temporary variable (save the index too)
    // a b c d e f i h a j [tmp1 = g, tmp1Idx = 6]
    // Repeat until done
    // Note that if the array length is divisible by the rotation count, there will be sub-groups of
    // indices
    // that will rotate amongst themselves by this technique. So, repeat this for all such
    // sub-groups

    nRotationCount = nRotationCount % array.length;
    if (nRotationCount == 0) {
      return;
    }

    int nPasses = 1;
    if (array.length % nRotationCount == 0) {
      nPasses = nRotationCount;
    }

    for (int passStartIdx = 0; passStartIdx < nPasses; passStartIdx++) {
      T tmp1 = array[passStartIdx];
      int tmp1Idx = passStartIdx;
      T tmp2 = null;
      do {
        int destIdx = getDesiredPosition(tmp1Idx, array.length, nRotationCount);
        tmp2 = array[destIdx];
        array[destIdx] = tmp1;
        tmp1 = tmp2;
        tmp1Idx = destIdx;
      } while (tmp1Idx != passStartIdx);
    }
  }

  private static int getDesiredPosition(int idx, int arrayLength, int nRotationCount) {
    return idx < nRotationCount ? arrayLength - nRotationCount + idx : idx - nRotationCount;
  }
}
