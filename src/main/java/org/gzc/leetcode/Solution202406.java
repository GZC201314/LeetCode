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
            case 3111:
                log.info(String.valueOf(minRectanglesToCoverPoints(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}},2)));
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


}
