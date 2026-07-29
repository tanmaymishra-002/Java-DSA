import java.util.*;
class combinationsum{
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(CombinationSum(candidates, target));
    }
    public static List<List<Integer>> CombinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    public static void helper(int index,int[] arr , int target , List<Integer> list , List<List<Integer>> ans){
        if(index == arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        // Pick
        if(arr[index] <= target){
        list.add(arr[index]);
        helper(index, arr, target-arr[index], list, ans);
        list.remove(list.size()-1);
        }
        // Not-Pick
        helper(index+1, arr, target, list, ans);
    }
}