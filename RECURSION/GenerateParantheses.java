import java.util.*;
class GenerateParantheses{
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println("Well-Formed Parentheses for n = " + n + ":");

        for (String str : result) {
            System.out.println(str);
        }
    }
    public  static List<String> generateParenthesis(int n){
        List<String> res =  new ArrayList<>();
        helper("", n, 0, 0, res);
        return res;
    }
    public static void helper(String current , int n , int open , int close , List<String> res){
        if(current.length() == 2*n){
            res.add(current);
            return;
        }
        if(open<n){
            helper(current+"(", n, open+1, close, res);
        }
        if(close<open){
            helper(current+")", n, open, close+1, res);
        }
    }
}