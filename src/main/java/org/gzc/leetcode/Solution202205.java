package org.gzc.leetcode;


import org.gzc.leetcode.model.Pair;
import org.gzc.leetcode.model.TreeNode;

import java.util.*;

import org.gzc.leetcode.model.Codec;

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
            case 666:
                TreeNode treeNode = inorderSuccessor(new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(1));
                System.out.println(treeNode != null ? treeNode.val : null);
                break;
            case 713:
                System.out.println(numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
                break;
            case 953:
                System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
                break;
            case 937:
                System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"})));
                break;
            case 942:
                System.out.println(Arrays.toString(diStringMatch("III")));
                break;
            case 944:
                System.out.println(minDeletionSize(new String[]{"cba", "daf", "ghi"}));
                break;
            case 449:
                Codec codec = new Codec();
                String serialize = codec.serialize(new TreeNode());
                TreeNode deserialize = codec.deserialize(serialize);
                System.out.println(deserialize);
                break;

            case 1823:
                System.out.println(findTheWinner(5, 2));
                System.out.println(findTheWinner1(5, 2));
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
        int result = 0;
        int index = 0;
        int num = 0;
        int restChild = n;
        int[] childs = new int[n];
        while (restChild > 1) {
            // 如果当前的用户没有被淘汰
            if (childs[index] == 0) {
                //叫号
                num++;
                if (num == k) {
                    //号码清零
                    num = 0;
                    //用户淘汰
                    childs[index % n] = -1;
                    index = (index + 1) % n;
                    //剩余用户-1
                    restChild--;
                } else {
                    num = num % k;
                    index = (index + 1) % n;
                }
            } else { // 如果当前的用户被淘汰了

                index = (index + 1) % n;
            }
        }
        for (int i = 0; i < n; i++) {
            if (childs[i] == 0) {
                result = i + 1;
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
        if (queue.isEmpty()) {
            return 0;
        }
        return queue.peek();
    }

    /**
     * 713. 乘积小于K的子数组
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int length = nums.length;
        /*设置窗口长度*/
        for (int i = 1; i <= length; i++) {
            int left = 0;
            int right = left + i;
            long mult = 1;
            for (int j = left; j < right; j++) {
                mult *= nums[j];
            }
            if (mult < k) {
                count++;
            }

            while (right < length) {
                int leftNum = nums[left++];
                int rightNum = nums[right++];
                mult /= leftNum;
                mult *= rightNum;
                // 判断当前sum是否大于K
                if (mult >= k) {
                    continue;
                }
                System.out.println(mult);
                count++;
            }

        }
        return count;
    }

    /**
     * 942. 增减字符串匹配
     */
    public static int[] diStringMatch(String s) {

        int n = s.length();
        int ni = 0;
        int nd = n;
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++) {
            result[i] = s.charAt(i) == 'I' ? ni++ : nd--;
        }
        result[n] = ni;
        return result;
    }

    /**
     * 944. 删列造序
     */
    public static int minDeletionSize(String[] strs) {
        int result = 0;
        int n = strs.length;
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c1 = strs[j].charAt(i);
                char c2 = strs[j + 1].charAt(i);
                if (c2 - c1 < 0) {
                    result++;
                    break;
                }
            }

        }
        return result;
    }

    /**
     * [面试题04.06]后继者
     */
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (pre == p) {
                return curr;
            }
            pre = curr;
            curr = curr.right;

        }
        return null;
    }

    /**
     * 953. 验证外星语词典
     */
    public static boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            boolean valid = false;
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                int prev = index[words[i - 1].charAt(j) - 'a'];
                int curr = index[words[i].charAt(j) - 'a'];
                if (prev < curr) {
                    valid = true;
                    break;
                } else if (prev > curr) {
                    return false;
                }
            }
            if (!valid) {
                /* 比较两个字符串的长度 */
                if (words[i - 1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }
}

