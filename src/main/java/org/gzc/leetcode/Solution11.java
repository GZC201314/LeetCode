package org.gzc.leetcode;

import java.util.*;

/**
 * @author GZC
 * @description 十一月份的LeetCode练习代码
 */
public class Solution11 {
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
     *
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
            if(res.size()+list[i].size()<=k){
                res.addAll(list[i]);
            }else{
                int size = k - res.size();

                res.addAll(list[i].subList(0,size));
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
