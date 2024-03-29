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
            case 849:
                log.info(String.valueOf(maxDistToClosest(new int[]{0, 1})));
                break;
            case 2766:
                log.info(String.valueOf(relocateMarbles(new int[]{1, 6, 7, 8}, new int[]{1, 7, 2}, new int[]{2, 9, 5})));
                break;
            case 38:
                log.info(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
                break;
            case 2682:
                log.info(Arrays.toString(circularGameLosers(4, 4)));
                break;
            case 1281:
                log.info(String.valueOf(subtractProductAndSum(123)));
                break;
            case 2704:
                log.info(removeTrailingZeros("123"));
                break;
            case 833:
                log.info(findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
                break;
            case 929:
                log.info(String.valueOf(numUniqueEmails(new String[]{"ae@example.com", "a.e@example.com"})));
                break;
            case 617:
                TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(2));
                TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
                log.info(String.valueOf(Solution.levelOrder(mergeTrees(root1, root2))));
                break;
            case 2525:
                log.info(categorizeBox(12, 120, 1200, 200));
                break;
            case 2578:
                log.info(String.valueOf(splitNum(12)));
                break;
            case 2678:
                log.info(String.valueOf(countSeniors(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"})));
                break;
            case 2594:
                log.info(String.valueOf(repairCars(new int[]{4, 2, 3, 1}, 10)));
                break;
            case 6:
                log.info(String.valueOf(minCount(new int[]{4, 2, 3, 1})));
                break;
            case 2554:
                log.info(String.valueOf(maxCount(new int[]{4, 2, 3, 1}, 10, 10)));
                break;
            case 1278:
                log.info(String.valueOf(countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}})));
            case 2304:
                log.info(String.valueOf(minPathCost(new int[][]{{5,3},{4,0},{2,1}},new int[][]{{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}})));
                break;
            default:
                log.info(Arrays.toString(swapNumbers(new int[]{100, 2})));
                break;

        }
    }


    /**
     * 2304. 网格中的最小路径代价
     * @param grid 图
     * @param moveCost 代价值
     * @return 最小路径代价
     */
    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[m - 1] = grid[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                // 移动到下一行的第 k 列
                for (int k = 0; k < n; k++) {
                    f[i][j] = Math.min(f[i][j], f[i + 1][k] + moveCost[grid[i][j]][k]);
                }
                f[i][j] += grid[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int res : f[0]) {
            ans = Math.min(ans, res);
        }
        return ans;
    }




    /**
     * 2678. 老人的数量
     * @param details 乘客信息
     * @return 老人的个数
     */
    public static int countSeniors (String[]details){
        int count = 0;
        for (String detail : details) {
            String ageStr = detail.substring(11, 13);
            int age = Integer.parseInt(ageStr);
            if (age > 60) {
                count++;
            }
        }
        return count;
    }

    /**
     * 2578.最小和分割
     * @param num 数字
     * @return 最小和
     */
    public static int splitNum ( int num){
        List<Integer> numCount = new ArrayList<>();
        while (num > 0) {
            numCount.add(num % 10);
            num /= 10;
        }
        numCount.sort(Comparator.comparingInt(o -> o));
        int first = 0;
        int second = 0;
        boolean flag = false;
        for (Integer numBit : numCount) {
            if (flag) {
                first = first * 10 + numBit;
            } else {
                second = second * 10 + numBit;
            }
            flag = !flag;
        }
        return first + second;
    }

    /**
     * 929. 独特的电子邮件地址
     *
     * @param emails 邮箱
     * @return 有效邮箱
     */
    public static int numUniqueEmails (String[]emails){
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            StringBuilder sb = new StringBuilder();
            char[] chars = split[0].toCharArray();
            for (char aChar : chars) {
                if (aChar == '+') {
                    break;
                } else if (aChar != '.') {
                    sb.append(aChar);
                }
            }
            emailSet.add(sb + "@" + split[1]);
        }
        return emailSet.size();

    }

    /**
     * LCP 06 拿硬币
     *
     * @param coins 金币堆
     * @return 大小拿取次数
     */
    public static int minCount ( int[] coins){
        int ans = 0;
        for (int coin : coins) {
            ans += (coin / 2 + coin % 2);
        }
        return ans;
    }

    /**
     * 面试题 16.01 交换数字
     *
     * @param numbers 待交换的数字
     * @return 交换后的数字
     */
    public static int[] swapNumbers ( int[] numbers){
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];

        return numbers;
    }


    /**
     * 1278. 统计全为 1 的正方形子矩阵
     *
     * @param matrix 0,1数字矩阵
     * @return 全为1的数字矩阵的个数
     * 转移方程 dp[i][j] = min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])+1
     */
    public static int countSquares ( int[][] matrix){
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] ints : matrix) {
            ans += ints[0];
        }
        dp[0] = matrix[0];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
        }
        if (dp[0][0] == 1) {
            ans--;
        }
        ans += Arrays.stream(matrix[0]).sum();
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    ans += dp[i][j];
                }
            }
        }
        return ans;

    }


    /**
     * 2554. 从一个范围内选择最多整数 I
     *
     * @param banned 数组
     * @param n      n
     * @param maxSum 最大和
     * @return 个数
     */
    public static int maxCount ( int[] banned, int n, int maxSum){
        Set<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }
        long ans = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                if (ans + i <= maxSum) {
                    ans += i;
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }


    /**
     * 2594. 修车的最少时间
     *
     * @param ranks 修理工能力数组
     * @param cars  需要修的汽车个数
     * @return 最少的修理时间
     */
    public static long repairCars ( int[] ranks, int cars){
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((arr1, arr2) -> arr1[0] * arr1[1] * arr1[1] - arr2[0] * arr2[1] * arr2[1] + 2 * arr1[0] * arr1[1] - 2 * arr2[0] * arr2[1] + arr1[0] - arr2[0]);
        long max = 0;
        for (int rank : ranks) {
            priorityQueue.offer(new int[]{rank, 0});
        }
        for (int i = 1; i <= cars; i++) {
            int[] poll = priorityQueue.poll();
            assert poll != null;
            poll[1] += 1;
            max = Math.max(max, (long) poll[0] * poll[1] * poll[1]);
            priorityQueue.offer(poll);
        }
        return max;
    }

    /**
     * 2766. 重新放置石块
     *
     * @param nums     有石子的索引
     * @param moveFrom 移出的索引
     * @param moveTo   移入的索引
     * @return 有石子的索引
     */
    public static List<Integer> relocateMarbles ( int[] nums, int[] moveFrom, int[] moveTo){
        Set<Integer> ans = new HashSet<>();
        for (int num : nums) {
            ans.add(num);
        }
        int n = moveFrom.length;
        for (int i = 0; i < n; i++) {
            ans.remove(moveFrom[i]);
            ans.add(moveTo[i]);
        }
        List<Integer> answer = new ArrayList<>(ans);
        answer.sort(Comparator.comparingInt(o -> o));
        return answer;

    }

    /**
     * 2710. 移除字符串中的尾随零
     *
     * @param num 数字字符串
     * @return 去除后缀零的字符串
     */
    public static String removeTrailingZeros (String num){
        int n = num.length();
        int index = n - 1;
        while (num.charAt(index) == '0') {
            index--;
        }

        return num.substring(0, index + 1);
    }


    /**
     * 849. 到最近的人的最大距离
     *
     * @param seats 座位数组
     * @return 距离最近的人的最大距离的座位
     */
    public static int maxDistToClosest ( int[] seats){
        int ans = 1;
        int n = seats.length;
        int idx = 0;
        if (seats[0] == 0) {
            while (idx < n && seats[idx] == 0) {
                idx++;
            }
            ans = idx;
        }
        for (int i = idx; i < n; i++) {
            while (i < n && seats[i] == 0) {
                i++;
            }
            if (i < n) {
                ans = Math.max(ans, (i - idx) / 2);
                idx = i;
            } else {
                ans = Math.max(ans, i - idx - 1);
            }
        }
        return ans;
    }

    /**
     * LCR 038. 每日温度
     *
     * @param temperatures 历史温度
     * @return 检测到最大温度的天数
     */
    public static int[] dailyTemperatures ( int[] temperatures){
        int n = temperatures.length;
        int[] ans = new int[n];
        int max;
        for (int i = 0; i < n - 1; i++) {
            max = temperatures[i];
            int cacheI = i + 1;
            if (max < temperatures[cacheI]) {
                ans[i] = 1;
                continue;
            }
            while (cacheI < n && temperatures[cacheI] <= max) {
                cacheI++;
            }
            if (cacheI != n) {
                ans[i] = cacheI - i;
            }
        }
        return ans;
    }


    /**
     * 2682. 找出转圈游戏输家
     *
     * @param n 人数
     * @param k k值
     * @return 失败的人数
     */
    public static int[] circularGameLosers ( int n, int k){
        int[] dp = new int[n];
        int i = 1;
        int cur = 0;
        dp[0] = 1;
        while (true) {
            cur = (cur + i * k) % n;
            if (dp[cur] == 1) {
                break;
            }
            dp[cur]++;
            i++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (dp[j] == 0) {
                ans.add(j + 1);
            }
        }
        int[] result = new int[ans.size()];
        int idx = 0;
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
    public static String findReplaceString (String s,int[] indices, String[] sources, String[]targets){
        int n = targets.length;
        int len = s.length();
        Map<Integer, Integer> indexMap = new HashMap<>(n);
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
    public static TreeNode mergeTrees (TreeNode root1, TreeNode root2){

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
    public static String categorizeBox ( int length, int width, int height, int mass){
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
    public static int subtractProductAndSum ( int n){
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
    public static List<String> removeComments (String[]source){

        List<String> ans = new ArrayList<>();
        boolean flag = false;
        for (String code : source) {
            flag = isFlag(ans, flag, code);
        }
        return ans;
    }

    private static boolean isFlag (List < String > ans,boolean flag, String code){
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
    public static int maxAbsoluteSum ( int[] nums){
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
