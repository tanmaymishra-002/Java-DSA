class ListNode {
    int val;
    ListNode next;
    ListNode child;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next, ListNode child) {
        this.val = val;
        this.next = next;
        this.child = child;
    }
}
public class FlattenLinkedList {
    public ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mergeHead = flattenLinkedList(head.next);
        return merge2List(head, mergeHead);
    }

    public ListNode merge2List(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }
        if (list1 != null)
            res.child = list1;
        if (list2 != null)
            res.child = list2;
        return dummy.child;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.child != null)
                System.out.print(" -> ");
            head = head.child;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        FlattenLinkedList obj = new FlattenLinkedList();
        // Horizontal nodes
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(10);
        ListNode n3 = new ListNode(19);
        ListNode n4 = new ListNode(28);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        // Vertical list of 5
        ListNode a1 = new ListNode(7);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(30);

        n1.child = a1;
        a1.child = a2;
        a2.child = a3;
        // Vertical list of 10
        ListNode b1 = new ListNode(20);

        n2.child = b1;
        // Vertical list of 19
        ListNode c1 = new ListNode(22);
        ListNode c2 = new ListNode(50);

        n3.child = c1;
        c1.child = c2;
        // Vertical list of 28
        ListNode d1 = new ListNode(35);
        ListNode d2 = new ListNode(40);
        ListNode d3 = new ListNode(45);

        n4.child = d1;
        d1.child = d2;
        d2.child = d3;
        System.out.println("Original Vertical Lists:");
        System.out.print("5:  ");
        obj.printList(n1);
        System.out.print("10: ");
        obj.printList(n2);
        System.out.print("19: ");
        obj.printList(n3);
        System.out.print("28: ");
        obj.printList(n4);
        ListNode ans = obj.flattenLinkedList(n1);
        System.out.println("\nFlattened Linked List:");
        obj.printList(ans);
    }
}