class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class KthSmallestElementInABST {
    static int answer = -1;
    static int count = 0;
    public static int kthSmallest(TreeNode root, int k) {
        answer = -1;
        count = 0;
        inorder(root, k);
        return answer;
    }
    public static void inorder(TreeNode root, int k) {
        if (root == null || answer != -1)
            return;
        inorder(root.left, k);
        count++;
        if (count == k) {
            answer = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;

        System.out.println("Kth Smallest Element = " + kthSmallest(root, k));
    }
}