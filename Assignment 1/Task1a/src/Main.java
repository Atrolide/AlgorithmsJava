import SortAlgorithms.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Long> bubbleTime = new ArrayList<>();
        ArrayList<Long> insertTime = new ArrayList<>();
        ArrayList<Long> mergeTime = new ArrayList<>();
        ArrayList<Long> quickTime = new ArrayList<>();
        GenerateArray SmallArr = new GenerateArray();

        for (int i = 100; i < 10001; i += 100) {
            SmallArr.Arr.clear();
            SmallArr.generate(i);

            BubbleSort SmallBubble = new BubbleSort(SmallArr.Arr);
            InsertionSort SmallInsert = new InsertionSort(SmallArr.Arr);
            MergeSort SmallMerge = new MergeSort(SmallArr.Arr);
            QuickSort SmallQuick = new QuickSort(SmallArr.Arr);

            //BUBBLE SORT
            SmallBubble.executeSort();
            bubbleTime.add(SmallBubble.getTotalTime());

            //INSERTION SORT
            SmallInsert.executeSort();
            insertTime.add(SmallInsert.getTotalTime());

            //MERGE SORT
            SmallMerge.executeSort();
            mergeTime.add(SmallMerge.getTotalTime());

            //QUICK SORT
            SmallQuick.executeSort();
            quickTime.add(SmallQuick.getTotalTime());
        }

        long bsum = 0;
        long isum = 0;
        long msum = 0;
        long qsum = 0;

        System.out.println("\nBUBBLE SORT: ");
        for (int i = 0; i < bubbleTime.size(); i++) {
            System.out.println("Exec time for array size " + (i + 1) * 100 + "  ->  " + bubbleTime.get(i) + "μs");
            bsum += bubbleTime.get(i);
        }
        System.out.println("\nINSERTION SORT: ");
        for (int i = 0; i < insertTime.size(); i++) {
            System.out.println("Exec time for array size " + (i + 1) * 100 + "  ->  " + insertTime.get(i) + "μs");
            isum += insertTime.get(i);
        }
        System.out.println("\nMERGE SORT: ");
        for (int i = 0; i < mergeTime.size(); i++) {
            System.out.println("Exec time for array size " + (i + 1) * 100 + "  ->  " + mergeTime.get(i) + "μs");
            msum += mergeTime.get(i);
        }
        System.out.println("\nQUICK SORT: ");
        for (int i = 0; i < quickTime.size(); i++) {
            System.out.println("Exec time for array size " + (i + 1) * 100 + "  ->  " + quickTime.get(i) + "μs");
            qsum += quickTime.get(i);
        }

        long bavg = bsum / bubbleTime.size();
        long iavg = isum / insertTime.size();
        long mavg = msum / mergeTime.size();
        long qavg = qsum / quickTime.size();

        //Full graph csv
        //STRING BUILDER ATTEMPT
        StringBuilder mainGraph = new StringBuilder();
        File mainGraphFile = new File("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1a\\src\\graph.csv");
        mainGraphFile.delete();

        //APPEND HEADER
        mainGraph.append(";").append("Bubble Sort").append(";").append("Insertion Sort").append(";").append("Merge Sort").append(";").append("Quick Sort").append("\n");

        //APPEND RUNTIME
        for (int i = 0; i < quickTime.size(); i++) {
            String bubble = bubbleTime.get(i).toString();
            String insert = insertTime.get(i).toString();
            String merge = mergeTime.get(i).toString();
            String quick = quickTime.get(i).toString();
            mainGraph.append((i + 1) * 100 + "el").append(";").append(bubble).append("μs").append(";").append(insert).append("μs").append(";").append(merge).append("μs").append(";").append(quick).append("μs").append("\n");
        }

        try(FileWriter mainGraphWriter = new FileWriter("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1a\\src\\graph.csv")) {
            mainGraphWriter.write(mainGraph.toString());
            System.out.println("CSV file created");
        } catch (Exception e) {
            System.out.println("File already exists! Close the file and run the program again.");
        }

        System.out.println("Average execution time for bubble sort: " + bavg + "μs");
        System.out.println("Average execution time for insert sort: " + iavg + "μs");
        System.out.println("Average execution time for merge sort: " + mavg + "μs");
        System.out.println("Average execution time for quick sort: " + qavg + "μs");


        //AVG CSV
        StringBuilder avgGraph = new StringBuilder();
        File avgGraphFile = new File("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1a\\src\\graphAVG.csv");
        avgGraphFile.delete();
        avgGraph.append(";").append("Bubble Sort").append(";").append("Insertion Sort").append(";").append("Merge Sort").append(";").append("Quick Sort").append("\n");
        avgGraph.append("Array size ").append(SmallArr.Arr.size()).append(" Average Runtime").append(";").append(bavg).append("μs").append(";").append(iavg).append("μs").append(";").append(mavg).append("μs").append(";").append(qavg).append("μs").append("\n");

        try(FileWriter avgGraphWriter = new FileWriter("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1a\\src\\graphAVG.csv")) {
            avgGraphWriter.write(avgGraph.toString());
            System.out.println("CSV file created");
        } catch (Exception e) {
            System.out.println("File already exists! Close the file and run the program again.");
        }

        //Merge Quick CSV
        StringBuilder mqGraph = new StringBuilder();
        File myObj3 = new File("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1a\\src\\graphMergeQuick.csv");
        myObj3.delete();

        mqGraph.append(";").append("Merge Sort").append(";").append("Quick Sort").append("\n");

        for (int i = 0; i < quickTime.size(); i++) {
            String merge = mergeTime.get(i).toString();
            String quick = quickTime.get(i).toString();
            mqGraph.append((i + 1) * 100 + "el").append(";").append(merge).append("μs").append(";").append(quick).append("μs").append("\n");
        }

        try(FileWriter mqGraphWriter = new FileWriter("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1a\\src\\graphMergeQuick.csv")) {
            mqGraphWriter.write(mqGraph.toString());
            System.out.println("CSV file created");
        } catch (Exception e) {
            System.out.println("File already exists! Close the file and run the program again.");
        }

        //Bubble Insert CSV
        StringBuilder biGraph = new StringBuilder();
        File biGraphFile = new File("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1a\\src\\graphBubbleInsert.csv");
        biGraphFile.delete();

       biGraph.append(";").append("Bubble Sort").append(";").append("Insertion Sort").append("\n");

        for (int i = 0; i < bubbleTime.size(); i++) {
            String bubble = bubbleTime.get(i).toString();
            String insert = insertTime.get(i).toString();
            biGraph.append((i + 1) * 100 + "el").append(";").append(bubble).append("μs").append(";").append(insert).append("μs").append("\n");
        }

        try(FileWriter biGraphWriter = new FileWriter("D:\\Learning Materials\\Java\\AlgorithmsJava\\Assignment 1\\Task1a\\src\\graphBubbleInsert.csv")) {
            biGraphWriter.write(biGraph.toString());
            System.out.println("CSV file created");
        } catch (Exception e) {
            System.out.println("File already exists! Close the file and run the program again.");
        }

    }
}

