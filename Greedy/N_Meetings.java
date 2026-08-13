import java.util.*;
class N_Meetings {
    public static int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);
        int count = 0;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= prev) {
                count++;
                prev = meetings[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int result = maxMeetings(start, end);
        System.out.println(result);
    }
}