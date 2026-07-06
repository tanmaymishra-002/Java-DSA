class longestcommonprefix{
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String res ="";
        for(int i =0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for(int j =1;j<strs.length;j++){
                // IF THE COMPARING STRING IS TOO SHORT
                if(i>=strs[j].length()|| strs[j].charAt(i) != ch){
                    System.out.println(strs[0].substring(0,i));
                    return;
                }
            }
            res+=ch;
        }
        System.out.println(res);
    }
}