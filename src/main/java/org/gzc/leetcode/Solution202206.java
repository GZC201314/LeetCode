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
            if (k % 2 == 0) { // 正向
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
}

