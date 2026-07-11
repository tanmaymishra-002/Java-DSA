
import java.util.HashMap;

class FRUITS{
    public static void main(String[] args) {
         int [] fruits = {1, 2, 1};
         int left =0;
         int right =0;
         int maxlength=0;
         HashMap <Integer,Integer> map = new HashMap<>();
         while(right<fruits.length){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left]-1));
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxlength = Math.max(maxlength,right-left+1);
            right++;
         }
         System.out.println(maxlength);
    }
}