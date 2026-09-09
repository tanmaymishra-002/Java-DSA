import java.util.*;
public class UniqueWays {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } 
                else {
                    int up = dp[i - 1][j];
                    int left = dp[i][j - 1];

                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(uniquePaths(m, n));

        sc.close();
    }
}