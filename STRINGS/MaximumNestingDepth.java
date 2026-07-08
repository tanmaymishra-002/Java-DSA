class MaximumNestingDepth {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                count++;
                maxCount = Math.max(maxCount, count);
            } else if (ch == ')') {
                count--;
            }
        }

        System.out.println("Maximum Nesting Depth = " + maxCount);
    }
}