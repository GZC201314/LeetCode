package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

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
                log.info(String.valueOf(findnumberoflis(new int[]{1, 3, 5, 4, 7})));
                break;
            case 3099:
                log.info(String.valueOf(sumOfTheDigitsOfHarshadNumber(18)));
                break;
            case 486:
                log.info(String.valueOf(predictTheWinner(new int[]{2, 4, 55, 6, 8})));
                break;
            case 494:
                log.info(String.valueOf(findTargetSumWays(new int[]{1, 1, 1, 1, 1},3)));
                break;
            default:
                break;

        }


    }

    /**
     * 673.最长递增子序列的个数
     */
    public static int findnumberoflis(int[] nums) {
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

    /**
     * 3099.哈沙德数
     */
    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int temp = x;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        assert sum != 0;
        if (x % sum == 0) {
            return sum;
        }
        return -1;
    }

    /**
     *
     * 486. 预测赢家
     */
    public static boolean predictTheWinner(int[] nums) {

        // 1,5,2
        int[] max = dfsPredictTheWinner(nums, 0, nums.length - 1, true, new int[]{0, 0});
        return max[0] >= max[1];
    }

    private static int[] dfsPredictTheWinner(int[] nums, int start, int end, boolean p1First, int[] max) {
        if (p1First) {
            if (start == end) {
                return new int[]{nums[start] + max[0], max[1]};
            } else if (start == end - 1) {
                if (nums[start] > nums[end]) {
                    return new int[]{nums[start] + max[0], nums[end] + max[1]};
                } else {
                    return new int[]{nums[end] + max[0], nums[start] + max[1]};
                }
            } else {

                // 两种情况，选择左边和右边
                int[] right = dfsPredictTheWinner(nums, start, end - 1, false, new int[]{max[0] + nums[end], max[1]});
                int[] left = dfsPredictTheWinner(nums, start + 1, end, false, new int[]{max[0] + nums[start], max[1]});
                if (right[0] > left[0]) {
                    return right;
                } else if (right[0] == left[0]) {
                    if (right[1] > left[1]) {
                        return left;
                    } else {
                        return right;
                    }
                }
                return left;

            }
        } else {
            // 后手，需要绝对理性
            if (start == end) {
                return new int[]{max[0], max[1] + nums[start]};
            } else if (start == end - 1) {
                if (nums[start] <= nums[end]) {
                    return new int[]{nums[start] + max[0], nums[end] + max[1]};
                } else {
                    return new int[]{nums[end] + max[0], nums[start] + max[1]};
                }
            } else {
                // 两种情况，选择左边和右边
                int[] right = dfsPredictTheWinner(nums, start, end - 1, true, new int[]{max[0], max[1] + nums[end]});
                int[] left = dfsPredictTheWinner(nums, start + 1, end, true, new int[]{max[0], max[1] + nums[start]});

                if (right[0] > left[0]) {
                    return left;
                } else if (right[0] == left[0]) {
                    if (right[1] <= left[1]) {
                        return left;
                    } else {
                        return right;
                    }
                }
                return right;
            }
        }
    }


    /**
     * 494.目标和
     */
    public static int findTargetSumWays(int[] nums, int target) {
        int[] res = new int[1];
        dfsFindTargetSumWays(nums, target, 0, 0, res);
        return res[0];

    }

    public static void dfsFindTargetSumWays(int[] nums, int target, int index, int sum, int[] res) {
        if (index == nums.length) {
            if (sum == target) {
                res[0]++;
            }
            return;
        }
        dfsFindTargetSumWays(nums, target, index + 1, sum + nums[index], res);
        dfsFindTargetSumWays(nums, target, index + 1, sum - nums[index], res);
    }



}
