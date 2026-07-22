class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class removeNthNodeFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        // Move fast n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // If the head itself needs to be removed
        if (fast == null)
            return head.next;
        // Move both pointers together
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // Delete the nth node from the end
        prev.next = slow.next;
        slow.next = null;
        return head;
    }
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        removeNthNodeFromLast obj = new removeNthNodeFromLast();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.print("Original List: ");
        printList(head);
        head = obj.removeNthFromEnd(head, 2);
        System.out.print("After Deletion: ");
        printList(head);
    }
}