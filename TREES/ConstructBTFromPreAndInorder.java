import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ConstructBTFromPreAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                         inorder, 0, inorder.length - 1, inMap);
    }
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd,
                               Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preorder,
                              preStart + 1,
                              preStart + numsLeft,
                              inorder,
                              inStart,
                              inRoot - 1,
                              inMap);
        root.right = buildTree(preorder,
                               preStart + numsLeft + 1,
                               preEnd,
                               inorder,
                               inRoot + 1,
                               inEnd,
                               inMap);
        return root;
    }
    // Inorder traversal to verify the constructed tree
    public void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
    public static void main(String[] args) {
       int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        ConstructBTFromPreAndInorder tree = new ConstructBTFromPreAndInorder();
        TreeNode root = tree.buildTree(preorder, inorder);
        System.out.println("Inorder Traversal of Constructed Tree:");
        tree.inorderTraversal(root);
    }
}