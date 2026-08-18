import java.util.*;
public class connectedComponents {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjLS, boolean[] visited) {
        visited[node] = true;
        for (Integer it : adjLS.get(node)) {
            if (visited[it] == false) {
                dfs(it, adjLS, visited);
            }
        }
    }
    public static int findNumberOfComponent(int V, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjLS = new ArrayList<>();
        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adjLS.add(new ArrayList<>());
        }
        // Convert edges to adjacency list
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjLS.get(u).add(v);
            adjLS.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        int cnt = 0;
        // Count connected components
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                cnt++;
                dfs(i, adjLS, visited);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 4));
        int result = findNumberOfComponent(V, edges);
        System.out.println("Number of Components: " + result);
    }
}