package org.gzc.leetcode;

import org.gzc.leetcode.model.AuthenticationManager;

import java.text.ParseException;
import java.util.*;

/**
 * @author GZC
 */
public class Solution202302 {


    /**
     * 802. 迷路的机器人
     */

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 1797:
                AuthenticationManager authenticationManager = new AuthenticationManager(10);
                authenticationManager.generate("aaa", 10);
                authenticationManager.renew("bbb", 12);
                System.out.println(authenticationManager.countUnexpiredTokens(12));
                break;
            case 1604:
                System.out.println(alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}));
                break;
            case 1233:
                System.out.println(removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
                break;
            case 1234:
                System.out.println(balancedString("QWER"));
                break;
            case 1124:
                System.out.println(longestwpi(new int[]{9, 9, 6, 0, 6, 6, 9}));
                break;
            default:
                break;
        }
    }


    /**
     * 1124. 表现良好的最长时间段
     */
    public static int longestwpi(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<>(64);
        int s = 0, res = 0;
        for (int i = 0; i < n; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(s - 1)) {
                    res = Math.max(res, i - map.get(s - 1));
                }
            }
            if (!map.containsKey(s)) {
                map.put(s, i);
            }
        }
        return res;
    }

    /**
     * 1234. 替换子串得到平衡字符串
     */
    public static int balancedString(String s) {
        // 使用数组来存储四个字符的出现次数（使用数组便于代码书写）
        int[] counts = new int[26];
        // 字符串长度
        int len = s.length();
        // n / 4
        int limit = len / 4;
        char ch;
        // 初始化不替换内容字符出现次数数组，即初始滑动窗口维护一个空串
        for (int i = 0; i < len; i++) {
            ch = s.charAt(i);
            counts[ch - 'A']++;
        }
        // 初始化滑动窗口左右指针，维护的子串是[left,right]的内容
        // 初始化子串为空，因此left=0，right=-1表示一个空子串
        int left = 0;
        int right = -1;
        // 最小替换子串长度，初始为整个字符串长度
        int minLength = len;
        // 滑动窗口
        while (left < len) {
            // 校验通过
            if (check(counts, limit)) {
                // 记录当前合法子串的长度并更新最小长度
                // 左指针右移，那么原本左指针指向的字符就变成不替换的内容，不替换内容多了一个字符，对应count数组中的值加1
                minLength = Math.min(minLength, right - left + 1);
                counts[s.charAt(left++) - 'A']++;
            } else if (right < len - 1) {
                // 当前子串不合法且右指针还没到头
                // 右指针右移，移动后的右指针指向的字符变成了子串的内容，不替换的内容少了一个字符，对应count数组中的值减1
                counts[s.charAt(++right) - 'A']--;
            } else {
                // 右指针到头，搜索结束
                break;
            }
        }
        return minLength;

    }

    /**
     * 校验函数，校验当前counts中四个字符的出现次数是否都小于等于limit；
     * 是返回true，否返回false
     */
    private static boolean check(int[] counts, int limit) {
        return counts['Q' - 'A'] <= limit && counts['W' - 'A'] <= limit && counts['E' - 'A'] <= limit && counts['R' - 'A'] <= limit;
    }

    /**
     * 1233. 删除子文件夹
     */
    public static List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        for (String s : folder) {

            boolean flag = true;
            for (String an : ans) {
                if (s.startsWith(an) && '/' == s.charAt(an.length())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(s);
            }
        }
        return ans;
    }

    /**
     * 1604. 警告一小时内使用相同员工卡大于等于三次的人
     */
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<>();
        Map<String, List<Integer>> mapSet = new HashMap<>(10);
        int length = keyName.length;
        for (int i = 0; i < length; i++) {
            if (mapSet.containsKey(keyName[i])) {
                String[] split = keyTime[i].split(":");
                int hour = Integer.parseInt(split[0]);
                int min = Integer.parseInt(split[1]);
                mapSet.get(keyName[i]).add(hour * 60 + min);
            } else {
                List<Integer> treeSet = new ArrayList<>();
                String[] split = keyTime[i].split(":");
                int hour = Integer.parseInt(split[0]);
                int min = Integer.parseInt(split[1]);
                treeSet.add(hour * 60 + min);
                mapSet.put(keyName[i], treeSet);
            }
        }
        Set<Map.Entry<String, List<Integer>>> entries1 = mapSet.entrySet();
        for (Map.Entry<String, List<Integer>> stringListEntry : entries1) {
            List<Integer> value = stringListEntry.getValue();
            int size = value.size();
            if (size < 3) {
                continue;
            }
            value.sort(Integer::compareTo);
            int left = 0;
            int right = 0;
            while (right < size) {
                if (value.get(right) - value.get(left) <= 60) {
                    right++;
                } else {
                    left++;
                }
                if (right - left >= 3) {
                    String key = stringListEntry.getKey();
                    ans.add(key);
                    break;
                }
            }


        }
        ans.sort(String::compareTo);
        return ans;
    }


}
