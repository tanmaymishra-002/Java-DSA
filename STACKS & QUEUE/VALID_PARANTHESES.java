import java.util.*;
class  VALID_PARANTHESES{
    public static void main(String[] args) {
       String s = "()[]{}";
       System.out.println(isvalid(s));
    }
    public static boolean isvalid(String s){
        Stack<Character> st = new Stack <>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch =='(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.peek();
                if(ch == ')' && top!='('){
                    return false;
                }
                if(ch == '}' && top!='{'){
                    return false;
                }
                if(ch == ']' && top!='['){
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}