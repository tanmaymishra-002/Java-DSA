public class BoardSearch {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(0, board, word, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int index, char[][] board, String word,
                              int row, int col, boolean[][] visited) {
        // Base Case
        if (index == word.length()) {
            return true;
        }
        // Boundary Check
        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length) {
            return false;
        }
        // Character Mismatch
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        // Already Visited
        if (visited[row][col]) {
            return false;
        }
        // Choose
        visited[row][col] = true;
        // Explore
        boolean up = dfs(index + 1, board, word, row - 1, col, visited);
        boolean down = dfs(index + 1, board, word, row + 1, col, visited);
        boolean left = dfs(index + 1, board, word, row, col - 1, visited);
        boolean right = dfs(index + 1, board, word, row, col + 1, visited);
        // Backtrack
        visited[row][col] = false;

        return up || down || left || right;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}