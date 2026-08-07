public class MaxSumBST {
    static class TreeNode {
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

    static class MaxSumBSTHelper {
        int minNode;
        int maxNode;
        int sum;
        MaxSumBSTHelper(int minNode, int maxNode, int sum) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.sum = sum;
        }
    }
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return maxSum;
    }
    public MaxSumBSTHelper maxSumBSTHelper(TreeNode root) {
        // Base Case
        if (root == null) {
            return new MaxSumBSTHelper(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        MaxSumBSTHelper left = maxSumBSTHelper(root.left);
        MaxSumBSTHelper right = maxSumBSTHelper(root.right);
        // Current subtree is a BST
        if (left.maxNode < root.val && root.val < right.minNode) {
            int currSum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, currSum);
            int minValue = Math.min(left.minNode, root.val);
            int maxValue = Math.max(right.maxNode, root.val);
            return new MaxSumBSTHelper(minValue, maxValue, currSum);
        }
        // Current subtree is not a BST
        return new MaxSumBSTHelper(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    public static void main(String[] args) {
        MaxSumBST obj = new MaxSumBST();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);

        System.out.println(obj.maxSumBST(root));
    }
}