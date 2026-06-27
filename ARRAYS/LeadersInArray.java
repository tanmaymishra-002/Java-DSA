// LEADERS IN AN ARRAY
import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {

    public static ArrayList<Integer> leaders(int[] nums) {

        ArrayList<Integer> ans = new ArrayList<>();

        // The rightmost element is always a leader
        int maxSoFar = Integer.MIN_VALUE;

        // Traverse from right to left
        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] > maxSoFar) {
                ans.add(nums[i]);
                maxSoFar = nums[i];
            }
        }
        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {16, 17, 4, 3, 5, 2};

        ArrayList<Integer> result = leaders(nums);

        System.out.println("Leaders in the array are: " + result);
    }
}