class Solution {
    // [64]最小路径和.java
    public int minPathSum(int[][] grid) {
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } if (i == 0) {
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    // [91]解码方法.java
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;

        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i=1; i<s.length(); i++) {
            if (chars[i] != '0') dp[i] = dp[i-1];

            int curr = 10 * (chars[i-1] - '0') + (chars[i] - '0');
            if (curr >= 10 && curr <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length()-1];
    }
}
