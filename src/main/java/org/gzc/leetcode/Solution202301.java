package org.gzc.leetcode;

import java.util.Scanner;

/**
 * @author GZC
 */
public class Solution202301 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {

            case 2042:
                System.out.println(areNumbersAscending("sunset is at 7 50 pm overnight lows will be in the low 51 and 60 s"));
                break;
            default:
                break;
        }
    }

    /**
     * 2042. 检查橘子中的数字是否递增
     */
    public static boolean areNumbersAscending(String s) {
        final char[] sChrs = s.toCharArray();
        long cur = 0;
        long preNum = Long.MIN_VALUE;
        for (char sChr : sChrs) {
            if (Character.isDigit(sChr)){
                cur = cur*10+(sChr - '0');
            }else {
                if (cur != 0){
                    if (cur<=preNum){
                        return false;
                    }
                    preNum = cur;
                    cur =0;
                }
            }
        }
        if (cur != 0){
            return cur > preNum;
        }
        return true;
    }




}
