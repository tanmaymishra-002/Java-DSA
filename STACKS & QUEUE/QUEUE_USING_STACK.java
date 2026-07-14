import java.util.*;

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    public void push(int x) {
        in.push(x);
    }
    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return out.pop();
    }
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            return -1;
        }
        return out.peek();
    }
    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }
}

public class QUEUE_USING_STACK {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}