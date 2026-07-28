import java.util.*;
// We need to reverse a stack without using any data-structure
public class ReverseAStack{
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);

        System.out.println("Original Stack : " + st);
        reversestack(st);
        System.out.println("Reversed Stack : " + st);
    }
    public static void reversestack(Stack<Integer> st){
        if(st.isEmpty()) return;
        int top = st.pop();
        reversestack(st);
        insert(top,st);
    }
    public static void insert(int el , Stack<Integer> st){
        if(st.isEmpty()){
            st.push(el);
            return;
        }
        int top = st.pop();
        insert(el,st);
        st.push(top);
    }
}