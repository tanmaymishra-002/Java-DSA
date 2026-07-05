import java.util.Arrays;
import java.util.HashMap;

public class twoSum {

    public static int[] twoSum(int[] nums, int target) {
        //            BRUTE FORCE
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }

        // return new int[]{-1, -1}; 

        //              OPTIMAL
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            int value = target-nums[i];
            if (!map.containsKey(value)){
                map.put(nums[i],i);
            }else{
                return new int [] {map.get(value),i};
            }
        }
        return new int [] {-1,-1};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
}