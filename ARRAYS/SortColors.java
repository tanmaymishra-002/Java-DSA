import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        SortColors obj = new SortColors();
        obj.sortColors(nums);

        System.out.println("Sorted Array: " + Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;

        // Count the number of 0s, 1s, and 2s
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count_0++;
            } else if (nums[i] == 1) {
                count_1++;
            } else {
                count_2++;
            }
        }

        // Overwrite the array with sorted values
        int i = 0;

        while (count_0 > 0) {
            nums[i] = 0;
            i++;
            count_0--;
        }

        while (count_1 > 0) {
            nums[i] = 1;
            i++;
            count_1--;
        }

        while (count_2 > 0) {
            nums[i] = 2;
            i++;
            count_2--;
        }
    }
}