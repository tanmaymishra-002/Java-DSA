import java.util.*;
public class NinjasTraining {
    static int[][] dp;
    static int solve(int day, int last, int[][] matrix) {
        // Already calculated
        if (dp[day][last] != -1) {
            return dp[day][last];
        }
        // Base case
        if (day == 0) {
            int max = 0;
            for (int activity = 0; activity < 3; activity++) {
                if (activity != last) {
                    max = Math.max(max, matrix[0][activity]);
                }
            }
            return dp[day][last] = max;
        }
        int max = 0;

        // Try all 3 activities
        for (int activity = 0; activity < 3; activity++) {

            if (activity != last) {

                int points = matrix[day][activity]
                           + solve(day - 1, activity, matrix);

                max = Math.max(max, points);
            }
        }

        return dp[day][last] = max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] matrix = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // dp[n][4]
        dp = new int[n][4];

        // Initialize with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // 3 means no previous activity
        int answer = solve(n - 1, 3, matrix);

        System.out.println(answer);

        sc.close();
    }
}