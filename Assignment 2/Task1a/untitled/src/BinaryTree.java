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

    //TODO - check and explain why we look if `node == null`
    private Node insert(Node node, int data) {
        // If the node is null -> create a new node with the current value (constructor from line 11)
        if (node == null) {
            return new Node(data);
        }
        //TODO - ask why do we compare `node.data`

        // If value is less than data in the node -> insert as the left child
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            // If value is greater than data in the node -> insert as the right child
            node.right = insert(node.right, data);
        }
        return node;
    }

    //TODO - Explain `find` method in comments
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


}

