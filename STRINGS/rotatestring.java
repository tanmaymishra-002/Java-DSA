class rotatestring{
    public static void main(String[] args) {
        // LEETCODE-796
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(isrotated(s,goal));
        }
        
        
        public static Boolean isrotated(String s,String goal){
            
        String doubled = s+s;
        if(s.length() != goal.length()){
            return false;
        }
        if(doubled.contains(goal)){
            return true;
        }
        return false;
    }
}
