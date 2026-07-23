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
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (prev != null)
                    prev.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            ListNode newHead = reverseLinkedList(temp);
            if (temp == head) {
                head = newHead;
            } else {
                prev.next = newHead;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
    }
    public ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }
        return prev;
    }
    public ListNode findKthNode(ListNode head, int k) {
        while (head != null && k > 1) {
            k--;
            head = head.next;
        }
        return head;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
        int k = 2;
        System.out.println("Original List:");
        printList(head);
        head = obj.reverseKGroup(head, k);
        System.out.println("After Reversing Every " + k + " Nodes:");
        printList(head);
    }
}