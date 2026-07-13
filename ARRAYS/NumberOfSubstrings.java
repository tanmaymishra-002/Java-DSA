public class NumberOfSubstrings {

    public static int numberOfSubstrings(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        int ans = 0;

        int[] freq = new int[26];

        while (right < s.length()) {

            char ch = s.charAt(right);
            freq[ch - 'a']++;

            if (freq[ch - 'a'] == 1) {
                count++;
            }

            while (count == 3) {

                ans += s.length() - right;

                char remove = s.charAt(left);
                freq[remove - 'a']--;

                if (freq[remove - 'a'] == 0) {
                    count--;
                }

                left++;
            }

            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}