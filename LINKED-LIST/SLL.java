// Singly Linked List

class Node{
    int data;
    Node next;

    Node(int data1,Node next1){
        this.data = data1;
        this.next = next1;
    }
    Node(int data1){
        this.data=data1;
        this.next=null;
    }
}
class SLL{
        static Node convertarr2LL(int[] arr){
            if(arr.length==0){
                return null;
            }
            Node head = new Node(arr[0]);
            Node mover = head;
            for(int i=1;i<arr.length;i++){
                Node temp = new Node(arr[i]);
                mover.next = temp;
                mover = temp;
            }
            return head;
        } 
        static void traverse(Node head){
            Node temp = head;
            while(temp!=null){
                System.out.println(temp.data+" ");
                temp=temp.next;
            }
            
        }
        static int lengthOfLL(Node head){
            int count = 0;
            Node temp = head;
            while(temp!=null){
                temp = temp.next;
                count++;
            }
            return count;
        }
        static boolean search(Node head , int key){
            Node temp = head;
            while(temp!=null){
                if(temp.data == key){
                    return true;
                }
                temp= temp.next;
            }
            return false;
        }
        static Node insertHead(Node head , int data){
            Node temp = new Node(data);
            temp.next = head;
            return temp;
        }
        static Node insertTail(Node head, int data){
            Node newNode = new Node(data);
            Node temp = head;
            if(head == null){
                return newNode;
            }
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next = newNode;
            return head;
        }
        static Node insertAtK(Node head , int data,int k){
            if(k==1){
                return insertHead(head,data);
            }
            int count=0;
            Node temp = head;
            while(temp!=null){
                count++;
                if(count == k-1){
                    Node newNode = new Node(data);
                    newNode.next = temp.next;
                    temp.next = newNode;
                    break;
                }
                temp = temp.next;
            }
            return head;
        }
        static Node removeHead(Node head){
            if(head == null) return head;
            head = head.next;
            return head;
        }
        static Node removeTail(Node head){
            if(head == null || head.next == null)  return null;
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            return head;
        }
        static Node removeKthelement(Node head, int k){
            if(head == null) return null;
            if(k==1) return head.next;
            Node temp = head;
            int count =0;
            Node prev = null;
            while(temp!=null){
                count++;
                if(count == k){
                    prev.next = prev.next.next;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
            return head;
        }
        static Node removeByValue(Node head,int data){
            if(head == null) return null;
            if(head.data==data) return head.next;
            Node temp = head;
            Node prev = null;
            while(temp!=null){
                if(temp.data== data){
                    prev.next = prev.next.next;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
            return head;
        }
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        Node head = convertarr2LL(arr);
        System.out.println("Original Linked List:");
        traverse(head);

        System.out.println("\nLength of LL = " + lengthOfLL(head));
        System.out.println("\nSearch 30 : " + search(head, 30));
        System.out.println("Search 100 : " + search(head, 100));
        head = insertHead(head, 5);
        System.out.println("\nAfter Inserting 5 at Head:");
        traverse(head);
        head = insertTail(head, 60);
        System.out.println("\nAfter Inserting 60 at Tail:");
        traverse(head);
        head = insertAtK(head, 25, 4);
        System.out.println("\nAfter Inserting 25 at Position 4:");
        traverse(head);
        head = removeHead(head);
        System.out.println("\nAfter Removing Head:");
        traverse(head);
        head = removeTail(head);
        System.out.println("\nAfter Removing Tail:");
        traverse(head);
        head = removeKthelement(head, 3);
        System.out.println("\nAfter Removing 3rd Element:");
        traverse(head);
        head = removeByValue(head, 40);
        System.out.println("\nAfter Removing Value 40:");
        traverse(head);
    }

}