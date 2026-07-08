import java.util.*;

class Sortbyfreq{
    public static void main(String[] args){
        String s = "tree";
        // WE NEED OUTPUT = "eert"
        HashMap <Character , Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        // SORING THE LIST
        Collections.sort(list,(a,b)->b.getValue()-a.getValue());

        // APPENDING IT TO STRINGBUILDER 
        for(Map.Entry<Character,Integer> entry : list){
            char ch = entry.getKey();
            int freq = entry.getValue();

            for(int i=0;i<freq;i++){
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
}