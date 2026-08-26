import java.util.*;
public class AlienDict {
    private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        // Calculate indegree
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        // Add nodes with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);
            // Remove node from graph
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }
    public static String findOrder(String[] dict, int N, int K) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        // Build graph
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    // s1 character comes before s2 character
                    adj.get(s1.charAt(ptr) - 'a')
                       .add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        // Topological sort
        List<Integer> topo = topoSort(K, adj);
        String ans = "";
        // Convert numbers back to characters
        for (int it : topo) {
            ans = ans + (char)(it + 'a');
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] dict = {
            "baa",
            "abcd",
            "abca",
            "cab",
            "cad"
        };
        int N = 5;
        int K = 4;
        String ans = findOrder(dict, N, K);
        System.out.println("Alien Dictionary Order: " + ans);
    }
}