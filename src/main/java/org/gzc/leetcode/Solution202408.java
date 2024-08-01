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
        long ans =0;
        int curIndex = 0;
        for (Integer index : list1) {
            for (int i = curIndex; i < list2.size(); i++) {
                if (index < list2.get(i)) {
                    ans += list2.size()-i;
                    curIndex = i;
                    break;
                }
            }
        }
        return ans+ Math.max(list1.size(),list2.size());

    }


}
