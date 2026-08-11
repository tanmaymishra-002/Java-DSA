import java.util.*;
public class ConnSticks {
    public static int connectSticks(List<Integer> sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Add all sticks to min heap
        for (int x : sticks) {
            pq.add(x);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int newStick = a + b;
            sum += newStick;
            pq.add(newStick);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> sticks = Arrays.asList(2, 4, 3);
        int answer = connectSticks(sticks);
        System.out.println(answer);
    }
}