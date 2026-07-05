import java.util.Arrays;
class rotateArray{
    public static void reverse(int[] arr , int start , int end){
        while (start < end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start ++;
        end--;
    }
}


    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        int k = 3;
        int start = 0; int end = arr.length-1;
        reverse(arr,start , end);
        reverse(arr , start , k-1);
        reverse(arr,k+1,end);
        System.out.println(Arrays.toString(arr));
    }
}