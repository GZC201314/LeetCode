package org.gzc.leetcode;


import org.gzc.leetcode.model.Codec;
import org.gzc.leetcode.model.Pair;
import org.gzc.leetcode.model.TreeNode;

import java.util.*;

/**
 * @author GZC
 * @create 2022-03-03 21:59
 * @description 2022年三月 LeetCode代码练习
 */
public class Solution202206 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 390:
                System.out.println(lastRemaining(9));
                break;
            case 522:
                System.out.println(findLUSlength(new String[]{"aaa","bbb","ccc"}));
                break;
            default:
                break;
        }

    }

    /**
     * 390. 消除游戏 (自己的版本,空间复杂度过大)
     */
    public static int lastRemaining(int n) {
        if(n ==1){
            return 1;
        }
        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> deque1 = new LinkedList<>();
        for (int i = 1; i <=n ; i++) {
            deque.offer(i);
        }
        int index =0;
        int result = 0;
        List<Integer> newList = new ArrayList<>();
        while (!deque.isEmpty()){
            if(index++ %2 ==0){
                deque.poll();
            }else {
                result = deque.poll();
                deque1.offerFirst(result);
            }
            if(deque.isEmpty()){
                deque.addAll(deque1);
                deque1.clear();
                index =0;
            }
        }
        return result;
    }

    public static int lastRemaining1(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            // 正向
            if (k % 2 == 0) {
                a1 = a1 + step;
            } else { // 反向
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }

    /**
     * 522. 最长特殊序列 II
     */
    public static int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public static boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length();
    }

}

