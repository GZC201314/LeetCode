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
            case 2600:
                System.out.println(kItemsWithMaximumSum(3,2,3));
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
        List<PriorityQueue<Integer>> priorityQueueList = new ArrayList<>();
        for (int[] ints : nums) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int num : ints) {
                priorityQueue.offer(num);
            }
            priorityQueueList.add(priorityQueue);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (PriorityQueue<Integer> priorityQueue : priorityQueueList) {
                Integer num = priorityQueue.poll();
                if (Objects.nonNull(num)) {
                    max = Math.max(max, num);
                }
            }
            ans += max;
        }
        return ans;
    }

    /**
     * 2600. K件物品的最大值
     * @param numOnes 1的个数
     * @param numZeros 0的个数
     * @param k 取值数
     * @return 最大和
     */
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int k) {
        int sum = numOnes + numZeros;
        if (sum>=k){
            return Math.min(numOnes,k);
        }
        return numOnes-(k-sum);
    }


}
