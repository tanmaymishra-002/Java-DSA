class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right) {
        // If one or both nodes are null
        if (left == null || right == null)
            return left == right;
        // Values must be equal
        if (left.val != right.val)
            return false;
        // Compare mirror nodes
        return helper(left.left, right.right)
                && helper(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree obj = new SymmetricTree();

        if (obj.isSymmetric(root)) {
            System.out.println("Tree is Symmetric");
        } else {
            System.out.println("Tree is NOT Symmetric");
        }
    }
}