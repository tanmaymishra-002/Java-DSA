class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1) {
                take += prev2;
            }
            int nonTake = prev;
            int curr = Math.max(take, nonTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        HouseRobber obj = new HouseRobber();
        System.out.println("Maximum money: " + obj.rob(nums));
    }
}