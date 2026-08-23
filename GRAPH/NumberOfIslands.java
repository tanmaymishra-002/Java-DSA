import java.util.*;
public class NumberOfIslands {
    static class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Found an unvisited land
                if (grid[i][j] == '1') {
                    count++;
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i, j));
                    // Mark as visited
                    grid[i][j] = '0';
                    while (!q.isEmpty()) {
                        Pair current = q.poll();
                        int row = current.row;
                        int col = current.col;
                        // Check 4 directions
                        for (int k = 0; k < 4; k++) {
                            int nrow = row + drow[k];
                            int ncol = col + dcol[k];
                            // Check boundaries
                            if (nrow >= 0 && nrow < n &&
                                ncol >= 0 && ncol < m &&
                                grid[nrow][ncol] == '1') {
                                q.add(new Pair(nrow, ncol));
                                grid[nrow][ncol] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int answer = numIslands(grid);
        System.out.println("Number of Islands: " + answer);
    }
}