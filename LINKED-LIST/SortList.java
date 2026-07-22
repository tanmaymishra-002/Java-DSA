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
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(second);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left != null)
            temp.next = left;
        if (right != null)
            temp.next = right;
        return dummy.next;
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
        SortList obj = new SortList();
        ListNode head = null;
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);
        head = insert(head, 3);
        head = insert(head, 5);
        System.out.print("Original List: ");
        printList(head);
        head = obj.sortList(head);
        System.out.print("Sorted List: ");
        printList(head);
    }
}