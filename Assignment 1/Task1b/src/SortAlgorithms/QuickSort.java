package SortAlgorithms;

import java.util.ArrayList;

public class QuickSort {

    ArrayList<Integer> toBeSorted;
    ArrayList<String> toBeSorted2;

    ArrayList<Long> quickTime = new ArrayList<>();
    long startTime;
    long endTime;
    long totalTime;

    public QuickSort(ArrayList<Integer> someArr, ArrayList<String> otherArr) {
        toBeSorted = new ArrayList<>(someArr);
        toBeSorted2 = new ArrayList<>(otherArr);
    }

    public void printArr() {
        for (int i = 0; i < toBeSorted.size(); i++) {
            System.out.println(i + 1 + ". -> " + toBeSorted2.get(i) + "  " + toBeSorted.get(i));
        }
    }

    public void quicksort(int start, int endExclusive) {
        if (endExclusive - start <= 1) {
            return;
        }
        int pivotIndex = endExclusive - 1;
        int pivot = toBeSorted.get(pivotIndex);

        for (int i = start; i < pivotIndex; i++) {
            if (toBeSorted.get(i) < pivot) {
                continue;
            } else {
                swap(toBeSorted, i, pivotIndex - 1, toBeSorted2);
                swap(toBeSorted, pivotIndex, pivotIndex - 1, toBeSorted2);
                pivotIndex--;
                i--;
            }
        }
        quicksort(start, pivotIndex);
        quicksort(pivotIndex + 1, endExclusive);
    }

    private static void swap(ArrayList<Integer> someArray, int i, int j, ArrayList<String> otherArray) {
        int m = someArray.get(i);
        String str = otherArray.get(i);

        someArray.set(i, someArray.get(j));
        someArray.set(j, m);

        otherArray.set(i, otherArray.get(j));
        otherArray.set(j, str);
    }

    public void executeSort(int index) {
        for (int i = 0; i < index; i++) {
            startTime = System.nanoTime();
            quicksort(0, toBeSorted.size());
            endTime = System.nanoTime();
            totalTime = (endTime - startTime) / 1000;
            quickTime.add(totalTime);
        }
    }

    public void printQuickTime() {
        for (int i = 0; i < quickTime.size(); i++) {
            System.out.println("QuickSort runtime: " + quickTime.get(i) + "μs");
        }
    }
}


