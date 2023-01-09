import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        // Generate a list of random keys
        int numKeys = 100;
        Random rand = new Random();
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < numKeys; i++) {
            keys.add(rand.nextInt(1000));
        }

        // Insert keys into binary tree in original random order
        long startTime = System.nanoTime();
        BinaryTree tree = new BinaryTree();
        for (int key : keys) {
            tree.insert(key);
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Cumulative running time for original random order: " + elapsedTime + " nanoseconds");

        // Rearrange keys into best-case order (consecutive levels of the tree downwards)
        // and insert into binary tree
        startTime = System.nanoTime();
        tree = new BinaryTree();
        for (int i = 0; i < numKeys; i++) {
            tree.insert(keys.get(i));
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Cumulative running time for original random order: " + elapsedTime + " nanoseconds");
    }
}