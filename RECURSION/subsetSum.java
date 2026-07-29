import java.util.*;
class subsetSum{
    public static void main(String[] args) {
        int[] nums = {2, 3};
        System.out.println(subsetSums(nums));
    }
    public static List<Integer> subsetSums(int[] nums){
        List<Integer> ans = new ArrayList<>();
        helper(0, nums, ans, 0);
        return ans;
    }
    public static void helper(int index , int[] arr , List<Integer> list, int sum){
        if(index == arr.length){
            list.add(sum);
            return;
        }
        // Pick
        helper(index+1,arr,list,sum+arr[index]);
        // Not-Pick
        helper(index+1, arr, list, sum);
    }
}