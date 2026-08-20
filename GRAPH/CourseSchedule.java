import java.util.*;
public class CourseSchedule {
    private static boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] path) {
        vis[node] = true;
        path[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(it, adj, vis, path)) {
                    return true;
                }
            } else if (path[it]) {
                return true;
            }
        }
        path[node] = false;
        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];
            adj.get(prerequisite).add(course);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, path)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
            {1, 0}
        };
        System.out.println(canFinish(numCourses, prerequisites));
    }
}