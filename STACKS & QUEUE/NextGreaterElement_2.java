import java.util.*;
class NextGreaterElement_2{
    public static void main(String[] args) {
        // LEETCODE - 503
        int [] nums = {1,2,1};
        int n=nums.length;
        int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i%n]>=st.peek()){
                st.pop();
            }
            if(i<n){
                res[i] = st.isEmpty()? -1 :st.peek();
            }
            st.push(nums[i%n]);
        }
        System.out.println(Arrays.toString(res));
    }
}