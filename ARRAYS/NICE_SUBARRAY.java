public class NICE_SUBARRAY {
    public static void main(String[] args) {
        // LEETCODE-1248
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int ans = numberOfSubarrays(nums, k);
        System.out.println("Number of nice subarrays: " + ans);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        // Exactly(k) = AtMost(k) - AtMost(k - 1)
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    private static int atMost(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int oddCount = 0;
        int ans = 0;

        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }
            ans += (right - left + 1);
            right++;
        }
        return ans;
    }
}