import java.util.*;
class sumSubarrayMins{
    public static void main(String[] args){
        int [] arr = {3,1,2,4};
        int[] nse = findnse(arr);
        int[] pse = findpse(arr);
        int total = 0;
        for(int i=0;i<arr.length;i++){
            int left = i-pse[i];
            int right = nse[i]-i;

            total += (left*right*arr[i]);
        }
        System.out.println(total);

    }
    public static int[] findnse(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int i = n-1;
        int[] res = new int[n];
        while(i>=0){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = n;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
            i--;
        }
        return res;
    }
    public static  int[] findpse(int[]arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int i =0;
        int [] ans = new int[n];
        while(i<n){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
            i++;
        }
        return ans;
    }
}