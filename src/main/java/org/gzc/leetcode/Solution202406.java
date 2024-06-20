package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.*;

/**
 * @author GZC
 */
@Slf4j
public class Solution202406 {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 3121:
                log.info(String.valueOf(numberOfSpecialChars("cCceDC")));
                break;
            default:
                break;

        }


    }

    /**
     * 3121.统计特殊字母的数量 II
     */
    public static int numberOfSpecialChars(String word) {

        char[] chars = word.toCharArray();
        Set<Character> ansSet = new HashSet<>();
        Set<Character> existChar = new HashSet<>();
        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                // 之前存在大写字母
                if (existChar.contains(Character.toUpperCase(c))) {
                    ansSet.remove(c);
                }
                existChar.add(c);
            } else {
                // 大写字母
                if (existChar.contains(Character.toLowerCase(c))) {
                    if (!existChar.contains(c)) {
                        ansSet.add(Character.toLowerCase(c));
                    }
                }
                existChar.add(c);
            }
        }
        return ansSet.size();
    }


}
