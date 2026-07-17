import java.util.*;
class asteroidcollison{
    public static void main (String[] args){
        int []asteroids = {5,10,-5};
        Stack <Integer> st = new Stack<>();
        for(int i = 0;i<asteroids.length;i++){
            int current = asteroids[i];
            while(!st.isEmpty() && current<0 && st.peek()>0 && st.peek()<Math.abs(current)){
                st.pop();
            }
            if(st.isEmpty() || current>0 ||  st.peek()<0){
                st.push(current);
            }else if(Math.abs(st.peek()) == Math.abs(current)){
                st.pop();
            }
            
        }
        int [] res = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            res[i] = st.pop();
        }
        System.out.println(Arrays.toString(res));
    }
}