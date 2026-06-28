public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        SubarraySumEqualsK obj = new SubarraySumEqualsK();

        int result = obj.subarraySum(nums, k);

        System.out.println("Number of subarrays with sum " + k + " = " + result);
    }

    public int subarraySum(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}