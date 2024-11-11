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
                log.info(String.valueOf(countBadPairs(new int[]{1, 2, 3, 4, 5})));
                break;
            case 491:
                log.info(String.valueOf(findSubsequences(new int[]{4, 6, 7, 7})));
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

    /**
     * 491. 非递减子序列
     */
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsFindSubsequences(nums, 0, path, res);
        return res;
    }

    private static void dfsFindSubsequences(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        Set<Integer> childSet = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (path.size() > 0 && path.get(path.size() - 1) > nums[i]) {
                continue;
            }
            // 去重，如果集合中已经存在该元素，则跳过
            if (childSet.contains(nums[i])) {
                continue;
            }
            childSet.add(nums[i]);
            path.add(nums[i]);
            dfsFindSubsequences(nums, i + 1, path, res);
            path.remove(path.size() - 1);

        }
    }

}





