import java.util.*;

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

    public void unionBySize(int u, int v) {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);

        if (ulp_u == ulp_v)
            return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

public class no_ofAccountsMerged {
    static List<List<String>> accountsMerge(List<List<String>> details) {
        int n = details.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode =
                new HashMap<String, Integer>();
        // Map each email to its accoun
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details.get(i).size(); j++) {
                String mail = details.get(i).get(j);
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }
        // Store emails belonging to each ultimate parent
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<String>();
        }
        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUpar(it.getValue());
            mergedMail[node].add(mail);
        }
        // Build final answer
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0)
                continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            // Account name
            temp.add(details.get(i).get(0));
            // Emails
            for (String mail : mergedMail[i]) {
                temp.add(mail);
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        List<List<String>> details = new ArrayList<>();
        details.add(Arrays.asList(
                "John",
                "johnsmith@mail.com",
                "john_newyork@mail.com"
        ));
        details.add(Arrays.asList(
                "John",
                "johnsmith@mail.com",
                "john00@mail.com"
        ));
        details.add(Arrays.asList(
                "Mary",
                "mary@mail.com"
        ));
        details.add(Arrays.asList(
                "John",
                "johnnybravo@mail.com"
        ));
        List<List<String>> ans = accountsMerge(details);
        for (List<String> account : ans) {
            System.out.println(account);
        }
    }
}