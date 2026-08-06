import java.util.*;
class TreeNode {
    int data;
    TreeNode left,right;
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class FloorCeilBST {
    public static List<Integer> floorCeilOfBST(TreeNode root, int key) {
        int floor = -1;
        int ceil = -1;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.data == key) {
                floor = curr.data;
                ceil = curr.data;
                break;
            }
            if (curr.data < key) {
                floor = curr.data;
                curr = curr.right;
            } else {
                ceil = curr.data;
                curr = curr.left;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(floor);
        list.add(ceil);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        int key = 11;

        List<Integer> ans = floorCeilOfBST(root, key);

        System.out.println("Floor = " + ans.get(0));
        System.out.println("Ceil = " + ans.get(1));
    }
}