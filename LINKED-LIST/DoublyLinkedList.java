class Node {
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}

class DoublyLinkedList {
    static Node convertarr2DLL(int[] arr) {
        if (arr.length == 0) return null;
        Node Head = new Node(arr[0]);
        Node back = Head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            back.next = temp;
            temp.back = back;
            back = temp;
        }
        return Head;
    }
    static void traverse(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    static void reversetraverse(Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.back;
        }
        System.out.println();
    }
    static int length(Node head) {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    static boolean search(Node head, int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    static Node insertbeforHead(Node Head, int data) {
        Node newHead = new Node(data, Head, null);
        Head.back = newHead;
        return newHead;
    }
    static Node insertbeforeTail(Node head, int data) {
        if (head.next == null)
            return insertbeforHead(head, data);
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.back;
        Node newNode = new Node(data, tail, prev);
        prev.next = newNode;
        tail.back = newNode;
        return head;
    }
    static Node insertbeforeK(Node head, int k, int data) {
        if (k == 1) {
            return insertbeforHead(head, data);
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k)
                break;
            temp = temp.next;
        }
        if (temp == null)
            return head;
        Node prev = temp.back;
        Node newNode = new Node(data, temp, prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }
    static Node removeHead(Node head) {
        if (head == null || head.next == null)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        head.back = null;
        return head;
    }
    static Node removeTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newTail = tail.back;
        newTail.next = null;
        tail.back = null;
        return head;
    }
    static Node removeKthelement(Node head, int k) {
        if (head == null)
            return null;
        int count = 0;
        Node Knode = head;
        while (Knode != null) {
            count++;
            if (count == k)
                break;
            Knode = Knode.next;
        }
        if (Knode == null)
            return head;
        Node prev = Knode.back;
        Node front = Knode.next;
        if (prev == null)
            return removeHead(head);
        else if (front == null)
            return removeTail(head);
        prev.next = front;
        front.back = prev;
        Knode.next = null;
        Knode.back = null;
        return head;
    }
    static Node removeByValue(Node head, int data) {
        if (head == null)
            return null;
        if (head.data == data)
            return removeHead(head);
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                if (temp.next != null) {
                    temp.next.back = temp.back;
                }
                temp.back.next = temp.next;
                temp.next = null;
                temp.back = null;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    static Node reverseDLL(Node head) {
        if (head == null || head.next == null)
            return head;
        Node prev = null;
        Node current = head;
        while (current != null) {
            prev = current.back;
            current.back = current.next;
            current.next = prev;

            current = current.back;
        }
        return prev.back;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Node head = convertarr2DLL(arr);
        System.out.println("Original DLL:");
        traverse(head);
        System.out.println("Reverse Traversal:");
        reversetraverse(head);
        System.out.println("Length: " + length(head));
        System.out.println("Search 30: " + search(head, 30));
        System.out.println("Search 100: " + search(head, 100));
        head = insertbeforHead(head, 5);
        traverse(head);
        head = insertbeforeTail(head, 45);
        traverse(head);
        head = insertbeforeK(head, 3, 15);
        traverse(head);
        head = removeHead(head);
        traverse(head);
        head = removeTail(head);
        traverse(head);
        head = removeKthelement(head, 3);
        traverse(head);
        head = removeByValue(head, 30);
        traverse(head);
        head = reverseDLL(head);
        traverse(head);
        System.out.println("Reverse Traversal:");
        reversetraverse(head);
    }
}