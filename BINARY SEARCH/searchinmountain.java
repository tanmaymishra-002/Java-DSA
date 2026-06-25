// search in mountain array(LEETCODE HARD 1095)

class searchinmountain{
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,3,1};
        int target = 3;
        int result = search(arr,target);
        System.out.println(result);
    }

    static int search(int arr[] , int target){
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderagnostic(arr, target,0, peak);
        if (firstTry!=-1){
            return firstTry;
        }
        //if not found in ascending side search in descending side
        return orderagnostic(arr, target,peak+1, arr.length-1);
    }

    static int orderagnostic(int [] arr , int target , int start , int end){
        
         

        // find whether the array  is sorted  in ascending or descending
         boolean isAsc;
         if (arr[start] < arr[end]){
            isAsc = true;
         }else{
            isAsc = false;
         }

        while(start <= end){
           
            int mid = start + (end-start)/2;  // the same thing 
            
            if (arr[mid] == target){
                return mid;
            }
            if (isAsc){
                 if (target< arr[mid]){
                      end = mid-1;
                } else if (target > arr[mid]) {
                     start = mid +1;
              } 

            }
            else{
                  if (target< arr[mid]){
                        start =mid+1;
                }else if (target > arr[mid]) {
                        end = mid-1;
             } 
        }
           
            } 
            return -1;
        }


    static  int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                
                end = mid;
            } else {
                start = mid + 1; 
             }
         }
        return start;
    }
}