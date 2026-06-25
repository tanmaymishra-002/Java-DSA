class orderAgnostic{
    public static void main(String[] args) {
         int arr[] = {2,3,4,5,6,7,8,9,10,33,55};
        int target = 9;
        int ans = orderagnostic(arr, target);
        System.out.println(ans);
    }

    static int orderagnostic(int [] arr , int target){
        
         int start = 0;
        int end = arr.length -1;

        // find whether the array  is sorted  in ascending or descending
         boolean isAsc;
         if (arr[start] < arr[end]){
            isAsc = true;
         }else{
            isAsc = false;
         }

        while(start <= end){
            // find the middle element
            // int mid  = (start + end )/2  [we dont do this coz there may be cases that the value of mid may exceed the range of int variable 

            //instead of that
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
        

    }
