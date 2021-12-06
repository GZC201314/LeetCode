package org.gzc.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
        int index =0;
        while (index <n){
            if(s.charAt(index) == ' ' && 0 == --k){
                break;
            }
            index++;
        }
        return s.substring(0,index);
    }

    public static void main(String[] args) {
        System.out.println(superPow(2147483647, new int[]{2, 0, 0}));
    }
}
