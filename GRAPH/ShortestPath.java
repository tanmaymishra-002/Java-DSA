import java.util.*;
public class ShortestPath {
    public static int[] shortestPath(int[][] edges, int N, int M) {
        List<List<Integer>> adj = new ArrayList<>();
        // Create adjacency list
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        // Add edges
        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] dist = new int[N];
        int src = 0;
        // Initially all distances are infinity
        for (int i = 0; i < N; i++) {
            dist[i] = (int) 1e9;
        }
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        // BFS
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }
        // Convert unreachable nodes to -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int N = 9;
        int[][] edges = {
            {0, 1},
            {0, 3},
            {3, 4},
            {4, 5},
            {5, 6},
            {1, 2},
            {2, 6},
            {6, 7},
            {7, 8},
            {6, 8}
        };
        int M = edges.length;
        int[] ans = shortestPath(edges, N, M);
        System.out.println(Arrays.toString(ans));
    }
}