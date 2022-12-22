package SortAlgorithms;

import java.util.ArrayList;

public class CountingSort {
    ArrayList<CardData> toBeSorted;
    ArrayList<ArrayList<String>> list = new ArrayList<>(10000);
    long startTime;
    long endTime;
    long totalTime;
    int count;

    public CountingSort(ArrayList<CardData> someArr, int index) {
        toBeSorted = new ArrayList<>(someArr);
        count = index;
    }


    public void printArr() {
        for (int i = 0; i < count; i++) {
            System.out.println(i + 1 + ". -> " + toBeSorted.get(i).cardNumber() + " " + toBeSorted.get(i).pinNumber());
        }
    }

    public void countingSort() {
        for (int i = 0; i < 10000; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < count; i++) {
            list.get(toBeSorted.get(i).pinNumber()).add(toBeSorted.get(i).cardNumber());
        }

        toBeSorted.clear();

        for (int i = 0; i < 10000; i++) {
            if (list.get(i).size() == 0) continue;

            ArrayList<String> ll = list.get(i);
            for (int j = 0; j < ll.size(); j++) {
                toBeSorted.add(new CardData(ll.get(j), i));
            }
        }
    }
    public void executeSort() {
        startTime = System.nanoTime();
        countingSort();
        endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000;
    }

    public long getTotalTime() {
        return totalTime;
    }
}

