import java.util.*;
class pair {
    int row;
    int col;
    int distance;
    pair(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
public class ShortestPathinBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0, 0, 1));
        grid[0][0] = 1;
        // 8 directions
        int[] drow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dcol = {-1, 0, 1, -1, 1, -1, 0, 1};
        while (!q.isEmpty()) {
            pair current = q.poll();
            int r = current.row;
            int c = current.col;
            int dist = current.distance;
            if (r == n - 1 && c == n - 1) {
                return dist;
            }
            for (int i = 0; i < 8; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < n &&
                    grid[nrow][ncol] == 0) {
                    grid[nrow][ncol] = 1;
                    q.add(new pair(nrow, ncol, dist + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1},
            {1, 0}
        };
        int result = shortestPathBinaryMatrix(grid);
        System.out.println(result);
    }
}