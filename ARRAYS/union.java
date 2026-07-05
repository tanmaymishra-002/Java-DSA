// union of two sorted arrays
import java.util.ArrayList;
import java.util.Arrays;
class union{
    public static void main(String[] args) {
        int nums1[] = {1,2,3,4,5};
        int nums2[] = {1,2,7};
        ArrayList <Integer> union = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
            if (union.isEmpty() || union.get(union.size()-1) != nums1[i]){
                union.add(nums1[i]);
            }
             i++;
        }else if (nums1[i] > nums2[j]){
             if (union.isEmpty() || union.get(union.size() -1) !=nums2[j]){
            union.add(nums2[j]);
             } 
             j++; 
          }else{
                if (union.isEmpty() || union.get(union.size() -1) != nums1[i]){
                    union.add(nums1[i]);
                }
                i++;
                j++;
             }
             
   
        }
        while(i<nums1.length){
                if(union.isEmpty() || union.get(union.size() -1) != nums1[i]){

                union.add(nums1[i]);
             }
             i++;
             }
             while(j<nums2.length){
                if(union.isEmpty() || union.get(union.size() -1) != nums2[j]){

                union.add(nums2[j]);
             }
             j++;
             }
        int[] arr = new int[union.size()];
        for( i =0;i<union.size();i++){
            arr[i] = union.get(i);
        }
        System.out.println(Arrays.toString(arr));
    }
}