import java.util.Scanner;
public class no_OfFlips {
    public static int minBitFlips(int start, int goal) {
        int x = start ^ goal;
        int count = 0;
        while (x > 0) {
            count += x & 1;
            x >>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int goal = sc.nextInt();
        System.out.println(minBitFlips(start, goal));
        sc.close();
    }
}