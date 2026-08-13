import java.util.*;

public class JobDeadline {
    static class Solution {
        public int[] JobScheduling(int[][] Jobs) {
            // 1. Sort jobs by profit in descending order
            Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);
            // 2. Find maximum deadline
            int maxDeadline = 0;
            for (int[] job : Jobs) {
                maxDeadline = Math.max(maxDeadline, job[1]);
            }
            // 3. Create time slots
            int[] slots = new int[maxDeadline + 1];
            // -1 means slot is empty
            Arrays.fill(slots, -1);
            int jobCount = 0;
            int totalProfit = 0;
            // 4. Try to schedule each job
            for (int[] job : Jobs) {
                int deadline = job[1];
                int profit = job[2];
                // Start from the latest possible slot
                for (int time = deadline; time >= 1; time--) {
                    if (slots[time] == -1) {
                        // Put job in this slot
                        slots[time] = job[0];
                        jobCount++;
                        totalProfit += profit;
                        break;
                    }
                }
            }
            return new int[]{jobCount, totalProfit};
        }
    }

    public static void main(String[] args) {
        int[][] Jobs = {
            {1, 4, 20},
            {2, 1, 10},
            {3, 1, 40},
            {4, 1, 30}
        };
        Solution obj = new Solution();
        int[] answer = obj.JobScheduling(Jobs);
        System.out.println("Number of Jobs: " + answer[0]);
        System.out.println("Maximum Profit: " + answer[1]);
    }
}