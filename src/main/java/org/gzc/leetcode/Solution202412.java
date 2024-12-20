package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;


/**
 * @author GZC
 */
@Slf4j
public class Solution202412 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 423:
                log.info(originalDigits("fviefuro"));
                break;
            case 424:
                log.info(String.valueOf(characterReplacement("EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH", 7)));
                break;
            default:
                break;

        }


    }

    /**
     * 423. 从英文中重建数字
     */
    public static String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int[] nums = new int[10];
        // 微扰理论 寻找那些在字母中独一无二的字符，用于确定数字
        nums[0] = map.getOrDefault('z', 0);
        map.put('e', map.getOrDefault('e', 0) - nums[0]);
        map.put('r', map.getOrDefault('r', 0) - nums[0]);
        map.put('o', map.getOrDefault('o', 0) - nums[0]);

        nums[8] = map.getOrDefault('g', 0);
        map.put('e', map.getOrDefault('e', 0) - nums[8]);
        map.put('i', map.getOrDefault('i', 0) - nums[8]);
        map.put('h', map.getOrDefault('h', 0) - nums[8]);
        map.put('t', map.getOrDefault('t', 0) - nums[8]);


        nums[2] = map.getOrDefault('w', 0);
        map.put('t', map.getOrDefault('t', 0) - nums[2]);
        map.put('o', map.getOrDefault('o', 0) - nums[2]);

        nums[3] = map.getOrDefault('h', 0);
        map.put('t', map.getOrDefault('t', 0) - nums[3]);
        map.put('r', map.getOrDefault('r', 0) - nums[3]);
        map.put('e', map.getOrDefault('e', 0) - nums[3] - nums[3]);

        nums[6] = map.getOrDefault('x', 0);
        map.put('s', map.getOrDefault('s', 0) - nums[6]);
        map.put('i', map.getOrDefault('i', 0) - nums[6]);

        nums[7] = map.getOrDefault('s', 0);
        map.put('e', map.getOrDefault('e', 0) - nums[7] - nums[7]);
        map.put('v', map.getOrDefault('v', 0) - nums[7]);
        map.put('n', map.getOrDefault('n', 0) - nums[7]);

        nums[4] = map.getOrDefault('r', 0);
        map.put('f', map.getOrDefault('f', 0) - nums[4]);
        map.put('o', map.getOrDefault('o', 0) - nums[4]);
        map.put('u', map.getOrDefault('u', 0) - nums[4]);

        nums[5] = map.getOrDefault('v', 0);
        map.put('f', map.getOrDefault('f', 0) - nums[5]);
        map.put('e', map.getOrDefault('e', 0) - nums[5] - nums[5]);
        map.put('i', map.getOrDefault('i', 0) - nums[5]);

        nums[1] = map.getOrDefault('o', 0);
        map.put('n', map.getOrDefault('n', 0) - nums[1]);
        map.put('e', map.getOrDefault('e', 0) - nums[1]);

        nums[9] = map.getOrDefault('i', 0);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();


    }


    /**
     * 424. 替换后的最长重复字符
     */
    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int length = s.length();
        int sameMax =0;
        char[] charArray = s.toCharArray();
        int[] counter = new int[26];
        while (right < length) {
            counter[charArray[right]-'A']++;
            sameMax = Math.max(sameMax, counter[charArray[right] - 'A']);
            right++;
            if (right - left - sameMax > k) {
                counter[charArray[left] - 'A']--;
                left++;
            }
        }
        return right - left;
    }

}







