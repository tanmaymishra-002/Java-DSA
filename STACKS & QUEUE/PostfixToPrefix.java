import java.util.*;
class PostfixToPrefix {
    public static String postToPre(String postfix) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while (i < postfix.length()) {
            char ch = postfix.charAt(i);
            if ((ch >= 'A' && ch <= 'Z')
                    || (ch >= 'a' && ch <= 'z')
                    || (ch >= '0' && ch <= '9')) {
                st.push(String.valueOf(ch));
            } else {
                String t1 = st.pop();
                String t2 = st.pop();
                st.push(ch + t2 + t1);
            }
            i++;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Postfix Expression: ");
        String postfix = sc.next();
        System.out.println("Prefix Expression: " + postToPre(postfix));
        sc.close();
    }
}