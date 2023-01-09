import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        BinaryTree cont = new BinaryTree();                             // Create `cont` object of BinaryTree class
        Random rand = new Random();                                     // Create `rand` object of Random class
        int n = 10;                                                  // number of keys to insert

        /*
        We can create an array `keys` of ints and fill it with `n` random ints
        int[] keys = new int[n];
        for (int i = 0; i < n; i++) {keys[i] = rand.nextInt();}
        */

        int[] keys = IntStream.range(0, n).map(i -> rand.nextInt(101)).toArray();
        /*
        Or we can achieve the same thing with a lambda expression instead of a for loop
        */

        /*+++++++++++++++++++++++++++++++++++++++++++ORIGINAL RANDOM ORDER+++++++++++++++++++++++++++++++++++++++++++*/

        //TODO - make separate time measurement var names for each class and case
        long startTime = System.nanoTime();                             // Start the timer

        IntStream.of(keys).forEach(key -> cont.insert(key));            // for (int key : keys) {cont.insert(key);}
        /*
        `IntStream` -> method from Java Stream API, it creates a new stream of ints

        `.of` -> method that takes a variable number of arguments, in this case `keys`,
                 so I can pass the array directly to it
                 This way I create a stream that contains `n` elements from the `keys` array in the same order

         `.forEach` -> method that is used to apply a lambda expr for each of `n` elements in the created stream

         Then, a lambda expression takes an int (key) as a parameter and passes it to the method `insert` (insert(key))
         This way each key from the stream is inserted into the binary tree
        */

        long endTime = System.nanoTime();                                             // End the timer
        long elapsedTimeOR = endTime - startTime;                                     // Count elapsed time

        // Output elapsed time for inserting
        System.out.println("OR Cumulative elapsed time for inserting: " + elapsedTimeOR + "ns");

        System.out.println(Arrays.toString(keys));

        startTime = System.nanoTime();
        IntStream.of(keys).forEach(key -> System.out.println("Key: " + cont.find(key) + " has been found!"));       // same way as in `insert` method
        endTime = System.nanoTime();
        elapsedTimeOR = endTime - startTime;

        // Output elapsed time for finding
        System.out.println("OR elapsed time for finding: " + elapsedTimeOR + "ns");

        // Call the sorting method
        cont.inOrderTraversal();
        System.out.println(Arrays.toString(keys));

        /*++++++++++++++++++++++++++++++++++++++++++++++BEST CASE ORDER++++++++++++++++++++++++++++++++++++++++++++++*/

    }
}

