package org.gzc.leetcode;

import org.gzc.leetcode.model.ParkingSystem;
import org.gzc.leetcode.model.TreeNode;
import org.gzc.leetcode.model.UnionFind2;

import java.util.*;

/**
 * @author GZC
 */
public class Solution202210 {

    /**
     * 956. 最高的广告牌
     */
    public static int tallestBillboardAns = 0;
    public static Set<TallestBillboardInfo> set = new HashSet<>();
    /**
     * 1601. 最多可达成的换楼请求数目
     */
    public static int maximumRequestsAnswer = 0;
    public static int num_two = 2;
    public static int num_three = 3;
    public static int num_four = 4;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 1800:
                System.out.println(maxAscendingSum(new int[] {1, 2, 3, 4}));
                break;
            case 1601:
                System.out.println(maximumRequests(5, new int[][] {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
                break;
            case 934:
                System.out.println(shortestBridge(
                    new int[][] {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}}));
                break;
            case 1603:
                ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
                System.out.println(parkingSystem.addCar(1));
                System.out.println(parkingSystem.addCar(1));
                System.out.println(parkingSystem.addCar(2));
                System.out.println(parkingSystem.addCar(3));

                break;
            case 870:
                System.out
                    .println(Arrays.toString(advantageCount(new int[] {12, 24, 8, 32}, new int[] {13, 25, 32, 11})));
                break;
            case 1551:
                System.out.println(minOperations(3));
                break;
            case 952:
                System.out.println(largestComponentSize(new int[] {4, 6, 15, 9}));
                break;
            case 904:
                System.out.println(totalFruit(new int[] {1, 2, 3, 2, 2}));
                break;
            case 1733:
                System.out
                    .println(minimumTeachings(2, new int[][] {{1}, {2}, {1, 2}}, new int[][] {{1, 2}, {1, 3}, {2, 3}}));
                break;
            case 957:
                System.out.println(Arrays.toString(prisonAfterNDays(new int[] {0, 1, 0, 1, 1, 0, 0, 1}, 7)));
                break;
            case 956:
                System.out.println(tallestBillboard(
                    new int[] {33, 30, 41, 34, 37, 29, 26, 31, 42, 33, 38, 27, 33, 31, 35, 900, 900, 900, 900, 900}));
                break;
            case 955:
                System.out.println(minDeletionSize(new String[] {"123", "612", "156", "913"}));
                break;
            case 959:
                System.out.println(regionsBySlashes(new String[] {" /", "/ "}));
                break;
            case 1552:
                System.out.println(maxDistance(new int[] {1, 2, 3, 4, 5, 6}, 3));
                break;
            case 915:
                System.out.println(partitionDisjoint(new int[] {5, 0, 3, 8, 6}));
                break;
            case 1822:
                System.out.println(arraySign(new int[] {5, 0, 3, 8, 6}));
                break;
            case 481:
                System.out.println(magicalString(2));
                break;
            case 1952:
                System.out.println(isThree(9));
                break;
            case 862:
                System.out.println(shortestSubarray(new int[] {2, -1, 2}, 3));
                break;
            case 1755:
                System.out.println(minAbsDifference(new int[] {9210, -5402, 8022, -4660, -1719, -9686, 3899, 8543,
                    -8813, 2070, 3791, 3177, -775, -9400, -7036, -7050, -9843, 2563, -1190, 5216, -1089, 2210, 5775,
                    1027, 2729, 4947, -6183, 5850, 1616, -5259, 3605, -5142}, -10259));
                break;
            case 1700:
                System.out.println(countStudents(new int[] {1, 1, 1, 0, 0, 1}, new int[] {1, 0, 0, 0, 1, 1}));
                break;
            case 1253:
                System.out.println(reconstructMatrix(9, 2, new int[] {0, 1, 2, 0, 0, 0, 0, 0, 2, 1, 2, 1, 2}));
                break;
            case 958:
                TreeNode treeNode = new TreeNode(1, new TreeNode(3), null);
                System.out.println(isCompleteTree(treeNode));
                break;
            case 951:
                TreeNode node = new TreeNode(1, new TreeNode(3), null);
                TreeNode node1 = new TreeNode(1, null, new TreeNode(3));
                System.out.println(flipEquiv(node, node1));
                break;
            case 907:
                System.out.println(sumSubarrayMins(new int[] {11, 81, 94, 43, 3}));
                break;
            default:
                break;
        }
    }

