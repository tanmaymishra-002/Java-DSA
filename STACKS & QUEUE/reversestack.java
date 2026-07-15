// REVERSING A STACK 
import java.util.*;
class stack{
    Stack<Integer> st;
    Stack<Integer> st1;
    int top;

    public stack(){
        st = new Stack<>();
        st1 = new Stack<>();
        top= -1;
    }
    public void push(int x){
        if(st.isEmpty()){
            System.out.println("Empty stack");
        }
        st.push(x);
    }
    public void reverse(){
        while(!st.isEmpty()){
            st1.push(st.pop());
        }
    }
    public void display(){
        while(!st1.isEmpty()){
            System.out.println(st1.pop() +" ");
        }
    }
}
class reversestack{
    public static void main (String[] args){
        stack s = new stack();

        s.push(0);
        s.push(-13);
        s.push(4);
        s.push(8);
        s.push(11);
        s.push(69);
        s.push(2005);
        s.push(-6);
        s.push(7);
        s.push(67);

        s.reverse();
        s.display();
    }
    
}
