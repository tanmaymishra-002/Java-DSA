import java.util.*;
public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int prev = 1;
        int prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int curri = prev + prev2;
            prev = prev2;
            prev2 = curri;
        }
        return prev2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(climbStairs(n));
        sc.close();
    }
}