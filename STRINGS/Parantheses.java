class Parantheses{
    public static void main(String[] args) {
        String s = "(()())(())"; 
        // LEETCODE - 1021

        StringBuilder ans = new StringBuilder("");
        int open = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                if (open>0){                        // BECAUSE WE ALSO WERE ASKED TO REMOVE THE OUTERMOST PARANTHESES
                    ans.append('(');
                }
                open++;
            }else{
                open--;
                if(open>0){
                    ans.append(')');
                }
            }
        }
        System.out.println(ans.toString());
    }
}