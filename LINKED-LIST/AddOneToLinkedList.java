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
public class AddOneToLinkedList {
    public ListNode addOne(ListNode head) {
        head = reverse(head);
        int carry = 1;
        ListNode temp = head;
        while (temp != null && carry == 1) {
            int sum = temp.val + carry;
            temp.val = sum % 10;
            carry = sum / 10;
            if (carry == 1 && temp.next == null) {
                temp.next = new ListNode(0);
            }
            temp = temp.next;
        }
        head = reverse(head);
        return head;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
    // Helper method to print the list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        AddOneToLinkedList obj = new AddOneToLinkedList();
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        System.out.print("Original List: ");
        obj.printList(head);
        head = obj.addOne(head);
        System.out.print("After Adding One: ");
        obj.printList(head);
    }
}