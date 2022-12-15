import SortAlgorithms.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        ArrayList<CardData> cardData = new ArrayList<>();

    List<String> lines = Files.readAllLines(Path.of("D:\\Learning Materials\\Java\\AlgorithmsJava\\Ex1b\\Task1b\\src\\creditcardnumbers.txt"));


    int step = 500;
    int maxNumOfLines = lines.size();
    int precision = 10;

        for (String line : lines) {
        String[] parts = line.split(" ");
        cardData.add(new CardData(parts[0], Integer.parseInt(parts[1])));
    }

        for (int i = step; i < maxNumOfLines + 1; i += step) {
            float sum = 0;
            for (int j = 0; j < precision; j++) {
                CountingSort test2Arr = new CountingSort(cardData, i);
                test2Arr.executeSort();
            }
        }
            CountingSort test2Arr = new CountingSort(cardData, 1);
//            test2Arr.copyArr();
//            test2Arr.printArr();
            test2Arr.executeSort();
        System.out.println("Total time: " + test2Arr.getTotalTime() + "μs");
            test2Arr.printArr();

        }


    }

