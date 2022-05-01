package org.gzc.leetcode;

import org.gzc.leetcode.model.TreeNode;

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
            case 388:
                System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
                break;
            case 824:
                System.out.println(toGoatLatin("I speak Goat Latin"));
                break;
            case 868:
                System.out.println(binaryGap(1234));
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
                int min = Integer.MAX_VALUE;
                for (Integer index : cIndex) {
                    int abs = Math.abs(i - index);
                    if (abs < min) {
                        min = abs;
                    }
                }
                result[i] = min;
            }
        }
        return result;

    }

    /**
     * 388. 文件的最长绝对路径
     */
    public static int lengthLongestPath(String input) {

        int maxPath = 0;

        int length = input.length();
        int pos = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        while (pos < length) {
            /*计算当前文件或文件夹的深度*/
            int depth = 1;
            while (pos < length && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            /*统计当前文件的长度和信息*/
            boolean isFile = false;
            int fileNameLen = 0;

            while (pos < length && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                pos++;
                fileNameLen++;
            }
            /*跳过换行符*/
            pos++;
            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                fileNameLen += stack.peek() + 1;
            }
            if (isFile) {
                maxPath = Math.max(maxPath, fileNameLen);
            } else {
                stack.push(fileNameLen);
            }
        }
        return maxPath;
    }

    /**
     * 824. 山羊拉丁文
     */
    public static String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        int length = words.length;
        for (int i = 0; i < length; i++) {
            if ("aeiouAEIOU".contains(words[i].substring(0, 1))) {
                words[i] = words[i] + "ma";
            } else {
                words[i] = words[i].substring(1) + words[i].charAt(0) + "ma";
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            words[i] = words[i] + sb;
        }

        return String.join(" ", words);
    }

    /**
     * 868. 二进制间距
     */
    public static int binaryGap(int n) {
        int max = 0;
        int last = -1;
        for (int i = 0; n != 0; i++) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    max = Math.max(max, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return max;
    }

    /**
     * 1305. 两棵二叉搜索树中的所有元素
     */
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        inorder(root1, result1);
        inorder(root2, result2);
        int root1Len = result1.size();
        int root2Len = result2.size();
        int root1Index = 0;
        int root2Index = 0;
        while (root1Index<root1Len && root2Index<root2Len){
            if(result1.get(root1Index)<=result2.get(root2Index)){
                result.add(result1.get(root1Index++));
            }else {
                result.add(result2.get(root2Index++));
            }
        }
        while (root1Index<root1Len){
            result.add(result1.get(root1Index++));
        }
        while (root2Index<root2Len){
            result.add(result2.get(root2Index++));
        }
        return result;
    }

    private static void inorder(TreeNode root1, List<Integer> result1) {
        if(root1 == null){
            return;
        }
        inorder(root1.left,result1);
        result1.add(root1.val);
        inorder(root1.right,result1);
    }

    // 中序遍历搜索树,存入列表中





}
