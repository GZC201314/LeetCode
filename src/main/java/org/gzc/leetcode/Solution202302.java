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
            case 1792:
                System.out.println(maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {1, 1}}, 4));
                break;
            case 2341:
                System.out.println(Arrays.toString(numberOfPairs(new int[]{9, 9, 6, 0, 6, 6, 9})));
                break;
            case 2347:
                System.out.println(bestHand(new int[]{13,2,3,1,9},new char[]{'a','a','a','a','a'}));
                break;
            default:
                break;
        }
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
        if (three){
            return "Three of a Kind";
        }
        if (two){
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
