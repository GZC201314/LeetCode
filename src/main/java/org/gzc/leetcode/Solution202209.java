package org.gzc.leetcode;

import java.util.*;

import org.gzc.leetcode.model.DisjointSet;
import org.gzc.leetcode.model.UnionFind;

/**
 * @author GZC
 */
public class Solution202209 {

    /**
     * 1391. 检查网格中是否存在有效路径
     * <p>
     * 1 表示连接左单元格和右单元格的街道。 2 表示连接上单元格和下单元格的街道。 3 表示连接左单元格和下单元格的街道。 4 表示连接右单元格和下单元格的街道。 5 表示连接左单元格和上单元格的街道。 6
     * 表示连接右单元格和上单元格的街道。
     */
    public static DisjointSet ds;
    public static int n;
    /**
     * 672. 灯泡开关 ||
     */
    public static Set<Integer> set = new HashSet<>();
    /**
     * 386. 字典排序数
     */
    static List<Integer> ans = new ArrayList<>();
    /**
     * 返回nums[i...]是否可以组成rest 剪枝
     */
    static Map<CanPartitionInfo, Boolean> dbMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 416:
                System.out.println(canPartition(new int[]{9, 79, 2, 4, 8, 16, 32, 64, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100}));
                System.out.println(canPartition1(new int[]{19, 79, 2, 4, 8, 16, 32, 64, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                        100, 100, 100, 100}));
            case 1391:
                System.out.println(hasValidPath(new int[][]{{2, 4, 3}, {6, 5, 2}}));
                break;
            case 435:
                System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {-100, -2}, {5, 7}}));
                break;
            case 399:
                // equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
                List<List<String>> equations = new ArrayList<>();
                List<String> equation = new ArrayList<>();
                equation.add("a");
                equation.add("b");
                List<String> equation1 = new ArrayList<>();
                equation1.add("b");
                equation1.add("c");
                equations.add(equation);
                equations.add(equation1);
                double[] values = new double[]{2.0, 3, 0};
                System.out.println(Arrays.toString(calcEquation(equations, values, equations)));
                break;
            case 547:
                System.out.println(findCircleNum(new int[][]{{1, 2}, {2, 3}, {3, 4}, {-100, -2}, {5, 7}}));
                break;
            case 446:
                System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 67, 7}));
                break;
            case 852:
                System.out.println(peakIndexInMountainArray(new int[]{1, 2, 3, 4, 5, 67, 7}));
                break;
            case 2149:
                System.out.println(Arrays.toString(rearrangeArray(new int[]{3, 1, 2, -5, -1, -3})));
                break;
            case 670:
                System.out.println(maximumSwap(2736));
                break;
            case 400:
                System.out.println(findNthDigit(1000000000));
                break;
            case 386:
                System.out.println(lexicalOrder(1234));
                break;
            case 869:
                System.out.println(reorderedPowerOf2(1234));
                break;
            case 394:
                System.out.println(decodeString("3[a2[c]]"));
                break;
            case 395:
                System.out.println(longestSubstring("abcdedghijklmnopqrstuvwxyz", 2));
                break;
            case 672:
                System.out.println(flipLights(2, 5));
                break;
            case 788:
                System.out.println(rotatedDigits(10000));
                break;
            case 666:
                System.out.println(Arrays.toString(missingTwo(new int[]{3})));
                break;
            case 885:
                System.out.println(Arrays.toString(spiralMatrixIII(1,4,0,0)));
                break;
            case 458:
                System.out.println(poorPigs(4, 15, 15));
                break;
            default:
                break;
        }

    }

    /**
     * 852. 山脉数组的峰顶索引
     */
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int mid = (left+right)/2;
        while (left < right) {
            if (mid ==0){
                return 1;
            }
            if (mid == arr.length-1){
                return mid-1;
            }
            if (arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                break;
            }
            if (arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                left = mid+1;
            }
            if (arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]){
                right = mid-1;
            }
            mid = (left+right)/2;
        }
        return mid;
    }

    /**
     * 869. 重新排序得到2的幂
     */
    public static boolean[] vis;
    public static boolean reorderedPowerOf2(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        vis = new boolean[chars.length];
        Arrays.sort(chars);
        return reorderedPowerOf2Dfs(chars, 0,0);


    }
    public static boolean reorderedPowerOf2Dfs(char[] chars,int index,int num){
        if (index == chars.length){
            return powerOf2(num);
        }
        for (int i = 0; i < chars.length; i++) {
            if ((num ==0 && chars[i] == '0') || vis[i]|| (i>0 && !vis[i-1] && chars[i] == chars[i-1])){
                continue;
            }
            vis[i] = true;
            if (reorderedPowerOf2Dfs(chars,index+1,num*10+chars[i]-'0')){
                return true;
            }
            vis[i] = false;
        }
        return false;
    }
    public static boolean powerOf2(int n){
        return (n &(n-1)) ==0;
    }

    /**
     * 885.螺旋矩阵|||
     */
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows * cols;
        int[][] result = new int[n][2];

        int left = cStart;
        int right = cStart;
        int top = rStart;
        int down = rStart;

        int count = 0;
        while (count < n){
            // 向右
            for (int i = left; i <= right ; i++) {
                if (validPos(top, i,rows,cols)){
                    result[count++] = new int[]{top,i};
                }
            }
            right++;

            // 向下
            for (int i = top; i <= down ; i++) {
                if (validPos(i, right,rows,cols)){
                    result[count++] = new int[]{i,right};
                }
            }
            down++;
            // 向左
            for (int i = right; i >= left ; i--) {
                if (validPos(down, i, rows,cols)){
                    result[count++] = new int[]{down,i};
                }
            }
            left--;
            // 向上
            for (int i = down; i >= top ; i--) {
                if (validPos(i, left, rows,cols)){
                    result[count++] = new int[]{i,left};
                }
            }
            top--;
        }
        return result;

    }

    private static boolean validPos(int r, int l, int rows, int cols) {
        return r >= 0 && r < rows && l >= 0 && l < cols;
    }


    /**
     * 面试题 17.19 消失的两个数字
     */
    public static int[] missingTwo(int[] nums) {
        int n = nums.length+2;
        int sum = (int)((1+n)*(n/2.0));
        int sum1 = 0;
        for (int num : nums) {
            sum1 += num;
        }
        int result = sum - sum1;
        int mid = (result+1)/2;
        sum =0;
        for (int num : nums) {
            if (num<mid){
                sum += num;
            }
        }
        sum1 = (int)((mid)*((mid-1)/2.0));

        return new int[]{sum1-sum,result-(sum1-sum)};
    }

    /**
     * 788. 旋转数字
     */
    public static int rotatedDigits(int n) {
        int lastResult = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            if (str.contains("3")|| str.contains("4")||str.contains("7")){
                result = lastResult;
            }else {
                if (str.contains("2")||str.contains("5")||str.contains("6")||str.contains("9")){

                    result = lastResult+1;
                    lastResult = result;

                }else {
                    result = lastResult;
                }
            }

        }
        return result;
    }


    /**
     * 547. 省份数量
     */
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    findCircleNumdfs(isConnected, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void findCircleNumdfs(int[][] isConnected, int i, int j) {
        isConnected[i][j] = 2;
        isConnected[j][i] = 2;
        int n = isConnected.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(j);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int k = 0; k < n; k++) {
                if (isConnected[poll][k] == 1) {
                    isConnected[poll][k] = 2;
                    isConnected[k][poll] = 2;
                    queue.offer(k);
                }
            }
        }
    }

    public static boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        n = grid[0].length;
        ds = new DisjointSet(m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hasValidPathdfs(grid, i, j);
            }
        }
        return ds.find(getId(0, 0)) == ds.find(getId(m - 1, n - 1));

    }

    private static void hasValidPathdfs(int[][] grid, int i, int j) {
        switch (grid[i][j]) {
            case 1:
                turnLeftIsOk(grid, i, j);
                turnRightIsOk(grid, i, j);
                break;
            case 2:
                turnUpIsOk(grid, i, j);
                turnBottomIsOk(grid, i, j);
                break;
            case 3:
                turnLeftIsOk(grid, i, j);
                turnBottomIsOk(grid, i, j);
                break;
            case 4:
                turnRightIsOk(grid, i, j);
                turnBottomIsOk(grid, i, j);
                break;
            case 5:
                turnLeftIsOk(grid, i, j);
                turnUpIsOk(grid, i, j);
                break;
            case 6:
                turnUpIsOk(grid, i, j);
                turnRightIsOk(grid, i, j);
                break;
            default:
                break;

        }
    }

    private static void turnBottomIsOk(int[][] grid, int i, int i1) {
        i++;
        if (i < grid.length && (grid[i][i1] == 2 || grid[i][i1] == 5 || grid[i][i1] == 6)) {
            ds.union(getId(i - 1, i1), getId(i, i1));
        }
    }

    private static void turnUpIsOk(int[][] grid, int i, int i1) {
        i--;

        if (i >= 0 && (grid[i][i1] == 2 || grid[i][i1] == 3 || grid[i][i1] == 4)) {
            ds.union(getId(i + 1, i1), getId(i, i1));
        }
    }

    private static void turnRightIsOk(int[][] grid, int i, int i1) {
        i1++;
        if (i1 < grid[0].length && (grid[i][i1] == 1 || grid[i][i1] == 3 || grid[i][i1] == 5)) {
            ds.union(getId(i, i1 - 1), getId(i, i1));
        }
    }

    private static void turnLeftIsOk(int[][] grid, int i, int i1) {
        i1--;
        if (i1 >= 0 && (grid[i][i1] == 1 || grid[i][i1] == 4 || grid[i][i1] == 6)) {
            ds.union(getId(i, i1 + 1), getId(i, i1));
        }

    }

    private static int getId(int x, int y) {
        return x * n + y;
    }

    /**
     * 400. 第N位数字
     */
    public static int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int index = 0;
        long sum = 0;
        while (sum <= n) {
            sum += ((index + 1) * 9 * Math.pow(10, index++));
        }
        index = index - 1;
        // 计算当前位数的就、第一个数
        int v = (int) (n - (sum - ((index + 1) * 9 * Math.pow(10, index))));

        int count = v / (index + 1);

        int rest = v % (index + 1);

        int pow = (int) Math.pow(10, index) + count;
        String s = String.valueOf(pow);
        if (rest == 0) {
            return (pow - 1) % 10;
        } else {
            return Integer.parseInt(s.charAt(rest - 1) + "");
        }

    }

    /**
     * 399. 除法求值
     */
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                if (unionFind.isConnected(id1, id2)) {
                    res[i] = unionFind.getWeight(id1, id2);
                } else {
                    res[i] = -1.0;
                }
            }
        }
        return res;
    }

    /**
     * 2149. 按符号重排数组
     */
    public static int[] rearrangeArray(int[] nums) {
        int zheng = 0;
        int fu = 0;
        int index = 0;
        int[] result = new int[nums.length];
        while (index < nums.length) {
            while (zheng < nums.length) {
                if (0 < nums[zheng]) {
                    break;
                }
                zheng++;
            }
            if (zheng < nums.length) {
                result[index++] = nums[zheng++];
            }

            while (fu < nums.length) {
                if (0 > nums[fu]) {
                    break;
                }
                fu++;
            }
            if (fu < nums.length) {
                result[index++] = nums[fu++];
            }
        }
        return result;
    }

    /**
     * 395. 至少有K个字符的最长子串
     */
    public static int longestSubstring(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        // 统计所有的字母出现个数
        for (int c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        // 定义一个字符串，用于传入split函数分割当前字符串
        StringBuilder cut = new StringBuilder();
        // 定义一个标志，用于标记是否所有字符都满足要求
        boolean flag = true;
        // 遍历所有字符
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                // 这个字符不满足要求，并且加入分割串
                flag = false;
                cut.append((char) (i + 'a'));
                cut.append("|");
            }
        }
        // 所有字符都满足要求的话，就直接返回字符串长度
        if (flag) {
            return n;
        }
        String s1 = cut.toString();
        s1 = s1.substring(0, s1.length() - 1);
        // 切割当前字符串，得到被切割的子串数组
        String[] cuted = s.split(s1);

        int res = 0;
        for (String c : cuted) {
            // 递归处理子串
            res = Math.max(longestSubstring(c, k), res);
        }

        return res;
    }

    /**
     * 394. 解密字符串
     */
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ']') {
                // 一直弹栈，一直到第一个【
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (pop == '[') {
                        // 组合加密的字符串
                        String encodeString = sb.reverse().toString();
                        // 寻找加密次数
                        int count = 0;
                        int index = 0;
                        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                            count += Math.pow(10, index++) * (stack.pop() - '0');
                        }
                        for (int i = 0; i < count; i++) {
                            char[] chars1 = encodeString.toCharArray();
                            for (char c : chars1) {
                                stack.push(c);
                            }
                        }
                        break;
                    } else {
                        sb.append(pop);

                    }
                }
            } else {
                stack.push(aChar);
            }

        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();

    }

    public static int flipLights(int n, int presses) {

        // 初始化灯泡
        int light = 1 << n - 1;
        // 用于存储可能的情况
        flipLightsDfs(n, light, presses);

        return set.size();

    }

    /**
     * @param n       灯泡个数
     * @param light   当前的灯泡的情况
     * @param presses 剩余的操作次数
     */
    public static void flipLightsDfs(int n, int light, int presses) {

        if (presses == 0) {
            set.add(light);
        }
        if (presses < 0) {
            return;
        }
        Set<Integer> pressesSet = new HashSet<>();
        // 第一个开关 ，把所有的灯都反转
        int p1 = 1 << n - 1;
        light = p1 ^ light;
        if (pressesSet.add(light)) {

            flipLightsDfs(n, light, presses - 1);
        }
        // 第二个开关，反转编号为偶数的灯的状态
        for (int i = 2; i <= n; i = i + 2) {
            int p2 = 1 << (i - 1);
            light = ((light | p2) == 0) ? light + p2 : light ^ p2;
        }
        if (pressesSet.add(light)) {
            flipLightsDfs(n, light, presses - 1);
        }
        // 第三个开关，反转编号为奇数的灯的状态
        for (int i = 1; i <= n; i = i + 2) {
            int p3 = 1 << (i - 1);
            light = ((light | p3) == 0) ? light + p3 : light ^ p3;
        }
        if (pressesSet.add(light)) {
            flipLightsDfs(n, light, presses - 1);
        }
        // 第四个开关，反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
        for (int i = 1; i <= n; i = i + 3) {
            int p4 = 1 << (i - 1);
            light = ((light | p4) == 0) ? light + p4 : light ^ p4;
        }
        if (pressesSet.add(light)) {
            flipLightsDfs(n, light, presses - 1);
        }

    }

    public static List<Integer> lexicalOrder(int n) {

        for (int i = 1; i < 10; i++) {
            if (i > n) {
                break;
            }
            ans.add(i);
            dfsLexicalOrder(n, i);

        }
        return ans;
    }

    public static void dfsLexicalOrder(int n, int num) {
        for (int i = 0; i < 10; i++) {
            int numNew = num * 10 + i;
            if (numNew > n) {
                break;
            }
            ans.add(numNew);
            dfsLexicalOrder(n, numNew);
        }
    }

    /**
     * 670. 最大交换
     */
    public static int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int mod = num % 10;
            num /= 10;
            list.add(mod);
        }
        dfsMaximumSwap(list, list.size() - 1, 0);
        int result = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            result = result * 10 + list.get(i);
        }
        return result;

    }

    public static void dfsMaximumSwap(List<Integer> list, int left, int right) {
        if (left == right) {
            return;
        }

        int max = -1;
        for (int i = right; i <= left; i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        // 从左往右找第一个不是最大值的数，从右向左找是最大值的第一个数
        // 分两种情况进行讨论 第一种 最高位是最大值 第二种 最高位不是最大值
        if (list.get(left) == max) {
            dfsMaximumSwap(list, left - 1, right);
        } else {
            while (left >= 0) {
                if (list.get(left--) != max) {
                    break;
                }
            }
            left++;
            while (right <= left) {
                if (list.get(right++) == max) {
                    break;
                }
            }
            right--;
            if (left > right) {
                Integer integer = list.get(left);
                Integer integer1 = list.get(right);
                list.set(left, integer1);
                list.set(right, integer);
            }
        }
    }

    /**
     * 458. 可怜的小猪
     */
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int times = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(times) - 1e-5);

    }

    /**
     * 446. 等差数列划分 II - 子序列
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int n = nums.length;
        // 用于记录以i结尾公差为d的伪等差数列的个数（任意两个数都是伪等差数列）
        Map<Long, Integer>[] dpMap = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dpMap[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[j] - nums[i];
                Integer count = dpMap[j].getOrDefault(d, 0);
                result += count;

                // 加一是为了统计两个数的等差数列
                dpMap[i].put(d, dpMap[i].getOrDefault(d, 0) + count + 1);
            }
        }
        return result;

    }

    /**
     * 435. 无重叠区间
     */
    public static int eraseOverlapIntervals(int[][] intervals) {

        List<EraseOverlapIntervalsClass> sortedList = new ArrayList<>();

        for (int[] interval : intervals) {
            sortedList.add(new EraseOverlapIntervalsClass(interval[0], interval[1]));
        }
        sortedList.sort((o1, o2) -> o1.right == o2.right ? o1.left - o2.left : o1.right - o2.right);

        int curRight = Integer.MIN_VALUE;
        int count = 0;
        for (EraseOverlapIntervalsClass eraseOverlapIntervalsClass : sortedList) {
            if (curRight != eraseOverlapIntervalsClass.right) {
                if (eraseOverlapIntervalsClass.left >= curRight) {
                    // lastRight = curRight;
                    curRight = eraseOverlapIntervalsClass.right;
                } else {
                    count++;
                }
            } else {
                count++;
            }
        }

        return count;

    }

    /**
     * 416. 分割等和子集
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2; // dp[i][j]代表可装物品为0-i，背包容量为j的情况下，背包内容量的最大价值
        int[][] dp = new int[nums.length][target + 1];
        // 初始化,dp[0][j]的最大价值nums[0](if j > weight[i]) //dp[i][0]均为0，不用初始化
        for (int j = nums[0]; j <= target; j++) {
            dp[0][j] = nums[0];
        }
        // 遍历物品，遍历背包 //递推公式:
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 背包容量可以容纳nums[i]
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target] == target;
    }

    /**
     * 返回nums[i...]是否可以组成rest 剪枝
     */
    public static boolean canPartition1(int[] nums) {

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }

        if ((sum[nums.length - 1] & 1) == 1) {
            return false;
        }
        return canPartitionDfs(nums, 0, sum[nums.length - 1] / 2, sum);

    }

    public static boolean canPartitionDfs(int[] nums, int i, int rest, int[] sum) {
        if (rest < 0) {
            return false;
        }
        if (i >= nums.length) {
            return false;
        }

        if (dbMap.get(new CanPartitionInfo(i, rest)) != null) {
            return dbMap.get(new CanPartitionInfo(i, rest));
        }
        if (rest == nums[i]) {
            dbMap.put(new CanPartitionInfo(i, rest), true);
            return true;
        }
        if (i != 0 && sum[sum.length - 1] - sum[i - 1] < rest) {
            dbMap.put(new CanPartitionInfo(i, rest), false);
            return false;
        }

        // 分两种情况 nums[i] 要 nums[i] 不要
        boolean p1 = canPartitionDfs(nums, i + 1, rest - nums[i], sum);
        boolean p2 = canPartitionDfs(nums, i + 1, rest, sum);
        boolean result = p1 || p2;
        dbMap.put(new CanPartitionInfo(i, rest), result);
        dbMap.put(new CanPartitionInfo(i + 1, rest), p1);
        dbMap.put(new CanPartitionInfo(i + 1, rest - nums[i]), p2);
        return result;
    }

    static class EraseOverlapIntervalsClass {
        int left;
        int right;

        public EraseOverlapIntervalsClass(int left, int right) {
            this.left = left;
            this.right = right;
        }

    }

    static class CanPartitionInfo {
        int index;
        int rest;

        public CanPartitionInfo(int index, int rest) {
            this.index = index;
            this.rest = rest;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CanPartitionInfo that = (CanPartitionInfo) o;
            return index == that.index && rest == that.rest;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, rest);
        }
    }

}
