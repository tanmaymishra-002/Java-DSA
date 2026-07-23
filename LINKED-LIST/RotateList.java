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
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        k %= length;
        if (k == 0)
            return head;
        tail.next = head; // Make the list circular
        ListNode newLastNode = findLastNode(head, length - k);
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }

    public ListNode findLastNode(ListNode head, int k) {
        ListNode temp = head;
        int count = 1;
        while (temp != null) {
            if (count == k)
                return temp;
            count++;
            temp = temp.next;
        }
        return null;
    }

    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RotateList obj = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        obj.printList(head);
        head = obj.rotateRight(head, 2);
        System.out.println("After Rotation:");
        obj.printList(head);
    }
}