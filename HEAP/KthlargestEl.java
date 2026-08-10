import java.util.*;
public class KthlargestEl {
    public static int KthlargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Store first k elements
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        // Process remaining elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {11, 9, 8, 7, 3, 1};
        int k = 4;
        int answer = KthlargestElement(nums, k);
        System.out.println("Kth largest element: " + answer);
    }
}