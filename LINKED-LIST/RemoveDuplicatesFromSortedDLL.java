class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }
    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }
    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}
public class RemoveDuplicatesFromSortedDLL {
    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                ListNode duplicate = temp.next;
                temp.next = duplicate.next;
                if (duplicate.next != null) {
                    duplicate.next.prev = temp;
                }
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(3);
        ListNode fifth = new ListNode(3);
        ListNode sixth = new ListNode(4);
        ListNode seventh = new ListNode(5);
        ListNode eighth = new ListNode(5);
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
        seventh.next = eighth;
        eighth.prev = seventh;
        RemoveDuplicatesFromSortedDLL obj = new RemoveDuplicatesFromSortedDLL();
        System.out.println("Original DLL:");
        printList(head);
        head = obj.removeDuplicates(head);
        System.out.println("After Removing Duplicates:");
        printList(head);
    }
}