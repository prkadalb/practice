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
      if(length <=1) { //array of 1 element is already sorted. Empty array doesn't need to be processed
          return;
      }
      int partitionPoint = partition(a, beginIdx, endIdx);
      if(partitionPoint == -1) {
          return;
      }

      //TODO: Debug and get rid of this patch
      if(partitionPoint==beginIdx) { //the first element is the pivot
          partitionPoint++;
      }

      doQuickSort(a, beginIdx, partitionPoint-1);
      doQuickSort(a, partitionPoint, endIdx);
  }

  private int partition(int a[], int beginIdx, int endIdx) {
      int length = endIdx - beginIdx + 1;
      if(length <=1) { //array of 1 element is already sorted. Empty array doesn't need to be processed
          return -1;
      }

      int p1 = beginIdx; //pointer that travels from beginIdx onwards
      int p2 = endIdx; //pointer that travels backwards from endIdx onwards

      //pick some element as the pivot
      int pivotIdx = beginIdx + length/2;
      int pivot = a[pivotIdx];

      while(true) {
          boolean p1Moved = false;
          while (a[p1] < pivot) {
              p1++;
              p1Moved = true;
              //this loop will terminate because pivot exists in the array
          }
          if(!p1Moved) {
              //p1 points to the pivot -or- an element larger than the pivot
              //move the pivot here so that p1 points to the pivot now
              int tmp = a[p1];
              a[p1] = pivot;
              a[pivotIdx] = tmp;
              pivotIdx = p1;
          }
          boolean p2Moved = false;
          while(a[p2]>=pivot) {
              p2--;
              if(p2<beginIdx) {
                  break;
              }
              p2Moved = true;
          }
          if(!p2Moved) {
              int tmp = a[p2];
              a[p2] = pivot;
              a[pivotIdx] = tmp;
              pivotIdx = p2;
          }
          if (p2 <= p1) {
              return p1;
          } else {
              int tmp = a[p2];
              a[p2] = pivot;
              a[pivotIdx] = tmp;
              pivotIdx = p2;
          }
      }
  }
}
