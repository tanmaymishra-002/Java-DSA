import java.util.*;

public class BeautySum {

    public static int beautySum(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for (int value : map.values()) {
                    max = Math.max(max, value);
                    min = Math.min(min, value);
                }

                answer += (max - min);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        System.out.println("Beauty Sum = " + beautySum(s));

        sc.close();
    }
}