import java.util.*;
public class numOfProvinces {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjLS, boolean[] visited) {
        visited[node] = true;
        for (Integer it : adjLS.get(node)) {
            if (visited[it] == false) {
                dfs(it, adjLS, visited);
            }
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // Creating adjacency list
        ArrayList<ArrayList<Integer>> adjLS = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjLS.add(new ArrayList<>());
        }
        // Converting adjacency matrix to adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjLS.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                cnt++;
                dfs(i, adjLS, visited);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int ans = findCircleNum(isConnected);
        System.out.println("Number of provinces: " + ans);
    }
}