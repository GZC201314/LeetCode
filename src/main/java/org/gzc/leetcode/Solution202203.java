package org.gzc.leetcode;

import java.util.TreeSet;

/**
 * @author GZC
 * @create 2022-03-03 21:59
 * @desc 2022年三月 LeetCode代码练习
 */
public class Solution202203 {

    public static void main(String[] args) {

    }

    /**
     * 414. 第三大的数
     *
     * @param nums 数据
     * @return 第三大的数
     */
    public int thirdMax(int[] nums) {
        TreeSet<Integer> results = new TreeSet<>();
        for (int num :
                nums) {
            results.add(num);
            if (results.size() > 3) {
                results.remove(results.first());
            }
        }
        if (results.size() == 3) {
            return results.first();
        }
        return results.last();
    }


    /**
     * 504. 七进制数
     *
     * @param num 参数
     * @return 七进制数字符串
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        char flag = 0;
        if (num < 0) {
            flag = '-';
        }
        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (flag == '-') {
            sb.reverse().insert(0, '-');
        } else {
            sb.reverse();
        }
        return sb.toString();
    }
}
