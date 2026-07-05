import java.util.*;

public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {

        // HashMap<Integer, Integer> map = new HashMap<>();
        // List<Integer> list = new ArrayList<>();

        // // Count frequencies
        // for (int num : nums) {
        //     if (map.containsKey(num)) {
        //         map.put(num, map.get(num) + 1);
        //     } else {
        //         map.put(num, 1);
        //     }
        // }
        // int limit = nums.length / 3;
        // // Find majority elements
        // for (int key : map.keySet()) {
        //     if (map.get(key) > limit) {
        //         list.add(key);
        //     }
        // }
        // return list;
        ArrayList <Integer> list = new ArrayList<>();
        int count1=0;
        int element1=0;
        int count2=0;
        int element2=0;

        for(int num : nums){
            if(count1==0 && element2!=num){
                element1 = num;
                count1=1;
            }else if(count2==0 && element1!=num){
                element2=num;
                count2=1;
            }else if(element1 == num){
                count1++;
            }else if(element2 == num){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int condition = nums.length/3;
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(element1 == num){
                count1++;
            }else if(element2 == num){
                count2++;
            }
        }
        if(count1>condition){
            list.add(element1);
        }
        if (count2>condition){
            list.add(element2);
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