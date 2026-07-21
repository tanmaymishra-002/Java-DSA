class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    // Create Linked List from an array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    // Print Linked List
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = createList(arr);
        System.out.print("Original List: ");
        printList(head);
        head = oddEvenList(head);
        System.out.print("Odd-Even Rearranged List: ");
        printList(head);
    }
}