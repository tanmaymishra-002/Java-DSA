import java.util.*;
class Pair {
    int steps;
    int node;
    Pair(int steps, int node) {
        this.steps = steps;
        this.node = node;
    }
}
public class MinMultiplications {
    public static int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[100000];
        Arrays.fill(dist, (int) 1e9);
        dist[start] = 0;
        q.offer(new Pair(0, start));
        int mod = 100000;
        while (!q.isEmpty()) {
            Pair it = q.poll();
            int steps = it.steps;
            int node = it.node;
            for (int num : arr) {
                int mul = (num * node) % mod;
                if (steps + 1 < dist[mul]) {
                    dist[mul] = steps + 1;
                    if (mul == end) {
                        return steps + 1;
                    }
                    q.offer(new Pair(steps + 1, mul));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;
        int answer = minimumMultiplications(arr, start, end);
        System.out.println(answer);
    }
}