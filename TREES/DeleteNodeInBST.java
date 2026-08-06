class DeleteNodeInBST {
    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node deleteNode(Node root, int key) {
        if (root == null)
            return null;
        if (root.val == key)
            return helper(root);
        Node temp = root;
        while (root != null) {
            if (key < root.val) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }

            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return temp;
    }

    public static Node helper(Node root) {
        // No left child
        if (root.left == null)
            return root.right;
        // No right child
        if (root.right == null)
            return root.left;
        // Both children exist
        Node rightSubtree = root.right;
        Node lastRight = findLastRight(root.left);
        lastRight.right = rightSubtree;
        return root.left;
    }

    public static Node findLastRight(Node root) {
        if (root.right == null)
            return root;
        return findLastRight(root.right);
    }

    // Inorder Traversal
    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        System.out.print("Before Deletion: ");
        inorder(root);
        root = deleteNode(root, 3);
        System.out.print("\nAfter Deletion: ");
        inorder(root);
    }
}