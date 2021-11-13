package org.gzc.leetcode;

import java.util.*;

/**
 * @author GZC
 * @description 十一月份的LeetCode练习代码
 */
public class Solution11 {
    /**
     * 495. 提莫攻击
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int prisonTimeStart = 0;
        int prisonTimeEnd = 0;
        int prisonSum = 0;
        for (Integer timeSerie : timeSeries) {
            if (prisonTimeEnd <= timeSerie) {
                prisonSum += (prisonTimeEnd - prisonTimeStart);
                prisonTimeStart = timeSerie;
                prisonTimeEnd = timeSerie + duration;
            } else if (prisonTimeEnd < (timeSerie + duration)) {
                prisonTimeEnd = timeSerie + duration;
            }
        }
        prisonSum += (prisonTimeEnd - prisonTimeStart);
        return prisonSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4};
        System.out.println(findPoisonedDuration(arr, 2));
    }

    /**
     * 343. 整数拆分
     * <p>
     * 算法 动态规划
     * <p>
     * 转移方程:
     * dp[i]= 1≤j<i max{max(j×(i−j),j×dp[i−j])} 其中dp[i] 表示整数i拆分后的最大乘积
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    /**
     * 347. 前K个高频元素
     * <p>
     * map 加 桶排序
     */
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        /*使用map ,统计每个元素出现的次数*/
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num :
                nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        /*桶排序*/
        //将频率作为数组下标,对于出现频率不同的数字集合,存入对应的数组下表
        ArrayList<Integer>[] list = new ArrayList[nums.length + 1];

        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }

        //倒序遍历数组获取出现顺序从大到小的排列

        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) {
                continue;
            }
            if (res.size() + list[i].size() <= k) {
                res.addAll(list[i]);
            } else {
                int size = k - res.size();

                res.addAll(list[i].subList(0, size));
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 520. 检测大写字母
     */
    public boolean detectCapitalUse(String word) {
        //如果所有的字母都是大写字母
        if (word.toUpperCase().equals(word) || word.toLowerCase().equals(word)) {
            return true;
        }
        //如果首字母是大写
        if ('A' <= word.charAt(0) && word.charAt(0) <= 'Z') {
            String substring = word.substring(1);
            if (substring.toLowerCase().equals(substring)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 357. 计算各个位数不同的数字个数
     * <p>
     * 算法思路 动态规划
     * <p>
     * 比如，个位数中各个位数不同的数字个数为9（这里0不算个位数），
     * <p>
     * 那么两位数中各个位数不同的数字就是在这9个数的后面插入另一个不同的数字，
     * <p>
     * 所以个数为9 * 9 = 81。可能有人问，为什么只在后面插，不在前面插，这是因为会重复，
     * <p>
     * 比如1后插2等于2前面插1。而在1前面插0就不是两位数了，已经算在了个位数里。
     * <p>
     * <p>
     * 转移方程:dp[i] = dp[i-1]*(11-i);
     */
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 1;
        }
        dp[0] = 1;
        dp[1] = 9;
        int sum = dp[0] + dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * (11 - i);
            sum += dp[i];
        }

        return sum;
    }
}
