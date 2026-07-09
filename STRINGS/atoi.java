class atoi{
    public static void main(String[] args){
        // LEETCODE -8
        String s =" -042";
        int i =0;
        boolean isnegative= false;
        int digit =0;
        while(i<s.length() && s.charAt(i) == ' '){
            i++;
        }
        if(i<s.length() && s.charAt(i) == '-'){
            isnegative = true;
            i++;
        }else if(i<s.length() && s.charAt(i) =='+'){
            i++;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int currentdigit = s.charAt(i)-'0';
            if(digit > Integer.MAX_VALUE/10 || (digit == Integer.MAX_VALUE/10 && currentdigit>7)){
                System.out.println(isnegative ? Integer.MIN_VALUE:Integer.MAX_VALUE);
                return;
            }
            digit = digit*10+currentdigit;
            i++;

        }
        if (isnegative){
            System.out.println(-digit);
        }else{
        System.out.println(digit);;
    }
    }
}