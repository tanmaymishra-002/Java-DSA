import java.util.*;
public class FloydWarshall {
    public static void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        // Convert -1 to infinity
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                }
                // Distance from a node to itself = 0
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        // Convert infinity back to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 5, -1, 10},
                {-1, 0, 3, -1},
                {-1, -1, 0, 1},
                {-1, -1, -1, 0}
        };
        shortest_distance(matrix);
        // Print the shortest distance matrix
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}