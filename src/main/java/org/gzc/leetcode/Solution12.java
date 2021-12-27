package org.gzc.leetcode;

import java.util.*;

/**
 * @author GZC
 * @description 十二月份的LeetCode练习代码
 */
public class Solution12 {

    static int N = 210;
    static int[][] cache = new int[N][N];

    public static int maxPower(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int maxPower = 1;
        int power = 1;
        char startChar = s.charAt(0);
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == startChar) {
                power++;
            } else {
                if (maxPower <= power) {
                    maxPower = power;
                }
                //如果比当前的最大值小
                power = 1;
                startChar = s.charAt(i);

            }
        }
        return Math.max(maxPower, power);
    }

    public static int superPow(int a, int[] b) {
        int len = b.length;
        return indexPow(a, b, len);
    }

    private static int indexPow(int a, int[] b, int len) {
        if (len < 1) {
            return 1;
        }
        int part1 = myPow(a, b[len - 1]);
        len--;
        int part2 = myPow(indexPow(a, b, len), 10);

        return part1 * part2 % 1337;
    }

    /*防止溢出*/
    private static int myPow(int a, int k) {
        a = a % 1337;
        int ans = 1;
        for (int i = 0; i < k; i++) {
            ans *= a;
            ans %= 1337;
        }
        return ans;
    }

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        if (n == 1) {
            return new String[]{"Gold Medal"};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(score[i], i);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int rank = 1;
        String[] res = new String[n];
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            int idx = entry.getValue();
            if (rank == 1) {
                res[idx] = "Gold Medal";
            } else if (rank == 2) {
                res[idx] = "Silver Medal";
            } else if (rank == 3) {
                res[idx] = "Bronze Medal";
            } else {
                res[idx] = "" + rank;
            }
            rank++;
        }
        return res;
    }

    public static String truncateSentence(String s, int k) {
        int n = s.length();
        int index = 0;
        while (index < n) {
            if (s.charAt(index) == ' ' && 0 == --k) {
                break;
            }
            index++;
        }
        return s.substring(0, index);
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };
        System.out.println(isSubsequence("b", "abc"));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] pos = new int[len1];
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> minHeap = new PriorityQueue<>(
                (integers, t1) -> nums1[integers.get(0)] + nums2[integers.get(1)] - nums1[t1.get(0)] - nums2[t1.get(1)]
        );
        for (int i = 0; i < Math.min(len1, k); i++) {
            minHeap.offer(new ArrayList<>(Arrays.asList(i, 0)));
        }

        while (res.size() < k && !minHeap.isEmpty()) {
            List<Integer> topNode = minHeap.poll();
            res.add(new ArrayList<>(Arrays.asList(nums1[topNode.get(0)], nums2[topNode.get(1)])));
            if (topNode.get(1) + 1 < len2) {
                minHeap.offer(new ArrayList<>(Arrays.asList(topNode.get(0), topNode.get(1) + 1)));
            }
        }
        return res;
    }

    /**
     * 807. 保持城市天际线
     */
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int hang = grid.length;
        if (hang == 0) {
            return 0;
        }
        int lie = grid[0].length;
        int[] hangMax = new int[hang];
        int[] lieMax = new int[lie];
        for (int i = 0; i < hang; i++) {
            int max = grid[i][0];
            for (int j = 1; j < lie; j++) {
                if (max < grid[i][j]) {
                    max = grid[i][j];
                }
            }
            hangMax[i] = max;
        }
        for (int i = 0; i < lie; i++) {
            int max = grid[0][i];
            for (int j = 1; j < hang; j++) {
                if (max < grid[j][i]) {
                    max = grid[j][i];
                }
            }
            lieMax[i] = max;
        }
        int result = 0;
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                result += Math.min(hangMax[i] - grid[i][j], lieMax[j] - grid[i][j]);
            }
        }
        return result;
    }

    public static int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][2];
        int i = 1;
        while (i < length) {
            if (nums[i] > nums[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][0] + 1;
            } else if (nums[i] < nums[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
            i++;
        }
        return Math.max(dp[i - 1][0], dp[i - 1][1]) + 1;
    }

    public static boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        if (sLen == 0) {
            return true;
        }
        int tLen = t.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sIndex = 0;
        int tIndex = 0;
        while (tIndex < tLen) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
                if (sIndex == sLen) {
                    return true;
                }
            } else {
                tIndex++;
            }
        }
        return sIndex == sLen;
    }

    public int getMoneyAmount(int n) {
        return dfs_getMoneyAmount(1, n);
    }

    public int dfs_getMoneyAmount(int l, int r) {
        if (l >= r) {
            return 0;
        }
        if (cache[l][r] != 0) {
            return cache[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            // 当选择的数位 x 时，至少需要 cur 才能猜中数字
            int cur = Math.max(dfs_getMoneyAmount(l, i - 1), dfs_getMoneyAmount(i + 1, r)) + i;
            //在所有的决策中我们选择数值最小的一个
            ans = Math.min(ans, cur);
        }
        cache[l][r] = ans;
        return ans;

    }

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {

            String newString = s.replaceFirst(String.valueOf(s.charAt(i)), "");
            if (!newString.contains(String.valueOf(s.charAt(i)))) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public char findTheDifference(String s, String t) {
        int sLen = s.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sLen + 1; i++) {
            map.put(tChars[i], map.getOrDefault(tChars[i], 0) + 1);
        }
        for (int i = 0; i < sLen; i++) {
            int count = map.get(sChars[i]) - 1;
            if (count == 0) {
                map.remove(sChars[i]);
            } else {
                map.put(sChars[i], count);
            }
        }
        return map.keySet().stream().findFirst().get();
    }

    public int dayOfYear(String date) {
        int[] monthDays = new int[]{
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };
        String[] dates = date.split("-");

        int year = Integer.parseInt(dates[0]);
        int mouth = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        int result = 0;
        for (int i = 0; i < mouth - 1; i++) {
            result += monthDays[i];
        }
        if (mouth > 2) {
            if ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
                result += 1;
            }
        }
        return result += day;

    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6, m = i & 63;
            // 用位运算取出高 4 位和低 6 位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int left = 0, right = 0, result = 0;
        for (int age :
                ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                left++;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                right++;
            }
            result += right - left;
        }
        return result;
    }

}
