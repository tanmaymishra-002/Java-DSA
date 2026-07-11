// Longest Repeating Character Replacement
class LRCR{
    public static void main(String[] args) {
        // LEETCODE -424
        String s = "ABAB";
        int k = 2;
        int maxlength =0;
        int [] freq  = new int[26];
        int maxfreq=0;
        int left =0;
        int right=0;
         while(right<s.length()){
            char ch = s.charAt(right);
            freq[ch-'A']++;
            maxfreq = Math.max(maxfreq, freq[ch-'A']);
            while((right-left+1)-maxfreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxlength = Math.max(maxlength, right-left+1);
            right++;
         }
         System.out.println(maxlength);
    }
}