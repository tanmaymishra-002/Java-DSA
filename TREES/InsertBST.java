class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class InsertBST {
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode curr = root;
        while (true) {
            if (curr.val <= val) {
                if (curr.right != null)
                    curr = curr.right;
                else {
                    curr.right = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

    // Inorder Traversal
    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);

        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        int value = 5;

        root = insertIntoBST(root, value);

        System.out.println("Inorder Traversal after insertion:");
        inorder(root);
    }
}