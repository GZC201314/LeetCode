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
            case 2351:
                System.out.println(repeatedCharacter("QWER"));
                break;
            case 1124:
                System.out.println(longestwpi(new int[]{9, 9, 6, 0, 6, 6, 9}));
                break;
            case 1491:
                System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
                break;
            case 1139:
                System.out.println(largest1BorderedSquare(new int[][]{{0, 1, 1, 1, 1, 0}, {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}}));
                break;
            case 1901:
                System.out.println(Arrays.toString(findPeakGrid(new int[][]{{1, 4}, {3, 2}})));
                break;
            case 2373:
                System.out.println(Arrays.toString(largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}})));
                break;
            case 1792:
                System.out.println(maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {1, 1}}, 4));
                break;
            case 2363:
                System.out.println(mergeSimilarItems(new int[][]{{1, 2}, {3, 5}, {1, 1}}, new int[][]{{1, 2}, {3, 5}, {1, 1}}));
                break;
            case 2341:
                System.out.println(Arrays.toString(numberOfPairs(new int[]{9, 9, 6, 0, 6, 6, 9})));
                break;
            case 1140:
                System.out.println(stoneGame2(new int[]{9, 9, 6, 0, 6, 6, 9}));
                break;
            case 2357:
                System.out.println(minimumOperations(new int[]{9, 9, 6, 0, 6, 6, 9}));
                break;
            case 1144:
                System.out.println(movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
                break;
            case 1238:
                System.out.println(circularPermutation(2, 3));
                break;
            case 1247:
                System.out.println(minimumSwap("xxxx", "yyyy"));
                break;
            case 1689:
                System.out.println(minPartitions("128"));
                break;
            case 1653:
                System.out.println(minimumDeletions("aababbab"));
                break;
            case 2347:
                System.out.println(bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}));
                break;
            default:
                break;
        }
    }

    /**
     * 1653. 使字符串平衡的最少删除次数
     */
    public static int minimumDeletions(String s) {
        int dp = 0, bNum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                ++bNum;
            } else {
                dp = Math.min(dp + 1, bNum);
            }
        }
        return dp;
    }

    /**
     * 2373. 矩阵中的局部最大值
     */
    public static int[][] largestLocal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - 2][n - 2];
        //把首个矩阵放到最大堆

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                ans[i - 1][j - 1] = Math.max(grid[i - 1][j - 1], Math.max(grid[i - 1][j], Math.max(grid[i - 1][j + 1], Math.max(grid[i][j - 1], Math.max(grid[i][j], Math.max(grid[i][j + 1], Math.max(grid[i + 1][j - 1], Math.max(grid[i + 1][j], grid[i + 1][j + 1]))))))));
            }
        }
        return ans;

    }


    /**
     * 2363. 合并相似的物品
     */
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            List<Integer> list = new ArrayList<>();
            list.add(key);
            list.add(map.get(key));
            ans.add(list);
        }
        ans.sort(Comparator.comparingInt(t -> t.get(0)));
        return ans;
    }


    /**
     * 1144. 递减元素使数组呈锯齿状
     */
    public static int movesToMakeZigzag(int[] nums) {
        return Math.min(help(nums, 0), help(nums, 1));
    }

    public static int help(int[] nums, int pos) {
        int res = 0;
        for (int i = pos; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0) {
                a = Math.max(a, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                a = Math.max(a, nums[i] - nums[i + 1] + 1);
            }
            res += a;
        }
        return res;
    }

    /**
     * 1689. 十-二进制数的最少数目
     */
    public static int minPartitions(String n) {
        char[] nChar = n.toCharArray();
        char max = '0';
        for (char c : nChar) {
            if (c > max) {
                max = c;
            }
        }
        return Integer.parseInt(String.valueOf(max));
    }

    /**
     * 1247. 交换字符使得字符串相同
     */
    public static int minimumSwap(String s1, String s2) {
        int[] cnt = new int[2];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);
            if (s1Char != s2Char) {
                cnt[s1Char % 2]++;
            }
        }
        int sum = Arrays.stream(cnt).sum();
        return sum % 2 != 0 ? -1 : (sum / 2 + cnt[0] % 2);
    }

    /**
     * 2357. 使数组中所有元素都等于零
     */
    public static int minimumOperations(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }

    /**
     * 1238.循环码排列
     * 格雷码生成公式 i ^ (i >>1)
     */
    public static List<Integer> circularPermutation(int n, int start) {
        int len = (int) Math.pow(2, n), j = 0;
        int[] grey = new int[len];
        for (int i = 0; i < len; i++) {
            grey[i] = i ^ (i >> 1);
            if (grey[i] == start) {
                j = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = j; i < len + j; i++) {
            ans.add(grey[i % len]);
        }
        return ans;
    }

    /**
     * 1140. 石子游戏||
     * <p>
     * dp[i][j]表示剩余[i : len - 1]堆时，M = j的情况下，先取的人能获得的最多石子数
     */
    public static int stoneGame2(int[] piles) {
        int len = piles.length, sum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int m = 1; m <= len; m++) {
                if (i + 2 * m >= len) {
                    dp[i][m] = sum;
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

    /**
     * 1901. 寻找峰值||
     */
    public static int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int l = -1, r = m;
        while (l + 1 < r) {
            int cRow = l + (r - l) / 2;
            int maxCol = findMaxIdx(mat[cRow]);
            if (cRow == m - 1 || mat[cRow][maxCol] > mat[cRow + 1][maxCol]) {
                r = cRow;
            } else {
                l = cRow;
            }
        }
        int j = findMaxIdx(mat[r]);
        return new int[]{r, j};
    }

    private static int findMaxIdx(int[] row) {
        int n = row.length;
        int max = 0, maxIdx = -1;
        for (int i = 0; i < n; i++) {
            if (row[i] > max) {
                max = row[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    /**
     * 2347. 最好的扑克手牌
     */
    public static String bestHand(int[] ranks, char[] suits) {
        int[] count = new int[4];
        for (char suit : suits) {
            count[suit - 'a']++;
        }
        for (int i : count) {
            if (i == 5) {
                return "Flush";
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {

            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }

        boolean three = false;
        boolean two = false;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() >= 3) {
                three = true;

            }
            if (entry.getValue() == 2) {
                two = true;

            }
        }
        if (three) {
            return "Three of a Kind";
        }
        if (two) {
            return "Pair";
        }
        return "High Card";
    }

    /**
     * 1792. 最大平均通过率
     */
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
        });
        for (int[] c : classes) {
            pq.offer(new int[]{c[0], c[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            assert arr != null;
            int pass = arr[0], total = arr[1];
            pq.offer(new int[]{pass + 1, total + 1});
        }

        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            assert arr != null;
            int pass = arr[0], total = arr[1];
            res += 1.0 * pass / total;
        }
        return res / classes.length;
    }

    /**
     * 1491.去掉最低工资和最高工资后的工资平均值
     */
    public static double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        for (int i : salary) {
            max = Math.max(i, max);
            min = Math.min(i, min);
            sum += i;
        }
        return (sum - min - max) / (salary.length - 2);
    }

    /**
     * 2351. 第一个出现两次的字母
     */
    public static char repeatedCharacter(String s) {

        char ans = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            if (!set.add(aChar)) {
                ans = aChar;
                break;
            }
        }
        return ans;
    }

    /**
     * 2341.数组能形成多少数对
     */
    public static int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
                ans[0]++;
            }
        }
        ans[1] = set.size();
        return ans;
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

    /**
     * 1139.最大的以 1 为边界的正方形
     */
    public static int largest1BorderedSquare(int[][] grid) {

        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] hang = new int[m][n];
        int[][] lie = new int[m][n];
        // 初始化横向数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (j >= 1) {
                        hang[i][j] = hang[i][j - 1] + 1;
                    } else {
                        hang[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1) {
                    if (j >= 1) {
                        lie[j][i] = lie[j - 1][i] + 1;
                    } else {
                        lie[j][i] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 向上找连续的1
                    int index = i;
                    int topOne = 0;
                    int leftOne = 0;
                    while (index >= 0) {
                        if (grid[index--][j] == 1) {
                            topOne++;
                        } else {
                            break;
                        }
                    }
                    index = j;
                    while (index >= 0) {
                        if (grid[i][index--] == 1) {
                            leftOne++;
                        } else {
                            break;
                        }
                    }
                    int min = Math.min(topOne, leftOne);
                    for (int k = min; k >= 0; k--) {

                        if (Math.min(hang[i - k + 1][j], lie[i][j - k + 1]) >= k) {
                            ans = Math.max(ans, k * k);
                            break;
                        }
                    }
                }
            }
        }

        return ans;
    }


}
