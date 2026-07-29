class CountSubsequenceWithSumK{
    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 5, 1};
        int k = 10;
        System.out.println(countsubsequencewithsumK(nums,k));
    }
    public static int countsubsequencewithsumK(int[] nums ,int k){
        return helper(0, nums, 0  , k);
    }
    public static int helper(int index , int[] arr , int currentSum , int targetSum ){
        if(index == arr.length){
            if(currentSum == targetSum){
                return 1;
            }else{
                return 0;
            }
        }
        // Pick
        currentSum+=arr[index];
        int left = helper(index+1,arr,currentSum,targetSum);
        // Not-Pick
        currentSum-=arr[index];
        int right = helper(index+1, arr, currentSum, targetSum);

        return left+right;
    }
}