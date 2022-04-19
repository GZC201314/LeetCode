package org.gzc.leetcode;

import java.util.*;

/**
 * @author GZC
 * @create 2022-03-03 21:59
 * @description 2022年三月 LeetCode代码练习
 */
public class Solution202204 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int qusetionNum = input.nextInt();
        switch (qusetionNum) {
            case 954:
                System.out.println(canReorderDoubled(new int[]{3, 1, 3, 6}));
                break;
            case 806:
                System.out.println(Arrays.toString(numberOfLines(new int[]{3, 1, 3, 6}, "abc")));
                break;
            case 448:
                System.out.println(findDisappearedNumbers(new int[]{3, 1, 3, 6}));
                break;
            case 1672:
                System.out.println(maximumWealth(new int[][]{{3, 1, 3, 6}, {3, 1, 3, 7}}));
                break;
            case 821:
                System.out.println(Arrays.toString(shortestToChar("helloworld", 'l')));
                break;
            default:
                break;
        }

    }

    /**
     * 954. 二倍数对数组
     *
     * @param arr 数组
     * @return 是否是二倍数对数组
     */
    public static boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>(16);
        for (int num : arr) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        List<Integer> absKey = new ArrayList<>(cnt.keySet());
        absKey.sort(Comparator.comparingInt(Math::abs));

        for (int key : absKey) {
            if (cnt.getOrDefault(2 * key, 0) < cnt.get(key)) {
                return false;
            }
            cnt.put(2 * key, cnt.getOrDefault(2 * key, 0) - cnt.get(key));
        }
        return true;
    }

    /**
     * 806. 写字符串需要的行数
     */
    public static int[] numberOfLines(int[] widths, String s) {

        char[] chars = s.toCharArray();
        int line = 0;
        int danwei = 0;
        for (char ch : chars) {
            int index = ch - 'a';
            if (danwei + widths[index] < 100) {
                danwei += widths[index];
            } else if (danwei + widths[index] == 100) {
                danwei = 0;
                line++;
            } else {
                danwei = widths[index];
                line++;
            }
        }
        if (danwei == 0) {
            danwei = 100;
        } else {
            line++;
        }
        return new int[]{line, danwei};
    }

    /**
     * 448. 找到所有数组中消失的数字
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    /**
     * 1672. 最富有客户的资产总量
     */
    public static int maximumWealth(int[][] accounts) {

        int result = 0;
        int n = accounts[0].length;
        for (int[] account : accounts) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max += account[j];
            }
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

    /**
     * 821. 字符的最短距离
     */
    public static int[] shortestToChar(String s, char c) {

        int[] result = new int[s.length()];
        List<Integer> cIndex = new ArrayList<>();
        // 遍历一次获取所有的c的索引
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] == c) {
                cIndex.add(i);
            }
        }

        for (int i = 0; i < length; i++) {
            if (chars[i] == c) {
                result[i] = 0;
            } else {
                int min =Integer.MAX_VALUE;
                for (Integer index : cIndex) {
                    int abs = Math.abs(i - index);
                    if(abs <min){
                        min = abs;
                    }
                }
                result[i] = min;
            }
        }
        return result;

    }

}
