import java.util.*;
public class shortestJobFirst {
    public static long solve(int[] bt) {
        Arrays.sort(bt);
        int t = 0;
        int wttime = 0;
        for (int i = 0; i < bt.length; i++) {
            wttime += t;
            t += bt[i];
        }
        return wttime / bt.length;
    }
    public static void main(String[] args) {
        int[] bt = {3, 1, 2};
        System.out.println(solve(bt));
    }
}