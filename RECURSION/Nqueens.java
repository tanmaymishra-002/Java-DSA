import java.util.*;
class Nqueens{
    public static void main(String[] args) {
    int n = 4;
    List<List<String>> res = nqueeens(n);

    for (List<String> board : res) {
        for (String row : board) {
            System.out.println(row);
            }
        System.out.println();
        }
    }
    public static List<List<String>> nqueeens(int n){
        List<List<String>> ans = new ArrayList<>();
        char[][]board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2*n-1];
        int[] upperDiagonal = new int[2*n-1];
        helper(0, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);
        return ans;
    }
    public static void helper(int col,char[][] board,List<List<String>> ans,int[] leftRow,int[] lowerDiagonal , int[] upperDiagonal,int n){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(char[] row : board){
                temp.add(new String(row));
            }
            ans.add(temp);
            return;
        }
        for(int row =0;row<n;row++){
            if(leftRow[row] ==0 && lowerDiagonal[row+col] ==0 && upperDiagonal[(n-1) + (col-row)] == 0){
                // Place queen
                board[row][col] = 'Q';

                // Mark
                leftRow[row] = 1;
                lowerDiagonal[row+col] =1;
                upperDiagonal[n-1 +(col-row)] =1;

                // Move
                helper(col+1, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);

                // Backtrack
                board[row][col]= '.';

                // UNmark
                leftRow[row] = 0;
                lowerDiagonal[row+col] =0;
                upperDiagonal[n-1 +(col-row)] =0;
            }
        }
    }
}