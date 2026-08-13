import java.util.*;
public class TrainPlatforms {
    public static int findPlatform(int[] Arrival, int[] Departure) {
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int n = Arrival.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int max_cnt = 0;
        while (i < n) {
            if (Arrival[i] <= Departure[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            max_cnt = Math.max(max_cnt, count);
        }
        return max_cnt;
    }

    public static void main(String[] args) {
        int[] Arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] Departure = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(Arrival, Departure));
    }
}