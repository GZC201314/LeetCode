package org.gzc.leetcode;

import java.util.*;

/**
 * @author GZC
 */
public class Solution202211 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 816:
                System.out.println(ambiguousCoordinates("(0012)"));
                break;
            case 1704:
                System.out.println(halvesAreAlike("book"));
                break;
            case 19:
                System.out.println(minimumOperations("ryryyrryryrryrrrrrrrrrryyyyyyyyrrrryryyyyyrrrryrryrryyrrrryyryyyryyrryrryyyyyrrrryryryyrrrr"));
                break;
            case 1104:
                System.out.println(pathInZigZagTree(14));
                break;
            case 799:
                System.out.println(champagneTower(14,2,3));
                break;
            case 775:
                System.out.println(isIdealPermutation(new int[]{4,1,2}));
                break;
            case 813:
                System.out.println(largestSumOfAverages(new int[]{4,1,2},2));
                break;
            case 882:
                System.out.println(reachableNodes(new int[][] {{0,1,10},{0,2,1},{1,2,2}},6,3 ));
                break;
            case 764:
                System.out.println(orderOfLargestPlusSign(5, new int[][] {{4, 2}}));
                break;
            default:
                break;
        }
    }

    /**
     * 813. 最大平均值和的分组
     */
    public static double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                for (int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }

    /**
     * 882. 细分图中的可到达节点
     */
    public static int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] adList = new List[n];
        for (int i = 0; i < n; i++) {
            adList[i] = new ArrayList<int[]>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], nodes = edge[2];
            adList[u].add(new int[]{v, nodes});
            adList[v].add(new int[]{u, nodes});
        }
        Map<Integer, Integer> used = new HashMap<Integer, Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        int reachableNodes = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty() && pq.peek()[0] <= maxMoves) {
            int[] pair = pq.poll();
            int step = pair[0], u = pair[1];
            if (!visited.add(u)) {
                continue;
            }
            reachableNodes++;
            for (int[] next : adList[u]) {
                int v = next[0], nodes = next[1];
                if (nodes + step + 1 <= maxMoves && !visited.contains(v)) {
                    pq.offer(new int[]{nodes + step + 1, v});
                }
                used.put(encode(u, v, n), Math.min(nodes, maxMoves - step));
            }
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], nodes = edge[2];
            reachableNodes += Math.min(nodes, used.getOrDefault(encode(u, v, n), 0) + used.getOrDefault(encode(v, u, n), 0));
        }
        return reachableNodes;
    }

    public static int encode(int u, int v, int n) {
        return u * n + v;
    }

    /**
     * 799. 香槟塔
     */
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 2][query_row + 2];
        // 为了防止越界，下标（0,0）的酒杯我们存放在dp[1][1]的位置上
        dp[1][1] = poured;
        for (int row = 2; row <= query_row + 1; row++) {
            for (int column = 1; column <= row; column++) {
                dp[row][column] = Math.max(dp[row - 1][column - 1] - 1, 0) / 2 + Math.max(dp[row - 1][column] - 1, 0) / 2;
                if (row == query_row+1 && column == query_glass+1){
                    return Math.min(dp[query_row + 1][query_glass + 1], 1);
                }
            }
        }
        return Math.min(dp[query_row + 1][query_glass + 1], 1);
    }

    /**
     * 775. 全局倒置与局部倒置
     */
    public static boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 2; i < n; i++) {

            if (nums[i] < max){
                return false;
            }
            max = Math.max(max,nums[i-1]);
        }
        return true;
    }
    /**
     * LCP 19. 秋叶收藏集
     */
    public static int minimumOperations(String leaves) {
        char[] leavesArr = leaves.toCharArray();
        int n = leavesArr.length;
        char red = 'r';
        char yellow = 'y';
        // dp[i][j]表示从0-i 其中第i枚状态为j的最小移动次数
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], i+1);
        }
        if (leavesArr[0] == red) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        if (leavesArr[1] == red) {
            dp[1][0] = dp[0][0];
            dp[1][1] = Math.min(dp[0][0],dp[0][1])+1;
        } else {
            dp[1][0] =dp[0][0]+ 1;
            dp[1][1] = Math.min(dp[0][0],dp[0][1]);
        }
        if (leavesArr[2] == red) {
            dp[2][0] = dp[1][0];
            dp[2][1] = Math.min(dp[1][0],dp[1][1])+1;
            dp[2][2] = dp[1][1];
        } else {
            dp[2][0] =dp[1][0]+ 1;
            dp[2][1] = Math.min(dp[1][0],dp[1][1]);
            dp[2][2] = dp[1][1]+1;
        }
        for (int i = 3; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + (leavesArr[i] == red ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (leavesArr[i] == yellow ? 0 : 1);
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + (leavesArr[i] == red ? 0 : 1);
        }
        return dp[n - 1][2];
    }

    /**
     * 1104. 二叉树寻路
     */
    public static List<Integer> result = new ArrayList<>();

    public static List<Integer> pathInZigZagTree(int label) {
        result.add(label);
        if (label == 1) {
            Collections.reverse(result);
            return result;
        }
        String s = Integer.toBinaryString(label);
        int level = s.length();
        // 计算当前lable的父节点
        int mirrorParent = label / 2;
        int parent = (int)((Math.pow(2, level - 2) + Math.pow(2, level - 1) - 1) - mirrorParent);
        return pathInZigZagTree(parent);
    }

    /**
     * 1704. 判断字符串的两半是否相似
     */
    public static boolean halvesAreAlike(String s) {
        String words = "aeiouAEIOU";
        int len = s.length();
        int count = 0;
        int right = len / 2;
        int left = 0;
        while (right < len) {
            if (words.contains(String.valueOf(s.charAt(left++)))) {
                count++;
            }
            if (words.contains(String.valueOf(s.charAt(right++)))) {
                count--;
            }
        }
        return count == 0;
    }

    /**
     * 764. 最大加号标志
     */
    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        // dp[i][j] 表示以i,j为中心向四周扩展最小的距离
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> banned = new HashSet<>();
        for (int[] vec : mines) {
            banned.add(vec[0] * n + vec[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* left */
            for (int j = 0; j < n; j++) {
                count = getCount(n, dp, banned, i, count, j);
            }
            count = 0;
            /* right */
            for (int j = n - 1; j >= 0; j--) {
                count = getCount(n, dp, banned, i, count, j);
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* up */
            for (int j = 0; j < n; j++) {
                count = getCount(n, dp, banned, j, count, i);
            }
            count = 0;
            /* down */
            for (int j = n - 1; j >= 0; j--) {
                count = getCount(n, dp, banned, j, count, i);
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }

    private static int getCount(int n, int[][] dp, Set<Integer> banned, int i, int count, int j) {
        if (banned.contains(i * n + j)) {
            count = 0;
        } else {
            count++;
        }
        dp[i][j] = Math.min(dp[i][j], count);
        return count;
    }

    /**
     * 816. 模糊坐标
     */
    public static List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        String replace = s.replace("(", "").replace(")", "");
        int n = replace.length();
        for (int i = 1; i < n; i++) {
            for (String num1 : getNums(replace.substring(0, i))) {
                for (String num2 : getNums(replace.substring(i, n))) {
                    result.add("(" + num1 + "," + num2 + ")");
                }
            }
        }
        return result;
    }

    public static List<String> getNums(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            // 正数部分
            String zheng = s.substring(0, i);
            String xiao = s.substring(i);
            if (zheng.startsWith("0") && (Integer.parseInt(zheng) != 0 || zheng.length() > 1) || xiao.endsWith("0")) {
                continue;
            }
            if ("".equals(xiao)) {
                result.add(zheng);
            } else {
                result.add(zheng + "." + xiao);
            }
        }
        return result;
    }
}
