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
public class RootToLeafPaths {
    public List<List<Integer>> rootToLeaf(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> path, List<List<Integer>> ans) {
        if (node == null)
            return;
        // Add current node to the path
        path.add(node.val);

        // If it is a leaf node, store the current path
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        }

        // Traverse left subtree
        dfs(node.left, path, ans);

        // Traverse right subtree
        dfs(node.right, path, ans);

        // Backtrack
        path.remove(path.size() - 1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        RootToLeafPaths obj = new RootToLeafPaths();

        List<List<Integer>> ans = obj.rootToLeaf(root);

        System.out.println("Root to Leaf Paths:");

        for (List<Integer> path : ans) {
            System.out.println(path);
        }
    }
}