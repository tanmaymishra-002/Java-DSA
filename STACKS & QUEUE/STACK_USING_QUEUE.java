// STACK USING QUEUE
import java.util.*;
class MyStack {
    Queue<Integer> q;
    MyStack() {
        q = new LinkedList<>();
    }
    public void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.offer(q.poll());
        }
    }
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return q.poll();
    }
    public int top() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek();
    }
    public boolean isEmpty() {
        return q.isEmpty();
    }
}
public class STACK_USING_QUEUE {
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}