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
class TreeConstructionFromPostorderAndInorder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                         postorder, 0, postorder.length - 1,
                         inMap);
    }
    public static TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                                     int[] postorder, int postStart, int postEnd,
                                     Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(inorder,
                              inStart,
                              inRoot - 1,
                              postorder,
                              postStart,
                              postStart + numsLeft - 1,
                              inMap);
        root.right = buildTree(inorder,
                               inRoot + 1,
                               inEnd,
                               postorder,
                               postStart + numsLeft,
                               postEnd - 1,
                               inMap);
        return root;
    }
    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println("Preorder Traversal:");
        preorder(root);
    }
}