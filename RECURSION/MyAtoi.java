// MyAtoi using recursion 
public class MyAtoi {
    public static int myAtoi(String s) {
        boolean isNegative = false;
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        if (i < s.length() && s.charAt(i) == '-'){
            isNegative = true;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+'){
            i++;
        }
        return solve(s, i, 0L, isNegative);
    }
    public static int solve(String s, int i, long num, boolean isNegative) {
        // Base case
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return isNegative ? (int) -num : (int) num;
        }
        int digit = s.charAt(i) - '0';
        num = num * 10 + digit;
        if (!isNegative && num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (isNegative && -num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return solve(s, i + 1, num, isNegative);
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));                  // 42
        System.out.println(myAtoi("   -42"));              // -42
        System.out.println(myAtoi("4193 with words"));     // 4193
        System.out.println(myAtoi("words and 987"));       // 0
        System.out.println(myAtoi("-91283472332"));        // -2147483648
        System.out.println(myAtoi("91283472332"));         // 2147483647
    }
}