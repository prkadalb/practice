package com.training;

/** Implements common sorting algorithms */
public class Sorter {

  public void doBubbleSort(int a[]) {
    int lastIdx = a.length - 1;
    for (int unsortedSubarrayEndIdx = lastIdx;
        unsortedSubarrayEndIdx > 0;
        unsortedSubarrayEndIdx--) {
      boolean swapsDone = false;
      for (int i = 0; i < unsortedSubarrayEndIdx; i++) {
        if (a[i] > a[i + 1]) {
          int tmp = a[i + 1];
          a[i + 1] = a[i];
          a[i] = tmp;
          swapsDone = true;
        }
      }
      if (!swapsDone) {
        // No swaps were done. The array is in order
        return;
      }
    }
  }

  public void doSelectionSort(int a[]) {
    int lastIdx = a.length - 1;
    for (int unsortedSubarrayBeginIdx = 0;
        unsortedSubarrayBeginIdx < lastIdx;
        unsortedSubarrayBeginIdx++) {
      int min = a[unsortedSubarrayBeginIdx];
      int minIdx = unsortedSubarrayBeginIdx;
      // Find the minimum in the unsorted subarray
      for (int i = unsortedSubarrayBeginIdx + 1; i <= lastIdx; i++) {
        if (a[i] < min) {
          min = a[i];
          minIdx = i;
        }
      }
      // put it in the beginning of the unsorted subarray
      if (minIdx != unsortedSubarrayBeginIdx) {
        a[minIdx] = a[unsortedSubarrayBeginIdx];
        a[unsortedSubarrayBeginIdx] = min;
      }
    }
  }

  public void doInsertionSort(int a[]) {
    int lastIdx = a.length - 1;
    for (int unsortedSubarrayBeginIdx = 0;
        unsortedSubarrayBeginIdx <= lastIdx;
        unsortedSubarrayBeginIdx++) {
      int elementToBeInserted = a[unsortedSubarrayBeginIdx];
      int currentPositionOfElementToBeInserted = unsortedSubarrayBeginIdx;
      for (int i = unsortedSubarrayBeginIdx - 1; i >= 0; i--) {
        if (a[i] > elementToBeInserted) {
          a[currentPositionOfElementToBeInserted] = a[i];
          a[i] = elementToBeInserted;
          currentPositionOfElementToBeInserted = i;
        }
      }
    }
  }

  public void doQuickSort(int a[]) {
    // TODO
  }
}
