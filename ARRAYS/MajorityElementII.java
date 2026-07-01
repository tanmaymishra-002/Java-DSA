import java.util.*;

public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        // Count frequencies
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int limit = nums.length / 3;

        // Find majority elements
        for (int key : map.keySet()) {
            if (map.get(key) > limit) {
                list.add(key);
            }
        }

        return list;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> result = majorityElement(nums);

        System.out.println("Majority Elements (> n/3 times): " + result);

        sc.close();
    }
}