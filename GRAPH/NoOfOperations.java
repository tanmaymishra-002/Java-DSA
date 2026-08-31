class DisjointSet {
    int[] rank;
    int[] parent;
    int[] size;
    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUpar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUpar(parent[node]);
    }
    public void size(int u, int v) {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if (ulp_u == ulp_v) {
            return;
        }
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
public class NoOfOperations {
    public static int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        int m = connections.length;
        for (int i = 0; i < m; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.findUpar(u) == ds.findUpar(v)) {
                cntExtras++;
            } else {
                ds.size(u, v);
            }
        }
        int cntC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i) {
                cntC++;
            }
        }
        int ans = cntC - 1;
        if (cntExtras >= ans) {
            return ans;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {
            {0, 1},
            {0, 2},
            {1, 2}
        };
        int result = makeConnected(n, connections);
        System.out.println(result);
    }
}