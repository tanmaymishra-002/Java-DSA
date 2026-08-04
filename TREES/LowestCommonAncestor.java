class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        TreeNode lca1 = lowestCommonAncestor(root, root.left.left, root.left.right.right);
        System.out.println("LCA of 4 and 7 = " + lca1.val);

        TreeNode lca2 = lowestCommonAncestor(root, root.left.right, root.right.right);
        System.out.println("LCA of 5 and 9 = " + lca2.val);

        TreeNode lca3 = lowestCommonAncestor(root, root.left, root.left.right.left);
        System.out.println("LCA of 2 and 6 = " + lca3.val);
    }
}