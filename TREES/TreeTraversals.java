import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class TreeTraversals {
    public static List<List<Integer>> treeTraversal(TreeNode root) {

        // Preorder -> Root Left Right
        // Inorder -> Left Root Right
        // Postorder -> Left Right Root

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        preorder(root, pre);
        inorder(root, in);
        postorder(root, post);

        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
    }
    public static void preorder(TreeNode root, List<Integer> pre) {
        if (root == null)
            return;

        pre.add(root.data);
        preorder(root.left, pre);
        preorder(root.right, pre);
    }
    public static void inorder(TreeNode root, List<Integer> in) {
        if (root == null)
            return;

        inorder(root.left, in);
        in.add(root.data);
        inorder(root.right, in);
    }
    public static void postorder(TreeNode root, List<Integer> post) {
        if (root == null)
            return;

        postorder(root.left, post);
        postorder(root.right, post);
        post.add(root.data);
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);

        List<List<Integer>> ans = treeTraversal(root);

        System.out.println("Inorder   : " + ans.get(0));
        System.out.println("Preorder  : " + ans.get(1));
        System.out.println("Postorder : " + ans.get(2));
    }
}