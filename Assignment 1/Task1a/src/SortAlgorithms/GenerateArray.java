package SortAlgorithms;
import java.util.ArrayList;
import java.util.Random;

public class GenerateArray {
   public ArrayList<Integer> Arr = new ArrayList<>();

    public void generate(int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            Arr.add(rand.nextInt(1001));
        }
    }
}
