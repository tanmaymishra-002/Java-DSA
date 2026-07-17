import java.util.*;
class NextSmallerElement {
    public int[] nextSmallerElements(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        NextSmallerElement obj = new NextSmallerElement();
        int[] arr = {4, 8, 5, 2, 25};
        int[] ans = obj.nextSmallerElements(arr);
        System.out.println(Arrays.toString(ans));
    }
}