class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }
    public static int check(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = check(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = check(root.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        // Example 1 (Balanced)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println(isBalanced(root)); // true
    }
}