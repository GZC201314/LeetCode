package org.gzc.leetcode;

/**
 * @author GZC
 * @description 十一月份的LeetCode练习代码
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

    public static void main(String[] args) {
        System.out.println(maxPower("hooraaaaaaaaaaay"));
    }
}
