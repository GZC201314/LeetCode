package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author GZC
 */
@Slf4j
public class Solution202408 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 2207:
                log.info(String.valueOf(maximumSubsequenceCount("aabb", "ab")));
                break;
            case 1954:
                log.info(String.valueOf(minimumPerimeter(13)));
                break;
            case 3129:
                log.info(String.valueOf(numberOfStableArrays(1, 2, 1)));
                break;
            default:
                break;

        }


    }

    /**
     * 2207. 字符串中最多数目的子序列
     */
    public static long maximumSubsequenceCount(String text, String pattern) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == pattern.charAt(0)) {
                list1.add(i);
            }
            if (charArray[i] == pattern.charAt(1)) {
                list2.add(i);
            }
        }
        long ans = 0;
        int curIndex = 0;
        for (Integer index : list1) {
            for (int i = curIndex; i < list2.size(); i++) {
                if (index < list2.get(i)) {
                    ans += list2.size() - i;
                    curIndex = i;
                    break;
                }
            }
        }
        return ans + Math.max(list1.size(), list2.size());
    }

    /**
     * 1954. 收集足够苹果的最小花园周长
     */
    public static long minimumPerimeter(long neededApples) {
        // 前n个花园的苹果的个数 appleNum = 2i*(i+1)*(2i+1)
        long i = 0;
        while (2 * i * (i + 1) * (2 * i + 1) < neededApples) {
            i++;
        }
        return (i * 2) * 4;
    }

    /**
     * 3129. 找出所有稳定的二进制数组 I
     */
    public static int numberOfStableArrays(int zero, int one, int limit) {
        final int mod = 1_000_000_007;
        int[][][] f = new int[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(limit, zero); i++) {
            f[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(limit, one); j++) {
            f[0][j][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // + mod 保证答案非负
                f[i][j][0] = (int) (((long) f[i - 1][j][0] + f[i - 1][j][1] + (i > limit ? mod - f[i - limit - 1][j][1] : 0)) % mod);
                f[i][j][1] = (int) (((long) f[i][j - 1][0] + f[i][j - 1][1] + (j > limit ? mod - f[i][j - limit - 1][0] : 0)) % mod);
            }
        }
        return (f[zero][one][0] + f[zero][one][1]) % mod;
    }


}
