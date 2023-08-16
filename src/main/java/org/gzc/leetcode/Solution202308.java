package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.gzc.leetcode.model.TreeNode;

import java.text.ParseException;
import java.util.*;

/**
 * @author GZC
 */
@Slf4j
public class Solution202308 {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 722:
                log.info(String.valueOf(removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"})));
                break;
            case 1749:
                log.info(String.valueOf(maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2})));
                break;
            case 2682:
                log.info(Arrays.toString(circularGameLosers(4, 4)));
                break;
            case 1281:
                log.info(String.valueOf(subtractProductAndSum(123)));
                break;
            case 833:
                log.info(findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
                break;
            case 617:
                TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(2));
                TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
                log.info(String.valueOf(Solution.levelOrder(mergeTrees(root1, root2))));
                break;
            case 2525:
                log.info(categorizeBox(12, 120, 1200, 200));
                break;
            default:
                break;

        }
    }


    /**
     * 2682. 找出转圈游戏输家
     * @param n 人数
     * @param k k值
     * @return 失败的人数
     */
    public static int[] circularGameLosers(int n, int k) {
        int[] dp = new int[n];
        int i = 1;
        int cur =0;
        dp[0] =1;
        while (true) {
            cur = (cur + i*k)%n;
            if (dp[cur] ==1){
                break;
            }
            dp[cur]++;
            i++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (dp[j] == 0){
                ans.add(j+1);
            }
        }
        int[] result = new int[ans.size()];
        int idx =0;
        for (Integer count : ans) {
            result[idx++] = count;
        }
        return result;
    }


    /**
     * 833.字符串中的查找与替换
     *
     * @param s       原始字符串
     * @param indices 替换的索引
     * @param sources 原字符串
     * @param targets 目标字符串
     * @return 替换后的字符串
     */
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = targets.length;
        int len = s.length();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            indexMap.put(indices[i], i);
        }
        Arrays.sort(indices);
        char[] chars = s.toCharArray();
        List<String> strArr = new ArrayList<>();
        for (char aChar : chars) {
            strArr.add(aChar + "");
        }
        for (int i = n - 1; i >= 0; i--) {
            int index = indices[i];
            int indexOld = index;
            Integer integer = indexMap.get(index);
            String source = sources[integer];
            String target = targets[integer];
            char[] sourceArr = source.toCharArray();
            boolean isMatch = true;
            for (char c : sourceArr) {
                if (index < len) {
                    if (chars[index++] != c) {
                        isMatch = false;
                        break;
                    }
                }
            }
            if (isMatch) {
                int length = source.length();
                for (int j = 0; j < length; j++) {
                    strArr.remove(indexOld);
                }
                char[] tarArr = target.toCharArray();
                int tarLen = tarArr.length;
                for (int j = tarLen - 1; j >= 0; j--) {
                    strArr.add(indexOld, tarArr[j] + "");
                }
            }
        }
        return String.join("", strArr);
    }

    /**
     * 617. 合并二叉树
     *
     * @param root1 二叉树1
     * @param root2 二叉树2
     * @return 合并的二叉树
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;

    }


    /**
     * 2525. 根据规则将箱子分类
     *
     * @param length 长度
     * @param width  宽度
     * @param height 高度
     * @param mass   质量
     * @return 箱子分类
     */
    public static String categorizeBox(int length, int width, int height, int mass) {
        boolean isHeavy = mass >= 100;
        boolean isBulky = (length >= 10000 || width >= 10000 || height >= 10000) || ((long) length * width * height) >= 1000000000;
        if (isBulky && isHeavy) {
            return "Both";
        }
        if (isBulky) {
            return "Bulky";
        } else if (isHeavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }

    /**
     * 1281. 整数的各位积和之差
     *
     * @param n 整数
     * @return 整数的各位积和之差
     */
    public static int subtractProductAndSum(int n) {
        int curMul = 1;
        int curSum = 0;
        while (n != 0) {
            int bit = n % 10;
            n /= 10;
            curMul *= bit;
            curSum += bit;
        }
        return curMul - curSum;
    }

    /**
     * 722. 删除注释
     *
     * @param source 源代码
     * @return 去除注释的代码
     */
    public static List<String> removeComments(String[] source) {

        List<String> ans = new ArrayList<>();
        boolean flag = false;
        for (String code : source) {
            flag = isFlag(ans, flag, code);
        }
        return ans;
    }

    private static boolean isFlag(List<String> ans, boolean flag, String code) {
        int multiIndex = code.indexOf("/*");
        int multiIndex1 = code.indexOf("*/");
        int singleIndex = code.indexOf("//");
        if (flag) {
            //存在多行注释的结尾
            if (multiIndex1 != -1) {
                code = code.substring(multiIndex1 + 2).trim();
                if (!"".equals(code)) {
                    flag = isFlag(ans, false, code);
                } else {
                    flag = false;
                }
            }
        } else {
            if (singleIndex != -1) {
                // 只有单行注释
                if (multiIndex == -1) {
                    code = code.substring(0, singleIndex).trim();
                    if (!"".equals(code)) {
                        ans.add(code);
                    }
                } else {
                    //存在单行注释和多行注释,单行注释在前面
                    if (singleIndex < multiIndex) {
                        code = code.substring(0, singleIndex);
                        if (!"".equals(code)) {
                            ans.add(code);
                        }
                    } else {
                        //存在单行注释和多行注释,多行注释在前面
                        // 存在多行注释的结尾
                        if (multiIndex1 != -1) {
                            // /**/XX//XX
                            if (singleIndex > multiIndex1) {
                                code = code.substring(multiIndex1 + 2).trim();
                                // XX//XX
                                flag = isFlag(ans, flag, code);
                            }
                        } else {
                            //存在单行注释和多行注释,多行注释在前面
                            //不存在多行注释的结尾
                            // /*XX//XX
                            code = code.substring(0, multiIndex).trim();
                            isFlag(ans, false, code);
                            flag = true;
                        }
                    }
                }
            } else if (multiIndex != -1) {
                //只有多行注释
                // 存在多行注释的结尾
                if (multiIndex1 != -1) {
                    // /**/XXXX
                    code = code.substring(multiIndex1 + 2).trim();
                    // XX//XX
                    flag = isFlag(ans, flag, code);
                } else {
                    //存在单行注释和多行注释,多行注释在前面
                    //不存在多行注释的结尾
                    // /*XX//XX
                    code = code.substring(0, multiIndex).trim();
                    isFlag(ans, false, code);
                    flag = true;
                }
            } else {
                if (!"".equals(code)) {
                    ans.add(code);
                }
            }
        }
        return flag;
    }

    /**
     * 1749. 任意子数组和的绝对值的最大值
     *
     * @param nums 整数数组
     * @return 子数组和的绝对值的最大值
     */
    public static int maxAbsoluteSum(int[] nums) {
        int min = 0, max = 0, res = Math.abs(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
            max = Math.max(nums[i - 1], max);
            min = Math.min(nums[i - 1], min);
            res = Math.max(res, Math.max(Math.abs(nums[i] - max), Math.abs(nums[i] - min)));
        }
        return res;
    }

}
