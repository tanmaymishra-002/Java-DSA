public class NinjaAndHisFriends {
    public static int maxChocolates(int[][] g) {
        int r = g.length;
        int c = g[0].length;
        int[][][] dp = new int[r][c][c];
        // Initialize DP with -1
        for (int i = 0; i < r; i++) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }
        return solve(r, c, 0, 0, c - 1, g, dp);
    }
    public static int solve(int r, int c, int i, int j1, int j2,int[][] g, int[][][] dp) {
        // Out of bounds
        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) {
            return (int) -1e8;
        }
        // Already calculated
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        // Last row
        if (i == r - 1) {
            if (j1 == j2) {
                return dp[i][j1][j2] = g[i][j1];
            } 
            else {
                return dp[i][j1][j2] = g[i][j1] + g[i][j2];
            }
        }
        // Explore all 9 possible moves
        int max = (int) -1e8;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                if (j1 == j2) {
                    max = Math.max(max,g[i][j1] +solve(r, c, i + 1, j1 + dj1, j2 + dj2, g, dp));
                } 
                else {
                    max = Math.max(max,g[i][j1] + g[i][j2] +solve(r, c, i + 1, j1 + dj1, j2 + dj2, g, dp));
                }
            }
        }
        return dp[i][j1][j2] = max;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {2, 3, 1, 2},
            {3, 4, 2, 2},
            {5, 6, 3, 5}
        };
        int result = maxChocolates(grid);
        System.out.println("Maximum chocolates: " + result);
    }
}