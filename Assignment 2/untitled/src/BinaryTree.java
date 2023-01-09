class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int key) {
        this.root = insertRecursive(this.root, key);
    }

    private Node insertRecursive(Node current, int key) {
        if (current == null) {
            return new Node(key);
        }

        if (key < current.key) {
            current.left = insertRecursive(current.left, key);
        } else if (key > current.key) {
            current.right = insertRecursive(current.right, key);
        } else {
            // key is already in the tree
            return current;
        }

        return current;
    }
}