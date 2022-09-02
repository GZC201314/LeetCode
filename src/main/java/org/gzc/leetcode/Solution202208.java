package org.gzc.leetcode;

import org.apache.commons.lang3.time.StopWatch;
import org.gzc.leetcode.model.*;
import org.gzc.leetcode.model.Node;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author GZC
 */
public class Solution202208 {

    /**
     * 640. 求解方程
     */
    private static final String CHARS = "-+x=";
    /**
     * 1553. 吃掉 N 个橘子的最少天数
     */
    public static Map<Integer, Integer> dpMap = new HashMap<>();
    public static int[] dp;
    /**
     * 1569. 将子数组重排序得到同一个二叉查找树的方案数
     */
    public static int[][] C;
    public static int mod = 1000000007;
    public static int[] used;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 503:
                System.out.println(Arrays.toString(nextGreaterElements(new int[] {1, 2, 3, 4, 3})));
                break;
            case 1403:
                System.out.println(minSubsequence(new int[] {4, 4, 6, 7, 7}));
                break;
            case 623:
                System.out.println(addOneRow(new TreeNode(4), 1, 3));
                break;
            case 841:
                List<List<Integer>> lists = new ArrayList<>();
                List<Integer> list1 = new ArrayList<>();
                list1.add(1);
                list1.add(1);
                lists.add(list1);
                List<Integer> list2 = new ArrayList<>();
                list2.add(2);
                lists.add(list2);
                List<Integer> list3 = new ArrayList<>();
                list3.add(1);
                list3.add(1);
                lists.add(list3);
                System.out.println(canVisitAllRooms(lists));
                break;
            case 554:
                List<List<Integer>> lists1 = new ArrayList<>();
                List<Integer> list4 = new ArrayList<>();
                list4.add(1);
                list4.add(1);
                lists1.add(list4);
                List<Integer> list5 = new ArrayList<>();
                list5.add(2);
                lists1.add(list5);
                List<Integer> list6 = new ArrayList<>();
                list6.add(1);
                list6.add(1);
                lists1.add(list6);
                System.out.println(leastBricks(lists1));
                break;
            case 123:
                morris(new Node(5, new Node(4), new Node(2)));
                break;
            case 124:
                preOrderMorris(new Node(5, null, new Node(2)));
                break;
            case 507:
                System.out.println(checkPerfectNumber(28));
                break;
            case 1884:
                System.out.println(twoEggDrop(28));
                break;
            case 517:
                System.out.println(findMinMoves(new int[] {3, 4, 5}));
                break;
            case 666:
                goodNote(new int[] {3, 4, 5});
                break;
            case 888:
                System.out.println(getValue("-1+4*(-2*3)"));
                break;
            case 640:
                System.out.println(solveEquation("3x+6=2x"));
                break;
            case 1302:
                System.out.println(deepestLeavesSum(new TreeNode(1)));
                break;
            case 33:
                System.out.println(verifyPostorder(new int[] {4, 6, 7, 5}));
                break;
            case 793:
                System.out.println(preimageSizeFZF(5));
                break;
            case 1450:
                System.out.println(busyStudent(new int[] {4, 6, 7, 5}, new int[] {4, 6, 7, 5}, 4));
                break;
            case 2344:
                System.out.println(minOperations(new int[] {4, 6, 7, 5}, new int[] {4, 6, 7, 5}));
                break;
            case 1818:
                System.out.println(minAbsoluteSumDiff(new int[] {4, 6, 7, 5}, new int[] {4, 6, 7, 5}));
                break;
            case 1460:
                System.out.println(canBeEqual(new int[] {4, 6, 7, 5}, new int[] {4, 6, 7, 5}));
                break;

