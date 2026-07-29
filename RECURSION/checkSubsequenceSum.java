class checkSubsequenceSum{
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 8;
        System.out.println(checksubsequence(nums,k));
    }
    public static boolean checksubsequence(int[] nums , int k){
        return helper(0, nums, 0, k);
    }
    public static boolean helper(int index, int[] nums , int currentsum , int targetsum){
        if(index == nums.length){
            if(currentsum== targetsum) return true;
            else return false;
        }
        // Pick
        currentsum += nums[index];
        if(helper(index+1, nums, currentsum, targetsum)) return true;
        // Not-Pick
        currentsum -= nums[index];
        if(helper(index+1, nums, currentsum, targetsum)) return true;

        return false;
    }
}