import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
public class FindPairsWithGivenSum {
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (head == null) {
            return ans;
        }
        ListNode left = head;
        ListNode right = head;
        while (right.next != null) {
            right = right.next;
        }
        while (left != null && right != null && left != right && right.next != left) {
            int sum = left.val + right.val;
            if (sum > target) {
                right = right.prev;
            } else if (sum < target) {
                left = left.next;
            } else {
                ans.add(Arrays.asList(left.val, right.val));
                left = left.next;
                right = right.prev;
            }
        }
        return ans;
    }
    public static void printPairs(List<List<Integer>> pairs) {
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(6);
        ListNode sixth = new ListNode(8);
        ListNode seventh = new ListNode(9);
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;
        fifth.next = sixth;
        sixth.prev = fifth;
        sixth.next = seventh;
        seventh.prev = sixth;
        FindPairsWithGivenSum obj = new FindPairsWithGivenSum();
        List<List<Integer>> ans = obj.findPairsWithGivenSum(head, 7);
        System.out.println("Pairs with given sum:");
        printPairs(ans);
    }
}