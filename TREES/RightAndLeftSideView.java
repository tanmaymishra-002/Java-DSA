import java.util.*;
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
public class RightAndLeftSideView {

     public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightView(root, ans, 0);
        return ans;
    }
    private void rightView(TreeNode node, List<Integer> ans, int level) {
        if (node == null)
            return;
        if (ans.size() == level) {
            ans.add(node.val);
        }
        rightView(node.right, ans, level + 1);
        rightView(node.left, ans, level + 1);
    }
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        leftView(root, ans, 0);
        return ans;
    }
    private void leftView(TreeNode node, List<Integer> ans, int level) {
        if (node == null)
            return;
        if (ans.size() == level) {
            ans.add(node.val);
        }
        leftView(node.left, ans, level + 1);
        leftView(node.right, ans, level + 1);
    }
       public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        RightAndLeftSideView obj = new RightAndLeftSideView();

        List<Integer> right = obj.rightSideView(root);
        List<Integer> left = obj.leftSideView(root);

        System.out.println("Right Side View:");
        for (int x : right) {
            System.out.print(x + " ");
        }

        System.out.println();

        System.out.println("Left Side View:");
        for (int x : left) {
            System.out.print(x + " ");
        }
    }
}