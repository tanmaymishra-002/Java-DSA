import java.util.*;
class WordBreak{
    public static void main(String[] args) {
        String s = "takeuforward";
        List<String> wordDict = Arrays.asList("take","forward","you","u");
        System.out.println(wordBreak(s, wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        return helper(0, s, set);
    }
    public static boolean helper(int start , String s,Set<String> set){
        if(start == s.length()){
            return true;
        }
        for(int end = start;end<s.length();end++){
            String word = s.substring(start,end+1);
            if(set.contains(word)){
                if(helper(end+1, s, set)){
                    return true;
                }
            }
        }
        return false;
    }
}