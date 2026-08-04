import java.util.*;
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair {
    TreeNode node;
    int hd;
    Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class BottomViewOfTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        BottomViewOfTree obj = new BottomViewOfTree();
        List<Integer> ans = obj.bottomView(root);
        System.out.println("Bottom View:");
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair it = q.poll();
            TreeNode temp = it.node;
            int hd = it.hd;
            // Overwrite every time
            map.put(hd, temp.data);
            if (temp.left != null) {
                q.offer(new Pair(temp.left, hd - 1));
            }
            if (temp.right != null) {
                q.offer(new Pair(temp.right, hd + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
