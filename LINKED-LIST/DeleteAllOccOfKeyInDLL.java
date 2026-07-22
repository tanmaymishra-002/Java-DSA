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
public class DeleteAllOccOfKeyInDLL {
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        if (head == null)
            return null;
        ListNode temp = head;
        while (temp != null) {
            ListNode front = temp.next;
            if (temp.val == target) {
                ListNode prev = temp.prev;
                if (prev == null && front == null) {
                    return null;
                } 
                else if (prev == null) {
                    head = deleteHead(head);
                } 
                else if (front == null) {
                    head = deleteTail(head);
                } 
                else {
                    prev.next = front;
                    front.prev = prev;
                    temp.next = null;
                    temp.prev = null;
                }
            }
            temp = front;
        }
        return head;
    }
    public static ListNode deleteHead(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode newHead = head.next;
        newHead.prev = null;
        head.next = null;
        return newHead;
    }
    public static ListNode deleteTail(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        ListNode prevNode = tail.prev;
        prevNode.next = null;
        tail.prev = null;
        return head;
    }
        public static void main(String[] args) {
        DeleteAllOccOfKeyInDLL obj =new DeleteAllOccOfKeyInDLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.prev = head;
        head.next.next = new ListNode(2);
        head.next.next.prev = head.next;
        head.next.next.next = new ListNode(3);
        head.next.next.next.prev = head.next.next;
        head = obj.deleteAllOccurrences(head, 2);
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}