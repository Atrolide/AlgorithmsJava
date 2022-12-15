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
        ArrayList<Long> execTime = new ArrayList<>();
        ArrayList<Float> avgTime = new ArrayList<>();

        List<String> lines = Files.readAllLines(Path.of("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1b\\src\\creditcardnumbers.txt"));

        int step = 500;
        int maxNumOfLines = lines.size();
        int precision = 10;

        for (String line : lines) {
            String[] parts = line.split(" ");
            cardData.add(new CardData(parts[0], Integer.parseInt(parts[1])));
        }

        for (int i = step; i < maxNumOfLines + 1; i += step) {
            execTime.clear();
            float sum = 0;
            for (int j = 0; j < precision; j++) {
                NewQuickSort quickArr = new NewQuickSort(cardData, i);
                quickArr.executeSort();
                execTime.add(quickArr.getQuickTime());
                sum += execTime.get(j);
            }
//            for (int j = 0; j < precision; j++) {
//                System.out.println(j + 1 + " Execution time for " + i + " lines  ->  " + execTime.get(j) + "μs");
//            }
            float avg = sum / precision;
//            System.out.println("Sum for " + i + " lines     =    " + sum + "μs");
//            System.out.println("Average for " + i +" lines     =    " + avg + "μs");
            avgTime.add(avg);
        }

        for (int i = 0; i < maxNumOfLines / step; i++) {
            System.out.println("Average time for " + (i + 1) * step + " lines   ->  " + avgTime.get(i) + "μs");
        }
        System.out.println(avgTime);

//                  "D:\\Learning Materials\\Java\\AlgorithmsJava\\Ex1b\\Task1b\\src"

        StringBuilder stringBuilder = new StringBuilder();
        File myObj = new File("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1b\\src\\avggraph.csv");
        myObj.delete();

        stringBuilder.append(";").append("Quick Sort").append("\n");

        for (int i = 0; i < maxNumOfLines / step; i++) {
            String quickAvg = avgTime.get(i).toString();
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
