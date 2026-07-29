import java.util.*;
public class Subset {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public static void helper(int index, int[] arr, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        if (index == arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            helper(i + 1, arr, list, ans);
            list.remove(list.size() - 1);
        }
    }
}