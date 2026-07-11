
import java.util.HashMap;

// LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS 
class LSWRC{
    public static void main(String[] args) {
        // LEETCODE -3
        String s = "abcabcbb";
        int left =0;
        int right =0;
        HashMap <Character ,Integer> map = new HashMap<>();
        int maxlength=0;
        while(right<s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch) && map.get(ch)>=left){
                left=map.get(ch)+1;
            }
            map.put(ch,right);
            maxlength = Math.max(maxlength,right-left+1);
            right++;
        }
        System.out.println(maxlength);
    }
}