import java.util.*;
public class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode temp = st.pop();
        if (temp.right != null) {
            pushAll(temp.right);
        }
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void pushAll(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        // Construct BST
        //         7
        //       /   \
        //      3     15
        //           /  \
        //          9    20

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}