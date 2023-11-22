package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author GZC
 */
@Slf4j
public class Solution202311 {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 318:
                log.info(String.valueOf(maxProduct(new String[]{"a1", "aa1", "aaa", "aaaa1"})));
                break;
            default:
                log.info(String.valueOf(maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})));
                break;

        }
    }

    /**
     * 318.最大单词长度乘积
     *
     * @param words 字符数组
     */
    public static int maxProduct(String[] words) {
        // 用于记录掩码对应的字符串的长度
        Map<Integer, Integer> map = new HashMap<>(64);
        for (String w : words) {
            // 用t的低26位表示该字符串26个字母是否出现过
            int t = 0;
            int m = w.length();
            for (int i = 0; i < m; i++) {
                int u = w.charAt(i) - 'a';
                t |= (1 << u);
            }
            // 多个相同的字符，缓存长度最大的
            map.put(t,Math.max(map.getOrDefault(t,0),m));
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> a : map.entrySet()) {
            for (Map.Entry<Integer, Integer> b : map.entrySet()) {
                int aKey = a.getKey();
                int bKey = b.getKey();
                if ((aKey & bKey) == 0) {
                    ans = Math.max(ans, a.getValue() * b.getValue());
                }
            }
        }
        return ans;
    }


}
