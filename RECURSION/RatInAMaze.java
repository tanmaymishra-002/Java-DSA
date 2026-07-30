import java.util.*;
class RatInAMaze{
    public static void main(String[] args) {
        int[][] grid = { {1, 0, 0, 0} , {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1} };
        System.out.println(findPath(grid));
    }
     public static List<String> findPath(int[][] grid){
        List<String> ans = new ArrayList<>();
        if(grid[0][0] == 0){
            return ans;
        }
        helper(grid, 0, 0, "", ans, grid.length);
        return ans;
     }
     public static void helper(int[][] grid,int row,int col,String Path , List<String> ans,int n){
        if(row==n-1 && col == n-1){
            ans.add(Path);
            return;
        }
        // Marked
        grid[row][col] =0;

        // Up
        if(row-1>=0 && grid[row-1][col]==1){
            helper(grid, row-1, col, Path+"U", ans, n);
        }
        // Down
        if(row+1<n && grid[row+1][col] == 1){
            helper(grid, row+1, col, Path+"D", ans, n);
        }
        // Left
        if(col-1>=0 && grid[row][col-1] == 1){
            helper(grid, row, col-1, Path+"L", ans, n);
        }
        // Right
        if(col+1<n && grid[row][col+1] == 1){
            helper(grid, row, col+1, Path+"R", ans, n);
        }
        // BackTrack
        grid[row][col] = 1;
     }
}