import java.util.*;

class Pair {
    int node;
    int distance;
    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
public class PrimsAlgo {
    public static int spanningTree(int V, List<List<List<Integer>>> adj) {
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Pair(0, 0));
        int[] vis = new int[V];
        int sum = 0;
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            pq.remove();
            if (vis[node] == 1)
                continue;
            vis[node] = 1;
            sum += distance;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgwt = adj.get(node).get(i).get(1);
                int adjnode = adj.get(node).get(i).get(0);
                if (vis[adjnode] == 0) {
                    pq.add(new Pair(adjnode, edgwt));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int V = 5;
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Edge: 0 - 1, weight 2
        adj.get(0).add(Arrays.asList(1, 2));
        adj.get(1).add(Arrays.asList(0, 2));
        // Edge: 0 - 2, weight 1
        adj.get(0).add(Arrays.asList(2, 1));
        adj.get(2).add(Arrays.asList(0, 1));
        // Edge: 1 - 2, weight 1
        adj.get(1).add(Arrays.asList(2, 1));
        adj.get(2).add(Arrays.asList(1, 1));

        // Edge: 1 - 3, weight 3
        adj.get(1).add(Arrays.asList(3, 3));
        adj.get(3).add(Arrays.asList(1, 3));

        // Edge: 2 - 4, weight 4
        adj.get(2).add(Arrays.asList(4, 4));
        adj.get(4).add(Arrays.asList(2, 4));

        // Edge: 3 - 4, weight 5
        adj.get(3).add(Arrays.asList(4, 5));
        adj.get(4).add(Arrays.asList(3, 5));
        int result = spanningTree(V, adj);
        System.out.println("Minimum Spanning Tree weight = " + result);
    }
}