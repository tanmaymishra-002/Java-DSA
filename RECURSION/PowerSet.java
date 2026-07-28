import java.util.*;
class PowerSet{
    public static void main(String[] args) {
        int [] nums = {1, 2, 3};
        int n = nums.length;
        System.out.println(powerSet(nums));
    }
    public static List<List<Integer>> powerSet(int[] nums){
        List<List<Integer>> ans  = new ArrayList<>();
        helper(0, nums.length, nums, new ArrayList<>(), ans);
        return ans;
    }
    public static void helper(int index , int n, int [] nums, List<Integer> list, List<List<Integer>> ans ){
        if(index >= n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        helper(index+1, n, nums, list, ans);
        list.remove(list.size()-1);
        helper(index+1, n, nums, list, ans);
    }
}