import java.util.*;

public class infix_Postfix {

    public static int priority(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        }
        return -1;
    }

    public static String infixToPostfix(String s) {

        Stack<Character> st = new Stack<>();
        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {

                ans += ch;
            }

            else if (ch == '(') {
                st.push(ch);
            }

            else if (ch == ')') {

                while (!st.isEmpty() && st.peek() != '(') {
                    ans += st.pop();
                }

                if (!st.isEmpty()) {
                    st.pop(); // Remove '('
                }
            }

            else {

                while (!st.isEmpty() &&
                       st.peek() != '(' &&
                       (priority(st.peek()) > priority(ch) ||
                        (priority(st.peek()) == priority(ch) && ch != '^'))) {

                    ans += st.pop();
                }

                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Infix Expression: ");
        String s = sc.nextLine();

        System.out.println("Postfix Expression: " + infixToPostfix(s));

        sc.close();
    }
}