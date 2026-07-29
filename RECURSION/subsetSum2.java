import java.util.*;
class subsetSum2{
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
        
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public static void helper(int index , int [] arr ,List<Integer> list , List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        if(index == arr.length) return;
        for(int i = index ; i<arr.length; i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            helper(index+1, arr, list, ans);
            list.remove(list.size()-1);
        }
    }
}