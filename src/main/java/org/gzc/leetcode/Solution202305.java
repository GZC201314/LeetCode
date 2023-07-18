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
            case 16:
                System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
                break;
            case 1911:
                System.out.println(maxAlternatingSum(new int[]{5, 6, 7, 8}));
                break;
            case 1442:
                System.out.println(countTriplets(new int[]{1, 1, 1, 1, 1}));
                break;
            case 2460:
                System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 3})));
                break;
            case 2461:
                System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 3})) + " ");
                break;
            case 2679:
                System.out.println(matrixSum(new int[][]{{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}}));
                break;
            case 931:
                System.out.println(minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
                break;
            case 2600:
                System.out.println(kItemsWithMaximumSum(3, 2, 3));
            case 2544:
                System.out.println(alternateDigitSum(521));
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
     *
     * @param numOnes  1的个数
     * @param numZeros 0的个数
     * @param k        取值数
     * @return 最大和
     */
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int k) {
        int sum = numOnes + numZeros;
        if (sum >= k) {
            return Math.min(numOnes, k);
        }
        return numOnes - (k - sum);
    }

    /**
     * 16.最接近的三数之和
     *
     * @param nums   参数数组
     * @param target 目标值
     * @return 最接近目标值的三数和
     */
    public static int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            int mid = nums[i];
            int left = i - 1;
            int right = i + 1;
            int sum = mid + nums[left] + nums[right];

            while (sum <= target && right <= n) {
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                right++;
                if (right < n) {
                    sum = sum - nums[right - 1] + nums[right];
                }
            }

            while (sum >= target && left >= 0) {
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                left--;
                if (left >= 0) {
                    sum = sum - nums[left + 1] + nums[left];
                }
            }
            if (Math.abs(target - sum) < Math.abs(target - ans)) {
                ans = sum;
            }
        }
        return ans;
    }

    /**
     * 1911.最大子序列交替和
     *
     * @param nums 参数数组
     * @return 子序列最大交替和
     */
    public static long maxAlternatingSum(int[] nums) {

        int n = nums.length;
        long[][] dp = new long[n][2];
        dp[0][0] = nums[0];
        //dp[i][0]表示[0, i]范围内构造的长度为偶数的子序列的最大交替和，
        // dp[i][1]表示[0, i]范围内构造的长度为奇数的子序列的最大交替和。
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - nums[i], dp[i - 1][1]);

        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 2544. 交替数字和
     *
     * @param n 参数
     * @return 交替数字和
     */
    public static int alternateDigitSum(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 10);
            n /= 10;
        }
        int ans = 0;
        int flag = 1;
        while (!stack.isEmpty()) {
            ans += (flag * stack.pop());
            flag *= -1;
        }
        return ans;
    }

    /**
     * 931.下降路径最小和
     *
     * @param matrix 参数矩阵
     * @return 下降路径最小和
     */
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0] = matrix[0];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 计算三个方向的和
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + matrix[i][j];
                }

            }
        }
        int ans = Integer.MAX_VALUE;
        for (int num : dp[m - 1]) {
            ans = Math.min(num, ans);
        }
        return ans;
    }

    /**
     * 1442. 形成两个异或相等数组的三元组数目
     *
     * @param arr 数字数组
     * @return 异或相等数组个数
     */
    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int[] xor = new int[n];
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            cur = cur ^ arr[i];
            xor[i] = cur;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {

                    int a = xor[j - 1] ^ (i == 0 ? 0 : xor[i - 1]);
                    int b = xor[k] ^ xor[j - 1];
                    if (a == b) {
                        ans++;
                    }
                }
            }
        }
        return ans;

    }


}
