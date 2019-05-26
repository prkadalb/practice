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
          swap(a, i, i + 1);
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
        } else {
          break;
        }

      }
    }
  }

  public void doQuickSort(int a[]) {
    doQuickSort(a, 0, a.length - 1);
  }

  private void doQuickSort(int a[], int beginIdx, int endIdx) {
    int length = endIdx - beginIdx + 1;
    if (length <= 1) {
      // array of 1 element is already sorted. Empty array doesn't need to be processed
      return;
    }
    int partitionPoint = partition(a, beginIdx, endIdx);

    doQuickSort(a, beginIdx, partitionPoint - 1);
    doQuickSort(a, partitionPoint + 1, endIdx);
  }

  private int partition(int a[], int beginIdx, int endIdx) {
    int p1 = beginIdx; // pointer that travels from beginIdx onwards
    int p2 = endIdx; // pointer that travels backwards from endIdx onwards

    int pivotIdx = endIdx;
    int pivot = a[pivotIdx];

    while (true) {
      while (p1 <= p2 && a[p1] <= pivot) {
        p1++;
      }
      // all elements before p1 are less than or equal to the pivot now
      while (p2 >= p1 && a[p2] >= pivot) {
        p2--;
      }
      // all elements after p2 are greater than or equal to the pivot now
      if (p2 < p1) {
        // pointers have crossed. Time to exit.
        if (pivotIdx > p1) {
          // p1 got blocked by a number larger than the pivot. Put the pivot in the correct place
          // Eg: 0 1 5 2, where 2 is the pivot and p1 is pointing to 5
          swap(a, p1, pivotIdx);
          pivotIdx = p1;
        } else {
          // p1 is after the pivot, which is okay as pivot should already be in its correct place
          // Eg: 0 1 2 5,
        }
        return pivotIdx;
      } else {
        swap(a, p1, p2);
      }
    }
  }

  private void swap(int[] a, int x, int y) {
    int tmp = a[x];
    a[x] = a[y];
    a[y] = tmp;
  }
}
