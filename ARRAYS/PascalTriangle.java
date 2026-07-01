import java.util.*;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                // First and last element are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> previousRow = ans.get(i - 1);
                    row.add(previousRow.get(j - 1) + previousRow.get(j));
                }
            }

            ans.add(row);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int numRows = sc.nextInt();

        List<List<Integer>> result = generate(numRows);

        System.out.println(result);

        sc.close();
    }
}