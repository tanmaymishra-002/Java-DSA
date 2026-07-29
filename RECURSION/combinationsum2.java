import java.util.*;
class combinationsum2{
    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(candidates);
        System.out.println(combSum(candidates, target));
    }
    public static List<List<Integer>> combSum(int[] candidates , int target){
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    public static void helper(int index , int[] arr , int target , List<Integer> list , List<List<Integer>> ans){
        if(target ==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<arr.length;i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            if(target <arr[i]) break;

            list.add(arr[i]);
            helper(i+1, arr, target-arr[i], list, ans);
            list.remove(list.size()-1);
        }
    }
}