class largestodd{
    public static void main(String[] args) {
        // LEETCODE - 1903
         String num = "4208";
         for (int i = num.length()-1;i>=0;i--){
            if (num.charAt(i) %2 != 0){
                System.out.println(num.substring(0,i+1));
            }
         }
         System.out.println("");
    }
}