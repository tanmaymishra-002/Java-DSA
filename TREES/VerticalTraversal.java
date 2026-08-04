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
class Tuple {
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple it = q.poll();
            TreeNode temp = it.node;
            int row = it.row;
            int col = it.col;

            // Create column if absent
            map.putIfAbsent(col, new TreeMap<>());

            // Create row if absent
            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            // Insert node value
            map.get(col).get(row).offer(temp.val);

            // Left Child
            if (temp.left != null) {
                q.offer(new Tuple(temp.left, row + 1, col - 1));
            }

            // Right Child
            if (temp.right != null) {
                q.offer(new Tuple(temp.right, row + 1, col + 1));
            }
        }

        // Construct Answer
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> curr = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    curr.add(pq.poll());
                }
            }
            ans.add(curr);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        VerticalTraversal obj = new VerticalTraversal();

        List<List<Integer>> ans = obj.verticalTraversal(root);

        System.out.println("Vertical Order Traversal:");

        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}