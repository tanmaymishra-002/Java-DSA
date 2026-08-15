import java.util.*;
public class ithbitSetOrNot {
    public static boolean checkIthBit(int n, int i) {
        return n > 0 && ((n & (1 << i)) != 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        System.out.println(checkIthBit(n, i));
        sc.close();
    }
}