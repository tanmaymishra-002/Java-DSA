// Maximum Consecutive ones - III in java
class MCOIII{
    public static void main(String[] args) {
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0}; 
        int k = 2;

        int left =0;
        int right =0;
        int countzeros =0;
        int maxlength =0;
        while(right<nums.length){
            if(nums[right]==0){
                countzeros++;
            }
            while(countzeros>k){
                if(nums[left]==0){
                    countzeros--;
                }
                left++;
            }
                maxlength = Math.max(maxlength,right-left+1);
                right++;
            
        }
        System.out.println(maxlength);
    }
}