public class checkOdd {
    public static boolean isOdd(int n) {
        return (n | (n - 1)) == n;
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println(isOdd(n));
    }
}