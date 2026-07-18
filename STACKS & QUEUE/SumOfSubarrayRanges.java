import java.util.*;

public class SumOfSubarrayRanges {
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] nse = findNSE(nums);
        int[] pse = findPSE(nums);
        int[] pge = findPGE(nums);
        int[] nge = findNGE(nums);
        long minSum = 0;
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            long leftMin = i - pse[i];
            long rightMin = nse[i] - i;
            long leftMax = i - pge[i];
            long rightMax = nge[i] - i;
            minSum += (long) nums[i] * leftMin * rightMin;
            maxSum += (long) nums[i] * leftMax * rightMax;
        }
        return maxSum - minSum;
    }
    public static int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }
    public static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty())
                res[i] = n;
            else
                res[i] = st.peek();

            st.push(i);
        }
        return res;
    }
    public static int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }
    public static int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty())
                res[i] = n;
            else
                res[i] = st.peek();

            st.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        // LEETCODE - 2104
        int[] nums = {1, 2, 3};
        System.out.println(subArrayRanges(nums));
    }
}