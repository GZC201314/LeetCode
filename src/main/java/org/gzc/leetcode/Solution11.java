package org.gzc.leetcode;

public class Solution11 {
    /**
     * 343. 整数拆分
     * <p>
     * 算法 动态规划
     * <p>
     * 转移方程:
     * dp[i]= 1≤j<i max{max(j×(i−j),j×dp[i−j])} 其中dp[i] 表示整数i拆分后的最大乘积
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max,Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
