class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class CheckChildrenSum {
    static boolean checkChildrenSum(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int leftSum = 0;
        int rightSum = 0;

        if (root.left != null) leftSum = root.left.val;
        if (root.right != null) rightSum = root.right.val;
        if (root.val != leftSum + rightSum) return false;

        return checkChildrenSum(root.left) && checkChildrenSum(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        System.out.println(checkChildrenSum(root));
    }
}