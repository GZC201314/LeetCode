package org.gzc.leetcode;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author GZC
 */
public class Solution202305 {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 2460:
                System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 3})));
                break;
            case 2461:
                System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 3}))+" ");
                break;
            default:
                break;

        }
    }

    /**
     * 2460. 对数组执行操作
     */
    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= nums[i];
                nums[i+1] =0;
            }
        }
        int index = 0;
        int[] ans = new int[n];
        for (int num : nums) {
            if (num !=0){
                ans[index++] = num;
            }
        }
        return ans;
    }


}
