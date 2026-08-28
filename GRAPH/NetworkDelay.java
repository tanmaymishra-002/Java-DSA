import java.util.*;
class Pair {
    int node;
    int distance;
    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
public class NetworkDelay {
    public static int networkDelayTime(int[][] times, int n, int k) {
        // adj[u] = all nodes we can reach from u
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // Build graph
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        // Dijkstra:
        // Pair = {node, shortest distance so far}
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        // Initially every node is unreachable
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        // Signal starts at k
        dist[k] = 0;
        pq.add(new Pair(k, 0));
        // Dijkstra
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int distance = current.distance;
            // Explore neighbours
            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int edgeWeight = it.distance;
                int newDist = distance + edgeWeight;
                // Found a shorter path
                if (newDist < dist[adjNode]) {
                    dist[adjNode] = newDist;
                    pq.add(new Pair(adjNode, newDist));
                }
            }
        }
        // We need ALL nodes to receive the signal.
        // Therefore take the maximum shortest distance.
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            // Node cannot be reached
            if (dist[i] == (int) 1e9) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
    public static void main(String[] args) {
        int[][] times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };
        int n = 4;
        int k = 2;
        int answer = networkDelayTime(times, n, k);
        System.out.println(answer);
    }
}