// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

public class smallestletter {

    public static void main(String[] args) {

        char[] letters = {'c', 'f', 'j'};
        char target = 'a';

        char ans = nextGreatestLetter(letters, target);

        System.out.println("Target: " + target);
        System.out.println("Next greatest letter: " + ans);
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // Wrap around if target is greater than or equal to the largest letter
        return letters[start % letters.length];
    }
}