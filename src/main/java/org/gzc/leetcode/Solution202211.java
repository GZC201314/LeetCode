package org.gzc.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author GZC
 */
public class Solution202211 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 816:
                System.out.println(ambiguousCoordinates("(0012)"));
                break;
            default:
                break;
        }
    }

    /**
     * 816. 模糊坐标
     */
    public static List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        String replace = s.replace("(", "").replace(")", "");
        int n = replace.length();
        for (int i = 1; i < n; i++) {
            for (String num1 : getNums(replace.substring(0, i))) {
                for (String num2 : getNums(replace.substring(i, n))) {
                    result.add("("+num1+","+num2+")");
                }
            }
        }
        return result;
    }

    public static List<String> getNums(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            // 正数部分
            String zheng = s.substring(0, i);
            String xiao = s.substring(i);
            if (zheng.startsWith("0")&& (Integer.parseInt(zheng)!=0|| zheng.length()>1 )|| xiao.endsWith("0")){
                continue;
            }
            if ("".equals(xiao)){
                result.add(zheng);
            }else {
                result.add(zheng+"."+xiao);
            }
        }
        return result;
    }
}
