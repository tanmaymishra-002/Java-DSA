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
public class maxdepth {
    static int maxdepth = 0;
    public static int maxDepth(TreeNode root) {
        maxdepth = 0;
        preorder(root, 1);
        return maxdepth;
    }
    public static void preorder(TreeNode root, int depth) {
        if (root == null)
            return;
        maxdepth = Math.max(maxdepth, depth);
        preorder(root.left, depth + 1);
        preorder(root.right, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Depth = " + maxDepth(root));
    }
}