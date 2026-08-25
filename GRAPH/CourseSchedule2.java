import java.util.*;
public class CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        // Add courses with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] order = new int[numCourses];
        int count = 0;
        // Kahn's Algorithm
        while (!q.isEmpty()) {
            int node = q.poll();
            order[count] = node;
            count++;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        // Cycle exists
        if (count != numCourses) {
            return new int[0];
        }
        return order;
    }
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };
        int[] result = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
    }
}