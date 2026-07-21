public class MiddleOfLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // -------------------- Brute Force --------------------
    static ListNode middleNodeBrute(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int middle = count / 2;
        ListNode mover = head;
        int index = 0;
        while (mover != null) {
            if (index == middle) {
                return mover;
            }
            mover = mover.next;
            index++;
        }
        return null;
    }
    // -------------------- Optimal (Slow & Fast Pointer) --------------------
    static ListNode middleNodeOptimal(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // -------------------- Display Linked List --------------------
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    // -------------------- Main --------------------
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.print("Brute Force: ");
        printList(middleNodeBrute(head));
        System.out.print("Optimal: ");
        printList(middleNodeOptimal(head));
    }
}