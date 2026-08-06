public class ValidateBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean helper(TreeNode root, long max, long min) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        // Check left subtree
        boolean leftValid = helper(root.left, root.val, min);
        if (!leftValid)
            return false;
        // Check right subtree
        boolean rightValid = helper(root.right, max, root.val);
        if (!rightValid)
            return false;
        return true;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(obj.isValidBST(root)); // true


        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(6);

        System.out.println(obj.isValidBST(root2)); // false
    }
}