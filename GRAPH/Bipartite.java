import java.util.*;
public class Bipartite {
    public static boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;
        for (int it : graph[node]) {
            if (color[it] == -1) {
                if (dfs(it, 1 - col, color, graph) == false) {
                    return false;
                }
            } else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, graph) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };
        System.out.println(isBipartite(graph));
    }
}