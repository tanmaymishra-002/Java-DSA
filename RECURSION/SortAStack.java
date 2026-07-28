// So we have to sort a stack using pure recursion and not any sorting algorithm 
import java.util.*;
class SortAStack{
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(2);
        st.push(3);
        st.push(1);
        st.push(4);

        System.out.println("Original Stack: " + st);
        SortAStack obj = new SortAStack();
        obj.sortStack(st);
        System.out.println("Sorted Stack: " + st);
    }
    public void sortStack(Stack<Integer> st){
        if(st.isEmpty() || st.size()<=1) return;
        int topEl = st.pop();
        sortStack(st);
        insert(topEl,st);
    }
    public void insert(int element,Stack<Integer> st){
        if(st.isEmpty()){
            st.push(element);
            return;
        }
        if(st.peek() <=element){
            st.push(element);
            return;
        }
        int temp = st.pop();
        insert(element,st);
        st.push(temp);
    }
}