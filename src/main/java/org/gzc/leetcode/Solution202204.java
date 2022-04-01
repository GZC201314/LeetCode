package org.gzc.leetcode;

import java.util.*;

/**
 * @author GZC
 * @create 2022-03-03 21:59
 * @description 2022年三月 LeetCode代码练习
 */
public class Solution202204 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int qusetionNum = input.nextInt();
        switch (qusetionNum) {
            case 954:
                System.out.println(canReorderDoubled(new int[]{3,1,3,6}));
                break;
            default:
                break;
        }

    }

    /**
     * 954. 二倍数对数组
     *
     * @param arr 数组
     * @return 是否是二倍数对数组
     */
    public static boolean canReorderDoubled(int[] arr) {

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : arr) {
            cnt.put(num, cnt.getOrDefault(num, 0)+1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        List<Integer> absKey = new ArrayList<>(cnt.keySet());
        Collections.sort(absKey,new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return Math.abs(num1) - Math.abs(num2);
            }
        });

        for (int key : absKey) {
            if (cnt.getOrDefault(2 * key,0) < cnt.get(key)) {
                return false;
            }
            cnt.put(2 * key, cnt.getOrDefault(2 * key, 0) - cnt.get(key));
        }
        return true;
    }
}
