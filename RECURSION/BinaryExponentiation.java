import java.util.*;
class BinaryExponentiation{
    static final long MOD = 1000000007;
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        long even = (n+1)/2;
        long odd = n/2;

        long evenways = power(5,even);
        long oddways = power(4,odd);

        long res = (int) ((evenways * oddways)%MOD);
        System.out.println(res);
    }
    public static long power(long base,long exponent){
        long ans =1;
        while(exponent>0){
            if(exponent%2 == 1) ans = ((ans*base)%MOD);
            base = (base * base)%MOD;
            exponent/=2;
        }
        return ans;
    }
}