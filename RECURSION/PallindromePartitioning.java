import java.util.*;
class PallindromePartitioning{
    public static void main(String[] args){
        String s = "aabaa";
        System.out.println(pallindromicsubs(s));
    }
    public static List<List<String>> pallindromicsubs(String s){
        List<List<String>> ans = new ArrayList<>();
        helper(0, s, new ArrayList<>(), ans);
        return ans;
    }
    public static void helper(int index , String s ,List<String> list, List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPallindrome(s, index, i)){
                list.add(s.substring(index, i+1));
                helper(i+1, s, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isPallindrome(String s , int left , int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}