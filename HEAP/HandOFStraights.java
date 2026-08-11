import java.util.*;
public class HandOFStraights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : hand) {
            if (!freq.containsKey(x)) {
                pq.add(x);
            }
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        while (!pq.isEmpty()) {
            int smallest = pq.peek();
            for (int j = 0; j < groupSize; j++) {
                int card = smallest + j;
                // Card doesn't exist
                if (freq.getOrDefault(card, 0) == 0) {
                    return false;
                }
                // Use one copy
                freq.put(card, freq.get(card) - 1);
                // No copies remain
                if (freq.getOrDefault(card, 0) == 0) {
                    if (pq.peek() == card) {
                        pq.poll();
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        boolean result = isNStraightHand(hand, groupSize);
        System.out.println(result);
    }
}