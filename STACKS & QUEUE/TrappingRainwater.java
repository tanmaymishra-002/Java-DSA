// NOT EXACTLY A STACK PROBLEM
class TrappingRainwater{
    public static void main(String[] args) {
        // LEETCODE  - 42
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int left =0;
        int right =height.length-1;
        int leftmax = 0;
        int rightmax =0;
        int total =0;

        while(left<right){
            if(height[left]<=height[right]){
                if(leftmax>height[left]){
                    total += leftmax - height[left];
                }else{
                    leftmax = height[left];
                }
                left++;
            }else{
                if(rightmax>height[right]){
                    total+=rightmax-height[right];
                }else{
                    rightmax = height[right];
                }
                right--;
            }
        }
        System.out.println(total);
    }
}