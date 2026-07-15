import java.util.*;
class stack{
    Stack <Integer> st;
    Stack <Integer> st1;
    int top;
    int capacity;
    public stack(int capacity){
        st = new Stack();
        st1 = new Stack();
        top = -1;
        this.capacity = capacity;
    }
    public void push(int x){
        if (st.size() == capacity){
            System.out.println("overflow");
        }
        st.push(x);
    }
    public int pop(){
        if(st.isEmpty()){
            System.out.println("underflow");
        }
        return st.pop();
    }
    public void insertAtBottom(int x){
        if(st.size() == capacity){
            System.out.println("pushing is not possible ");
        }
        while(!st.isEmpty()){
            st1.push(st.pop());
        }
        st.push(x);
        while(!st1.isEmpty()){
            st.push(st1.pop());
        }
    }
    public void display(){
        System.out.println(st);
    }
}

class insertAtBottom{
    public static void main(String[] args) {
        // so we need to insert a element at the bottom in the stack 
        // stack : [6,9,49,69,100,26,911,147,420];
        // output : [69 ,6,9,49,69,100,26,911,147,420 ];
        // if the stack is full show pushing is not possible 
        stack s = new stack(10);

        s.push(6);
        s.push(9);
        s.push(49);
        s.push(69);
        s.push(100);
        s.push(26);
        s.push(911);
        s.push(147);
        s.push(420);

        System.out.println("Before:");
        s.display();
        s.insertAtBottom(69);
        System.out.println("After:");
        s.display();
    }
}