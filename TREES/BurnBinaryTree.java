import java.util.*;
class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}
public class BurnBinaryTree {
    public static int minTime(TreeNode root, TreeNode target) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParents(root, parentTrack);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && visited.get(curr.left) == null) {
                    burned = true;
                    visited.put(curr.left, true);
                    q.offer(curr.left);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    burned = true;
                    visited.put(curr.right, true);
                    q.offer(curr.right);
                }
                if (parentTrack.get(curr) != null &&
                        visited.get(parentTrack.get(curr)) == null) {

                    burned = true;
                    visited.put(parentTrack.get(curr), true);
                    q.offer(parentTrack.get(curr));
                }
            }
            if (burned)
                time++;
        }
        return time;
    }
    public static void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parentTrack.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parentTrack.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        TreeNode target = root;

        System.out.println(minTime(root, target));
    }
}