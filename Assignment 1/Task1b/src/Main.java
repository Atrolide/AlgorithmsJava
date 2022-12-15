//junit - debug fw

import SortAlgorithms.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<CardData> cardData = new ArrayList<>();

        ArrayList<Long> quickExecTime = new ArrayList<>();
        ArrayList<Float> quickAvgTime = new ArrayList<>();

        ArrayList<Long> countExecTime = new ArrayList<>();
        ArrayList<Float> countAvgTime = new ArrayList<>();

        List<String> lines = Files.readAllLines(Path.of("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1b\\src\\creditcardnumbers.txt"));

        int step = 100;
        int maxNumOfLines = 2000;
        int precision = 1;

        for (String line : lines) {
            String[] parts = line.split(" ");
            cardData.add(new CardData(parts[0], Integer.parseInt(parts[1])));
        }

        for (int i = step; i < maxNumOfLines + 1; i += step) {
            quickExecTime.clear();
            countExecTime.clear();

            float quickSum = 0;
            float countSum = 0;

            for (int j = 0; j < precision; j++) {
                NewQuickSort quickArr = new NewQuickSort(cardData, i);
                CountingSort countArr = new CountingSort(cardData, i);

                quickArr.executeSort();
                countArr.executeSort();

                quickExecTime.add(quickArr.getQuickTime());
                countExecTime.add(countArr.getTotalTime());

                quickSum += quickExecTime.get(j);
                countSum += countExecTime.get(j);
            }
            float quickAvg = quickSum / precision;
            float countAvg = countSum / precision;

            quickAvgTime.add(quickAvg);
            countAvgTime.add(countAvg);
        }

        for (int i = 0; i < maxNumOfLines / step; i++) {
            System.out.println("Quick Sort Average time for " + (i + 1) * step + " lines   ->  " + quickAvgTime.get(i) + "μs");
        }
        System.out.println(quickAvgTime);

        for (int i = 0; i < maxNumOfLines / step; i++) {
            System.out.println("Counting Sort Average time for " + (i + 1) * step + " lines   ->  " + countAvgTime.get(i) + "μs");
        }
        System.out.println(countAvgTime);

        StringBuilder stringBuilder = new StringBuilder();
        File myObj = new File("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1b\\src\\avggraph.csv");
        myObj.delete();

        stringBuilder.append(";").append("Quick Sort").append("\n");

        for (int i = 0; i < maxNumOfLines / step; i++) {
            String quickAvg = quickAvgTime.get(i).toString();
            stringBuilder.append((i + 1) * step + "lines").append(";").append(quickAvg).append("μs").append("\n");
        }

        try (FileWriter writer = new FileWriter("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1b\\src\\avggraph.csv")) {
            writer.write(stringBuilder.toString());
            System.out.println("CSV file created");
        } catch (Exception e) {
            System.out.println("File already exists! Close the file and run the program again.");
        }
    }
}
