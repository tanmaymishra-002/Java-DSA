public class kadanes {

    public static int maxSubArray(int[] nums) {
        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            current_sum = Math.max(current_sum + nums[i], nums[i]);
            max_sum = Math.max(current_sum, max_sum);
        }

        return max_sum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int answer = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum = " + answer);
    }
}