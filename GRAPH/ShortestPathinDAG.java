import java.util.*;
class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class ShortestPathinDAG {
    private static void topoSort(
            int node,
            ArrayList<ArrayList<Pair>> adj,
            int[] vis,
            Stack<Integer> st) {
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }
    public static int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // Create adjacency list
        for (int i = 0; i < N; i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        // Build directed graph
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        // Topological Sort
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }
        // Distance array
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = (int) 1e9;
        }
        // Source
        dist[0] = 0;
        // Process topological order
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }
        // Unreachable nodes
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int N = 4;
        int M = 2;
        int[][] edges = {
            {0, 1, 2},
            {0, 2, 1}
        };
        int[] ans = shortestPath(N, M, edges);
        System.out.println(Arrays.toString(ans));
    }
}