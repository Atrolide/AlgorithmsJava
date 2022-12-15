package SortAlgorithms;

import java.util.ArrayList;

public class MergeSort {
    ArrayList<Integer> toBeSorted;
    long startTime;
    long endTime;
    long totalTime;

    public MergeSort(ArrayList<Integer> someArr) {
        toBeSorted = new ArrayList<>(someArr);
    }

    public void printArr() {
        for (int i = 0; i < toBeSorted.size(); i++) {
            System.out.println(i + 1 + ". -> " + toBeSorted.get(i));
        }
    }

    public void mergeSort() {
        startTime = System.nanoTime();
        divide(0, toBeSorted.size() - 1);
        endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000;
    }

    public void divide(int startIndex, int endIndex) {
        //We divide until we get to a single element
        if ( (endIndex - startIndex) >= 1) {
            int midIndex = (startIndex + endIndex) / 2;
            //divide left side
            divide(startIndex, midIndex);
            //divide right side
            divide(midIndex + 1, endIndex);

            //merge sorted arrays into 1 big sorted array
            merge(startIndex, midIndex, endIndex);
        }
    }

    public void merge(int startI, int midI, int endI) {
        ArrayList<Integer> mergedSortedArray = new ArrayList<>();
        int leftIndex = startI;
        int rightIndex = midI + 1;

        while (leftIndex <= midI && rightIndex <= endI) {
            if (toBeSorted.get(leftIndex) <= toBeSorted.get(rightIndex)) {
                mergedSortedArray.add(toBeSorted.get(leftIndex));
                leftIndex++;
            } else {
                mergedSortedArray.add(toBeSorted.get(rightIndex));
                rightIndex++;
            }
        }

        //One of loops below will be executed:
        while (leftIndex <= midI) {
            mergedSortedArray.add(toBeSorted.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= endI) {
            mergedSortedArray.add(toBeSorted.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startI;
        //Set sorted array to original array
        while (i < mergedSortedArray.size()) {
            toBeSorted.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }

    public void executeSort() {
//        System.out.println("Before Merge Sort: ");
//        printArr();
        mergeSort();
//        System.out.println("\nAfter Merge Sort: ");
//        printArr();
//        System.out.println("\nMerge Sort time elapsed: " + totalTime + "ms");
//        System.out.println("\n------------------------------------------------------------");
    }

    public long getTotalTime() {
        return totalTime;
    }
}
