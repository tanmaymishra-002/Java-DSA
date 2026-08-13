import java.util.*;
public class candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        // Everyone gets at least 1 candy
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        // Left -> Right
        // If current rating is greater than left neighbor,
        // current child needs more candies.
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Right -> Left
        // If current rating is greater than right neighbor,
        // current child needs more candies.
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(
                    candies[i],
                    candies[i + 1] + 1
                );
            }
        }
        // Calculate total
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }
}