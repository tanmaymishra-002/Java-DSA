class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class SearchBST {
    // Search in BST
    public static TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = (root.val > val) ? root.left : root.right;
        }
        return root;
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

        int target = 6;

        TreeNode ans = searchBST(root, target);

        if (ans != null) {
            System.out.println("Node found: " + ans.val);
        } else {
            System.out.println("Node not found");
        }
    }
}