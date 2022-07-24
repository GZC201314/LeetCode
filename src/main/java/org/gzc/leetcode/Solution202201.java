package org.gzc.leetcode;

import org.gzc.leetcode.model.TreeNode;

import java.util.*;

/**
 * @author GZC
 * @description 十二月份的LeetCode练习代码
 */
public class Solution202201 {

    public static int lengthOfLongestSubstring(String s) {
        // write code here
        int maxLen = 0;
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                len++;
            } else {//如果含有该字符
                // 查找含有该字符
                maxLen = Math.max(maxLen, len);

                Integer index = map.get(s.charAt(i));
                // 把之前的元素全部移除掉,在新增新的元素
                map.clear();
                for (int j = index; j <= i; j++) {
                    map.put(s.charAt(j),j);
                }
                len = i - index;
            }
        }
        return Math.max(maxLen, len);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcd"));
    }
}
