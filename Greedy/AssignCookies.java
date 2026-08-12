import java.util.*;
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int left = 0;
        int right = 0;
        
        while (left < g.length && right < s.length) {
            if (g[left] <= s[right]) {
                left++;
            }
            right++;
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        AssignCookies solution = new AssignCookies();
        
        // Test case 1
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println("Test 1: " + solution.findContentChildren(g1, s1)); // Output: 1
        
        // Test case 2
        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println("Test 2: " + solution.findContentChildren(g2, s2)); // Output: 2
        
        // Test case 3
        int[] g3 = {10, 9, 8, 7};
        int[] s3 = {5, 6, 7, 8};
        System.out.println("Test 3: " + solution.findContentChildren(g3, s3)); // Output: 2
    }
}