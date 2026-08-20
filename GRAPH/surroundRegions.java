import java.util.*;
public class surroundRegions {
    static class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        // First column and last column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                q.add(new Pair(i, 0));
                vis[i][0] = true;
            }
            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                q.add(new Pair(i, m - 1));
                vis[i][m - 1] = true;
            }
        }
        // First row and last row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !vis[0][j]) {
                q.add(new Pair(0, j));
                vis[0][j] = true;
            }
            if (board[n - 1][j] == 'O' && !vis[n - 1][j]) {
                q.add(new Pair(n - 1, j));
                vis[n - 1][j] = true;
            }
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        // BFS
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    board[nrow][ncol] == 'O' &&
                    !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        // Convert surrounded O's to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        solve(board);
        // Print result
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}