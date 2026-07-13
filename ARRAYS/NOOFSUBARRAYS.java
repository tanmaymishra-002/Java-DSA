class NOOFSUBARRAYS{
    public static void main (String[] args){
        // LEETCODE 930
        int [] nums = {1,0,1,0,1};
        int goal = 2;
        int ans = atmost(nums,goal)-atmost(nums,goal-1);
        System.out.println(ans);
    }
    public static int atmost(int[]nums,int k){
        if (k<0) return 0;

        int left=0;
        int right=0;
        int count =0;
        int sum =0;

        while(right<nums.length){
            sum+=nums[right];
            while(sum>k){
                sum-=nums[left];
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
}