            case 508:
                System.out
                    .println(Arrays.toString(findFrequentTreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-3)))));
                break;
            case 655:
                System.out.println(printTree(new TreeNode(1, new TreeNode(2), null)));
                break;
            case 1569:
                System.out.println(numOfWays(new int[] {4, 6, 7, 5}));
                break;
            case 413:
                System.out.println(numberOfArithmeticSlices(new int[] {4, 6, 7, 5}));
                break;
            case 396:
                System.out.println(maxRotateFunction(new int[] {4, 6, 7, 5}));
                break;
            case 403:
                System.out.println(canCross(new int[] {4, 6, 7, 5}));
                break;
            case 410:
                System.out.println(splitArray(new int[] {4, 6, 7, 5},6));
                break;
            case 1470:
                System.out.println(Arrays.toString(shuffle(new int[] {4, 6, 7, 5}, 2)));
                break;
            case 851:
                System.out.println(
                    Arrays.toString(loudAndRich(new int[][] {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}},
                        new int[] {3, 2, 5, 4, 6, 1, 7, 0})));
                break;
            case 1553:
                System.out.println(minDays(10));
            case 1314:
                System.out.println(getSplitNumount(120));
                break;
            case 397:
                System.out.println(integerReplacement(2147483647));
                // System.out.println(integerReplacement(1000000));
                break;
            case 1328:
                System.out.println(breakPalindrome("aba"));
                break;
            case 57:
                System.out.println(Arrays.deepToString(findContinuousSequence(15)));
                break;
            case 1042:
                System.out
                    .println(Arrays.toString(gardenNoAdj(4, new int[][] {{1, 2}, {3, 4}, {3, 2}, {4, 2}, {1, 4}})));
                break;
            default:
                System.out.println(matchString("aaab", "a*b"));
                break;
        }

    }

    /**
     * 413. 等差数列划分
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n <3 ){
            return 0;
        }
        NumberOfArithmeticSlicesInfo last = new NumberOfArithmeticSlicesInfo(0, 0);
        for (int i = 3; i <= n ; i++) {
            // 以nums[i-1]结尾的子数组，组成的等差数列的个数
            // p1 在 dp[i-1]中找到已经组成的等差数列，拼上 nums[i-1] p2 在nums[0..i-2]取最后两个数和nums[i-1]组成等差数组
            int sub = nums[i-2]-nums[i-3];
            int sub1  = nums[i-1]- nums[i-2];
            int bottomSum =0;
            if (sub== sub1){
                bottomSum = last.bottomSum+1;
            }
            int sum = last.sum+bottomSum;

            last = new NumberOfArithmeticSlicesInfo(sum, bottomSum);
        }

        return last.sum;


    }
    static class NumberOfArithmeticSlicesInfo{
        int sum;
        int bottomSum;
        public NumberOfArithmeticSlicesInfo(int sum, int bottomSum){
            this.sum = sum;
            this.bottomSum = bottomSum;
        }
    }

    /**
     * 410. 分割数组的最大值
     */
    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 计算前缀和
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 403. 青蛙过河
     */
    public static Map<CanCrossInfo, Boolean> mapDb;

    public static boolean canCross(int[] stones) {
        // 如果第一步都跳不过
        if (stones[0] + 1 != stones[1]) {
            return false;
        }

        mapDb = new HashMap<>();

        // 保存距离和索引的映射
        Map<Integer, Integer> map = new HashMap<>();
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        return canCrossDfs(stones, map, 1, 1);
    }

    /**
     *
     * @param stones 石子分布 PS 可以跨越石子跳跃
     * @param cur 当前所在第几个石子
     * @param kStep 上一步跳的步数
     */
    public static boolean canCrossDfs(int[] stones, Map<Integer, Integer> map, int cur, int kStep) {
        // base case
        if (kStep < 1) {
            return false;
        }

        if (cur == stones.length - 1) {
            return true;
        }
        if (mapDb.containsKey(new CanCrossInfo(cur, kStep))) {
            return mapDb.get(new CanCrossInfo(cur, kStep));
        }
        boolean result = map.containsKey(stones[cur] + kStep - 1)
            && canCrossDfs(stones, map, map.get(stones[cur] + kStep - 1), kStep - 1)
            || map.containsKey(stones[cur] + kStep) && canCrossDfs(stones, map, map.get(stones[cur] + kStep), kStep)
            || map.containsKey(stones[cur] + kStep + 1)
                && canCrossDfs(stones, map, map.get(stones[cur] + kStep + 1), kStep + 1);

        mapDb.put(new CanCrossInfo(cur, kStep), result);
        return result;

    }

    static class CanCrossInfo {
        int cur;
        int kStep;

        public CanCrossInfo(int cur, int kStep) {
            this.cur = cur;
            this.kStep = kStep;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            CanCrossInfo info = (CanCrossInfo)o;
            return cur == info.cur && kStep == info.kStep;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cur, kStep);
        }
    }

    /**
     * 397.正数替换(溢出情况分析，变量增大的情况要避免)
     */
    public static Map<Integer, Integer> mapDp = new HashMap<>();

    public static int integerReplacement(int n) {
        // base case
        if (n == 1) {
            return 0;
        }
        if (!mapDp.containsKey(n)) {
            int ans;
            if (n % 2 == 1) {
                ans = 1 + Math.min(integerReplacement(n / 2 + 1) + 1, integerReplacement(n / 2) + 1);
            } else {
                ans = 1 + integerReplacement(n / 2);
            }
            mapDp.put(n, ans);
            return ans;
        }
        return mapDp.get(n);
    }

    /**
     * 396. 旋转函数 动态规划 转移方程 F(i) = F(i-1) +sum - n*nums[n-i];
     */
    public static int maxRotateFunction(int[] nums) {
        // 计算数组总和
        int sum = 0;
        int n = nums.length;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            ans += j * nums[j];
            sum += nums[j];
        }
        int res = ans;
        int pre = ans;
        for (int i = 1; i < n; i++) {
            pre = pre + sum - n * nums[n - i];
            res = Math.max(res, pre);
        }

        return res;
    }

    /**
     * 851. 喧闹和富有
     */
    public static int[] loudAndRich(int[][] richer, int[] quiet) {

        // 1. 构建图
        int n = quiet.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        // 用于记录比i大的结点的个数
        int[] richerCount = new int[n];
        for (int[] richs : richer) {
            g[richs[0]].add(richs[1]);
            ++richerCount[richs[1]];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }
        // 用于存储 当前的最大的结点
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (richerCount[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int max = q.poll();
            for (int min : g[max]) {
                if (quiet[ans[max]] < quiet[ans[min]]) {
                    ans[min] = ans[max];
                }
                if (--richerCount[min] == 0) {
                    q.offer(min);
                }
            }
        }
        return ans;

    }

    /**
     * 841. 钥匙与房间
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] set = new boolean[size];
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (!set[poll]) {
                set[poll] = true;
                count++;
            }
            List<Integer> list = rooms.get(poll);
            for (int roomKey : list) {
                if (!set[roomKey]) {
                    queue.offer(roomKey);
                }
            }
        }
        return count == size;
    }

    /**
     * 剑指offer 57-|| 和为S的连续正数序列
     */
    public static int[][] findContinuousSequence(int target) {
        if (target == 1) {
            return new int[][] {{}};
        }

        ArrayList<int[]> result = new ArrayList<>();
        int start = 0;
        int end = 1;
        int sum = 1;
        while (start < end) {
            if (sum == target) {
                if (start == 0) {
                    start++;
                }
                int[] ans = new int[end - start + 1];
                for (int i = start; i <= end; i++) {
                    if (i != 0) {
                        ans[i - start] = i;
                    }
                }
                result.add(ans);
                sum -= start++;
                sum += ++end;
            } else if (sum < target) {
                sum += ++end;
            } else {
                sum -= start++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    /**
     * 554. 砌砖
     */
    public static int leastBricks(List<List<Integer>> wall) {
        int m = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int split = 0;
            int size = list.size() - 1;
            for (int i = 0; i < size; i++) {
                split += list.get(i);
                map.put(split, map.getOrDefault(split, 0) + 1);
            }
        }
        // 如果中间没有缝隙，则每一层都会被切到
        if (map.isEmpty()) {
            return m;
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 计算最大的空隙数
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : entries) {
            max = Math.max(entry.getValue(), max);
        }
        return m - max;

    }

    /**
     * 1328. 破坏回文串
     */
    public static String breakPalindrome(String palindrome) {
        char[] paArr = palindrome.toCharArray();
        int n = paArr.length;
        if (n <= 1) {
            return "";
        }
        boolean aFlag = true;
        for (int i = 0; i < n / 2; i++) {

            if (paArr[i] == 'a') {
                continue;
            }
            if (paArr[i] != 'a') {
                aFlag = false;
                paArr[i] = 'a';
                break;
            }
        }

        if (aFlag) {
            paArr[n - 1] = 'b';
        }

        return new String(paArr);

    }

    static int[][] twoEggDropdb;

    /**
     * 1884. 鸡蛋掉落-两枚鸡蛋
     */
    public static int twoEggDrop(int n) {
        twoEggDropdb = new int[n + 1][3];
        return twoEggDropdfs(n, 2);
    }

    /**
     * n层楼，k个鸡蛋最少需要多少次尝试
     */
    public static int twoEggDropdfs(int n, int k) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (twoEggDropdb[n][k] != 0) {
            return twoEggDropdb[n][k];
        }
        if (k == 1) {
            twoEggDropdb[n][k] = n;
            return twoEggDropdb[n][k];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // 分两种情况在第i层鸡蛋碎了，另一种情况鸡蛋没有碎
            ans = Math.min(ans, Math.max(twoEggDropdfs(i - 1, 1), twoEggDropdfs(n - i, 2)) + 1);
        }
        twoEggDropdb[n][k] = ans;
        return ans;
    }

    /**
     * 1470. 重新排列数组
     */
    public static int[] shuffle(int[] nums, int n) {
        perfectShuffle(nums, 0, n * 2 - 1, n);
        for (int i = 0; i < n; i++) {
            int num = nums[i * 2];
            nums[i * 2] = nums[i * 2 + 1];
            nums[i * 2 + 1] = num;
        }
        return nums;

    }

    public static void perfectShuffle(int[] nums, int from, int to, int n) {
        if (from >= to) {
            return;// 如果递归到最后则直接返回
        } else if (to - from == 1) {
            revertArr(nums, from, to);
            return;
        }
        int k = 0;// 用来记录3^k中的k
        int m;// 算法中的m
        int n2 = 2 * n;// 算法中的2n
        int p = (n2 + 1);// p=3^k 3^k-1<2n<3^(k+1)-1->3^k<2n+1=p
        int k_3 = 1;// 用于记录3^k的
        while (k <= p / 3) {// 通过不断除以3找到最大k值，使得p>3^k成立
            k++;
            p /= 3;
            k_3 *= 3;
        }
        m = (k_3 - 1) / 2;// 2m=3^k-1->m=(3^k-1)/2 至此得到了最大2m=3^k-1<2n，当然还有其他更好的办法

        rightCircle(nums, from + m, from + n + m - 1, m);
        for (int i = 0, t = 1; i < k; ++i, t *= 3) {
            /*
             * 运用之前推导的环开始计算，因为算法中数组下标是从1开始的，我们这里的下标是从0开始
             * 所以在传偏移量的时候要减去1，这样偏移量加上算法计算出的值正好相互抵消符合实际下标
             *
             * */
            circle(nums, from - 1, t, m * 2 + 1);
        }

        perfectShuffle(nums, 2 * m + from, to, (to - (2 * m + from) + 1) / 2);

    }

    // 数组下标从1开始，主要是因为环是1->2->4->8->7->5->1
    public static void circle(int[] a, int from, int i, int n2) {
        for (int k = 2 * i % n2; k != i; k = 2 * k % n2) {
            int temp = a[i + from];
            a[i + from] = a[k + from];
            a[k + from] = temp;
        }
    }

    public static void revertArr(int[] nums, int left, int right) {
        while (left < right) {
            int tem = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tem;
        }
    }

    public static void rightCircle(int[] nums, int from, int to, int m) {
        revertArr(nums, to - m + 1, to);
        revertArr(nums, from, to - m);
        revertArr(nums, from, to);
    }

    /**
     * 字符匹配，动态规划版本
     */
    public static boolean matchString(String s, String e) {
        if (s == null || e == null) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] eChars = e.toCharArray();

        return isValid(sChars, eChars) && processString(sChars, eChars, 0, 0);

    }

    /**
     * s[si...] 能否被e[ei...]匹配成功 PS 必须保证e[ei] != '*'
     */
    private static boolean processString(char[] s, char[] e, int si, int ei) {
        // 是否匹配完成
        if (ei == e.length) {
            return si == s.length;
        }
        // ei+1 位置不是*
        if (ei + 1 == e.length || e[ei + 1] != '*') {
            return si != s.length && (e[ei] == s[si] || e[ei] == '.') && processString(s, e, si + 1, ei + 1);
        }
        // ei+1位置是*
        while (si != s.length && (e[ei] == s[si] || e[ei] == '.')) {
            if (processString(s, e, si, ei + 2)) {
                return true;
            }
            si++;
        }
        return processString(s, e, si, ei + 2);

    }

    public static boolean isValid(char[] s, char[] e) {
        for (char c : s) {
            if (c == '*' || c == '.') {
                return false;
            }
        }
        for (int i = 0; i < e.length; i++) {
            if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1314. 分裂方案数
     */
    public static int getSplitNumount(int num) {

        if (num <= 0) {
            return 0;
        }
        int[][] dp = new int[num + 1][num + 1];
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        int sum = getSplitNumountHandler(1, num);
        stopWatch.stop();
        System.out.println("优化前的版本花费时间是：" + stopWatch.getTime(TimeUnit.MILLISECONDS) + " 结果是:" + sum);
        stopWatch.reset();
        stopWatch.start();
        int sum1 = getSplitNumountHandler1(1, num, dp);
        stopWatch.stop();
        System.out.println("优化后的版本花费时间是：" + stopWatch.getTime(TimeUnit.MILLISECONDS) + " 结果是:" + sum1);
        return getSplitNumountHandler1(1, num, dp);
    }

    public static int getSplitNumountHandler(int pre, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (rest < pre) {
            return 0;
        }

        int sum = 0;
        for (int i = pre; i <= rest; i++) {
            sum += getSplitNumountHandler(i, rest - i);
        }
        return sum;
    }

    /**
     * 优化版本
     */
    public static int getSplitNumountHandler1(int pre, int rest, int[][] dp) {
        if (rest == 0) {
            return 1;
        }
        if (rest < pre) {
            return 0;
        }
        if (dp[pre][rest] != 0) {
            return dp[pre][rest];
        }

        int sum = 0;
        for (int i = pre; i <= rest; i++) {
            sum += getSplitNumountHandler1(i, rest - i, dp);
        }
        dp[pre][rest] = sum;
        return sum;
    }

    public static int minDays(int n) {

        if (n <= 1) {
            return n;
        }
        dp = new int[n + 1];

        return dfsMinDays(n);

    }

    public static int dfsMinDays(int n) {
        if (dpMap.getOrDefault(n, 0) != 0) {
            return dpMap.get(n);
        }
        if (n <= 1) {
            return n;
        }
        if (n % 6 == 0) {
            int i = 1 + dfsMinDays(n / 3);
            int i1 = 1 + dfsMinDays(n / 2);
            int min = Math.min(i, i1);
            dpMap.put(n, min);
            return min;
        }
        int one = 1 + dfsMinDays(n - 1);
        int three = n % 3 == 0 ? 1 + dfsMinDays(n / 3) : Integer.MAX_VALUE;
        int twn = n % 2 == 0 ? 1 + dfsMinDays(n / 2) : Integer.MAX_VALUE;
        int min = Math.min(one, Math.min(twn, three));
        dpMap.put(n, min);
        return min;
    }

    public static int numOfWays(int[] nums) {
        int n = nums.length;
        // 预处理先计算组合数
        C = new int[n + 1][n + 1];
        getC(n);
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        return dfsNumOfWays(res) - 1;
    }

    public static int dfsNumOfWays(List<Integer> nums) {
        int n = nums.size();
        if (n == 0) {
            return 1;
        }
        // 答案只有在头结点相同的重排中
        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }
        int leftCount = dfsNumOfWays(left);
        int rightCount = dfsNumOfWays(right);

        return (int)((long)C[n - 1][left.size()] * leftCount % mod * rightCount % mod);

    }

    /**
     * 计算组合数
     */
    public static void getC(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    C[i][j] = 1;
                } else {
                    C[i][j] = (C[i - 1][j] + C[i - 1][j - 1]) % mod;
                }
            }
        }
    }

    /**
     * 1460. 通过反转子数组使两个数组相等
     */
    public static boolean canBeEqual(int[] target, int[] arr) {

        int m = target.length;
        int n = arr.length;
        if (m != n) {
            return false;
        }
        HashMap<Integer, Integer> targetSet = new HashMap<>();
        HashMap<Integer, Integer> arrSet = new HashMap<>();

        for (int i = 0; i < n; i++) {
            targetSet.put(target[i], targetSet.getOrDefault(target[i], 0) + 1);
            arrSet.put(arr[i], arrSet.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> targerEntry : targetSet.entrySet()) {
            if (!targerEntry.getValue().equals(arrSet.get(targerEntry.getKey()))) {
                return false;
            } else {
                arrSet.remove(targerEntry.getKey());
            }
        }
        return arrSet.isEmpty();
    }

    /**
     * 655. 输出二叉树
     */
    public static List<List<String>> printTree(TreeNode root) {
        Queue<Info1> queue = new LinkedList<>();
        // 获取二叉树的深度
        int height = printTreeHandler(root);
        int n = (1 << height) - 1;
        String[][] res = new String[height][n];
        res[0][(n - 1) / 2] = String.valueOf(root.val);
        queue.offer(new Info1(root, 0, (n - 1) / 2));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Info1 node = queue.poll();
                assert node != null;
                int r = node.r;
                int c = node.c;
                // 获取它的左右孩子结点
                if (node.node.left != null) {
                    int nextR = r + 1;
                    int nextC = c - (1 << (height - r - 2));
                    res[nextR][nextC] = String.valueOf(node.node.left.val);
                    queue.offer(new Info1(node.node.left, nextR, nextC));
                }
                if (node.node.right != null) {
                    int nextR = r + 1;
                    int nextC = c + (1 << (height - r - 2));
                    res[nextR][nextC] = String.valueOf(node.node.right.val);
                    queue.offer(new Info1(node.node.right, nextR, nextC));
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (res[i][j] == null) {
                    list.add("");
                } else {
                    list.add(res[i][j]);
                }
            }
            result.add(list);
        }
        return result;

    }

    public static int printTreeHandler(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftHeight = printTreeHandler(root.left);
        int rightHeight = printTreeHandler(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 1818. 绝对差值和
     */
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int mod = 1000000007;
        long ans = 0;
        int n = nums1.length;
        for (int i : nums1) {
            treeSet.add(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num1 = nums1[i];
            int num2 = nums2[i];
            int curAns = Math.abs(num1 - num2);
            Integer floor = treeSet.floor(num2);
            if (floor != null) {
                max = Math.max(max, curAns - Math.abs(floor - num2));
            }
            Integer ceiling = treeSet.ceiling(num2);
            if (ceiling != null) {
                max = Math.max(max, curAns - Math.abs(ceiling - num2));
            }
            ans += curAns;
            ans %= mod;
        }

        return (int)(ans - max + mod) % mod;
    }

    /**
     * 2344. 使数组可以被整除的最少删除次数
     */
    public static int minOperations(int[] nums, int[] numsDivide) {
        int g = 0;
        for (int j : numsDivide) {
            g = gcd(g, j);
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int result = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (g % key == 0) {
                return result;
            } else {
                result += map.get(key);
            }
        }
        return -1;
    }

    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     */
    public static boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        int[] inorder = Arrays.copyOf(postorder, n);
        Arrays.sort(inorder);
        return verifyPostorderHandle(postorder, inorder, 0, n - 1, 0, n - 1);

    }

    public static boolean verifyPostorderHandle(int[] postorder, int[] inorder, int posti, int postj, int ini,
        int inj) {
        if (posti == postj && ini == inj) {
            return postorder[posti] == inorder[ini];
        }
        // 遍历完毕 返回true
        if (posti > postj || ini > inj) {
            return true;
        }

        // 获取根结点
        int root = postorder[postj];
        // 获取根结点在中序遍历中的位置
        int rootInorderIndex = -1;
        for (int i = ini; i <= inj; i++) {
            if (inorder[i] == root) {
                rootInorderIndex = i;
                break;
            }
        }
        if (rootInorderIndex == -1) {
            return false;
        }
        int[] subPostOrderLeft;
        if (posti > posti + rootInorderIndex - ini) {
            return true;
        } else {
            subPostOrderLeft = Arrays.copyOfRange(postorder, posti, posti + rootInorderIndex - ini);
        }
        int[] subPostOrderRight;
        if (posti + rootInorderIndex - ini > postj) {
            return true;
        } else {
            subPostOrderRight = Arrays.copyOfRange(postorder, posti + rootInorderIndex - ini, postj);
        }
        int leftMax = Integer.MIN_VALUE;
        int rightMin = Integer.MAX_VALUE;

        if (subPostOrderLeft.length > 0) {
            for (int node : subPostOrderLeft) {
                leftMax = Math.max(leftMax, node);
            }
        }
        if (subPostOrderRight.length > 0) {
            for (int node : subPostOrderRight) {
                rightMin = Math.min(rightMin, node);
            }
        }

        return verifyPostorderHandle(postorder, inorder, posti, posti + rootInorderIndex - ini - 1, ini,
            rootInorderIndex - 1)
            && verifyPostorderHandle(postorder, inorder, posti + rootInorderIndex - ini, postj - 1,
                rootInorderIndex + 1, inj)
            && root > leftMax && root < rightMin;

    }

    /**
     * 1042. 不邻接植花
     */
    public static int[] gardenNoAdj(int n, int[][] paths) {

        Map<Integer, List<Integer>> s2e = new HashMap<>();
        Map<Integer, List<Integer>> e2s = new HashMap<>();
        for (int[] path : paths) {
            List<Integer> s2eList = s2e.getOrDefault(path[0], new ArrayList<>());
            List<Integer> e2sList = e2s.getOrDefault(path[1], new ArrayList<>());
            s2eList.add(path[1]);
            e2sList.add(path[0]);
            s2e.put(path[0], s2eList);
            e2s.put(path[1], e2sList);
        }
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            // 先求出当前节点所有的邻接节点

            // 1. 获取所有的出度
            List<Integer> s2eList = s2e.get(i);
            List<Integer> e2sList = e2s.get(i);
            int[] flowers = new int[(s2eList == null ? 0 : s2eList.size()) + (e2sList == null ? 0 : e2sList.size())];
            int index = 0;
            if (s2eList != null) {
                for (Integer flower : s2eList) {
                    flowers[index++] = flower;
                }
            }
            if (e2sList != null) {
                for (Integer flower : e2sList) {
                    flowers[index++] = flower;
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for (int flower : flowers) {
                if (result[flower - 1] != 0) {
                    set.add(result[flower - 1]);
                }
            }
            if (set.size() == 0) {
                result[i - 1] = 1;
            } else {
                for (int j = 1; j <= 4; j++) {
                    if (!set.contains(j)) {
                        result[i - 1] = j;
                        break;
                    }
                }
            }
        }

        return result;

    }

    /**
     * 1302. 层数最深叶子节点的和
     */
    public static int deepestLeavesSum(TreeNode root) {

        return handleDeepestLeavesSum(root, 0).sum;
    }

    public static Info handleDeepestLeavesSum(TreeNode node, int deep) {
        if (node == null) {
            return new Info(deep, 0);
        }
        if (node.left == null && node.right == null) {
            return new Info(deep, node.val);
        }
        Info leftInfo = handleDeepestLeavesSum(node.left, deep + 1);
        Info rightInfo = handleDeepestLeavesSum(node.right, deep + 1);
        int sum;
        int maxDeep = leftInfo.deep;
        if (leftInfo.deep > rightInfo.deep) {
            sum = leftInfo.sum;
        } else if (leftInfo.deep < rightInfo.deep) {
            maxDeep = rightInfo.deep;
            sum = rightInfo.sum;
        } else {
            sum = leftInfo.sum + rightInfo.sum;
        }
        return new Info(maxDeep, sum);
    }

    /**
     * 503. 下一个更大元素||
     */
    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = i + 1; j < i + n; j++) {
                if (nums[j % n] > num) {
                    result[i] = nums[j % n];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 1403. 非递增顺序的最小子序列
     */
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        // 对数组进行排序
        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;
        int leftNum = 0;
        result.add(nums[right]);
        int rightNum = nums[right--];

        while (left <= right) {
            if (leftNum + nums[left] < rightNum) {
                leftNum += nums[left++];
            } else {
                result.add(nums[right]);
                rightNum += nums[right--];
            }
        }
        return result;
    }

    /**
     * 623. 在二叉树中增加一行
     */
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int curDepth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curDepth == depth - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    assert node != null;
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(val, left, null);
                    node.right = new TreeNode(val, null, right);
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            curDepth++;
        }

        return root;
    }

    /**
     * 507. 完美数
     */
    public static boolean checkPerfectNumber(int num) {

        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i <= num) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

    /**
     * 508. 出现次数最多的子树元素和
     */
    public static int[] findFrequentTreeSum(TreeNode root) {
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        dfsCheckPerfectNumber(root, sumMap);

        sumMap.forEach((key, value) -> countMap.put(value, countMap.getOrDefault(value, 0) + 1));
        Stream<Integer> stream = countMap.values().stream();
        int max = 0;
        Optional<Integer> max1 = stream.max(Integer::compareTo);
        if (max1.isPresent()) {
            max = max1.get();
        }
        List<Integer> list = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        int finalMax = max;
        entries.forEach((entry) -> {
            if (entry.getValue() == finalMax) {
                list.add(entry.getKey());
            }
        });
        int[] result = new int[list.size()];

        int index = 0;
        for (Integer key : list) {
            result[index++] = key;
        }
        return result;

    }

    public static int dfsCheckPerfectNumber(TreeNode node, Map<TreeNode, Integer> sumMap) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            sumMap.put(node, node.val);
            return node.val;
        }
        if (sumMap.containsKey(node)) {
            return sumMap.get(node);
        }
        int sum = node.val + dfsCheckPerfectNumber(node.left, sumMap) + dfsCheckPerfectNumber(node.right, sumMap);
        sumMap.put(node, sum);
        return sum;
    }

    /**
     * 二叉树 morris 遍历
     */
    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            // mostRight 变成了cur左子树的最右的节点
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // 第一次访问cur
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    // 第二次访问cur
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    /**
     * mirris 先序遍历
     */
    public static void preOrderMorris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            // mostRight 变成了cur左子树的最右的节点
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // 第一次访问cur
                if (mostRight.right == null) {
                    System.out.println(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    // 第二次访问cur
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }

    public static String solveEquation(String equation) {
        equation += "=";
        int sign = 1, cur = 0, num = 0, k = 0;
        boolean hasVal = false, left = true;
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (CHARS.contains(String.valueOf(c))) {
                if (c == 'x') {
                    if (!hasVal) {
                        cur = 1;
                    }
                    k += left ? sign * cur : -sign * cur;
                } else {
                    num -= left ? sign * cur : -sign * cur;
                }
                cur = 0;
                hasVal = false;
            }

            switch (c) {
                case '-':
                    sign = -1;
                    break;
                case '+':
                    sign = 1;
                    break;
                case '=':
                    sign = 1;
                    left = false;
                    break;
                case 'x':
                    break;
                default:
                    cur = cur * 10 + (c - '0');
                    hasVal = true;
            }

        }
        if (k == 0) {
            return num != 0 ? "No solution" : "Infinite solutions";
        }
        return num % k == 0 ? String.format("x=%d", num / k) : "No solution";
    }

    /**
     * 517. 超级洗衣机
     */
    public static int findMinMoves(int[] machines) {
        int sum = 0;
        int n = machines.length;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % n != 0) {
            return -1;
        }
        int ans = Integer.MIN_VALUE;
        int avg = sum / n;
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int leftRest = leftSum - i * avg;
            int rightRest = sum - leftSum - machines[i] - (n - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += machines[i];
        }
        return ans;
    }

    public static void goodNote(int[] nices) {
        int n = nices.length;
        dp = new int[n + 1];
        used = new int[n];
        System.out.println(handle(nices, 0));
        System.out.println(Arrays.toString(dp));
    }

    public static int handle(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        if (index == nums.length - 1) {
            return dp[index];
        }
        if (index == nums.length - 2) {
            dp[index] = Math.max(nums[index], nums[index + 1]);
            return dp[index];
        }
        dp[index] = Math.max(handle(nums, index + 2) + nums[index], handle(nums, index + 1));
        return dp[index];
    }

    /**
     * 1450. 在既定时间做作业的学生人数
     */
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int result = 0;
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                result++;
            }
        }

        return result;
    }

    /**
     * 888. 运算符计算
     */
    public static int getValue(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    public static int[] value(char[] str, int i) {
        Deque<String> que = new ArrayDeque<>();
        int num = 0;
        int[] bra;
        // 当前数组不越界
        while (i < str.length && str[i] != ')') {
            if (Character.isDigit(str[i])) {
                num += num * 10 + str[i++] - '0';
            } else if (str[i] != '(') {
                // 遇到的是运算符号
                addNum(que, num);
                que.addLast(String.valueOf(str[i++]));
                num = 0;
            } else {
                // 如果遇到的是（
                bra = value(str, i + 1);
                num = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que, num);
        return new int[] {getNum(que), i};
    }

    /**
     * 计算只有+-的表达式的最终结果
     */
    private static int getNum(Deque<String> que) {
        while (que.size() > 1) {
            int firstNum = Integer.parseInt(que.pollFirst());
            String opt = que.pollFirst();
            int secend = Integer.parseInt(Objects.requireNonNull(que.pollFirst()));
            que.offerFirst(String.valueOf("+".equals(opt) ? firstNum + secend : firstNum - secend));
        }
        return Integer.parseInt(Objects.requireNonNull(que.poll()));
    }

    private static void addNum(Deque<String> que, int num) {
        if (que.isEmpty()) {
            que.addLast(String.valueOf(num));
            return;
        }
        // 如果栈顶元素是 * /
        if ("*".equals(que.peekLast()) || "/".equals(que.peekLast())) {
            String opt = que.pollLast();
            int firstNum = Integer.parseInt(Objects.requireNonNull(que.pollLast()));
            if ("*".equals(opt)) {
                que.offerLast(String.valueOf(firstNum * num));
            } else {
                que.offerLast(String.valueOf(firstNum / num));
            }
        } else {
            que.offerLast(String.valueOf(num));
        }
    }

    /**
     * 793. 阶乘函数后K个零
     */
    public static int preimageSizeFZF(int k) {

        long start = 0L, end = 5L * k, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            long n = 5L;
            long sum = 0L;
            while (n <= mid) {
                sum += mid / n;
                n *= 5;
            }
            if (sum == k) {
                return 5;
            }
            if (sum < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return 0;
    }

    static class Info1 {
        TreeNode node;
        int r;
        int c;

        public Info1(TreeNode node, int r, int c) {
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }

    static class Info {
        int deep;
        int sum;

        public Info(int deep, int sum) {
            this.deep = deep;
            this.sum = sum;
        }
    }

}
