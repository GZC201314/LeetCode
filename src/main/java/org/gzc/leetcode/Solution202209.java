package org.gzc.leetcode;

import java.util.*;

/**
 * @author GZC
 */
public class Solution202209 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 416:
                System.out.println(canPartition(new int[] {9, 79, 2, 4, 8, 16, 32, 64, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100}));
                System.out.println(canPartition1(new int[] {19, 79, 2, 4, 8, 16, 32, 64, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                    100, 100, 100, 100}));
                case 435:
                    System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{-100,-2},{5,7}}));
                    break;
                case 446:
                    System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,5,67,7}));
                    break;
                case 670:
                    System.out.println(maximumSwap(2736));
                    break;
                case 458:
                    System.out.println(poorPigs(4,15,15));
                    break;
            default:
                break;
        }

    }

    /**
     * 670. 最大交换
     */
    public static int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num >0 ) {
            int mod = num%10;
            num /= 10;
            list.add(mod);
        }
        dfsMaximumSwap(list, list.size()-1, 0);
        int result = 0;

        for (int i = list.size()-1; i >=0 ; i--) {
            result = result*10+list.get(i);
        }
        return result;


    }

    public static void dfsMaximumSwap(List<Integer> list,int left, int right){
        if (left == right){
            return;
        }

        int max = -1;
        for (int i = right; i <= left; i++) {
            if (list.get(i) > max){
                max = list.get(i);
            }
        }
        // 从左往右找第一个不是最大值的数，从右向左找是最大值的第一个数
        // 分两种情况进行讨论 第一种 最高位是最大值 第二种 最高位不是最大值
        if (list.get(left) == max){
           dfsMaximumSwap(list,left-1,right);
        }else {
            while (left>=0){
                if (list.get(left--)!=max){
                    break;
                }
            }
            left++;
            while (right<=left){
                if (list.get(right++) == max){
                    break;
                }
            }
            right--;
            if (left>right){
                Integer integer = list.get(left);
                Integer integer1 = list.get(right);
                list.set(left, integer1);
                list.set(right, integer);
            }
        }
    }

    /**
     * 458. 可怜的小猪
     */
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int times = minutesToTest/minutesToDie+1;
        return (int) Math.ceil(Math.log(buckets)/Math.log(times)-1e-5);

    }

    /**
     * 446. 等差数列划分 II - 子序列
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int n = nums.length;
        // 用于记录以i结尾公差为d的伪等差数列的个数（任意两个数都是伪等差数列）
        Map<Long,Integer>[] dpMap = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dpMap[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[j]-nums[i];
                Integer count = dpMap[j].getOrDefault(d, 0);
                result += count;

                // 加一是为了统计两个数的等差数列
                dpMap[i].put(d, dpMap[i].getOrDefault(d,0)+count+1);
            }
        }
        return result;

    }

    /**
     * 435. 无重叠区间
     */
    public static int eraseOverlapIntervals(int[][] intervals) {

        List<EraseOverlapIntervalsClass> sortedList = new ArrayList<>();

        for (int[] interval : intervals) {
            sortedList.add(new EraseOverlapIntervalsClass(interval[0], interval[1]));
        }
        sortedList.sort((o1, o2) -> o1.right == o2.right ? o1.left - o2.left : o1.right - o2.right);

        int curRight = Integer.MIN_VALUE;
        int count = 0;
        for (EraseOverlapIntervalsClass eraseOverlapIntervalsClass : sortedList) {
            if (curRight != eraseOverlapIntervalsClass.right){
                if (eraseOverlapIntervalsClass.left>=curRight){
//                    lastRight = curRight;
                    curRight = eraseOverlapIntervalsClass.right;
                }else {
                    count++;
                }
            }else {
                count++;
            }
        }

        return count;

    }

    static class EraseOverlapIntervalsClass {
        int left;
        int right;

        public EraseOverlapIntervalsClass(int left, int right){
            this.left = left;
            this.right = right;
        }

    }

    /**
     * 416. 分割等和子集
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2; // dp[i][j]代表可装物品为0-i，背包容量为j的情况下，背包内容量的最大价值
        int[][] dp = new int[nums.length][target + 1];
        // 初始化,dp[0][j]的最大价值nums[0](if j > weight[i]) //dp[i][0]均为0，不用初始化
        for (int j = nums[0]; j <= target; j++) {
            dp[0][j] = nums[0];
        }
        // 遍历物品，遍历背包 //递推公式:
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 背包容量可以容纳nums[i]
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target] == target;
    }

    /**
     * 返回nums[i...]是否可以组成rest 剪枝
     */
    public static boolean canPartition1(int[] nums) {

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }

        if ((sum[nums.length - 1] & 1) == 1) {
            return false;
        }
        return canPartitionDfs(nums, 0, sum[nums.length - 1] / 2, sum);

    }

    /**
     * 返回nums[i...]是否可以组成rest 剪枝
     */
    static Map<CanPartitionInfo, Boolean> dbMap = new HashMap<>();

    public static boolean canPartitionDfs(int[] nums, int i, int rest, int[] sum) {
        // if (rest == 0) {
        // return true;
        // }
        if (rest < 0) {
            return false;
        }
        if (i >= nums.length) {
            return false;
        }

        if (dbMap.get(new CanPartitionInfo(i, rest)) != null) {
            return dbMap.get(new CanPartitionInfo(i, rest));
        }
        if (rest == nums[i]) {
            dbMap.put(new CanPartitionInfo(i, rest), true);
            return true;
        }
        if (i != 0 && sum[sum.length - 1] - sum[i - 1] < rest) {
            dbMap.put(new CanPartitionInfo(i, rest), false);
            return false;
        }

        // 分两种情况 nums[i] 要 nums[i] 不要
        boolean p1 = canPartitionDfs(nums, i + 1, rest - nums[i], sum);
        boolean p2 = canPartitionDfs(nums, i + 1, rest, sum);
        boolean result = p1 || p2;
        dbMap.put(new CanPartitionInfo(i, rest), result);
        dbMap.put(new CanPartitionInfo(i + 1, rest), p1);
        dbMap.put(new CanPartitionInfo(i + 1, rest - nums[i]), p2);
        return result;
    }

    static class CanPartitionInfo {
        int index;
        int rest;

        public CanPartitionInfo(int index, int rest) {
            this.index = index;
            this.rest = rest;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            CanPartitionInfo that = (CanPartitionInfo)o;
            return index == that.index && rest == that.rest;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, rest);
        }
    }

}
