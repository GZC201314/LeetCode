package org.gzc.leetcode;

import java.util.*;

/**
 * @author GZC
 * @description 十二月份的LeetCode练习代码
 */
public class Solution12 {

    public static int maxPower(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int maxPower = 1;
        int power = 1;
        char startChar = s.charAt(0);
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == startChar) {
                power++;
            } else {
                if (maxPower <= power) {
                    maxPower = power;
                }
                //如果比当前的最大值小
                power = 1;
                startChar = s.charAt(i);

            }
        }
        return Math.max(maxPower, power);
    }

    public static int superPow(int a, int[] b) {
        int len = b.length;
        return indexPow(a, b, len);
    }

    private static int indexPow(int a, int[] b, int len) {
        if (len < 1) {
            return 1;
        }
        int part1 = myPow(a, b[len - 1]);
        len--;
        int part2 = myPow(indexPow(a, b, len), 10);

        return part1 * part2 % 1337;
    }

    /*防止溢出*/
    private static int myPow(int a, int k) {
        a = a % 1337;
        int ans = 1;
        for (int i = 0; i < k; i++) {
            ans *= a;
            ans %= 1337;
        }
        return ans;
    }

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        if (n == 1) {
            return new String[]{"Gold Medal"};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(score[i], i);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int rank = 1;
        String[] res = new String[n];
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            int idx = entry.getValue();
            if (rank == 1) {
                res[idx] = "Gold Medal";
            } else if (rank == 2) {
                res[idx] = "Silver Medal";
            } else if (rank == 3) {
                res[idx] = "Bronze Medal";
            } else {
                res[idx] = "" + rank;
            }
            rank++;
        }
        return res;
    }

    public static String truncateSentence(String s, int k) {
        int n = s.length();
        int index = 0;
        while (index < n) {
            if (s.charAt(index) == ' ' && 0 == --k) {
                break;
            }
            index++;
        }
        return s.substring(0, index);
    }

    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] pos = new int[len1];
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> minHeap = new PriorityQueue<>(
                new Comparator<List<Integer>>() {
                    @Override
                    public int compare(List<Integer> integers, List<Integer> t1) {
                        return nums1[integers.get(0)] + nums2[integers.get(1)] - nums1[t1.get(0)] - nums2[t1.get(1)];
                    }
                }
        );
        for (int i = 0; i < Math.min(len1, k); i++) {
            minHeap.offer(new ArrayList<>(Arrays.asList(i, 0)));
        }

        while (res.size() < k && !minHeap.isEmpty()) {
            List<Integer> topNode = minHeap.poll();
            res.add(new ArrayList<>(Arrays.asList(nums1[topNode.get(0)], nums2[topNode.get(1)])));
            if(topNode.get(1)+1<len2){
                minHeap.offer(new ArrayList<>(Arrays.asList(topNode.get(0),topNode.get(1)+1)));
            }
        }
        return res;
    }

    static int N = 210;
    static int[][] cache = new int[N][N];

    public int getMoneyAmount(int n) {
        return dfs_getMoneyAmount(1,n);
    }
    public int dfs_getMoneyAmount(int l,int r){
        if(l>=r){
            return 0;
        }
        if(cache[l][r]!=0){
            return cache[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l; i <= r ; i++) {
            // 当选择的数位 x 时，至少需要 cur 才能猜中数字
            int cur = Math.max(dfs_getMoneyAmount(l,i-1),dfs_getMoneyAmount(i+1,r))+i;
            //在所有的决策中我们选择数值最小的一个
            ans = Math.min(ans,cur);
        }
        cache[l][r] = ans;
        return ans;

    }

}
