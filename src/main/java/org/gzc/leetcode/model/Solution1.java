package org.gzc.leetcode.model;

import java.util.Random;

/**
 * @author GZC
 * @create 2022-04-11 17:36
 * @desc 打乱数组
 */
public class Solution1 {
    int[] nums;
    int[] original;

    public Solution1(int[] nums){
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums,0, original,0,nums.length);
    }
    public int[] reset(){
        System.arraycopy(original,0, nums,0,nums.length);
        return nums;
    }

    public int[] shuffle(){
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = i + random.nextInt(nums.length-i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

}
