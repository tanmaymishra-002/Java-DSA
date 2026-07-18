import java.util.*;
class LargestRectangleInHistogram{
        public static void main(String[] args) {
            int [] heights = {2,1,5,6,2,3};
            int [] nse = findnse(heights);
            int[] pse = findpse(heights);

            int maxArea  = 0;
            for(int i =0;i<heights.length;i++){
                int width = nse[i] - pse[i] - 1;
                int area = heights[i] * width;
                maxArea = Math.max(area,maxArea);
            }
            System.out.println(maxArea);
        }
        public static int[] findnse(int[] arr){
            int n = arr.length;
            int i = n-1;
            Stack<Integer> st = new Stack<>();
            int[] res = new int[n];
            while(i>=0){
                while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i] =n;
                }else{
                    res[i] = st.peek();
                }
                st.push(i);
                i--;
            }
            return res;
        }
        public static int[] findpse(int[] arr){
            int n = arr.length;
            int i = 0;
            Stack<Integer> st = new Stack<>();
            int[] res = new int[n];
            while(i<n){
                while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i] =n;
                }else{
                    res[i] = st.peek();
                }
                st.push(i);
                i++;
            }
            return res;
        }
}