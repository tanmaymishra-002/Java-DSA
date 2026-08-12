import java.util.*;
class Item {
    int weight;
    int value;
    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
class FractionalKnapsack {
    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;
        Item[] items = new Item[n];       
        // Create items
        for (int i = 0; i < n; i++) {
            items[i] = new Item(wt[i], val[i]);
        }
        // Sort by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> {
            double ratioA = (double) a.value / a.weight;
            double ratioB = (double) b.value / b.weight;
            return Double.compare(ratioB, ratioA);
        });
        double totalValue = 0.0;
        long remainingCapacity = cap;
        for (Item item : items) {
            if (remainingCapacity == 0) {
                break;
            }
            // Take whole item
            if (item.weight <= remainingCapacity) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            }
            // Take fraction
            else {
                double fraction = (double) remainingCapacity / item.weight;
                totalValue += fraction * item.value;
                remainingCapacity = 0;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        FractionalKnapsack sol = new FractionalKnapsack();
        
        // Test case 1
        int[] val1 = {60, 100, 120};
        int[] wt1 = {10, 20, 30};
        long cap1 = 50;
        System.out.println("Test 1: " + sol.fractionalKnapsack(val1, wt1, cap1)); // 240.0
        
        // Test case 2
        int[] val2 = {280, 100, 120, 120};
        int[] wt2 = {40, 10, 20, 30};
        long cap2 = 60;
        System.out.println("Test 2: " + sol.fractionalKnapsack(val2, wt2, cap2)); // 440.0
    }
}