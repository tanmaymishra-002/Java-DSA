import java.util.*;

class operations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        System.out.println("1. Decimal to Binary");
        System.out.println("2. Hexadecimal to Binary");
        System.out.println("3. Decimal to Octal");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            // Decimal to Binary
            case 1:
                System.out.print("Enter Decimal Number: ");
                int num = sc.nextInt();

                while (num > 0) {
                    st.push(num % 2);
                    num /= 2;
                }

                System.out.print("Binary = ");
                while (!st.isEmpty()) {
                    System.out.print(st.pop());
                }
                break;

            // Hexadecimal to Binary
            case 2:
                System.out.print("Enter Hexadecimal Number: ");
                String s = sc.next();

                int decimal = 0;
                int power = 0;

                for (int i = s.length() - 1; i >= 0; i--) {

                    char ch = Character.toUpperCase(s.charAt(i));
                    int value = 0;

                    if (ch >= '0' && ch <= '9') {
                        value = ch - '0';
                    } else if (ch >= 'A' && ch <= 'F') {
                        value = ch - 'A' + 10;
                    } else {
                        System.out.println("Invalid Hexadecimal Number");
                        return;
                    }

                    decimal += value * (int) Math.pow(16, power);
                    power++;
                }

                while (decimal > 0) {
                    st.push(decimal % 2);
                    decimal /= 2;
                }

                System.out.print("Binary = ");
                while (!st.isEmpty()) {
                    System.out.print(st.pop());
                }
                break;

            // Decimal to Octal
            case 3:
                System.out.print("Enter Decimal Number: ");
                num = sc.nextInt();

                while (num > 0) {
                    st.push(num % 8);
                    num /= 8;
                }

                System.out.print("Octal = ");
                while (!st.isEmpty()) {
                    System.out.print(st.pop());
                }
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}