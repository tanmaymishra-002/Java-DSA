public class SUBARRAYS_WITH_K_DISTINCT {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        if (k < 0)
            return 0;
        int left = 0;
        int right = 0;
        int distinct = 0;
        int ans = 0;
        int[] freq = new int[nums.length + 1];

        while (right < nums.length) {
            freq[nums[right]]++;
            if (freq[nums[right]] == 1) {
                distinct++;
            }
            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        int result = subarraysWithKDistinct(nums, k);
        System.out.println("Number of subarrays with exactly " + k + " distinct integers: " + result);
    }
}