import java.util.*;
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxInd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxInd) {
                return false;
            }
            maxInd = Math.max(maxInd, i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(canJump(nums));
        sc.close();
    }
}