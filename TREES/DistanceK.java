import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}
public class DistanceK {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParents(root, parentTrack);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance == k)
                break;
            distance++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null && visited.get(temp.left) == null) {
                    q.offer(temp.left);
                    visited.put(temp.left, true);
                }
                if (temp.right != null && visited.get(temp.right) == null) {
                    q.offer(temp.right);
                    visited.put(temp.right, true);
                }
                if (parentTrack.get(temp) != null && visited.get(parentTrack.get(temp)) == null) {
                    q.offer(parentTrack.get(temp));
                    visited.put(parentTrack.get(temp), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
    public static void markParents(TreeNode root,
                                   Map<TreeNode, TreeNode> parentTrack) {

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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode target = root.left; // Node 5
        int k = 2;
        List<Integer> ans = distanceK(root, target, k);
        System.out.println(ans);
    }
}