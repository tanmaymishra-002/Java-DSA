import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        NextPermutation obj = new NextPermutation();

        System.out.println("Original Array: " + Arrays.toString(nums));

        obj.nextPermutation(nums);

        System.out.println("Next Permutation: " + Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {

        int index = -1;

        // Step 1: Find the break point
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If no breakpoint exists, reverse the entire array
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 2: Find the next greater element and swap
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Step 3: Reverse the remaining part
        reverse(nums, index + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}