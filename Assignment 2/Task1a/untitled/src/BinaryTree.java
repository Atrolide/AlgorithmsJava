public class BinaryTree {
    /*
    We create a nested static class `Node` inside `BinaryTree` to represent a node in the binary tree
    */
    private static class Node {
        int data;                        // The value stored in the node
        Node left;                      // The left child of the node
        Node right;                     // The right child of the node

        // Node constructor to create a new node with a given value
        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;                      //The root node (first inserted element that we compare other values to)

    // `insert` method that inserts a new value into the binary tree
    public void insert(int data) {
        root = insert(root, data);
        /*
        We call the "helper" method   ->   private Node insert (Node node, int data)
        to insert the value at the correct position in our binary tree
        */
    }

        // Definition of a "helper" insert method, it puts the value at the correct position to our binary tree
    private Node insert(Node node, int data) {
          /*
          If the node is null -> create a new node with the current value (constructor from line 11)
          We check if node == null because `node` argument starts as the `root` node of the tree,
          if the root node is null, it means the tree is currently empty
          */
        if (node == null) {
            return new Node(data);
        }
        /*
        `node.data` is the value stored in each node of the binary tree.
        It is used to determine the location of the other nodes in the tree.
        */

        // If value is less than data in the node -> insert as the left child
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            // If value is greater than data in the node -> insert as the right child
            node.right = insert(node.right, data);
        }
        return node;
    }

    /*
     We compare the `data` value passed in the method with the value stored in the current node.
     If `data` is less than value in current node, it calls itself on `left` child of current node with same `data` value.
     If `data` is greater than value in current node, it calls itself on `right` child of current node with same `data` value.
     This process continues until the value is found or the current node == null <==> the data is not in the tree.
     */

    //TODO - Fix the output, if tree is empty print info that tree is empty and not `key -1 found`
    public int find(int data) {
        return find(root, data);
    }

    private int find(Node node, int data) {
        if (node == null) {
            return -1; // Return -1 to indicate that the key was not found
        }
        if (data == node.data) {
            return data; // Return the key if it is found
        }
        if (data < node.data) {
            return find(node.left, data);
        } else {
            return find(node.right, data);
        }
    }

    //TODO - Explain `in order traversal` sort in comments | Hint -> calling the func similar to mergesort
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    // Method to empty a binary tree, we set root to null
    public void makeEmpty(){
        root = null;
        makeEmpty(root);
    }

    // We call this method recursively on children, until we empty a whole tree
    public void makeEmpty(Node node) {
        if (node != null) {
            makeEmpty(node.left);
            makeEmpty(node.right);
            node = null;
        }
    }

    public void insertArray(int[] arr, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            insert(arr[mid]);
            insertArray(arr, start, mid - 1);
            insertArray(arr, mid + 1, end);
        }
    }

    // TODO - Method to draw/print a binary tree
    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        if (node == null) {
            return;
        }
        printTree(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------" + node.data);
        } else {
            System.out.println(node.data);
        }
        printTree(node.left, level + 1);
    }


}

