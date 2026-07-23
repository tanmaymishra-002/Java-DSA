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
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = list1;
        ListNode temp2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (temp != null && temp2 != null) {
            if (temp.val < temp2.val) {
                res.next = temp;
                res = res.next;
                temp = temp.next;
            } else if (temp.val > temp2.val) {
                res.next = temp2;
                res = res.next;
                temp2 = temp2.next;
            } else {
                res.next = temp;
                res = res.next;
                temp = temp.next;
            }
        }
        if (temp != null)
            res.next = temp;
        else
            res.next = temp2;
        return dummy.next;
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
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        ListNode list1 = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);

        list1.next = a1;
        a1.next = a2;

        ListNode list2 = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);

        list2.next = b1;
        b1.next = b2;
        System.out.println("List 1:");
        obj.printList(list1);
        System.out.println("List 2:");
        obj.printList(list2);
        ListNode merged = obj.mergeTwoLists(list1, list2);
        System.out.println("Merged List:");
        obj.printList(merged);
    }
}