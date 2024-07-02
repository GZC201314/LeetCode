package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.gzc.leetcode.model.MyTree;

import java.text.ParseException;
import java.util.*;


/**
 * @author GZC
 */
@Slf4j
public class Solution202407 {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 673:
                log.info(String.valueOf(findNumberOfLIS(new int[]{1, 3, 5, 4, 7})));
                break;
            default:
                break;

        }


    }

    /**
     *
     * 673.最长递增子序列的个数
     */
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int max = 0;
        int res = 0;
        //以i结尾的最长递增子序列的长度
        int[] dp = new int[n];
        //以i结尾的最长递增子序列的个数
        int[] number = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(number, 1);
        if (n < 1) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 == dp[i]) {
                        number[i] += number[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        number[i] = number[j];
                    }
                }
                max = Math.max(dp[i], max);
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                res += number[i];
            }
        }
        return res;
    }
}
