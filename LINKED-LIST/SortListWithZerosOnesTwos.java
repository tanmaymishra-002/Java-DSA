class ListNode {
    int data;
    ListNode next;
    ListNode() {}
    ListNode(int data) {
        this.data = data;
    }
    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
public class SortListWithZerosOnesTwos {
    public ListNode sortList(ListNode head) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        ListNode temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            } else if (temp.data == 1) {
                count1++;
            } else {
                count2++;
            }
            temp = temp.next;
        }
        temp = head;
        while (count0 > 0) {
            temp.data = 0;
            count0--;
            temp = temp.next;
        }
        while (count1 > 0) {
            temp.data = 1;
            count1--;
            temp = temp.next;
        }
        while (count2 > 0) {
            temp.data = 2;
            count2--;
            temp = temp.next;
        }
        return head;
    }
    static ListNode insert(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
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
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SortListWithZerosOnesTwos obj = new SortListWithZerosOnesTwos();
        ListNode head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 0);
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 0);
        System.out.print("Original List: ");
        printList(head);
        head = obj.sortList(head);
        System.out.print("Sorted List: ");
        printList(head);
    }
}