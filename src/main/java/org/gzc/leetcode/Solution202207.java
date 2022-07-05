package org.gzc.leetcode;


import org.gzc.leetcode.model.ListNode;

import java.util.*;

/**
 * @author GZC
 * @create 2022-03-03 21:59
 * @description 2022年三月 LeetCode代码练习
 */
public class Solution202207 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 390:
                System.out.println(Arrays.toString(shuffle(new int[]{12, 3, 4, 5, 6, 7, 8, 9}, 4)));
                break;
            case 6111:
                ListNode root = new ListNode(3,
                        new ListNode(0,
                                new ListNode(2,
                                        new ListNode(6,
                                                new ListNode(8,
                                                        new ListNode(1,
                                                                new ListNode(7,
                                                                        new ListNode(9,
                                                                                new ListNode(4,
                                                                                        new ListNode(2,
                                                                                                new ListNode(5,
                                                                                                        new ListNode(5,
                                                                                                                new ListNode(0)))))))))))));
                System.out.println(Arrays.deepToString(spiralMatrix(3, 5, root)));
                break;
            case 1200:
                List<List<Integer>> lists = minimumAbsDifference(new int[]{1, 2, 3, 4});
                System.out.println(lists);
                break;
            case 451:
                System.out.println(frequencySort("tree"));
                break;
            default:
                break;
        }

    }

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2*n];
        int left =0 ;
        int right = n;
        int index =0;
        for(int i=0;i<n;i++){
            arr[index++] = nums[left++];
            arr[index++] = nums[right++];
        }
        return arr;

    }

    /**
     * 6111. 螺旋矩阵 IV
     */
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int i = 0;i<m;i++){
            Arrays.fill(result[i],-1);
        }
        int top =0;
        int bottom = m-1;
        int left =0;
        int right =n-1;
        while (head != null){
            // 向右
            for(int i= left;i<=right;i++){
                result[top][i] = head.val;
                head = head.next;
                if(head == null){
                    return result;
                }
            }
            if(top<bottom){
                top++;
            }

            // 向下
            for(int i = top;i<=bottom;i++){
                result[i][right] = head.val;
                head = head.next;
                if(head == null){
                    return result;
                }
            }
            if(left<right){
                right--;
            }

            // 向左
            for (int i = right; i >= left ; i--) {
                result[bottom][i] = head.val;
                head = head.next;
                if(head == null){
                    return result;
                }
            }
            if(top<bottom){
                bottom--;
            }
            // 向上
            for (int i = bottom; i >= top ; i--) {
                result[i][left] = head.val;
                head = head.next;
                if(head == null){
                    return result;
                }
            }
            if(left<right){
                left++;
            }

        }
        return result;
    }

    /**
     * 1200. 最小绝对差
     */
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length - 2;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (min > arr[i + 1] - arr[i]) {
                result.clear();
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                result.add(list);
                min = arr[i + 1] - arr[i];

            }else if(min == arr[i + 1] - arr[i]){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                result.add(list);
            }
        }
        return result;
    }

    /**
     * 451. 根据字符出现频率排序
     */
    public static  String frequencySort(String s) {
        Map<Character,Integer> charMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            charMap.put(c, charMap.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(charMap.entrySet());
        Collections.sort(list, (Map.Entry<Character,Integer> en1,Map.Entry<Character,Integer> en2)->{
            return en2.getValue()-en1.getValue();
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character,Integer> en1 : list) {
            int n = en1.getValue();
            for (int i = 0;i<n;i++){
                sb.append(en1.getKey());
            }
        }
        return sb.toString();

    }

}

