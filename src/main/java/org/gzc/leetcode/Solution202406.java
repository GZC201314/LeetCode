package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.gzc.leetcode.model.MyTree;

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
            case 1763:
                log.info(String.valueOf(longestNiceSubstring("DBb")));
                break;
            case 3121:
                log.info(String.valueOf(numberOfSpecialChars("cCceDC")));
                break;
            case 2734:
                log.info(smallestString("cbabc"));
                break;
            case 784:
                log.info(String.valueOf(letterCasePermutation("3z4")));
                break;
            case 3186:
                log.info(String.valueOf(maximumTotalDamage(new int[]{3, 4, 8, 10, 8, 8, 3})));
                break;
            case 283:
                moveZeroes(new int[]{3, 4, 8, 10, 8, 8, 3});
                break;
            case 406:
                int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
                log.info(Arrays.toString(reconstructQueue1(people)));
                log.info(Arrays.toString(reconstructQueue(people)));
                break;
            case 503:
                log.info(String.valueOf(reverseBits(-2)));
                break;
            case 3111:
                log.info(String.valueOf(minRectanglesToCoverPoints(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}}, 2)));
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
            } else {
                // 大写字母
                if (existChar.contains(Character.toLowerCase(c)) && (!existChar.contains(c))) {
                    ansSet.add(Character.toLowerCase(c));

                }
            }
            existChar.add(c);
        }
        return ansSet.size();
    }

    /**
     * 3111.覆盖所有点的最少矩形数目
     */
    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int n = points.length;
        int len = points[0][0] + w;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (len >= points[i][0]) {
                continue;
            }
            len = points[i][0] + w;
            ans++;
        }
        return ans;
    }

    /**
     * 1763.最长的美好子字符串
     */
    public static String longestNiceSubstring(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String substring = s.substring(i, j + 1);
                Set<Character> validChars = new HashSet<>();
                Set<Character> existChars = new HashSet<>();

                for (char c : substring.toCharArray()) {
                    if (Character.isLowerCase(c)) {
                        if (existChars.contains(Character.toUpperCase(c))) {
                            validChars.remove(Character.toUpperCase(c));
                        } else {
                            validChars.add(c);
                        }
                        existChars.add(c);
                    } else {
                        if (existChars.contains(Character.toLowerCase(c))) {
                            validChars.remove(Character.toLowerCase(c));
                        } else {
                            validChars.add(c);
                        }
                        existChars.add(c);
                    }
                }
                if (validChars.isEmpty()) {
                    ans = ans.length() < substring.length() ? substring : ans;
                }


            }
        }
        return ans;

    }

    /**
     * 2734.执行子串操作后的字典序最小字符串
     */
    public static String smallestString(String s) {
        char[] chars = s.toCharArray();
        int i;
        boolean flag = false;
        for (i = 0; i < chars.length; i++) {
            if (chars[i] != 'a') {
                // 找到第一个不为a的字符
                flag = true;
                while (i < chars.length && chars[i] != 'a') {
                    chars[i] = (char) (chars[i] - 1);
                    i++;
                }
                break;
            }
        }
        if (i == chars.length && !flag) {
            chars[i - 1] = 'z';
        }
        return String.valueOf(chars);

    }

    /**
     * 面试题 05.03 翻转数位
     */
    public static int reverseBits(int num) {
        int ans = 0;
        // 状态矩阵 dp[i][0] 表示0->没有零转化的连续1的个数 dp[i][1]表示0->有零转化的连续1的个数
        int[][] dp = new int[32][2];
        if ((num & 1) == 1) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }
        dp[0][1] = 1;
        for (int i = 1; i < 32; i++) {
            int bit = (num >> i) & 1;
            if (bit == 1) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][0] + 1;
                ans = Math.max(Math.max(ans, dp[i][1]), dp[i - 1][1]);
            }
        }
        ans = Math.max(Math.max(ans, dp[31][0]), dp[31][1]);

        return ans;

    }

    /**
     * 3186.施咒的最大总伤害
     */
    public static long maximumTotalDamage(int[] power) {
        // 排序
        Arrays.sort(power);
        // 统计个数
        Map<Integer, Integer> map = new HashMap<>();
        // 去重
        List<Integer> single = new ArrayList<>();
        for (int i : power) {
            Integer count = map.getOrDefault(i, 0);
            if (count == 0) {
                single.add(i);
            }
            map.put(i, count + 1);
        }
        long[][] dp = new long[map.size()][2];
        // dp[i][0] 当前节点不选的情况下，0->i-1个节点的伤害
        // dp[i][1] 当前节点选的情况下，0->i-1个节点的伤害
        // 转移方程
        dp[0][0] = (long) single.get(0) * map.get(single.get(0));
        for (int i = 1; i < single.size(); i++) {
            // 转移方程，向左找，第一个帮助情况的值
            int tmpI = i;
            while (tmpI >= 0) {
                if (single.get(tmpI) >= single.get(i) - 2) {
                    tmpI--;
                } else {
                    break;
                }
            }
            if (tmpI >= 0) {
                if (single.get(tmpI) == single.get(i) - 2) {
                    dp[i][0] = Math.max(dp[tmpI][0], dp[tmpI + 1][1]) + (long) single.get(i) * map.get(single.get(i));
                } else {
                    dp[i][0] = Math.max(dp[tmpI][0], dp[tmpI][1]) + (long) single.get(i) * map.get(single.get(i));
                }
            } else {
                dp[i][0] = (long) single.get(i) * map.get(single.get(i));
            }
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[single.size() - 1][0], dp[single.size() - 1][1]);
    }

    /**
     * 406.根据身高重建队列
     */
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            if (person[1] == 0) {
                ans.add(0, person);
            } else {
                int count = person[1];
                int size = ans.size();
                for (int j = 0; j < size; j++) {
                    if (ans.get(j)[0] >= person[0]) {
                        count--;
                        if (count == 0) {
                            ans.add(j + 1, person);
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            people[i] = ans.get(i);
        }

        return people;
    }

    public static int[][] reconstructQueue1(int[][] people) {
        final int n = people.length;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = people[i][0] << 11 | (n - people[i][1]);
        }
        Arrays.sort(nums);

        MyTree tree = new MyTree(n);
        int mask = (1 << 11) - 1;
        int[][] ans = new int[n][];
        for (int num : nums) {
            int hi = num >> 11;
            int ki = n - (num & mask);
            int left = 1;
            int right = n;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (tree.query(mid) > ki) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            tree.remove(right);
            ans[right - 1] = new int[]{hi, ki};
        }
        return ans;
    }

    /**
     * 283.移动零
     */
    public static void moveZeroes(int[] nums) {
        // 不为零的分界线
        int left = 0;
        // 寻找不为零的指针
        int right = 0;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        while (left < nums.length) {
            nums[left++] = 0;
        }
    }

    /**
     * 784.字母大小写全排列
     */
    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() == 0) {
            return ans;
        }
        char[] chars = s.toCharArray();
        dfsLetterCasePermutation(chars, 0, ans, "");
        return ans;
    }

    private static void dfsLetterCasePermutation(char[] chars, int i, List<String> ans, String base) {
        if (i == chars.length) {
            ans.add(base);
            return;
        }
        if (chars[i] >= '0' && chars[i] <= '9') {
            dfsLetterCasePermutation(chars, i + 1, ans, base + chars[i]);
        } else {
            dfsLetterCasePermutation(chars, i + 1, ans, base + Character.toLowerCase(chars[i]));
            dfsLetterCasePermutation(chars, i + 1, ans, base + Character.toUpperCase(chars[i]));
        }
    }

}
