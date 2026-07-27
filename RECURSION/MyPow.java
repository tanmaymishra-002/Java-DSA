import java.util.Scanner;
public class MyPow {
    public static double myPow(double x, int n) {
        long num = n;
        if (num < 0)
            return 1.0 / power(x, -num);
        return power(x, num);
    }
    public static double power(double x, long n) {
        if (n == 0)
            return 1;
        double half = power(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return x * half * half;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = sc.nextDouble();
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Answer = " + myPow(x, n));

        sc.close();
    }
}