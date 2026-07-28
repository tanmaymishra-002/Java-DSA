import java.util.*;
public class GenerateBinaryStringsWithoutConsecutive1s {
    public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        helper("", n, result);
        return result;
    }

    private static void helper(String current, int n, List<String> result) {
        // Base Case
        if (current.length() == n) {
            result.add(current);
            return;
        }
        // Choice 1 : Always append '0'
        helper(current + "0", n, result);
        // Choice 2 : Append '1' only if previous character is not '1'
        if (current.length() == 0 || current.charAt(current.length() - 1) != '1') {
            helper(current + "1", n, result);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> answer = generateBinaryStrings(n);
        System.out.println("Binary Strings of Length " + n + " Without Consecutive 1's:");
        for (String str : answer) {
            System.out.println(str);
        }
    }
}