    /**
     * 1952. 三除数
     */
    public static boolean isThree(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return i * i == n;
            }
        }
        return false;
    }

    /**
     * 481. 神奇字符串
     */
    public static int magicalString(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int res = 0;
        int left = 0;
        int right = 0;
        int lastChar = 0;
        while (left < n) {
            lastChar = (lastChar) % 2 + 1;
            if (result[right] == 0) {
                result[right] = lastChar;
            }
            int count = Integer.parseInt(String.valueOf(result[right++]));
            for (int i = 0; i < count; i++) {
                if (left < n) {
                    result[left++] = lastChar;
                    if (lastChar == 1) {
                        res++;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 907. 子数组的最小值之和
     */
    public static int sumSubarrayMins(int[] arr) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int result = 0;
        int mod = 1000000001;
        int n = arr.length;
        int curSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!pq1.isEmpty()) {
                int max = pq1.peek();
                if (max > arr[i]) {
                    pq1.poll();
                    curSum -= max;
                    curSum += arr[i];
                    pq1.offer(arr[i]);
                } else {
                    break;
                }
            }
            curSum += arr[i];
            result += curSum;
            result %= mod;
            pq1.offer(arr[i]);
        }
        return result % mod;

    }

    /**
     * 1755. 最接近目标值得子序列值
     */
    public static int minAbsDifferenceResult = Integer.MAX_VALUE;
    public static Set<Info> dpSet = new HashSet<>();

    public static int minAbsDifference(int[] nums, int goal) {

        minAbsDifferenceDfs(nums, goal, 0, 0);

        return minAbsDifferenceResult == Integer.MAX_VALUE ? 0 : minAbsDifferenceResult;
    }

    private static void minAbsDifferenceDfs(int[] nums, int goal, int index, int curSum) {
        if (dpSet.contains(new Info(index, curSum))) {
            return;
        }
        if (Math.abs(curSum - goal) < minAbsDifferenceResult) {
            minAbsDifferenceResult = Math.abs(curSum - goal);
        }
        if (index == nums.length) {
            return;
        }
        dpSet.add(new Info(index, curSum));
        int sum = curSum + nums[index];
        // 取当前值
        minAbsDifferenceDfs(nums, goal, index + 1, sum);
        // 不取当前值
        minAbsDifferenceDfs(nums, goal, index + 1, curSum);
    }

    public static class Info {
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Info info = (Info)o;
            return x == info.x && y == info.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * 1822. 数组元素积的符号
     */
    public static int arraySign(int[] nums) {
        int navigationCount = 0;
        int zeroCount = 0;
        for (int num : nums) {
            if (num < 0) {
                navigationCount++;
            } else if (num == 0) {
                zeroCount++;
            }
        }

        if (zeroCount > 0) {
            return 0;
        }
        if (navigationCount != 0) {
            if (navigationCount % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        return 1;
    }

    /**
     * 862. 和至少为K的最短子数组
     */
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSumArr[i];
            while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }

    // 上、下、右、左四个方向
    public static int[][] coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    // 用户存储边缘格子
    public static Deque<int[]> edges;

    /**
     * 934. 最短的桥
     */
    public static int shortestBridge(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean findIsland = false; // 只要找到2个岛屿中其中的1个岛屿，就将其设置为true，并结束步骤1中的两层for循环
        edges = new ArrayDeque<>();
        /* 步骤1：为其中一个岛屿打标记（val=2），并保存”边界格子“到edges中 */
        for (int i = 0; !findIsland && i < grid.length; i++) {
            for (int j = 0; !findIsland && j < grid[0].length; j++) {
                if (findIsland = (grid[i][j] == 1)) {
                    markIsland(grid, i, j);
                }
            }
        }

        while (!edges.isEmpty()) {
            result++; // 扩展层数
            int num = edges.size();
            for (int i = 0; i < num; i++) {
                int[] edge = edges.removeFirst();
                for (int[] c : coordinates) { // 向edge的四个方向查看格子编号，并扩展岛屿边界
                    int nex = edge[0] + c[0], ney = edge[1] + c[1];
                    if (isLegal(nex, ney, m, n) && grid[nex][ney] == 0) {
                        edges.addLast(new int[] {nex, ney}); // 添加新的边界
                        grid[nex][ney] = 2;
                    } else if (isLegal(nex, ney, m, n) && grid[nex][ney] == 1) {
                        return result; // 与另一个岛屿相遇，则直接返回result
                    }
                }
            }
        }
        return result;
    }

    public static void markIsland(int[][] grid, int row, int column) {
        if (!isLegal(row, column, grid.length, grid[0].length) || grid[row][column] == 2) {
            return;
        }
        if (grid[row][column] == 0) {
            grid[row][column] = 2; // 将边界向外扩展1层岛屿（val=2)
            edges.addLast(new int[] {row, column});
            return;
        }
        grid[row][column] = 2; // 为岛屿打标记（val=2）
        for (int[] c : coordinates) {
            markIsland(grid, row + c[0], column + c[1]); // 深度遍历某个格子的四个方向
        }
    }

    public static boolean isLegal(int row, int column, int m, int n) {
        return row >= 0 && row < m && column >= 0 && column < n;
    }

    /**
     * 915. 分割数组
     */
    public static int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[n - 1] = nums[n - 1];
        for (int i = n - num_two; i >= 0; i--) {
            min[i] = Math.min(nums[i], min[i + 1]);
        }
        int leftMax = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > leftMax) {
                leftMax = nums[i];
            }
            if (leftMax <= min[i + 1]) {
                return i + 1;
            }
        }
        return -1;

    }

    /**
     * 959. 由斜杠划分区域
     */
    public static int regionsBySlashes(String[] grid) {
        int n = grid[0].length();
        int res = 0;
        int[][] gridArr = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = i * 3;
                int y = j * 3;
                if (grid[i].charAt(j) == '\\') {
                    for (int k = 0; k < num_three; k++) {
                        gridArr[x++][y++] = 1;
                    }
                }
                if (grid[i].charAt(j) == '/') {

                    gridArr[x + 1][y + 1] = 1;
                    gridArr[x + 2][y] = 1;
                    gridArr[x][y + 2] = 1;
                }
            }
        }
        int[][] dic = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n * num_three; i++) {
            for (int j = 0; j < n * num_three; j++) {
                // 开始扩散
                if (gridArr[i][j] == 0) {
                    Deque<Integer> stack = new ArrayDeque<>();
                    stack.offerLast(i);
                    stack.offerLast(j);
                    gridArr[i][j] = 1;
                    while (!stack.isEmpty()) {
                        int x = stack.pollFirst();
                        int y = 0;
                        if (!stack.isEmpty()) {
                            y = stack.pollFirst();
                        }
                        for (int k = 0; k < num_four; k++) {
                            if (validDic(x + dic[k][0], y + dic[k][1], n * 3)) {
                                if (gridArr[x + dic[k][0]][y + dic[k][1]] == 0) {
                                    stack.offerLast(x + dic[k][0]);
                                    stack.offerLast(y + dic[k][1]);
                                    gridArr[x + dic[k][0]][y + dic[k][1]] = 1;
                                }
                            }
                        }
                    }
                    res++;

                }
            }
        }
        return res;

    }

    public static boolean validDic(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    /**
     * 1700. 无法吃午餐的学生数量
     */
    public static int countStudents(int[] students, int[] sandwiches) {

        Deque<Integer> stuDeque = new ArrayDeque<>();
        Deque<Integer> sanDeque = new ArrayDeque<>();
        int n = students.length;
        for (int i = 0; i < n; i++) {
            stuDeque.offerLast(students[i]);
            sanDeque.offerLast(sandwiches[i]);
        }
        while (!stuDeque.isEmpty()) {
            int size = stuDeque.size();
            for (int i = 0; i < size; i++) {
                Integer like = stuDeque.pollFirst();
                Integer sandwich = sanDeque.peekFirst();
                assert like != null;
                if (like.equals(sandwich)) {
                    sanDeque.pollFirst();
                } else {
                    stuDeque.offerLast(like);
                }
            }
            if (size == stuDeque.size()) {
                break;
            }

        }
        return stuDeque.size();

    }

    /**
     * 1253. 重构2行二进制矩阵
     */
    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        int sum = Arrays.stream(colsum).sum();
        if (upper + lower != sum) {
            return result;
        }
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (int colSum : colsum) {

            if (colSum == 2) {
                result.get(0).add(1);
                result.get(1).add(1);
                upper--;
                lower--;
            } else if (colSum == 1) {
                if (upper > lower) {
                    upper--;
                    result.get(0).add(1);
                    result.get(1).add(0);
                } else {
                    lower--;
                    result.get(0).add(0);
                    result.get(1).add(1);
                }
            } else {
                result.get(0).add(0);
                result.get(1).add(0);
            }
        }
        if (upper != 0 || lower != 0) {
            result.clear();
        }
        return result;
    }

    /**
     * 1552. 两球之间的磁力
     */
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }

    /**
     * 1733. 需要教语言的最少人数
     */
    @SuppressWarnings("unchecked")
    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // 人数
        int m = languages.length;
        // 表示是否遍历过
        boolean[] p = new boolean[m + 1];
        // 统计每种语言下，可以说该门语言但不能直接和好友交流的人
        HashSet<Integer>[] set = new HashSet[n + 1];
        for (int i = 0; i < n + 1; i++) {
            set[i] = new HashSet<>();
        }
        for (int[] friend : friendships) {
            int u = friend[0];
            int v = friend[1];
            // 使用set判断u和v是否可以通过某种语言进行直接交流，是就跳过
            Set<Integer> tmp = new HashSet<>();
            boolean flag = false;
            for (int k : languages[u - 1]) {
                tmp.add(k);
            }
            for (int k : languages[v - 1]) {
                if (tmp.contains(k)) {
                    flag = true;
                    break;
                }
            }
            // 是，就跳过
            if (flag) {
                continue;
            }
            // 对于u和v，如果没被遍历过，则加入对应语言set中
            if (!p[u]) {
                p[u] = true;
                for (int k : languages[u - 1]) {
                    set[k].add(u);
                }
            }
            if (!p[v]) {
                p[v] = true;
                for (int k : languages[v - 1]) {
                    set[k].add(v);
                }
            }
        }
        int ans = m;
        // num，表示不能直接交流的人的总人数
        int num = 0;
        for (int i = 1; i < m + 1; i++) {
            if (p[i]) {
                num++;
            }
        }
        // 判断每种语言下，需要学习的人数，取最小即答案
        for (int i = 1; i < n + 1; i++) {
            ans = Math.min(ans, num - set[i].size());
        }
        return ans;
    }

    /**
     * 904. 水果成篮
     */
    public static int totalFruit(int[] fruits) {
        int max = 0;
        int left = 0;
        int right = 0;
        int cur = 0;
        // 存储当前窗口中的水果
        Map<Integer, Integer> map = new HashMap<>(16);
        int n = fruits.length;
        while (right < n) {
            int fruit = fruits[right++];
            if (map.containsKey(fruit)) {
                map.put(fruit, map.get(fruit) + 1);
                cur++;
            } else {
                if (map.size() < 2) {
                    map.put(fruit, 1);
                    cur++;
                } else {
                    max = Math.max(max, cur);
                    // 滑动窗口，删除窗口中的一个水果
                    while (left <= right) {
                        int leftFruit = fruits[left++];
                        int leftFruitCount = map.get(leftFruit);
                        if (leftFruitCount == 1) {
                            map.remove(leftFruit);
                            map.put(fruit, 1);
                            break;
                        } else {
                            map.put(leftFruit, leftFruitCount - 1);
                            cur--;
                        }

                    }

                }
            }
        }
        return Math.max(max, cur);

    }

    /**
     * 958. 二叉树的完全性检验
     */
    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reachedEnd = false;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (reachedEnd && cur != null) {
                return false;
            }
            if (cur == null) {
                reachedEnd = true;
                continue;
            }
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return true;
    }

    /**
     * 957. N天后的牢房
     */
    public static int[] prisonAfterNDays(int[] cells, int n) {
        List<int[]> cellsArr = new ArrayList<>();
        int cycle = 0;
        for (int i = 0; i < n; i++) {
            int length = cells.length;
            int[] newCells = new int[length];
            for (int j = 0; j < length; j++) {
                if (j == 0 || j == length - 1) {
                    newCells[j] = 0;
                } else {
                    if (cells[j - 1] == cells[j + 1]) {
                        newCells[j] = 1;
                    } else {
                        newCells[j] = 0;
                    }
                }
            }

            if (i == 0) {
                cellsArr.add(newCells);
            } else {
                // 计算出当前的周期是多少
                if (Arrays.equals(newCells, cellsArr.get(0))) {
                    cycle = i;
                    break;
                }
                cellsArr.add(newCells.clone());
            }
            cells = newCells.clone();
        }
        if (n > cycle && cycle != 0) {
            n = n % cycle;
            if (n == 0) {
                n = cycle;
            }
        }
        return cellsArr.get(n - 1);
    }

    public static int tallestBillboard(int[] rods) {
        int n = rods.length;
        int[] sumArr = new int[n];
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sumArr[i] = sum + rods[i];
            sum = sumArr[i];
        }
        tallestBillboardDfs(rods, sumArr, 0, 0, 0);
        return tallestBillboardAns;
    }

    public static void tallestBillboardDfs(int[] rods, int[] sumArr, int index, int cur1, int cur2) {

        if (index == rods.length) {
            if (cur1 == cur2) {
                tallestBillboardAns = Math.max(tallestBillboardAns, cur1);
            }
            return;
        }
        if (set.contains(new TallestBillboardInfo(cur1, cur2, index))) {
            return;
        }
        if ((cur1 + cur2 + sumArr[index]) < tallestBillboardAns * num_two) {
            return;
        }
        int max = Math.max(cur1, cur2);
        int min = Math.min(cur1, cur2);
        int sub = max - min;
        if (sub > sumArr[index]) {
            return;
        } else if (sub == sumArr[index]) {
            tallestBillboardAns = Math.max(tallestBillboardAns, max);
            return;
        }

        // 三个可能性
        tallestBillboardDfs(rods, sumArr, index + 1, cur1 + rods[index], cur2);
        tallestBillboardDfs(rods, sumArr, index + 1, cur1, cur2);
        tallestBillboardDfs(rods, sumArr, index + 1, cur1, cur2 + rods[index]);

        set.add(new TallestBillboardInfo(cur1, cur2, index));
        set.add(new TallestBillboardInfo(cur2, cur1, index));
    }

    /**
     * 955. 删列造序||
     */
    public static int minDeletionSize(String[] A) {
        int N = A.length;
        int W = A[0].length();
        int ans = 0;

        String[] cur = new String[N];
        for (int j = 0; j < W; ++j) {
            String[] cur2 = Arrays.copyOf(cur, N);
            for (int i = 0; i < N; ++i) {
                cur2[i] += A[i].charAt(j);
            }

            if (isSorted(cur2)) {
                cur = cur2;
            } else {
                ans++;
            }
        }

        return ans;
    }

    public static boolean isSorted(String[] A) {
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i].compareTo(A[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 952. 按公因数计算最大组件的大小
     */
    public static int largestComponentSize(int[] nums) {
        OptionalInt max = Arrays.stream(nums).max();
        if (!max.isPresent()) {
            return -1;
        }
        int m = max.getAsInt();
        UnionFind2 uf = new UnionFind2(m + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int[] counts = new int[m + 1];
        int ans = 0;
        for (int num : nums) {
            int root = uf.find(num);
            counts[root]++;
            ans = Math.max(ans, counts[root]);
        }
        return ans;
    }

    /**
     * 951. 反转等价二叉树
     */
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return false;
        }
        if (root1.left == null && root1.right == null && root2.left == null && root2.right == null) {
            return root1.val == root2.val;
        }
        return (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
            || flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) && root1.val == root2.val;
    }

    public static int maximumRequests(int n, int[][] requests) {
        maximumRequestsDfs(new int[n], requests, 0, 0);
        return maximumRequestsAnswer;
    }

    public static void maximumRequestsDfs(int[] used, int[][] requests, int cur, int chosen) {
        if (cur == requests.length) {
            if (validUsedArr(used)) {
                maximumRequestsAnswer = Math.max(chosen, maximumRequestsAnswer);
            }
            return;
        }
        // 不选当前的request
        maximumRequestsDfs(used, requests, cur + 1, chosen);

        // 选择当前的request
        used[requests[cur][0]]--;
        used[requests[cur][1]]++;
        maximumRequestsDfs(used, requests, cur + 1, chosen + 1);
        // 回溯
        used[requests[cur][1]]--;
        used[requests[cur][0]]++;
    }

    private static boolean validUsedArr(int[] used) {
        for (int i : used) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 870. 优势洗牌
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            // 找到最小的满足数
            Integer integer = map.higherKey(nums2[i]);
            if (integer == null) {
                integer = map.firstKey();
            }
            result[i] = integer;
            if (map.get(integer) == 1) {
                map.remove(integer);
            } else {
                map.put(integer, map.get(integer) - 1);
            }
        }
        return result;
    }

    /**
     * 1551. 使数组中所有元素相等的最小操作数
     */
    public static int minOperations(int n) {
        int num = 2 * (n - 1) + 1;
        int avg = (num + 1) / 2;
        int res = 0;
        for (int i = 0; i * num_two < n; i++) {
            res += (avg - (2 * i + 1));
        }
        return res;
    }

    /**
     * 1800. 最大升序子数组和
     */
    public static int maxAscendingSum(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        int lastNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > lastNum) {
                sum += num;
            } else {
                result = Math.max(result, sum);
                sum = num;
            }
            lastNum = num;
        }
        return Math.max(result, sum);
    }

    static class TallestBillboardInfo {
        int cur1;
        int cur2;
        int index;

        public TallestBillboardInfo(int cur1, int cur2, int index) {
            this.cur1 = cur1;
            this.cur2 = cur2;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TallestBillboardInfo info = (TallestBillboardInfo)o;
            return cur1 == info.cur1 && cur2 == info.cur2 && index == info.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cur1, cur2, index);
        }
    }

}
