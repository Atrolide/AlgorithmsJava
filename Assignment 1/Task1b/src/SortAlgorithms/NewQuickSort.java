package SortAlgorithms;

import java.util.ArrayList;

public class NewQuickSort {

    ArrayList<CardData> toBeSorted;
    int count;

    long startTime;
    long endTime;
    long totalTime;

    public NewQuickSort(ArrayList<CardData> someArr, int index) {
        toBeSorted = new ArrayList<>(someArr);
        count = index;
    }

    public void printArr() {
        for (int i = 0; i < count; i++) {
            System.out.println(i + 1 + ". -> " + toBeSorted.get(i).cardNumber() + " " + toBeSorted.get(i).pinNumber());
        }
    }

    public void quicksort(int start, int endExclusive) {
        if (endExclusive - start <= 1) {
            return;
        }
        int pivotIndex = endExclusive - 1;
        int pivot = toBeSorted.get(pivotIndex).pinNumber();

        for (int i = start; i < pivotIndex; i++) {
            if (toBeSorted.get(i).pinNumber() < pivot) {
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

    private static void swap(ArrayList<CardData> someArray, int i, int j) {
        CardData m = someArray.get(i);
        someArray.set(i, someArray.get(j));
        someArray.set(j, m);
    }

    public void executeSort() {
            startTime = System.nanoTime();
            quicksort(0, count);
            endTime = System.nanoTime();
            totalTime = (endTime - startTime) / 1000;
    }

    public long getQuickTime() {
        return totalTime;
    }
}

