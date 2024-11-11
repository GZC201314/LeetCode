package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.*;


/**
 * @author GZC
 */
@Slf4j
public class Solution202411 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 2364:
                System.out.println(countBadPairs(new int[]{1, 2, 3, 4, 5}));
                break;
            default:
                break;

        }


    }

    /**
     * 2364. 统计坏数对的数目
     */
    public static long countBadPairs(int[] nums) {
        int n = nums.length;
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = nums[i] - i;
            if (map.containsKey(count)) {
                res += map.get(count);
                map.put(count, map.get(count) + 1);
            } else {
                map.put(count, 1);
            }
        }
        return ((long) n * (n - 1)) / 2 - res;
    }
}




