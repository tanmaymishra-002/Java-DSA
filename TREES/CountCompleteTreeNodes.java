class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class CountCompleteTreeNodes {
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getHeightLeft(root);
        int right = getHeightRight(root);
        if (left == right) {
            return (1 << left) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static int getHeightLeft(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
    public static int getHeightRight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println("Number of Nodes: " + countNodes(root));
    }
}