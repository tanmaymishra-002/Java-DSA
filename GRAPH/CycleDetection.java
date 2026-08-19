import java.util.*;
class pair {
    int node;
    int parent;
    pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class CycleDetection {
    public static boolean isCycle(int V, List<Integer>[] adj) {
        Queue<pair> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                vis[i] = true;
                q.add(new pair(i, -1));
                while (!q.isEmpty()) {
                    int node = q.peek().node;
                    int parent = q.peek().parent;
                    q.remove();
                    for (Integer adjacentNode : adj[node]) {
                        if (!vis[adjacentNode]) {
                            vis[adjacentNode] = true;
                            q.add(new pair(adjacentNode, node));
                        } else if (adjacentNode != parent) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        // 0 - 1
        // |   |
        // 3 - 4 - 5
        //     |
        //     2
        adj[0].add(1);
        adj[1].add(0);
        adj[0].add(3);
        adj[3].add(0);
        adj[1].add(2);
        adj[2].add(1);
        adj[1].add(4);
        adj[4].add(1);
        adj[3].add(4);
        adj[4].add(3);
        adj[4].add(5);
        adj[5].add(4);
        boolean result = isCycle(V, adj);
        System.out.println("Cycle exists: " + result);
    }
}