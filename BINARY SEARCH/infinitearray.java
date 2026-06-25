class infinitearray{
   public static void main(String[] args) {
        int nums[] = {2,3,5,6,7,8,10,11,12,15,20,23,30,45};
        int target=15;
        System.out.println(ans(nums , target));
    }

    static int ans(int arr[] , int target){
        // we initialized the first box over here
        int start = 0;
        int end = 1;

        // condition to find the target element
        while (target > arr[end]){
            // we need to move the box
            int newStart = end + 1;
            // for end the formula is like 
            // previous end + 2*size of the block
            end = end+(end - start +1)*2;
            start = newStart;
        }
        return binarysearch(arr, target, start, end);

    }
 static int binarysearch(int[] arr , int target, int start,int end){
        
        while(start <= end){
           
            int mid = start + (end-start)/2; 

            if (target< arr[mid]){
                end = mid-1;
            }  else if (target > arr[mid]) {
                start = mid +1;
            } else{
                return mid;
            }
        }
        return -1;
    }
    
}