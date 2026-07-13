
public class MaximumPointsFromCards {

    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int maxSum = 0;

        // Take the first k cards from the left
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        maxSum = sum;

        int left = k - 1;
        int right = cardPoints.length - 1;

        // Replace one card from the left with one from the right
        while (left >= 0) {
            sum -= cardPoints[left];
            sum += cardPoints[right];

            maxSum = Math.max(maxSum, sum);

            left--;
            right--;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        int ans = maxScore(cardPoints, k);
        System.out.println("Maximum Score = " + ans);
    }
}