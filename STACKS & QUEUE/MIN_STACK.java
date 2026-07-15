// MINIMUM STACK
import java.util.*; 

class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    public void push(long x) {
        if (st.isEmpty()) {
            min = x;
            st.push(x);
        } else {
            if (x >= min) {
                st.push(x);
            } else {
                st.push(2L * x - min);
                min = x;
            }
        }
    }
    public void pop() {
        if (st.isEmpty()) {
            System.out.println("Empty stack");
            return;
        }
        long x = st.peek();
        st.pop();
        if (x < min) {
            min = 2L * min - x;
        }
    }
    public int top() {
        if (st.isEmpty()) {
            System.out.println("Empty stack");
            return -1;
        }
        long x = st.peek();
        if (x >= min) {
            return (int) x;
        }
        return (int) min;
    }
    public int getmin(){
        if(st.isEmpty()){
            return -1;
        }
        return (int) min;
    }
}

class MIN_STACK {
    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(5);
        System.out.println("Top = " + ms.top());       
        System.out.println("Min = " + ms.getmin());    

        ms.push(3);
        System.out.println("Top = " + ms.top());       
        System.out.println("Min = " + ms.getmin());    

        ms.push(7);
        System.out.println("Top = " + ms.top());       
        System.out.println("Min = " + ms.getmin());    

        ms.push(2);
        System.out.println("Top = " + ms.top());       
        System.out.println("Min = " + ms.getmin());    

        System.out.println("\nAfter one pop:");
        ms.pop();
        System.out.println("Top = " + ms.top());       
        System.out.println("Min = " + ms.getmin());    

        System.out.println("\nAfter second pop:");
        ms.pop();
        System.out.println("Top = " + ms.top());       
        System.out.println("Min = " + ms.getmin());    

        System.out.println("\nAfter third pop:");
        ms.pop();
        System.out.println("Top = " + ms.top());       
        System.out.println("Min = " + ms.getmin());    

        System.out.println("\nAfter fourth pop:");
        ms.pop();
        System.out.println("Top = " + ms.top());       
        System.out.println("Min = " + ms.getmin());    
    }
}