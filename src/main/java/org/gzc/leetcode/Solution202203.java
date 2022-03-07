package org.gzc.leetcode;

import org.gzc.leetcode.model.RandomizedSet;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author GZC
 * @create 2022-03-03 21:59
 * @description 2022年三月 LeetCode代码练习
 */
public class Solution202203 {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int qusetionNum = input.nextInt();
        switch (qusetionNum){
            case 414:
                System.out.println(thirdMax(new int[]{1,2,3,4}));
                break;
            case 504:
                System.out.println(convertToBase7(12));
                break;
            case 389:
                RandomizedSet randomizedSet = new RandomizedSet();
                randomizedSet.insert(1);
            default:
                break;
        }

    }

    /**
     * 414. 第三大的数
     *
     * @param nums 数据
     * @return 第三大的数
     */
    public static int thirdMax(int[] nums) {
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
    public static String convertToBase7(int num) {
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
