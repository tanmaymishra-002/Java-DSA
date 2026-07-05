import java.util.Arrays;
class RearrangeElement{
    public static void main(String[] args) {
        int [] arr = {3,1,-2,-5,2,-4};
        // LEETCODE - 2149
        int [] result= new int[arr.length];
        int positive = 0;
        int negative = 1;
        
        for(int num : arr){
            if (num>0){
                result[positive]=num;
                positive+=2;
            }
            if (num<0){
                result[negative] = num;
                negative+=2;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}