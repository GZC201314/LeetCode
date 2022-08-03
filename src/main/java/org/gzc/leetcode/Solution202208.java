package org.gzc.leetcode;

import org.gzc.leetcode.model.*;

import java.io.IOException;
import java.util.*;

/**
 * @author GZC
 */
public class Solution202208 {
    /**
     * 判断一个二叉树是否是二叉搜索树
     */
    public static int preValue = Integer.MIN_VALUE;
    /**
     * 折纸问题
     */
    public static String paperFoldStr = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 503:
                System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));
            default:
                break;
        }

    }

    /**
     * 503. 下一个更大元素||
     */
    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = i + 1; j < i + n; j++) {
                if (nums[j%n] > num) {
                    result[i] = nums[j%n];
                    break;
                }
            }
        }
        return result;
    }


}
