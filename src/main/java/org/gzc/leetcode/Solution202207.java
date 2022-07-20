package org.gzc.leetcode;

import java.util.*;

import org.gzc.leetcode.model.ListNode;
import org.gzc.leetcode.model.MagicDictionary;
import org.gzc.leetcode.model.ReturnType;
import org.gzc.leetcode.model.TreeNode;

/**
 * @author GZC
 */
public class Solution202207 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 390:
                System.out.println(Arrays.toString(shuffle(new int[] {12, 3, 4, 5, 6, 7, 8, 9}, 4)));
                break;
            case 6111:
                ListNode root = new ListNode(3,
                    new ListNode(0,
                        new ListNode(2, new ListNode(6, new ListNode(8, new ListNode(1, new ListNode(7, new ListNode(9,
                            new ListNode(4, new ListNode(2, new ListNode(5, new ListNode(5, new ListNode(0)))))))))))));
                System.out.println(Arrays.deepToString(spiralMatrix(3, 5, root)));
                break;
            case 1200:
                List<List<Integer>> lists = minimumAbsDifference(new int[] {1, 2, 3, 4});
                System.out.println(lists);
                break;
            case 451:
                System.out.println(frequencySort("tree"));
                break;
            case 452:
                System.out.println(findMinArrowShots(new int[][] {{1, 2}}));
                break;
            case 454:
                System.out
                    .println(fourSumCount(new int[] {1, 2}, new int[] {1, 2}, new int[] {1, 2}, new int[] {1, 2}));
                break;
            case 455:
                System.out.println(findContentChildren(new int[] {1, 2}, new int[] {1, 2}));
                break;
            case 456:
                System.out.println(find132pattern(new int[] {1, 3, 2, 4, 5, 6, 7, 8, 9, 10}));
                System.out.println(find132pattern1(new int[] {1, 3, 2, 4, 5, 6, 7, 8, 9, 10}));
                break;
            case 1217:
                System.out.println(minCostToMoveChips(new int[] {1, 2}));
                break;
            case 457:
                System.out.println(circularArrayLoop(new int[] {1, 2}));
            case 1260:
                System.out.println(shiftGrid(new int[][] {{1, 2,3},{2,3,4}},2));
                break;
            case 666:
                TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                    new TreeNode(6, new TreeNode(5), new TreeNode(7)));
                List<Integer> result = new ArrayList<>();
                inOrderTraversal(node, result);
                System.out.println("先序遍历： " + preOrderTraversalForStack(node));
                System.out.println("后序遍历：" + postOrderTraversalForStack(node));
                System.out.println("中序遍历：" + inOrderTraversalForStack(node));
                System.out.println("层次遍历：" + levelOrderTraversal(node));
                System.out.println("判断搜索二叉树：" + isBST(node));
                System.out.println("判断完全二叉树：" + isCBT(node));
                System.out.println("判断平衡二叉树：" + isBBT(node));
                System.out.println("折纸问题：" + paperFold(2));
                System.out.println("计算最小公共祖先：" + getLCA(node,node.left.right,node.right.left).val);
                System.out.println("层次遍历计算最大节点的层数：" + Arrays.toString(levelOrderTraversalMaxNodes(node)));
                break;
            case 459:
                System.out.println(repeatedSubstringPattern("bb"));
                break;
            case 461:
                System.out.println(hammingDistance(123, 234));
                break;
            case 463:
                System.out.println(islandPerimeter(new int[][] {{1, 1}, {1, 1}}));
                break;
            case 464:
                System.out.println(canIWin(12, 15));
                break;
            case 466:
                int[] count = new int[10];
                for (int i = 0; i < 1000; i++) {
                    count[rand10() - 1]++;
                }
                System.out.println(Arrays.toString(count));
                break;
            case 676:
                MagicDictionary magicDictionary = new MagicDictionary();
                magicDictionary.buildDict(new String[] {"hello", "leetcode"});
                System.out.println(magicDictionary.search("hhllo"));
                break;
            case 460:
                LFUCache lfuCache = new LFUCache(64);
                lfuCache.put(1, 1);
                System.out.println(lfuCache.get(1));
                break;
            case 473:
                System.out.println(makesquare(new int[] {3, 4, 5, 22, 3}));
                System.out.println(makesquare1(new int[] {3, 4, 5, 22, 3}));
                break;
            case 474:
                System.out.println(findMaxForm(new String[] {"001", "1", "0"}, 3, 5));
                break;
            case 648:
                List<String> list = new ArrayList<>();
                System.out.println(replaceWords(list, " "));
                break;
            case 735:
                System.out.println(Arrays.toString(asteroidCollision(new int[] {2, 3, -4, -5})));
                break;
            default:
                test();
                break;
        }

    }

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2 * n];
        int left = 0;
        int right = n;
        int index = 0;
        for (int i = 0; i < n; i++) {
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
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -1);
        }
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (head != null) {
            // 向右
            for (int i = left; i <= right; i++) {
                result[top][i] = head.val;
                head = head.next;
                if (head == null) {
                    return result;
                }
            }
            if (top < bottom) {
                top++;
            }

            // 向下
            for (int i = top; i <= bottom; i++) {
                result[i][right] = head.val;
                head = head.next;
                if (head == null) {
                    return result;
                }
            }
            if (left < right) {
                right--;
            }

            // 向左
            for (int i = right; i >= left; i--) {
                result[bottom][i] = head.val;
                head = head.next;
                if (head == null) {
                    return result;
                }
            }
            if (top < bottom) {
                bottom--;
            }
            // 向上
            for (int i = bottom; i >= top; i--) {
                result[i][left] = head.val;
                head = head.next;
                if (head == null) {
                    return result;
                }
            }
            if (left < right) {
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
                list.add(arr[i + 1]);
                result.add(list);
                min = arr[i + 1] - arr[i];

            } else if (min == arr[i + 1] - arr[i]) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                result.add(list);
            }
        }
        return result;
    }

    /**
     * 451. 根据字符出现频率排序
     */
    public static String frequencySort(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(charMap.entrySet());
        list.sort(
            (Map.Entry<Character, Integer> en1, Map.Entry<Character, Integer> en2) -> en2.getValue() - en1.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> en1 : list) {
            int n = en1.getValue();
            for (int i = 0; i < n; i++) {
                sb.append(en1.getKey());
            }
        }
        return sb.toString();

    }

    /**
     * 452. 用最少数量的箭引爆气球
     */
    public static int findMinArrowShots(int[][] points) {

        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt((int[] point) -> point[1]));
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;

    }

    /**
     * 454. 四数相加2
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if (map.containsKey(-(num3 + num4))) {
                    count += map.get(-(num3 + num4));
                }
            }
        }
        return count;
    }

    /**
     * 455. 分发饼干
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLen = g.length;
        int sLen = s.length;
        int gIndex = 0;
        int sIndex = 0;
        int result = 0;
        while (gIndex < gLen && sIndex < sLen) {
            if (s[sIndex] >= g[gIndex]) {
                gIndex++;
                sIndex++;
                result++;
            } else {
                sIndex++;
            }
        }
        return result;

    }

    /**
     * 456. 132模式 超时 O(n^2)
     */
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            // 查找左边的小于nums[i]的最小值
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (min > nums[j] && nums[j] < nums[i]) {
                    min = nums[j];
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (max < nums[j] && nums[j] < nums[i]) {
                    max = nums[j];
                }
            }
            if (max > min) {
                return true;
            }
        }
        return false;
    }

    /**
     * 456. 132模式
     */
    public static boolean find132pattern1(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }
        return false;
    }

    /**
     * 648. 单词替换
     */
    public static String replaceWords(List<String> dictionary, String sentence) {
        List<String> result = new ArrayList<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            String wordRoot = word;
            for (String dict : dictionary) {
                if (word.startsWith(dict)) {
                    if (dict.length() < wordRoot.length()) {
                        wordRoot = dict;
                    }
                }
            }
            result.add(wordRoot);
        }
        return String.join(" ", result);
    }

    /**
     * 1217. 玩筹码
     */
    public static int minCostToMoveChips(int[] position) {
        // 移动到某个偶数的位置，所有奇数的个数和就是此时的代价
        int even = 0;
        int odd = 0;
        for (int pos : position) {
            if (pos % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }

    /**
     * 457. 环形数组是否存在循环
     */
    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 在nums[i] ==0 设置当前节点已经遍历过，而且没有生成环
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(nums, i);
            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    // 循环的长度大于1 相遇的位置是环的起点
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    public static int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n; // 保证返回值在 [0,n) 中 }

    }

    /**
     * 459. 重复的子字符串
     */
    public static boolean repeatedSubstringPattern(String s) {
        HashSet<Integer> set = new HashSet<>();
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                set.add(i);
            }
        }
        for (Integer integer : set) {
            int start = 0;
            int end = integer;
            String subStr = s.substring(start, end);
            boolean flag = true;
            while (end <= len) {
                if (s.substring(start, end).equals(subStr)) {
                    start = end;
                    end = end + integer;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    /**
     * 461. 汉明距离
     */
    public static int hammingDistance(int x, int y) {
        int result = 0;
        while (x > 0 && y > 0) {
            if (x % 2 != y % 2) {
                result++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        while (x > 0) {
            if (x % 2 == 1) {
                result++;
            }
            x = x >> 1;
        }
        while (y > 0) {
            if (y % 2 == 1) {
                result++;
            }
            y = y >> 1;
        }
        return result;

    }

    /**
     * 463. 岛屿的周长
     */
    public static int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] useFlag = new int[row][col];
        int[][] direction = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<Xy> stack = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    // 计算所有的
                    stack.offer(new Xy(i, j));
                    while (!stack.isEmpty()) {

                        Xy top = stack.poll();
                        if (useFlag[top.x][top.y] == 1) {
                            continue;
                        }
                        for (int k = 0; k < 4; k++) {
                            int newx = direction[k][0] + top.x;
                            int newy = direction[k][1] + top.y;
                            // 判断边界是否是周长
                            if (isSea(new Xy(newx, newy), row, col, grid)) {
                                result++;
                            } else {
                                if (useFlag[newx][newy] == 0) {
                                    Xy xy = new Xy(newx, newy);
                                    System.out.println(xy.x + " " + xy.y);
                                    stack.offer(xy);
                                }

                            }
                        }
                        useFlag[top.x][top.y] = 1;
                    }
                    return result;
                }
            }
        }
        return result;

    }

    private static boolean isSea(Xy x, int row, int col, int[][] grid) {
        if (x.x >= 0 && x.x < row && x.y >= 0 && x.y < col) {
            return grid[x.x][x.y] != 1;
        }
        return true;

    }

    private static class Xy {
        int x;
        int y;

        public Xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 464. 我能赢吗
     */
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 总长度不满足目标值
        if (maxChoosableInteger * (maxChoosableInteger + 1) < (desiredTotal * 2)) {
            return false;
        }
        // 存储state的变量值，state一共有2^maxChoosableInteger种
        Map<Integer, Boolean> memory = new HashMap<>(1 << maxChoosableInteger);
        // 开始遍历整个树
        return dfs_canIWin(maxChoosableInteger, 0, desiredTotal, 0, memory);
    }

    /**
     * @param maxChoosableInteger 最大可选择的数字
     * @param state 状态位
     * @param desiredTotal 目标值
     * @param curTotal 当前值
     * @param memory 存储搜索过的状态
     */
    private static boolean dfs_canIWin(int maxChoosableInteger, int state, int desiredTotal, int curTotal,
        Map<Integer, Boolean> memory) {
        if (!memory.containsKey(state)) {
            boolean ans = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                // state的第i位表示 第i+1个数字被使用
                if (((state >> i) & 1) == 1) {
                    continue;
                }
                // 先手取i看 能不能赢 不能赢则轮到对手取数字
                if (curTotal + i + 1 >= desiredTotal) {
                    ans = true;
                    break;
                }
                // 轮到对手取数字 若对手不能赢（必然输掉的状态） 则我方赢
                // state | (1 << i), 将state的第i位置为已使用
                if (!dfs_canIWin(maxChoosableInteger, state | (1 << i), desiredTotal, curTotal + i + 1, memory)) {
                    ans = true;
                    break;
                }
            }
            memory.put(state, ans);
        }
        return memory.get(state);
    }

    /**
     * 735. 行星碰撞
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean alive = true;
            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();
                if (top <= -asteroid) {
                    stack.pop();
                }
                if (top >= -asteroid) {
                    alive = false;
                }
            }
            if (alive) {
                stack.push(asteroid);
            }
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    /**
     * 470. 用Rand7()实现Rand10()
     */
    public static int rand10() {
        int row, col, idx;
        Random rand = new Random();
        do {
            row = rand.nextInt(7) + 1;
            col = rand.nextInt(7) + 1;
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    /**
     * 473. 火柴拼正方形
     */
    public static boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        // 降序排列
        Arrays.sort(matchsticks);
        Collections.reverse(Collections.singletonList(matchsticks));
        int[] edges = new int[4];
        return dfs_makesquare(0, matchsticks, edges, sum / 4);
    }

    public static boolean dfs_makesquare(int index, int[] matchsticks, int[] edges, int len) {
        int n = matchsticks.length;
        if (index == n) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs_makesquare(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

    public static boolean makesquare1(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        // 1 << n 所有的状态
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                // 把当前的火柴拿掉 100 -》011
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    // 一条边放满后，自动清零
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        // 所有的火柴都使用了，边也刚刚填满
        return dp[(1 << n) - 1] == 0;
    }

    /**
     * 474. 一和零
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            // 计算当前字符的零和一的个数
            int[] zerosAndOnes = getZerosAndOnes(strs[i - 1]);
            int zers = zerosAndOnes[0];
            int ones = zerosAndOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zers && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zers][k - ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];

    }

    public static int[] getZerosAndOnes(String str) {
        int[] result = new int[2];
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            result[str.charAt(i) - '0']++;
        }
        return result;
    }

    /**
     * 二叉树递归遍历（基于递归序遍历）
     */

    public static void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 先序遍历
        list.add(root.val);
        inOrderTraversal(root.left, list);
        // 中序遍历
        // list.add(root.val);
        inOrderTraversal(root.right, list);
        // 后序遍历
        // list.add(root.val);

    }

    /**
     * 先序非递归遍历
     */
    public static List<Integer> preOrderTraversalForStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();

            list.add(top.val);

            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }

        return list;
    }

    /**
     * 后序非递归遍历
     */
    public static List<Integer> postOrderTraversalForStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            stack1.push(top);
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
        }
        while (!stack1.isEmpty()) {
            list.add(stack1.pop().val);
        }
        return list;
    }

    /**
     * 中序非递归遍历
     */
    public static List<Integer> inOrderTraversalForStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
        return list;
    }

    /**
     * 二叉树的层次遍历
     */
    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return list;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode first = deque.pollLast();
            list.add(first.val);
            if (first.left != null) {
                deque.push(first.left);
            }
            if (first.right != null) {
                deque.push(first.right);
            }

        }
        return list;
    }

    /**
     * 二叉树的层次遍历计算节点最多的层数
     */
    public static int[] levelOrderTraversalMaxNodes(TreeNode root) {
        int max = 0;
        int maxLevel = 1;
        if (root == null) {
            return new int[] {max, 0};
        }
        int curLevel = 1;
        // 用于保存节点所在的层数
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, curLevel);
        int curLevelNodes = 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode first = deque.pollLast();
            Integer nodeLevel = map.get(first);
            if (curLevel == nodeLevel) {
                curLevelNodes++;
            } else {
                if (max < curLevelNodes) {
                    max = curLevelNodes;
                    maxLevel = nodeLevel;
                }
                curLevelNodes = 1;
                curLevel++;

            }
            if (first.left != null) {
                deque.push(first.left);
                map.put(first.left, curLevelNodes + 1);
            }
            if (first.right != null) {
                deque.push(first.right);
                map.put(first.right, curLevelNodes + 1);
            }

        }
        return new int[] {max, maxLevel};
    }

    /**
     * 判断一个二叉树是否是二叉搜索树
     */
    public static int preValue = Integer.MIN_VALUE;

    public static boolean isBST(TreeNode node) {

        if (node == null) {
            return true;
        }
        if (!isBST(node.left)) {
            return false;
        }
        if (preValue >= node.val) {
            return false;
        } else {
            preValue = node.val;
        }
        return isBST(node.right);
    }

    /**
     * 判断一个二叉树是否是完全二叉树
     */
    public static boolean isCBT(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                assert poll != null;
                if (poll.left == null && poll.right != null) {
                    return false;
                } else {
                    if (!flag) {
                        if (poll.left != null && poll.right != null) {
                            queue.offer(poll.left);
                            queue.offer(poll.right);
                        } else {
                            if (poll.left != null) {
                                queue.offer(poll.left);
                            }
                            flag = true;
                        }
                    } else {
                        if (poll.left != null) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    /**
     * 判断一个二叉树是否是平衡二叉树
     */
    public static boolean isBBT(TreeNode node){
        ReturnType returnType = checkBBT(node);
        return returnType.isBalance();

    }

    public static ReturnType checkBBT(TreeNode node){
        if(node == null){
            return new ReturnType(true, 0);
        }
        ReturnType leftReturnType = checkBBT(node.left);
        ReturnType rightReturnType = checkBBT(node.right);


        int height = Math.max(leftReturnType.getHeight(), rightReturnType.getHeight())+1;

        return new ReturnType(leftReturnType.isBalance() && rightReturnType.isBalance() && Math.abs(leftReturnType.getHeight() - rightReturnType.getHeight()) <2,height);
    }

    /**
     * 找到两个节点的最小公共祖先
     */
    public static TreeNode getLCA(TreeNode head,TreeNode o1,TreeNode o2){
        if(head == null || o1 == head || o2 == head){
            return head;
        }
        TreeNode left = getLCA(head.left, o1, o2);
        TreeNode right = getLCA(head.right, o1, o2);

        if(left != null && right != null){
            return head;
        }
        return left != null?left:right;
    }

    /**
     * 折纸问题
     */
    public static String paperFoldStr = "";
    public static String paperFold(int n){
        paperFoldDfs(1,n,true);
        return paperFoldStr;
    }

    public static void paperFoldDfs(int i,int n,boolean isDown){
        if(i > n){
            return;
        }
        paperFoldDfs(i+1,n,true);
        paperFoldStr = paperFoldStr+ (isDown?"凹":"凸");
        paperFoldDfs(i+1,n,false);

    }

    /**
     * 1260. 二维网络迁移
     */
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int size = n*m;
        int[] nums = new int[n*m];

        for (int i = 0;i<n;i++){
            System.arraycopy(grid[i], 0, nums, i * m, m);
        }

        k = k%size;
        k = size-k;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i<n;i++){
            List<Integer> num = new ArrayList<>();
            for (int j = 0;j<m;j++){
                num.add(nums[k++%size]);
            }
            result.add(num);
        }

        return result;

    }

    public static void test(){
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
        pq.add(4);
        pq.add(2);
        pq.add(3);
        System.out.println(pq.poll());
    }

}