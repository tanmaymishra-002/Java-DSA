// BRUTE FORCE FOR LONGEST-CONSECUTIVE SEQUENCE

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longest = 1;
        int current = 1;

        for (int i = 1; i < nums.length; i++) {

            // Duplicate element
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            // Consecutive element
            else if (nums[i] == nums[i - 1] + 1) {
                current++;
            }

            // Sequence broken
            else {
                longest = Math.max(longest, current);
                current = 1;
            }
        }

        return Math.max(longest, current);
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        int answer = longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + answer);
    }
}