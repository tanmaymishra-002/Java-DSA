import java.util.*;
public class kthLargestStream {
    static class KthLargest {
        private PriorityQueue<Integer> pq;
        private int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }
        public int add(int val) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest obj = new KthLargest(k, nums);
        System.out.println(obj.add(3));   // 4
        System.out.println(obj.add(5));   // 5
        System.out.println(obj.add(10));  // 5
        System.out.println(obj.add(9));   // 8
        System.out.println(obj.add(4));   // 8
    }
}