import java.util.*;
class prefixtoinfix {
    public static String prefixToInfix(String s) {
        Stack<String> st = new Stack<>();
        int i = s.length() - 1;
        while (i >= 0) {
            char ch = s.charAt(i);
            if ((ch >= 'A' && ch <= 'Z')
                    || (ch >= 'a' && ch <= 'z')
                    || (ch >= '0' && ch <= '9')) {
                st.push(String.valueOf(ch));
            } else {
                String t1 = st.pop();
                String t2 = st.pop();
                String ans = "(" + t1 + ch + t2 + ")";
                st.push(ans);
            }
            i--;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Prefix Expression: ");
        String s = sc.next();
        System.out.println("Infix Expression: " + prefixToInfix(s));
        sc.close();
    }
}