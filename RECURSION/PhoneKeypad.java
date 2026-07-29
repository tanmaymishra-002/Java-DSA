import java.util.*;
class PhoneKeypad {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        String[] map = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        helper(0, new StringBuilder(), digits, map, ans);
        return ans;
    }
    public static void helper(int index,StringBuilder current,String digits,String[] map,List<String> ans) {
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            // Choose
            current.append(letters.charAt(i));
            // Explore
            helper(index + 1, current, digits, map, ans);
            // Unchoose (Backtrack)
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        PhoneKeypad obj = new PhoneKeypad();
        String digits = "23";
        List<String> result = obj.letterCombinations(digits);
        System.out.println(result);
    }
}