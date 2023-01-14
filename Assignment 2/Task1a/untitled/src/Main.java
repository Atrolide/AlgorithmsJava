import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        BinaryTree cont = new BinaryTree();                              // Create `cont` object of BinaryTree class
        Random rand = new Random();                                      // Create `rand` object of Random class
        int n = 8191;                                                       // number of keys to insert

        ArrayList<Long> insertTotalOR = new ArrayList<>();
        ArrayList<Long> findTotalOR= new ArrayList<>();

        ArrayList<Long> insertTotalBC= new ArrayList<>();
        ArrayList<Long> findTotalBC= new ArrayList<>();

        ArrayList<Long> insertTotalLib = new ArrayList<>();
        ArrayList<Long> findTotalLib = new ArrayList<>();


        for (int count = 0; count < 100; count++) {


        /*
        We can create an array `keys` of ints and fill it with `n` random ints
        int[] keys = new int[n];
        for (int i = 0; i < n; i++) {keys[i] = rand.nextInt();}
        */

            int[] keys = IntStream.range(0, n).map(i -> rand.nextInt(101)).toArray();
            cont.makeEmpty();
        /*
        Or we can achieve the same thing with a lambda expression instead of a for loop
        */

            /*+++++++++++++++++++++++++++++++++++++++++++ORIGINAL RANDOM ORDER+++++++++++++++++++++++++++++++++++++++++++*/

            long IstartTimeOR = System.nanoTime();                             // Start the timer

            IntStream.of(keys).forEach(key -> cont.insert(key));            // for (int key : keys) {cont.insert(key);}
//            System.out.println("Original Random Order: ");
//            System.out.println(Arrays.toString(keys) + "\n");
        /*
        `IntStream` -> method from Java Stream API, it creates a new stream of ints

        `.of` -> method that takes a variable number of arguments, in this case `keys`,
                 so I can pass the array directly to it
                 This way I create a stream that contains `n` elements from the `keys` array in the same order

         `.forEach` -> method that is used to apply a lambda expr for each of `n` elements in the created stream

         Then, a lambda expression takes an int (key) as a parameter and passes it to the method `insert` (insert(key))
         This way each key from the stream is inserted into the binary tree
        */

            long IendTimeOR = System.nanoTime();                                             // End the timer
            long IelapsedTimeOR = IendTimeOR - IstartTimeOR;                                     // Count elapsed time
            insertTotalOR.add(IelapsedTimeOR);

            // Output elapsed time for inserting
//        System.out.println("OR Cumulative elapsed time for inserting: " + IelapsedTimeOR + "ns");

            long FstartTimeOR = System.nanoTime();
            IntStream.of(keys).forEach(key -> cont.find(key));       // same way as in `insert` method
            long FendTimeOR = System.nanoTime();
            long FelapsedTimeOR = FendTimeOR - FstartTimeOR;

            findTotalOR.add(FelapsedTimeOR);
            // Output elapsed time for finding
//            System.out.println("OR elapsed time for finding: " + FelapsedTimeOR + "ns\n");
//        cont.printTree();       // Method to show a tree graphically using ASCII
//            System.out.println("\n");

            // Call the sorting method
//        startTimeOR = System.nanoTime();
//        cont.inOrderTraversal();
//        endTimeOR = System.nanoTime();
//        elapsedTimeOR = endTimeOR - startTimeOR;

            // Output elapsed time for sorting
//        System.out.println("OR elapsed time for sorting: " + elapsedTimeOR + "ns");

            /*++++++++++++++++++++++++++++++++++++++++++++++BEST CASE ORDER++++++++++++++++++++++++++++++++++++++++++++++*/

            // Empty the binary tree
            cont.makeEmpty();

            int[] keysSorted = Arrays.stream(keys).sorted().toArray();
            Arrays.sort(keysSorted);                    // nie zawieramy w czasie wykonyania

            long IstartTimeBC = System.nanoTime();
            cont.insertArray(keysSorted, 0, keysSorted.length - 1);
            long IendTimeBC = System.nanoTime();
            long IelapsedTimeBC = IendTimeBC - IstartTimeBC;

//            System.out.println("Best Case Order: ");
//            System.out.println(Arrays.toString(keysSorted) + "\n");

            insertTotalBC.add(IelapsedTimeBC);
            // Output elapsed time for inserting
//            System.out.println("BC Cumulative elapsed time for inserting: " + IelapsedTimeBC + "ns");

            long FstartTimeBC = System.nanoTime();
            IntStream.of(keysSorted).forEach(key -> cont.find(key));
            long FendTimeBC = System.nanoTime();
            long FelapsedTimeBC = FendTimeBC - FstartTimeBC;

            findTotalBC.add(FelapsedTimeBC);
            // Output elapsed time for finding
//            System.out.println("BC elapsed time for finding: " + FelapsedTimeBC + "ns\n");

//        cont.printTree();             // Method to show a tree graphically using ASCII
//            System.out.println("\n");


            /*++++++++++++++++++++++++++++++++++++++++++++++LIBRARY SOLUTION++++++++++++++++++++++++++++++++++++++++++++++*/
            /*
                A TreeSet is a collection that stores its elements in a tree data structure
                and maintains the elements in ascending order according to their natural ordering
                or by a specified comparator. It is a Set implementation that uses a Tree for storage,
                it is implemented as a Red-Black tree (A self-balancing tree).
                It provides guaranteed log(n) time cost for the basic operations
                (add, remove and contains). It is also serializable and cloneable.
            */

            // Create a `tree` object of TreeSet class
            TreeSet<Integer> tree = new TreeSet<>();
            tree.clear();

            long IstartTimeLib = System.nanoTime();
//            System.out.println("Library Solution: ");
//            System.out.println(Arrays.toString(keys) + "\n");

            // Insert the elements of the array into the TreeSet
            IntStream.of(keys).forEach(key -> tree.add(key));
            //This code is using IntStream to iterate over the elements of an int array and adding each element to a "tree" object using a lambda expression.

            // Output elapsed time for inserting
            long IendTimeLib = System.nanoTime();
            long IelapsedTimeLib = IendTimeLib - IstartTimeLib;
            insertTotalLib.add(IelapsedTimeLib);
//            System.out.println("Lib Cumulative elapsed time for inserting: " + IelapsedTimeLib + "ns");

            // Measure time for finding keys
            long FstartTimeLib = System.nanoTime();
            // Method `contains` is from TreeSet Library to look for keys in a tree
            IntStream.of(keys).forEach(key -> tree.add(key));
            long FendTimeLib = System.nanoTime();
            long FelapsedTimeLib = FendTimeLib - FstartTimeLib;

            findTotalLib.add(FelapsedTimeLib);
//            System.out.println("Lib elapsed time for finding: " + FelapsedTimeLib + "ns");

            // Output elements
//        for(Integer i : tree) System.out.print(i + " ");
//        System.out.println("\n");
        }

        double averageInsertOR = insertTotalOR.stream().mapToLong(i -> i).average().getAsDouble();
        System.out.println("Average Insert OR: " + averageInsertOR + "ns");

        double averageFindOR = findTotalOR.stream().mapToLong(i -> i).average().getAsDouble();
        System.out.println("Average Find OR: " + averageFindOR + "ns");

        double averageInsertBC = insertTotalBC.stream().mapToLong(i -> i).average().getAsDouble();
        System.out.println("Average Insert BC: " + averageInsertBC + "ns");

        double averageFindBC = findTotalBC.stream().mapToLong(i -> i).average().getAsDouble();
        System.out.println("Average Find BC: " + averageFindBC + "ns");

        double averageInsertLib = insertTotalLib.stream().mapToLong(i -> i).average().getAsDouble();
        System.out.println("Average Insert Lib: " + averageInsertLib + "ns");

        double averageFindLib = findTotalLib.stream().mapToLong(i -> i).average().getAsDouble();
        System.out.println("Average Find Lib: " + averageFindLib + "ns");

        /*
        .stream():
            This method is used to convert an ArrayList to a Stream.
            A Stream is a sequence of elements.
            In this case, the ArrayList is converted to a Stream so that it can be passed to the average() method.

        .mapToLong(i -> i):
            This method is used to convert the elements of the Stream to a primitive long type.
            i -> i is a lambda expression that returns the element itself,
            so this method is just used to convert the elements from the Stream to longs.

        .average():
            This method returns an OptionalDouble type, which represents a double value that may or may not be present.
            It calculates the average of the elements in the Stream.

        .getAsDouble() :
            This method is used to get the double value that is present within the OptionalDouble.
            It returns the average of all the elements in the stream.

        To sum up, this code:
            1. converts the ArrayList to a Stream using the stream() method,
            2. maps the elements of the stream to long using mapToLong(i -> i) method,
            3. calculates the average of the elements using the average() method.
            4. gets the double value of average by calling the getAsDouble() method.
        */


    }
}

  /*
         Conajmniej dla 3 róznych wielkości arraya w formie histogramu
         np 100, 1000, 10000
        * */
// TODO  - Wykonać wszystko w pętli 100 razy, podać uśrednioną wartość