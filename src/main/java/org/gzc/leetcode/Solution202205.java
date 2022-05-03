package org.gzc.leetcode;


import org.gzc.leetcode.model.Pair;

import java.util.Arrays;
import java.util.Scanner;

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
                System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"})));
                break;

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
            int logIndex1 =  pair1.getIndex();
            String log0SubString = log0.substring(log0.indexOf(" ")+1);
            String log1SubString = log1.substring(log1.indexOf(" ")+1);
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
                    return i == 0 ? log0.substring(0,log0.indexOf(" ")).compareTo(log1.substring(0,log1.indexOf(" "))) : i;
                }
            }
        });
        for (int i = 0; i < length; i++) {
            logs[i] = arr[i].getLog();
        }
        return logs;
    }


}

