import java.util.*;
public class SafeNodes {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        // Convert graph[][] to adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int node : graph[i]) {
                adj.get(i).add(node);
            }
        }
        // Reverse adjacency list
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        // Reversing Part
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                // i -> it becomes it -> i
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNode = new ArrayList<>();
        // Add terminal nodes
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        // Kahn's Algorithm
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNode.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        Collections.sort(safeNode);
        return safeNode;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };
        List<Integer> ans = eventualSafeNodes(graph);
        System.out.println(ans);
    }
}