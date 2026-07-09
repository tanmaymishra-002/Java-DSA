class pallindromicsubstring{
    public static void main(String[] args) {
        String s ="babad";
        String res = "";
        int res_len = 0;

        for(int i = 0;i<s.length();i++){
            // ODD CASE
            int left = i;
            int right  = i;
            while(left>=0 && right<=s.length()-1&&s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > res_len){      //RIGHT-LEFT+1 ==LENGTH OF STRING
                    res = s.substring(left,right+1);
                    res_len = right-left+1;          // UPDATING THE LENGTH OF RES STRING
                }
                left--;
                right++;
            }
            // EVEN CASE
            left = i;
            right = i+1;
            while(left>=0 && right<=s.length()-1&&s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > res_len){
                    res = s.substring(left,right+1);
                    res_len = right-left+1;
                }
                left--;
                right++;
            }
        }
        System.out.println(res);

    }
}