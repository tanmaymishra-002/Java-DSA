import java.util.*;

public class infixToPrefix {

    public static int priority(char ch) {
        if (ch == '^')
            return 3;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '+' || ch == '-')
            return 1;
        return -1;
    }

    public static String infixToPrefix(String s) {

        // Step 1: Reverse the infix expression and swap brackets
        String rev = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '(')
                rev += ')';
            else if (ch == ')')
                rev += '(';
            else
                rev += ch;
        }

        // Step 2: Convert reversed infix to postfix
        Stack<Character> st = new Stack<>();
        String postfix = "";

        for (int i = 0; i < rev.length(); i++) {

            char ch = rev.charAt(i);

            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {

                postfix += ch;
            }

            else if (ch == '(') {
                st.push(ch);
            }

            else if (ch == ')') {

                while (!st.isEmpty() && st.peek() != '(') {
                    postfix += st.pop();
                }

                if (!st.isEmpty())
                    st.pop();
            }

            else {

                while (!st.isEmpty() &&
                       st.peek() != '(' &&
                       priority(st.peek()) > priority(ch)) {

                    postfix += st.pop();
                }

                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            postfix += st.pop();
        }

        // Step 3: Reverse postfix to get prefix
        String prefix = "";

        for (int i = postfix.length() - 1; i >= 0; i--) {
            prefix += postfix.charAt(i);
        }

        return prefix;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Infix Expression: ");
        String s = sc.nextLine();

        System.out.println("Prefix Expression: " + infixToPrefix(s));

        sc.close();
    }
}
