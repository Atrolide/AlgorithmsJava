package SortAlgorithms;

import java.util.ArrayList;

public class InsertionSort {
    ArrayList<Integer> toBeSorted;
    long startTime;
    long endTime;
    long totalTime;

    public InsertionSort(ArrayList<Integer> someArr) {
        toBeSorted = new ArrayList<>(someArr);
    }

    public void printArr() {
        for (int i = 0; i < toBeSorted.size(); i++) {
            System.out.println(i + 1 + ". -> " + toBeSorted.get(i));
        }
    }

    public void insertionSort() {
        startTime = System.nanoTime();
        for (int i = 1; i < toBeSorted.size(); ++i) {
            int key = toBeSorted.get(i);
            int j = i - 1;

            while (j >= 0 && toBeSorted.get(j) > key) {
                toBeSorted.set(j + 1, toBeSorted.get(j));
                j -= 1;
            }
            toBeSorted.set(j + 1, key);
        }
        endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000;
    }

    public void executeSort() {
//        System.out.println("Before Insertion Sort: ");
//        printArr();
        insertionSort();
//        System.out.println("\nAfter Insertion Sort: ");
//        printArr();
//        System.out.println("\nInsertion Sort time elapsed: " + totalTime + "ms");
//        System.out.println("\n------------------------------------------------------------");
    }

    public long getTotalTime() {

        return totalTime;
    }
}


