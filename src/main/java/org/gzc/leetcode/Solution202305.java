package org.gzc.leetcode;

import java.text.ParseException;
import java.util.*;

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
                System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 3})) + " ");
                break;
            case 2679:
                System.out.println(matrixSum(new int[][]{{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}}));
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
                nums[i + 1] = 0;
            }
        }
        int index = 0;
        int[] ans = new int[n];
        for (int num : nums) {
            if (num != 0) {
                ans[index++] = num;
            }
        }
        return ans;
    }

    /**
     * 2679.矩阵中的和
     */
    public static int matrixSum(int[][] nums) {
        int n = nums[0].length;
        int m = nums.length;
        List<PriorityQueue<Integer>> priorityQueueList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int num : nums[i]) {
                priorityQueue.offer(num);
            }
            priorityQueueList.add(priorityQueue);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (PriorityQueue<Integer> priorityQueue : priorityQueueList) {
                max = Math.max(max, priorityQueue.poll());
            }
            ans += max;
        }
        return ans;
    }


}
