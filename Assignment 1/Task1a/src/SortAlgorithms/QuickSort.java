package SortAlgorithms;

import java.util.ArrayList;

public class QuickSort {

    ArrayList<Integer> toBeSorted;
    long startTime;
    long endTime;
    long totalTime;

    public QuickSort(ArrayList<Integer> someArr) {
        toBeSorted = new ArrayList<>(someArr);
    }

    public void printArr() {
        for (int i = 0; i < toBeSorted.size(); i++) {
            System.out.println(i + 1 + ". -> " + toBeSorted.get(i));
        }
    }

    public void quicksort(int start, int endExclusive) {
        if (endExclusive - start <= 1) {
            return;
        }
        int pivotIndex = endExclusive - 1;
        int pivot = toBeSorted.get(pivotIndex);

        for(int i = start; i < pivotIndex; i++) {
            if (toBeSorted.get(i) < pivot) {
                continue;
            } else {
                swap(toBeSorted, i, pivotIndex - 1);
                swap(toBeSorted, pivotIndex, pivotIndex - 1);
                pivotIndex--;
                i--;
            }
        }
        quicksort(start, pivotIndex);
        quicksort(pivotIndex + 1, endExclusive);
    }
//[0, 1, 2, 7, 5]
    private static void swap(ArrayList<Integer> someArray, int i, int j) {
        int m = someArray.get(i);
        someArray.set(i, someArray.get(j));
        someArray.set(j, m);
    }

    public void executeSort(){
//        System.out.println("Before Quick Sort: ");
//        printArr();
        startTime = System.nanoTime();
        quicksort(0, toBeSorted.size());
        endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000;
//        System.out.println("\nAfter Quick Sort: ");
//        printArr();
//        System.out.println("\nQuick Sort time elapsed: " + totalTime + "ms");
//        System.out.println("\n------------------------------------------------------------");
    }

    public long getTotalTime() {
        return totalTime;
    }
}


