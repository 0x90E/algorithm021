class Solution {
// 91. 解码方法
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

// 300. 最长递增子序列
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 ) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

