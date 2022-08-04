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
                break;
            case 1403:
                System.out.println(minSubsequence(new int[]{4, 4, 6, 7, 7}));
                break;
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

    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        // 对数组进行排序
        Arrays.sort(nums);
        int left = 0;
        int right = n-1;
        int leftNum = 0;
        result.add(nums[right]);
        int rightNum = nums[right--];

        while(left <= right){
            if (leftNum+nums[left] < rightNum){
                leftNum += nums[left++];
            }else {
                result.add(nums[right]);
                rightNum += nums[right--];
            }
        }
        return result;
    }


}
