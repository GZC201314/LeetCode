package org.gzc.leetcode;


import com.sun.tools.javac.util.Assert;
import org.gzc.leetcode.model.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.IntFunction;

/**
 * @author GZC
 * @create 2022-03-03 21:59
 * @description 2022年三月 LeetCode代码练习
 */
public class Solution202205 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int qusetionNum = input.nextInt();
        switch (qusetionNum) {
            case 937:
                System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"})));
                break;

            case 1823:
                System.out.println(findTheWinner(5,2));
                System.out.println(findTheWinner1(5,2));
            default:
                break;
        }

    }

    /**
     * 937. 重新排列日志文件
     */
    public static String[] reorderLogFiles(String[] logs) {

        int length = logs.length;
        Pair[] arr = new Pair[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Pair(logs[i], i);
        }
        Arrays.sort(arr, (pair0, pair1) -> {

            String log0 = pair0.getLog();
            int logIndex0 = pair0.getIndex();
            String log1 = pair1.getLog();
            int logIndex1 = pair1.getIndex();
            String log0SubString = log0.substring(log0.indexOf(" ") + 1);
            String log1SubString = log1.substring(log1.indexOf(" ") + 1);
            boolean log0IsDigit = Character.isDigit(log0SubString.charAt(0));
            boolean log1IsDigit = Character.isDigit(log1SubString.charAt(0));
            if (log0IsDigit) {
                if (log1IsDigit) {
                    return logIndex0 - logIndex1;
                } else {
                    return 1;
                }
            } else {
                if (log1IsDigit) {
                    return -1;
                } else {
                    /*如果两个都是字符传,在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。*/
                    int i = log0SubString.compareTo(log1SubString);
                    return i == 0 ? log0.substring(0, log0.indexOf(" ")).compareTo(log1.substring(0, log1.indexOf(" "))) : i;
                }
            }
        });
        for (int i = 0; i < length; i++) {
            logs[i] = arr[i].getLog();
        }
        return logs;
    }

    /**
     * 1823. 找出游戏的获胜者
     */
    public static int findTheWinner(int n, int k) {
        int result =0;
        int index =0;
        int num =0;
        int restChild = n;
        int[] childs = new int[n];
        while (restChild >1){
            // 如果当前的用户没有被淘汰
            if(childs[index] == 0){
                //叫号
                num++;
                if(num == k){
                    //号码清零
                    num=0;
                    //用户淘汰
                    childs[index%n] = -1;
                    index = (index+1)%n;
                    //剩余用户-1
                    restChild--;
                }else {
                    num = num%k;
                    index = (index+1)%n;
                }
            }else { // 如果当前的用户被淘汰了

                index = (index+1)%n;
            }
        }
        for (int i = 0; i < n; i++) {
            if(childs[i] == 0){
                result = i+1;
            }
        }
        return result;
    }

    /**
     * 1823. 找出游戏的获胜者
     */
    public static int findTheWinner1(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        if (queue.isEmpty()){
            return 0;
        }
        return queue.peek();
    }


}

