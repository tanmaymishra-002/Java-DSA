import java.util.Stack;
public class TwoSumIVInputIsABST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class BSTIterator {
        Stack<TreeNode> st = new Stack<>();
        boolean reverse;
        BSTIterator(TreeNode root, boolean isReverse) {
            reverse = isReverse;
            pushAll(root);
        }
        int next() {
            TreeNode temp = st.pop();
            if (!reverse) {
                pushAll(temp.right);
            } else {
                pushAll(temp.left);
            }
            return temp.val;
        }

        boolean hasNext() {
            return !st.isEmpty();
        }
        void pushAll(TreeNode root) {
            while (root != null) {
                st.push(root);
                if (reverse) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);
        int i = left.next();
        int j = right.next();
        while (i < j) {
            int sum = i + j;
            if (sum == k) {
                return true;
            } else if (sum < k) {
                if (left.hasNext()) {
                    i = left.next();
                } else {
                    break;
                }
            } else {
                if (right.hasNext()) {
                    j = right.next();
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 9;
        System.out.println(findTarget(root, k));
    }
}