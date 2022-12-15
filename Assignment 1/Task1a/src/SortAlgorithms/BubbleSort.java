package SortAlgorithms;

import java.util.ArrayList;

public class BubbleSort {

    ArrayList<Integer> toBeSorted;
    long startTime;
    long endTime;
    long totalTime;

    public BubbleSort(ArrayList<Integer> someArr) {
        toBeSorted = new ArrayList<>(someArr);
    }

    public void printArr() {
        for (int i = 0; i < toBeSorted.size(); i++) {
            System.out.println(i + 1 + ". -> " + toBeSorted.get(i));
        }
    }

    public void bubbleSort() {
        startTime = System.nanoTime();
        for (int i = 0; i < toBeSorted.size() - 1; i++) {
            for (int j = 0; j < toBeSorted.size() - 1; j++) {
                if (toBeSorted.get(j) > toBeSorted.get(j + 1)) {
                    int cont = toBeSorted.get(j);
                    toBeSorted.set(j, toBeSorted.get(j + 1));
                    toBeSorted.set(j + 1, cont);
                }
            }
        }
        endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000;
    }

    public void executeSort() {
//        System.out.println("Before Bubble Sort: ");
//        printArr();
        bubbleSort();
//        System.out.println("\nAfter Bubble Sort: ");
//        printArr();
//        System.out.println("Time elapsed: " + totalTime + "ms");
//        System.out.println("\n------------------------------------------------------------");
    }

    public long getTotalTime() {
        return totalTime;
    }
}
