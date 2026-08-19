import java.util.*;
class pair {
    int row;
    int col;
    pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        q.add(new pair(sr, sc));
        vis[sr][sc] = 1;
        int originalColor = image[sr][sc];
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();
            image[r][c] = color;
            for (int i = 0; i < 4; i++) {
                int nrow = drow[i] + r;
                int ncol = dcol[i] + c;
                if (nrow >= 0 && ncol >= 0 &&
                    nrow < n && ncol < m &&
                    vis[nrow][ncol] == 0 &&
                    image[nrow][ncol] == originalColor) {
                    q.add(new pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        return image;
    }
}
public class floodfill {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] image = {
            {1, 1, 1},
            {1, 2, 2},
            {1, 1, 0}
        };
        int sr = 0;
        int sc = 0;
        int color = 5;
        int[][] result = sol.floodFill(image, sr, sc, color);
        System.out.println("Flood Filled Image:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}