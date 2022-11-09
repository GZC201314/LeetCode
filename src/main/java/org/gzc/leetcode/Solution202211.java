package org.gzc.leetcode;

import java.util.*;

/**
 * @author GZC
 */
public class Solution202211 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 816:
                System.out.println(ambiguousCoordinates("(0012)"));
                break;
            case 764:
                System.out.println(orderOfLargestPlusSign(5,new int[][]{{4,2}}));
                break;
            default:
                break;
        }
    }

    /**
     * 764. 最大加号标志
     */
    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        // dp[i][j] 表示以i,j为中心向四周扩展最小的距离
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> banned = new HashSet<>();
        for (int[] vec : mines) {
            banned.add(vec[0] * n + vec[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* left */
            for (int j = 0; j < n; j++) {
                count = getCount(n, dp, banned, i, count, j);
            }
            count = 0;
            /* right */
            for (int j = n - 1; j >= 0; j--) {
                count = getCount(n, dp, banned, i, count, j);
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* up */
            for (int j = 0; j < n; j++) {
                count = getCount(n, dp, banned, j, count, i);
            }
            count = 0;
            /* down */
            for (int j = n - 1; j >= 0; j--) {
                count = getCount(n, dp, banned, j, count, i);
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }

    private static int getCount(int n, int[][] dp, Set<Integer> banned, int i, int count, int j) {
        if (banned.contains(i * n + j)) {
            count = 0;
        } else {
            count++;
        }
        dp[i][j] = Math.min(dp[i][j], count);
        return count;
    }

    /**
     * 816. 模糊坐标
     */
    public static List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        String replace = s.replace("(", "").replace(")", "");
        int n = replace.length();
        for (int i = 1; i < n; i++) {
            for (String num1 : getNums(replace.substring(0, i))) {
                for (String num2 : getNums(replace.substring(i, n))) {
                    result.add("("+num1+","+num2+")");
                }
            }
        }
        return result;
    }

    public static List<String> getNums(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            // 正数部分
            String zheng = s.substring(0, i);
            String xiao = s.substring(i);
            if (zheng.startsWith("0")&& (Integer.parseInt(zheng)!=0|| zheng.length()>1 )|| xiao.endsWith("0")){
                continue;
            }
            if ("".equals(xiao)){
                result.add(zheng);
            }else {
                result.add(zheng+"."+xiao);
            }
        }
        return result;
    }
}
