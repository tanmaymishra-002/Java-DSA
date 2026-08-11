import java.util.*;
public class ReplaceWithRank {
    public static List<Integer> replaceWithRank(List<Integer> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Add all elements to min heap
        for (int num : arr) {
            pq.add(num);
        }
        HashMap<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        // Assign ranks
        while (!pq.isEmpty()) {
            int x = pq.poll();
            if (!rank.containsKey(x)) {
                rank.put(x, r);
                r++;
            }
        }
        // Replace elements with their ranks
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, rank.get(arr.get(i)));
        }
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(
            Arrays.asList(20, 15, 26, 2, 98, 6)
        );
        List<Integer> result = replaceWithRank(arr);
        System.out.println(result);
    }
}