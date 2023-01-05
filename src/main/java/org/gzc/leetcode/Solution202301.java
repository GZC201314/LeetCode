package org.gzc.leetcode;

import java.util.Scanner;

/**
 * @author GZC
 */
public class Solution202301 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {

            case 2042:
                System.out.println(areNumbersAscending("sunset is at 7 50 pm overnight lows will be in the low 51 and 60 s"));
                break;
            case 1991:
                System.out.println(findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
                break;
            case 1802:
                System.out.println(maxValue(995610677, 934568761, 999009430));
                break;
            default:
                break;
        }
    }

    /**
     * 1991. 找到数组的中间位置
     */
    public static int findMiddleIndex(int[] nums) {
        int n = nums.length;
        long[] preSum = new long[n];

        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i-1]+nums[i];
        }

        for (int i = 0; i < n; i++) {
            long leftSum = i-1>=0?preSum[i-1]:0;
            long rightSum = n-i-1>0?preSum[n-1]-preSum[i]:0;
            if (leftSum == rightSum){
                return i;
            }

        }
        return -1;


    }

    /**
     * 1802. 有界数组中指定下标处的最大值
     */
    public static int maxValue(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum;
        int mid = left + (right - left) / 2;
        int ans = 0;
        while (left <= right) {
            // 当最大值为mid时，判断是否满足条件
            // 计算满足条件需要的最大最小值
            // 左边的最小值 0 -- index-1
            int leftIndex = index - 1;
            int leftNum = Math.max(mid - 1, 1);
            long leftSum = 0;
            while (leftIndex >= 0) {
                leftSum += leftNum;
                if (leftNum > 1) {
                    leftNum--;
                } else {
                    if (leftIndex > 0) {
                        leftSum += leftIndex;
                    }
                    break;
                }
                leftIndex--;
            }
            int rightIndex = index + 1;
            long rightSum = 0;
            int rightNum = Math.max(mid - 1, 1);
            while (rightIndex < n) {
                rightSum += rightNum;
                if (rightNum > 1) {
                    rightNum--;
                } else {
                    if (rightNum < n - 1) {
                        rightSum += (n - rightIndex - 1);
                    }
                    break;
                }
                rightIndex++;
            }
            if (leftSum + rightSum <= maxSum - mid) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return ans;

    }


    /**
     * 2042. 检查橘子中的数字是否递增
     */
    public static boolean areNumbersAscending(String s) {
        final char[] sChrs = s.toCharArray();
        long cur = 0;
        long preNum = Long.MIN_VALUE;
        for (char sChr : sChrs) {
            if (Character.isDigit(sChr)) {
                cur = cur * 10 + (sChr - '0');
            } else {
                if (cur != 0) {
                    if (cur <= preNum) {
                        return false;
                    }
                    preNum = cur;
                    cur = 0;
                }
            }
        }
        if (cur != 0) {
            return cur > preNum;
        }
        return true;
    }


}
