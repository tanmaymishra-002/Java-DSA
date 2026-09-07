class FrogJump {
    public int frogJump(int[] heights) {
        int n = heights.length;
        if (n == 1) return 0;
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int fs = prev + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int curri = Math.min(fs, ss);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10};
        Solution obj = new Solution();
        System.out.println("Minimum energy: " + obj.frogJump(heights));
    }
}