import java.util.*;
class PostfixToInfix {
    public static String postToInfix(String postExp) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while (i < postExp.length()) {
            char ch = postExp.charAt(i);
            if ((ch >= 'A' && ch <= 'Z')
                    || (ch >= 'a' && ch <= 'z')
                    || (ch >= '0' && ch <= '9')) {
                st.push(String.valueOf(ch));
            } else {
                String t1 = st.pop();
                String t2 = st.pop();
                String res = "(" + t2 + ch + t1 + ")";
                st.push(res);
            }
            i++;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Postfix Expression: ");
        String postExp = sc.next();
        System.out.println("Infix Expression: " + postToInfix(postExp));
        sc.close();
    }
}