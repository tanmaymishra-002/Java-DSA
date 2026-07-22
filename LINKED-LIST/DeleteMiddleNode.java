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
public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        slow.next = null;
        return head;
    }
    static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null)
            return newNode;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
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
        DeleteMiddleNode obj = new DeleteMiddleNode();
        ListNode head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);
        System.out.print("Original List: ");
        printList(head);
        head = obj.deleteMiddle(head);
        System.out.print("After Deleting Middle: ");
        printList(head);
    }
}