public class XorInRange {
    static int xorTill(int n) {
        if (n % 4 == 0) {
            return n;
        } 
        else if (n % 4 == 1) {
            return 1;
        } 
        else if (n % 4 == 2) {
            return n + 1;
        } 
        else {
            return 0;
        }
    }
    static int findRangeXOR(int l, int r) {
        return xorTill(r) ^ xorTill(l - 1);
    }
    public static void main(String[] args) {
        int l = 4;
        int r = 10;
        System.out.println(findRangeXOR(l, r));
    }
}