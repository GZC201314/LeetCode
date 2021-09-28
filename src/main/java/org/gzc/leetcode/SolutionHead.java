package org.gzc.leetcode;

import org.gzc.leetcode.model.ListNode;
import org.gzc.leetcode.model.TreeNode;
import org.gzc.leetcode.model.UnionFind;

import java.util.*;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class SolutionHead {
  private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
  /**
   * 216. 组合总和 III
   *
   * <p>找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
   */
  public static List<List<Integer>> result = new ArrayList<>();

  public static List<Integer> listResult = new ArrayList<>();
  /**
   * 236. 二叉树的最近公共祖先
   *
   * <p>给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
   */
  public static TreeNode lowestCommonAncestorResult;

  public static List<String> binaryTreePathsResult = new ArrayList<>();
  private final Set<String> validExpressions = new HashSet<>();
  public ArrayList<String> answer;
  public String digits;
  public long target;
  public int[][] paths = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  public int rows, columns;
  /** 306. 累加数 */
  String s;

  int n;
  /**
   * 301. 删除无效的括号
   *
   * <p>给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
   *
   * <p>返回所有可能的结果。答案可以按 任意顺序 返回。
   */
  private int len;

  private char[] charArray;

  /**
   * 213. 打家劫舍 II
   *
   * <p>你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
   *
   * <p>这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
   *
   * <p>如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
   *
   * <p>给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
   */
  public static int rob(int[] nums) {
    int length = nums.length;
    if (length == 1) {
      return nums[0];
    }
    if (length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
  }

  private static int robRange(int[] nums, int start, int end) {
    int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
    for (int i = start + 2; i <= end; i++) {
      int temp = second;
      second = Math.max(first + nums[i], second);
      first = temp;
    }
    return second;
  }

  /**
   * 214. 最短回文串
   *
   * <p>给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
   */
  public static String shortestPalindrome(String s) {
    int length = s.length();
    if (isPalindrome(s)) {
      return s;
    }
    for (int i = length - 1; i >= 0; i--) {
      if (isPalindrome(s.substring(0, i))) {
        return new StringBuilder(s.substring(i)).reverse() + s;
      }
    }
    return new StringBuilder(s).reverse() + s;
  }

  /** 校验回文数 */
  public static boolean isPalindrome(String s) {
    // 用StringBuilder的reverse方法将字符串反转
    StringBuilder sb = new StringBuilder(s);
    String afterReverse = sb.reverse().toString();
    // 判断反转后的字符串与原字符串是否相等，可用compareTo，equals，
    int isequal = afterReverse.compareTo(s); // 若相等则输出0
    return isequal == 0;
  }

  public static List<List<Integer>> combinationSum3(int k, int n) {
    List<Integer> ans = new ArrayList<>();
    dfs_combinationSum3(k, n, 1, ans);
    return result;
  }

  public static void dfs_combinationSum3(int k, int n, int start, List<Integer> ans) {
    if (k == 1) {
      if (n >= start && n <= 9) {
        ans.add(n);
        result.add(new ArrayList<>(ans));
        ans.remove(ans.size() - 1);
      }
    } else {
      for (int i = start; i <= 9; i++) {
        ans.add(i);
        dfs_combinationSum3(k - 1, n - i, i + 1, ans);
        ans.remove(ans.size() - 1);
      }
    }
  }

  /**
   * 217. 存在重复元素
   *
   * <p>给定一个整数数组，判断是否存在重复元素。
   */
  public static boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 217. 存在重复元素
   *
   * <p>给定一个整数数组，判断是否存在重复元素。
   */
  public static boolean containsDuplicate2(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == nums[i]) {
        return true;
      }
    }
    return false;
  }

  /**
   * 218. 天际线问题
   *
   * <p>城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。
   *
   * <p>给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
   */
  public static List<List<Integer>> getSkyline(int[][] buildings) {
    PriorityQueue<int[]> pq =
        new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    for (int[] building : buildings) {
      pq.offer(new int[] {building[0], -building[2]});
      pq.offer(new int[] {building[1], building[2]});
    }

    List<List<Integer>> res = new ArrayList<>();

    TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
    heights.put(0, 1);
    int left, height = 0;
    while (!pq.isEmpty()) {
      int[] arr = pq.poll();
      if (arr[1] < 0) {
        heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
      } else {
        heights.put(arr[1], heights.get(arr[1]) - 1);
        if (heights.get(arr[1]) == 0) {
          heights.remove(arr[1]);
        }
      }
      int maxHeight = heights.keySet().iterator().next();
      if (maxHeight != height) {
        left = arr[0];
        height = maxHeight;
        res.add(Arrays.asList(left, height));
      }
    }

    return res;
  }

  /**
   * 219. 存在重复元素 II
   *
   * <p>给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，
   *
   * <p>并且 i 和 j的差的 绝对值 至多为 k。
   *
   * <p>执行用时： 27 ms , 在所有 Java 提交中击败了 23.73% 的用户
   *
   * <p>内存消耗： 47.2 MB , 在所有 Java 提交中击败了 9.14% 的用户
   */
  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        if (i - map.get(nums[i]) <= k) {
          return true;
        } else {
          map.put(nums[i], i);
        }
      } else {
        map.put(nums[i], i);
      }
    }
    return false;
  }

  /**
   * 220. 存在重复元素 III
   *
   * <p>给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，
   *
   * <p>同时又满足 abs(i- j) <= k 。
   *
   * <p>如果存在则返回 true，不存在返回 false。
   */
  public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    int n = nums.length;
    Map<Long, Long> map = new HashMap<>();
    long w = (long) t + 1;
    for (int i = 0; i < n; i++) {
      long id;
      if (nums[i] >= 0) {
        id = nums[i] / w;
      } else {

        id = (nums[i] + 1) / w - 1;
      }
      if (map.containsKey(id)) {
        return true;
      }
      if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
        return true;
      }
      if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
        return true;
      }
      map.put(id, (long) nums[i]);
      if (i >= k) {
        if (nums[i - k] >= 0) {
          id = nums[i - k] / w;
        } else {

          id = (nums[i - k] + 1) / w - 1;
        }
        map.remove(id);
      }
    }
    return false;
  }

  /**
   * 221. 最大正方形
   *
   * <p>在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
   *
   * <p>动态规划算法 转移方程：
   *
   * <p>if matrix(i,j) == 0 则 dp(i,j)=0
   *
   * <p>if matrix(i,j) == 1 则 dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
   */
  public static int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int max = 0;
    int hang = matrix.length, lie = matrix[0].length;
    int[][] dp = new int[hang + 1][lie + 1];
    for (int i = 0; i < lie; i++) {
      dp[0][i] = (int) matrix[0][i] - 48;
      if (dp[0][i] > max) {
        max = dp[0][i];
      }
    }
    for (int i = 1; i < hang; i++) {
      dp[i][0] = (int) matrix[i][0] - 48;
      if (dp[i][0] > max) {
        max = dp[i][0];
      }
    }
    for (int i = 1; i < hang; i++) {
      for (int j = 1; j < lie; j++) {
        if (matrix[i][j] == '0') {
          dp[i][j] = 0;
        } else {
          dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
          if (dp[i][j] > max) {
            max = dp[i][j];
          }
        }
      }
    }
    return max * max;
  }

  /**
   * 222. 完全二叉树的节点个数
   *
   * <p>给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
   */
  public static int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  public static int computeArea(
      int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    // 计算重叠矩形的面积
    int x1 = Math.max(ax1, bx1);
    int x2 = Math.min(ax2, bx2);
    int y1 = Math.max(by1, ay1);
    int y2 = Math.min(ay2, by2);
    // 如果存在重叠的矩形
    int subArea = 0;
    if (x1 < x2 && y1 < y2) {
      subArea = (x2 - x1) * (y2 - y1);
    }
    int mainArea = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
    return mainArea - subArea;
  }

  /**
   * 224. 基本计算器
   *
   * <p>给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
   */
  public static int calculate1(String s) {
    s = s.replaceAll(" ", "");
    Deque<Integer> ops = new ArrayDeque<>();
    ops.push(1);
    int result = 0;
    int n = s.length();
    int i = 0;
    int sign = 1;
    while (i < n) {
      switch (s.charAt(i)) {
        case '+':
          sign = ops.peek();
          i++;
          break;
        case '-':
          sign = -ops.peek();
          i++;
          break;
        case '(':
          ops.push(sign);
          i++;
          break;
        case ')':
          ops.pop();
          i++;
          break;
        default:
          long num = 0;
          while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i) - '0';
            i++;
          }
          result += sign * num;
      }
    }

    return result;
  }

  /**
   * 226. 翻转二叉树
   *
   * <p>翻转一棵二叉树。
   */
  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode leftNode = invertTree(root.right);
    TreeNode rightNode = invertTree(root.left);
    root.left = leftNode;
    root.right = rightNode;
    return root;
  }

  /**
   * 227. 基本计算器 II
   *
   * <p>给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
   */
  public static int calculate(String s) {
    //    s = s.replaceAll(" ", "");
    //    Deque<Character> flag = new ArrayDeque<>();
    //    flag.push('#');
    //    Deque<Integer> number = new ArrayDeque<>();
    //    char[] charArr = s.toCharArray();
    //    for (int i = 0; i < charArr.length; i++) {
    //      StringBuilder sb = new StringBuilder();
    //      while (i < charArr.length && Character.isDigit(charArr[i])) {
    //        sb.append(charArr[i++]);
    //      }
    //      if (!"".equals(sb.toString())) {
    //        number.push(Integer.parseInt(sb.toString()));
    //      }
    //      char[] flags = {'+', '-', '*', '/'};
    //      if ("+-*/".contains(charArr[i] + "")) {}
    //    }
    Deque<Integer> stack = new LinkedList<>();
    s = s.replaceAll(" ", "");
    char preSign = '+';
    int num = 0;
    int n = s.length();
    for (int i = 0; i < n; ++i) {
      if (Character.isDigit(s.charAt(i))) {
        num = num * 10 + s.charAt(i) - '0';
      }
      if (!Character.isDigit(s.charAt(i)) || i == n - 1) {
        switch (preSign) {
          case '+':
            stack.push(num);
            break;
          case '-':
            stack.push(-num);
            break;
          case '*':
            stack.push(stack.pop() * num);
            break;
          default:
            stack.push(stack.pop() / num);
        }
        preSign = s.charAt(i);
        num = 0;
      }
    }
    int ans = 0;
    while (!stack.isEmpty()) {
      ans += stack.pop();
    }
    return ans;
  }

  /**
   * 228. 汇总区间
   *
   * <p>给定一个无重复元素的有序整数数组 nums 。
   */
  public static List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    int nextNum = nums[0];
    int first = nums[0];
    int end = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - nextNum == 1) {
        end++;
        nextNum = nums[i];
      } else {
        if (first == end) {
          result.add(first + "");
        } else {
          result.add(first + "->" + end);
        }
        first = end = nextNum = nums[i];
      }
    }
    if (first == end) {
      result.add(first + "");
    } else {
      result.add(first + "->" + end);
    }
    return result;
  }

  /**
   * 229. 求众数 II
   *
   * <p>给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
   */
  public static List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    int n = nums.length;
    if (n == 1) {
      result.add(nums[0]);
      return result;
    }
    int cand1 = nums[0], cand2 = nums[0];
    int count1 = 0, count2 = 0;
    for (int num : nums) {
      if (cand1 == num) {
        count1++;
        continue;
      }
      if (cand2 == num) {
        count2++;
        continue;
      }
      if (count1 == 0) {
        cand1 = num;
        count1 = 1;
        continue;
      }
      if (count2 == 0) {
        cand2 = num;
        count2 = 1;
        continue;
      }
      count1--;
      count2--;
    }
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
      if (num == cand1) {
        count1++;
      } else if (num == cand2) {
        count2++;
      }
    }
    if (count1 > n / 3) {
      result.add(cand1);
    }
    if (count2 > n / 3) {
      result.add(cand2);
    }
    return result;
  }

  /**
   * 230. 二叉搜索树中第K小的元素
   *
   * <p>给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
   */
  public static int kthSmallest(TreeNode root, int k) {
    zxpl(root);
    return listResult.get(k - 1);
  }

  public static void zxpl(TreeNode root) {
    if (root == null) {
      return;
    }
    zxpl(root.left);
    listResult.add(root.val);
    zxpl(root.right);
  }

  /**
   * 231. 2 的幂
   *
   * <p>给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
   *
   * <p>如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
   */
  public static boolean isPowerOfTwo(int n) {
    if (n == 0) {
      return false;
    }
    while (n != 0) {
      if (n == 1) {
        return true;
      }
      if (n % 2 != 0) {
        return false;
      }
      n = n / 2;
    }
    return true;
  }

  /**
   * 233. 数字 1 的个数
   *
   * <p>给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
   */
  public static int countDigitOne(int n) {
    int countr = 0;
    for (int i = 1; i <= n; i *= 10) {
      int divider = i * 10;
      countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
    }
    return countr;
  }

  public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode ancestor = root;
    while (true) {
      if (p.val > ancestor.val && q.val > ancestor.val) {
        ancestor = ancestor.right;
      } else if (p.val < ancestor.val && q.val < ancestor.val) {
        ancestor = ancestor.left;
      } else {
        break;
      }
    }
    return ancestor;
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    dfs_lowestCommonAncestor(root, p, q);
    return lowestCommonAncestorResult;
  }

  public static boolean dfs_lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return false;
    }
    boolean rson = dfs_lowestCommonAncestor(root.right, p, q);
    boolean lson = dfs_lowestCommonAncestor(root.left, p, q);
    if ((rson && lson) || ((root.val == p.val || root.val == q.val) && (rson || lson))) {
      lowestCommonAncestorResult = root;
    }
    return rson || lson || (root.val == p.val || root.val == q.val);
  }

  /**
   * 237 删除链表中的节点
   *
   * <p>请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
   */
  public static void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  /**
   * 238. 除自身以外数组的乘积
   *
   * <p>给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
   */
  public static int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] result = new int[length];
    result[0] = 1;
    // 计算左边的元素的乘积
    for (int i = 1; i < length; i++) {
      result[i] = nums[i - 1] * result[i - 1];
    }

    int R = 1;
    for (int i = length - 1; i >= 0; i--) {
      result[i] = result[i] * R;
      R *= nums[i];
    }
    return result;
  }

  /**
   * 239. 滑动窗口最大值
   *
   * <p>给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
   *
   * <p>你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
   */
  public static int[] maxSlidingWindow(int[] nums, int k) {
    //    int start = 0, end = k;
    //    int length = nums.length;
    //    int[] result = new int[length - k + 1];
    //    int max = nums[0];
    //    for (int i = start; i < end; i++) {
    //      if (nums[i] > max) {
    //        max = nums[i];
    //      }
    //    }
    //    int index = 0;
    //    result[index++] = max;
    //    while (end < length) {
    //      // 如果删除的数字不是max
    //      if (nums[start] != max) {
    //        // 判断新加入的数字是否比max大
    //        if (max < nums[end]) {
    //          result[index++] = nums[end];
    //          max = nums[end];
    //        } else {
    //          result[index++] = max;
    //        }
    //      } else { // 删除的是最大值
    //        // 新加入的数字比max大
    //        if (max < nums[end]) {
    //          result[index++] = nums[end];
    //          max = nums[end];
    //        } else { // 新加入的数字比max小。找出窗口中的最大值
    //          max = nums[start + 1];
    //          for (int i = start + 1; i <= end; i++) {
    //            if (nums[i] > max) {
    //              max = nums[i];
    //            }
    //          }
    //          result[index++] = max;
    //        }
    //      }
    //      start++;
    //      end++;
    //    }
    //    return result;
    if (nums == null || nums.length < 2) {
      return nums;
    }
    // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
    LinkedList<Integer> queue = new LinkedList<Integer>();
    // 结果数组
    int[] result = new int[nums.length - k + 1];
    // 遍历nums数组
    for (int i = 0; i < nums.length; i++) {
      // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
      while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
        queue.pollLast();
      }
      // 添加当前值对应的数组下标
      queue.addLast(i);
      // 判断当前队列中队首的值是否有效
      if (queue.peek() <= i - k) {
        queue.poll();
      }
      // 当窗口长度为k时 保存当前窗口中最大值
      if (i + 1 >= k) {
        result[i + 1 - k] = nums[queue.peek()];
      }
    }
    return result;
  }

  /**
   * 240. 搜索二维矩阵2
   *
   * <p>编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
   *
   * <p>每行的元素从左到右升序排列。每列的元素从上到下升序排列。
   */
  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }

    return searchRec(matrix, target, 0, 0, matrix[0].length - 1, matrix.length - 1);
  }

  private static boolean searchRec(
      int[][] matrix, int target, int left, int up, int right, int down) {
    // this submatrix has no height or no width.
    if (left > right || up > down) {
      return false;
      // `target` is already larger than the largest element or smaller
      // than the smallest element in this submatrix.
    } else if (target < matrix[up][left] || target > matrix[down][right]) {
      return false;
    }

    int mid = left + (right - left) / 2;

    // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
    int row = up;
    while (row <= down && matrix[row][mid] <= target) {
      if (matrix[row][mid] == target) {
        return true;
      }
      row++;
    }

    return searchRec(matrix, target, left, row, mid - 1, down)
        || searchRec(matrix, target, mid + 1, up, right, row - 1);
  }

  public static List<Integer> diffWaysToCompute(String expression) {
    if (expression.matches("[0-9]+")) {
      List<Integer> arr = new ArrayList<>();
      arr.add(Integer.parseInt(expression));
      return arr;
    }
    List<Integer> result = new ArrayList<>();
    List<Integer> lResult = new ArrayList<>();
    List<Integer> rResult = new ArrayList<>();
    int length = expression.length();
    for (int i = 0; i < length; ++i) {
      if ("+-*".contains(expression.charAt(i) + "")) {
        lResult = diffWaysToCompute(expression.substring(0, i));
        rResult = diffWaysToCompute(expression.substring(i + 1));
        for (Integer value : lResult) {
          for (Integer integer : rResult) {
            switch (expression.charAt(i)) {
              case '+':
                result.add(value + integer);
                break;
              case '-':
                result.add(value - integer);
                break;
              case '*':
                result.add(value * integer);
                break;
              default:
                break;
            }
          }
        }
      }
    }
    return result;
  }

  /** 242. 有效的字母异或词 */
  public static boolean isAnagram(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    if (s.length() != t.length()) {
      return false;
    }
    char[] saArr = s.toCharArray();
    char[] taArr = t.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      map.put(saArr[i], map.getOrDefault(saArr[i], 0) + 1);
    }
    for (int i = 0; i < s.length(); i++) {
      if (map.getOrDefault(taArr[i], 0) - 1 < 0) {
        return false;
      }
      map.put(taArr[i], map.getOrDefault(taArr[i], 0) - 1);
    }
    return true;
  }

  /** 257. 二叉树的所有路径 */
  public static List<String> binaryTreePaths(TreeNode root) {
    dfs_binaryTreePaths(root, "");
    return binaryTreePathsResult;
  }

  public static void dfs_binaryTreePaths(TreeNode root, String path) {
    if (root != null) {
      path += root.val;
      if (root.left == null && root.right == null) {
        binaryTreePathsResult.add(path);
      } else {
        dfs_binaryTreePaths(root.left, path + "->");
        dfs_binaryTreePaths(root.right, path + "->");
      }
    }
  }

  /** 258. 各位相加 */
  public static int addDigits(int num) {
    return (num - 1) % 9 + 1;
  }

  /**
   * 260. 只出现一次的数字
   *
   * <p>给定一个整数数组 nums，其中恰好有两个元素只出现一次，
   *
   * <p>其余所有元素均出现两次。 找出只出现一次的那两个元素。
   *
   * <p>你可以按 任意顺序 返回答案。
   */
  public static int[] singleNumber1(int[] nums) {
    int[] result = new int[2];
    Set<Integer> set = new HashSet<>();
    int length = nums.length;
    for (int num : nums) {
      if (set.contains(num)) {
        set.remove(num);
      } else {
        set.add(num);
      }
    }
    int index = 0;
    for (int num : set) {
      result[index++] = num;
    }
    return result;
  }

  /**
   * 263. 抽数
   *
   * <p>给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；
   *
   * <p>否则，返回 false 。
   *
   * <p>丑数 就是只包含质因数 2、3 和/或 5 的正整数。
   */
  public static boolean isUgly(int n) {
    if (n == 0) {
      return false;
    }
    while (n % 2 == 0) {
      n = n / 2;
    }
    while (n % 3 == 0) {
      n = n / 3;
    }
    while (n % 5 == 0) {
      n = n / 5;
    }
    return n == 1;
  }

  public static int nthUglyNumber(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int p2 = 1, p3 = 1, p5 = 1;
    for (int i = 2; i < n + 1; i++) {
      int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
      dp[i] = Math.min(Math.min(num2, num3), num5);
      if (dp[i] == num2) {
        p2++;
      }
      if (dp[i] == num3) {
        p3++;
      }
      if (dp[i] == num5) {
        p5++;
      }
    }
    return dp[n];
  }

  /**
   * 268. 丢失的数字
   *
   * <p>给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
   *
   * <p>排序算法
   */
  public static int missingNumber1(int[] nums) {
    Arrays.sort(nums);
    if (nums[0] != 0) {
      return 0;
    }
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] - nums[i] != -1) {
        return nums[i - 1] + 1;
      }
    }
    return nums[nums.length - 1] + 1;
  }

  /**
   * 268. 丢失的数字
   *
   * <p>给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
   *
   * <p>位运算算法
   */
  public static int missingNumber(int[] nums) {
    int result = nums.length;
    for (int i = 0; i < nums.length; i++) {
      result ^= i ^ nums[i];
    }
    return result;
  }

  /** 274. H指数 */
  public static int hIndex1(int[] citations) {
    int n = citations.length;
    int l = 0, r = n;
    // 二分引用次数
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (check(citations, mid)) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return r;
  }

  public static boolean check(int[] citations, int mid) {
    int count = 0;
    for (int citation : citations) {
      // 如果论文引用次数 >= 当前引用次数,符合要求的篇数+1
      if (citation >= mid) {
        count++;
      }
    }
    // 如果符合要求篇数>=引用次数,则当前值可以为H指数
    return count >= mid;
  }

  /** 275. H指数 2 */
  public static int hIndex(int[] citations) {
    int n = citations.length;
    int l = 0, r = n - 1;
    while (l < r) {
      int mid = l + r >> 1;
      if (citations[mid] >= n - mid) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return citations[r] >= n - r ? n - r : 0;
  }

  /** 283. 移动零 */
  public static void moveZeroes(int[] nums) {
    if (nums.length == 1) {
      return;
    }
    int start = 0, end = 1;
    while (end < nums.length) {
      if (nums[start] == 0 && nums[end] == 0) {
        end++;
        if (end >= nums.length) {
          break;
        }
      }
      if (nums[start] != 0 && nums[end] == 0) {
        start++;
        end++;
        if (end >= nums.length) {
          break;
        }
      }
      if (nums[start] != 0 && nums[end] != 0) {
        start++;
        end++;
        if (end >= nums.length) {
          break;
        }
      }
      if (nums[start] == 0 && nums[end] != 0) {
        int tem = nums[start];
        nums[start] = nums[end];
        nums[end] = tem;
        start++;
        end++;
        if (end >= nums.length) {
          break;
        }
      }
    }
  }

  /** 299. 猜数字游戏 */
  public static String getHint(String secret, String guess) {
    int[] array = new int[10];
    int A = 0, B = 0;
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        A++;
      } else {
        // 判断 guess 在 i 之前是否该数字
        if (array[secret.charAt(i) - '0']++ < 0) {
          B++;
        }
        // 判断 secret 在 i 之前是否该数字
        if (array[guess.charAt(i) - '0']-- > 0) {
          B++;
        }
      }
    }
    return String.valueOf(A) + 'A' + B + 'B';
  }

  /**
   * 300. 最大递增子序列
   *
   * <p>动态规划算法
   */
  public static int lengthOfLIS(int[] nums) {
    int length = nums.length;
    int max = 1;
    int[] dp = new int[length];
    Arrays.fill(dp, 1);
    for (int i = 1; i < length; i++) {
      int numCount = 1;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
          if (max < dp[i]) {
            max = dp[i];
          }
        }
      }
    }
    return max;
  }

  public static String reverseVowels1(String s) {
    int length = s.length();
    if (length <= 1) {
      return s;
    }
    char[] sArr = s.toCharArray();
    int start = 0;
    int end = length - 1;
    while (start < end) {
      while (start < length - 1 && !"AEIOUaeiou".contains(sArr[start] + "")) {
        start++;
      }
      if (start >= end) {
        break;
      }
      while (!"AEIOUaeiou".contains(sArr[end] + "")) {
        end--;
      }
      if (start < end) {
        char tem = sArr[start];
        sArr[start] = sArr[end];
        sArr[end] = tem;
      }
      start++;
      end--;
    }
    return new String(sArr);
  }

  public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> result = new ArrayList<>();
    if (n == 1) {
      result.add(0);
      return result;
    }
    int[] du = new int[n];
    List<List<Integer>> edgeList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      edgeList.add(new ArrayList<Integer>());
    }
    for (int[] edge : edges) {
      du[edge[0]]++;
      du[edge[1]]++;
      edgeList.get(edge[0]).add(edge[1]);
      edgeList.get(edge[1]).add(edge[0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    // 把叶子节点全部入队
    for (int i = 0; i < n; i++) {
      if (du[i] == 1) {
        queue.offer(i);
      }
    }
    while (!queue.isEmpty()) {
      result = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int leafNode = queue.poll();
        result.add(leafNode);
        List<Integer> neighbors = edgeList.get(leafNode);
        for (Integer neighbor : neighbors) {
          du[neighbor]--;
          if (du[neighbor] == 1) {
            queue.offer(neighbor);
          }
        }
      }
    }
    return result;
  }

  public static int nthSuperUglyNumber(int n, int[] primes) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int m = primes.length;
    int[] pointers = new int[m];
    Arrays.fill(pointers, 1);
    for (int i = 2; i <= n; i++) {
      int[] nums = new int[m];
      int minNum = Integer.MAX_VALUE;
      for (int j = 0; j < m; j++) {
        nums[j] = dp[pointers[j]] * primes[j];
        minNum = Math.min(minNum, nums[j]);
      }
      dp[i] = minNum;
      for (int j = 0; j < m; j++) {
        if (minNum == nums[j]) {
          pointers[j]++;
        }
      }
    }
    return dp[n];
  }

  /**
   * 316. 去除重复字母
   *
   * <p>给你一个字符串 s ，请你去除字符串中重复的字母，
   *
   * <p>使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
   */
  public static String removeDuplicateLetters(String s) {
    int len = s.length();
    char[] charArr = s.toCharArray();
    // 用于保存每个小写字母最后一次出现的索引值
    int[] lastIndex = new int[26];
    for (int i = 0; i < len; i++) {
      lastIndex[charArr[i] - 'a'] = i;
    }
    // 创建栈用于过滤重复的字母以及保证最小的字典序
    Deque<Character> stack = new ArrayDeque<>();
    boolean[] visited = new boolean[26];
    for (int i = 0; i < len; i++) {
      // 当前的字母已经确定位置
      if (visited[charArr[i] - 'a']) {
        continue;
      }
      // 当前栈顶元素严格大于要入栈的元素，并且当前栈顶元素在未来还会再入栈
      while (!stack.isEmpty()
          && stack.peekLast() > charArr[i]
          && lastIndex[stack.peekLast() - 'a'] > i) {
        Character top = stack.removeLast();
        visited[top - 'a'] = false;
      }
      stack.addLast(charArr[i]);
      visited[charArr[i] - 'a'] = true;
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pollFirst());
    }
    return sb.toString();
  }

  public static int bulbSwitch(int n) {
    return (int) (Math.ceil(Math.sqrt(n + 1)) - 1);
  }


  /**
   * 215. 数组中的第K个最大元素
   *
   * <p>在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
   */
  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  public int countNodes1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int level = 0;
    TreeNode node = root;
    while (node.left != null) {
      level++;
      node = node.left;
    }
    int low = 1 << level, high = (1 << (level + 1)) - 1;
    while (low < high) {
      int mid = (high - low + 1) / 2 + low;
      if (exists(root, level, mid)) {
        low = mid;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  public boolean exists(TreeNode root, int level, int k) {
    int bits = 1 << (level - 1);
    TreeNode node = root;
    while (node != null && bits > 0) {
      if ((bits & k) == 0) {
        node = node.left;
      } else {
        node = node.right;
      }
      bits >>= 1;
    }
    return node != null;
  }

  /**
   * 234. 回文链表
   *
   * <p>请判断一个链表是否为回文链表。
   *
   * <p>进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
   */
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }

    // 找到前半部分链表的尾节点并反转后半部分链表
    ListNode firstHalfEnd = endOfFirstHalf(head);
    ListNode secondHalfStart = reverseList(firstHalfEnd.next);

    // 判断是否回文
    ListNode p1 = head;
    ListNode p2 = secondHalfStart;
    boolean result = true;
    while (result && p2 != null) {
      if (p1.val != p2.val) {
        result = false;
      }
      p1 = p1.next;
      p2 = p2.next;
    }

    // 还原链表并返回结果
    firstHalfEnd.next = reverseList(secondHalfStart);
    return result;
  }

  /** 转换列表 */
  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  /** 寻找中间节点 */
  private ListNode endOfFirstHalf(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  /**
   * 260. 只出现一次的数字 III
   *
   * <p>给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
   *
   * <p>找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
   */
  public int[] singleNumber(int[] nums) {
    int ret = 0;
    for (int num : nums) {
      ret ^= num;
    }
    int index = 1;
    while ((ret & index) == 0) {
      index <<= 1;
    }
    int a = 0;
    int b = 0;
    for (int num : nums) {
      if ((num & index) == 0) {
        a ^= num;
      } else {
        b ^= num;
      }
    }

    return new int[] {a, b};
  }

  /** 个位整数 数字到文字的转换 */
  public String one(int num) {
    switch (num) {
      case 1:
        return "One";
      case 2:
        return "Two";
      case 3:
        return "Three";
      case 4:
        return "Four";
      case 5:
        return "Five";
      case 6:
        return "Six";
      case 7:
        return "Seven";
      case 8:
        return "Eight";
      case 9:
        return "Nine";
      default:
        break;
    }
    return "";
  }

  /** 小于20的整数的数字到文字的转换 */
  public String twoLessThan20(int num) {
    switch (num) {
      case 10:
        return "Ten";
      case 11:
        return "Eleven";
      case 12:
        return "Twelve";
      case 13:
        return "Thirteen";
      case 14:
        return "Fourteen";
      case 15:
        return "Fifteen";
      case 16:
        return "Sixteen";
      case 17:
        return "Seventeen";
      case 18:
        return "Eighteen";
      case 19:
        return "Nineteen";
      default:
        break;
    }
    return "";
  }

  /** 整十位的数字到文字的转换 */
  public String ten(int num) {
    switch (num) {
      case 2:
        return "Twenty";
      case 3:
        return "Thirty";
      case 4:
        return "Forty";
      case 5:
        return "Fifty";
      case 6:
        return "Sixty";
      case 7:
        return "Seventy";
      case 8:
        return "Eighty";
      case 9:
        return "Ninety";
    }
    return "";
  }

  /** 两位数的数字到文字的转换 */
  public String two(int num) {
    if (num == 0) {
      return "";
    } else if (num < 10) {
      return one(num);
    } else if (num < 20) {
      return twoLessThan20(num);
    } else {
      int tenner = num / 10;
      int rest = num - tenner * 10;
      if (rest != 0) {
        return ten(tenner) + " " + one(rest);
      } else {
        return ten(tenner);
      }
    }
  }

  /** 三位数的数字到文字的转换 */
  public String three(int num) {
    int hundred = num / 100;
    int rest = num - hundred * 100;
    String res = "";
    if (hundred * rest != 0) {
      res = one(hundred) + " Hundred " + two(rest);
    } else if ((hundred == 0) && (rest != 0)) {
      res = two(rest);
    } else if ((hundred != 0) && (rest == 0)) {
      res = one(hundred) + " Hundred";
    }
    return res;
  }

  /** 273. 整数转换英文表示 */
  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    int billion = num / 1000000000;
    int million = (num - billion * 1000000000) / 1000000;
    int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
    int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

    String result = "";
    if (billion != 0) {
      result = three(billion) + " Billion";
    }
    if (million != 0) {
      if (!result.isEmpty()) {
        result += " ";
      }
      result += three(million) + " Million";
    }
    if (thousand != 0) {
      if (!result.isEmpty()) {
        result += " ";
      }
      result += three(thousand) + " Thousand";
    }
    if (rest != 0) {
      if (!result.isEmpty()) {
        result += " ";
      }
      result += three(rest);
    }
    return result;
  }

  /**
   * 279. 完全平均数
   *
   * <p>给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
   *
   * <p>使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
   */
  public int numSquares(int n) {
    int[] f = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int minn = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        minn = Math.min(minn, f[i - j * j]);
      }
      f[i] = minn + 1;
    }
    return f[n];
  }

  public void recurse(
      int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops) {
    String nums = this.digits;

    // Done processing all the digits in num
    if (index == nums.length()) {

      // If the final value == target expected AND
      // no operand is left unprocessed
      if (value == this.target && currentOperand == 0) {
        StringBuilder sb = new StringBuilder();
        ops.subList(1, ops.size()).forEach(v -> sb.append(v));
        this.answer.add(sb.toString());
      }
      return;
    }

    // 将当前操作数扩展一位
    currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
    String current_val_rep = Long.toString(currentOperand);
    int length = nums.length();

    // 为了避免我们有 1 + 05 或 1 05 的情况，因为 05 将不是有效的操作数。因此这个检查
    if (currentOperand > 0) {

      // NO OP recursion
      recurse(index + 1, previousOperand, currentOperand, value, ops);
    }

    // +
    ops.add("+");
    ops.add(current_val_rep);
    recurse(index + 1, currentOperand, 0, value + currentOperand, ops);
    ops.remove(ops.size() - 1);
    ops.remove(ops.size() - 1);

    if (ops.size() > 0) {

      // -
      ops.add("-");
      ops.add(current_val_rep);
      recurse(index + 1, -currentOperand, 0, value - currentOperand, ops);
      ops.remove(ops.size() - 1);
      ops.remove(ops.size() - 1);

      // *，计算乘法之前需要先把之前计算的减去，再加乘法
      ops.add("*");
      ops.add(current_val_rep);
      recurse(
          index + 1,
          currentOperand * previousOperand,
          0,
          value - previousOperand + (currentOperand * previousOperand),
          ops);
      ops.remove(ops.size() - 1);
      ops.remove(ops.size() - 1);
    }
  }

  /** 282. 给表达式添加运算符 */
  public List<String> addOperators(String num, int target) {

    if (num.length() == 0) {
      return new ArrayList<String>();
    }

    this.target = target;
    this.digits = num;
    this.answer = new ArrayList<>();
    this.recurse(0, 0, 0, 0, new ArrayList<String>());
    return this.answer;
  }

  public List<String> removeInvalidParentheses(String s) {
    this.len = s.length();
    this.charArray = s.toCharArray();

    // 第 1 步：遍历一次，计算多余的左右括号
    int leftRemove = 0;
    int rightRemove = 0;
    for (int i = 0; i < len; i++) {
      if (charArray[i] == '(') {
        leftRemove++;
      } else if (charArray[i] == ')') {
        // 遇到右括号的时候，须要根据已经存在的左括号数量决定
        if (leftRemove == 0) {
          rightRemove++;
        }
        if (leftRemove > 0) {
          // 关键：一个右括号出现可以抵销之前遇到的左括号
          leftRemove--;
        }
      }
    }

    // 第 2 步：回溯算法，尝试每一种可能的删除操作
    StringBuilder path = new StringBuilder();
    dfs(0, 0, 0, leftRemove, rightRemove, path);
    return new ArrayList<>(this.validExpressions);
  }

  /**
   * @param index 当前遍历到的下标
   * @param leftCount 已经遍历到的左括号的个数
   * @param rightCount 已经遍历到的右括号的个数
   * @param leftRemove 最少应该删除的左括号的个数
   * @param rightRemove 最少应该删除的右括号的个数
   * @param path 一个可能的结果
   */
  private void dfs(
      int index,
      int leftCount,
      int rightCount,
      int leftRemove,
      int rightRemove,
      StringBuilder path) {
    if (index == len) {
      if (leftRemove == 0 && rightRemove == 0) {
        validExpressions.add(path.toString());
      }
      return;
    }

    char character = charArray[index];
    // 可能的操作 1：删除当前遍历到的字符
    if (character == '(' && leftRemove > 0) {
      // 由于 leftRemove > 0，并且当前遇到的是左括号，因此可以尝试删除当前遇到的左括号
      dfs(index + 1, leftCount, rightCount, leftRemove - 1, rightRemove, path);
    }
    if (character == ')' && rightRemove > 0) {
      // 由于 rightRemove > 0，并且当前遇到的是右括号，因此可以尝试删除当前遇到的右括号
      dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove - 1, path);
    }

    // 可能的操作 2：保留当前遍历到的字符
    path.append(character);
    if (character != '(' && character != ')') {
      // 如果不是括号，继续深度优先遍历
      dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove, path);
    } else if (character == '(') {
      // 考虑左括号
      dfs(index + 1, leftCount + 1, rightCount, leftRemove, rightRemove, path);
    } else if (rightCount < leftCount) {
      // 考虑右括号
      dfs(index + 1, leftCount, rightCount + 1, leftRemove, rightRemove, path);
    }
    path.deleteCharAt(path.length() - 1);
  }

  private boolean isNotVowel(char ch) {
    return ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' && ch != 'A' && ch != 'E'
        && ch != 'I' && ch != 'O' && ch != 'U';
  }

  public String reverseVowels(String s) {
    if (s == null) {
      return null;
    }
    int j = s.length() - 1;
    char[] sArr = new char[s.length()];
    int i = 0;
    while (i <= j) {
      char iChar = s.charAt(i);
      char jChar = s.charAt(j);
      if (isNotVowel(iChar)) {
        sArr[i++] = iChar;
      } else if (isNotVowel(jChar)) {
        sArr[j--] = jChar;
      } else {
        sArr[i++] = jChar;
        sArr[j--] = iChar;
      }
    }
    return new String(sArr);
  }

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    UnionFind unionFind = new UnionFind(m * n);
    boolean[] visited = new boolean[m * n];

    List<Integer> res = new ArrayList<>();
    for (int[] position : positions) {
      int currX = position[0];
      int currY = position[1];

      int index = currX * n + currY;
      if (!visited[index]) {
        // 把水变成陆地，连通分量个数加 1
        unionFind.addCount();
        visited[index] = true;
        for (int[] direction : DIRECTIONS) {
          int newX = currX + direction[0];
          int newY = currY + direction[1];
          int newIndex = newX * n + newY;
          // 下面这三个条件很重要
          if (inArea(newX, newY, m, n)
              && visited[newIndex]
              && !unionFind.isConnected(index, newIndex)) {
            unionFind.union(index, newIndex);
          }
        }
      }
      res.add(unionFind.getCount());
    }
    return res;
  }

  public boolean inArea(int x, int y, int m, int n) {
    return 0 <= x && x < m && 0 <= y && y < n;
  }

  public boolean isAdditiveNumber(String num) {
    this.s = num;
    this.n = num.length();
    return toFlashBack(0, 0, 0, 0);
  }

  /**
   * @param index 当前的下标
   * @param sum 前两个数的和
   * @param previous 前一个数的值
   * @param count 已生成几个数
   * @return
   */
  public boolean toFlashBack(int index, long sum, long previous, int count) {
    if (index == n) {
      return count >= 3;
    }
    long value = 0;

    for (int i = index; i < n; i++) {
      if (i > index && s.charAt(index) == '0') {
        break;
      }
      value = value * 10 + s.charAt(i) - '0';
      if (count >= 2) {
        if (value < sum) {
          continue;
        } else if (value > sum) {
          break;
        }
      }
      if (toFlashBack(i + 1, previous + value, value, count + 1)) {
        return true;
      }
    }
    return false;
  }

  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int length = prices.length;
    int[][] dp = new int[length][3];
    // dp[i][0] 持有股票的最大收益
    // dp[i][1] 不持有股票，且处于冷冻期的最大收益
    // dp[i][2] 不持有股票，且不处于冷冻期的最大收益
    dp[0][0] = -prices[0];
    for (int i = 1; i < length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
      dp[i][1] = dp[i - 1][0] + prices[i];
      dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
    }
    return Math.max(dp[length - 1][1], dp[length - 1][2]);
  }

  public void reverseString(char[] s) {
    int start = 0, end = s.length - 1;
    while (start < end) {
      char tem = s[start];
      s[start++] = s[end];
      s[end--] = tem;
    }
  }

  /*
   *315. 计算右侧小于当前元素的个数
   *
   * 归并排序加逆序数
   * */
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> result = new ArrayList<>();
    int len = nums.length;
    if (len == 0) {
      return result;
    }

    int[] temp = new int[len];
    int[] res = new int[len];

    // 索引数组，作用：归并回去的时候，方便知道是哪个下标的元素
    int[] indexes = new int[len];
    for (int i = 0; i < len; i++) {
      indexes[i] = i;
    }
    mergeAndCountSmaller(nums, 0, len - 1, indexes, temp, res);

    // 把 int[] 转换成为 List<Integer>，没有业务逻辑
    for (int i = 0; i < len; i++) {
      result.add(res[i]);
    }
    return result;
  }

  /** 针对数组 nums 指定的区间 [left, right] 进行归并排序，在排序的过程中完成统计任务 */
  private void mergeAndCountSmaller(
      int[] nums, int left, int right, int[] indexes, int[] temp, int[] res) {
    if (left == right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeAndCountSmaller(nums, left, mid, indexes, temp, res);
    mergeAndCountSmaller(nums, mid + 1, right, indexes, temp, res);

    // 归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
    if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
      return;
    }
    mergeOfTwoSortedArrAndCountSmaller(nums, left, mid, right, indexes, temp, res);
  }

  /** [left, mid] 是排好序的，[mid + 1, right] 是排好序的 */
  private void mergeOfTwoSortedArrAndCountSmaller(
      int[] nums, int left, int mid, int right, int[] indexes, int[] temp, int[] res) {
    if (right + 1 - left >= 0) {
      System.arraycopy(indexes, left, temp, left, right + 1 - left);
    }

    int i = left;
    int j = mid + 1;
    for (int k = left; k <= right; k++) {
      if (i > mid) {
        indexes[k] = temp[j];
        j++;
      } else if (j > right) {
        indexes[k] = temp[i];
        i++;
        res[indexes[k]] += (right - mid);
      } else if (nums[temp[i]] <= nums[temp[j]]) {
        // 注意：这里是 <= ，保证稳定性
        indexes[k] = temp[i];
        i++;
        res[indexes[k]] += (j - mid - 1);
      } else {
        indexes[k] = temp[j];
        j++;
      }
    }
  }

  /**
   * 318. 最大单词长度乘积
   *
   * <p>给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，
   *
   * <p>并且这两个单词不含有公共字母。
   *
   * <p>你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
   */
  public int maxProduct(String[] words) {
    Map<Integer, Integer> hashmap = new HashMap<>();
    int length = words.length;
    int[] bitMask = new int[length];
    int bitmask = 0;
    // 计算每个word的二进制掩码，重复的取最大的字符长长度
    for (int i = 0; i < length; i++) {
      char[] charArr = words[i].toCharArray();
      bitmask = 0;
      for (char ch : charArr) {
        bitmask |= 1 << (ch - 'a');
      }
      bitMask[i] = bitmask;
    }

    int maxProd = 0;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if ((bitMask[i] & bitMask[j]) == 0) {
          maxProd = Math.max(maxProd, words[i].length() * words[j].length());
        }
      }
    }
    return maxProd;
  }

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] res = new int[0];
    // 从 nums1 中选出长 i 的子序列
    for (int i = 0; i <= k && i <= nums1.length; i++) {
      // 从 nums2 中选出长 k - i 的子序列
      if (k - i >= 0 && k - i <= nums2.length) {
        // 合并
        int[] tmp = merge(subMaxNumber(nums1, i), subMaxNumber(nums2, k - i));
        // 取最大值
        if (compare(tmp, 0, res, 0)) {
          res = tmp;
        }
      }
    }
    return res;
  }

  // 类似于单调递减栈
  public int[] subMaxNumber(int[] nums, int len) {
    int[] subNums = new int[len];
    int cur = 0, rem = nums.length - len; // rem 表示还可以删去多少字符
    for (int num : nums) {
      while (cur > 0 && subNums[cur - 1] < num && rem > 0) {
        cur--;
        rem--;
      }
      if (cur < len) {
        subNums[cur++] = num;
      } else {
        rem--; // 避免超过边界而少删字符
      }
    }
    return subNums;
  }

  public int[] merge(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length + nums2.length];
    int cur = 0, p1 = 0, p2 = 0;
    while (cur < nums1.length + nums2.length) {
      if (compare(nums1, p1, nums2, p2)) { // 不能只比较当前值，如果当前值相等还需要比较后续哪个大
        res[cur++] = nums1[p1++];
      } else {
        res[cur++] = nums2[p2++];
      }
    }
    return res;
  }

  public boolean compare(int[] nums1, int p1, int[] nums2, int p2) {
    if (p2 >= nums2.length) {
      return true;
    }
    if (p1 >= nums1.length) {
      return false;
    }
    if (nums1[p1] > nums2[p2]) {
      return true;
    }
    if (nums1[p1] < nums2[p2]) {
      return false;
    }
    return compare(nums1, p1 + 1, nums2, p2 + 1);
  }

  /**
   * 338. 比特位计数
   *
   * <p>给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
   *
   * <p>返回一个长度为 n + 1 的数组 ans 作为答案。
   */
  public int[] countBits(int n) {
    int[] bits = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      bits[i] = countOnes(i);
    }
    return bits;
  }

  public int[] countBits1(int n) {
    int[] result = new int[n + 1];
    result[0] = 0;
    for (int i = 0; i <= n; i++) {
      if (i % 2 == 0) {
        result[i] = result[i / 2];
      } else {
        result[i] = result[i - 1] + 1;
      }
    }
    return result;
  }

  private int countOnes(int i) {
    int ones = 0;
    while (i > 0) {
      i &= (i - 1);
      ones++;
    }
    return ones;
  }

  /**
   * 328. 奇偶链表
   *
   * <p>给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，
   *
   * <p>而不是节点的值的奇偶性。
   *
   * <p>请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
   */
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode evenHead = head.next;
    ListNode odd = head, even = evenHead;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }

  /**
   * 367. 有效的完全平方数
   *
   * <p>使用牛顿迭代法
   */
  public boolean isPerfectSquare(int num) {
    if (num < 2) {
      return true;
    }
    long x = num / 2;
    while ((x * x) > num) {
      x = (x + num / x) / 2;
    }
    return (x * x == num);
  }

  public String findLongestWord(String s, List<String> dictionary) {
    int length = s.length();
    // dp[i][j] 表示字符串s从i位置开始往后,字符j 第一次出现的位置
    int[][] dp = new int[length + 1][26];
    Arrays.fill(dp[length], length);
    for (int i = length - 1; i >= 0; i--) {
      for (int j = 0; j < 26; j++) {
        if (s.charAt(i) == (char) ('a' + j)) {
          dp[i][j] = i;
        } else {
          dp[i][j] = dp[i + 1][j];
        }
      }
    }
    String res = "";
    for (String t : dictionary) {
      boolean match = true;
      int tLength = t.length();
      int j = 0;
      for (int i = 0; i < tLength; i++) {
        if (dp[j][t.charAt(i) - 'a'] == length) {
          match = false;
          break;
        }
        j = dp[j][t.charAt(i) - 'a'] + 1;
      }
      if (match) {
        if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
          res = t;
        }
      }
    }
    return res;
  }

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    rows = matrix.length;
    columns = matrix[0].length;
    int[][] outDegrees = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        for (int[] path : paths) {
          int newRow = i + path[0], newColumn = j + path[1];
          if (newRow >= 0
              && newRow < rows
              && newColumn >= 0
              && newColumn < columns
              && matrix[newRow][newColumn] > matrix[i][j]) {
            ++outDegrees[i][j];
          }
        }
      }
    }
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (outDegrees[i][j] == 0) {
          queue.offer(new int[] {i, j});
        }
      }
    }
    int ans = 0;
    while (!queue.isEmpty()) {
      ++ans;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] cell = queue.poll();
        int row = cell[0], column = cell[1];
        for (int[] path : paths) {
          int newRow = row + path[0], newColumn = column + path[1];
          if (newRow >= 0
              && newRow < rows
              && newColumn >= 0
              && newColumn < columns
              && matrix[newRow][newColumn] > matrix[row][column]) {
            --outDegrees[newRow][newColumn];
            if (outDegrees[newRow][newColumn] == 0) {
              queue.offer(new int[] {newRow, newColumn});
            }
          }
        }
      }
    }
    return ans;
  }

  /**
   * 331. 验证二叉树的前序序列化
   *
   * <p>使用栈算法
   */
  public boolean isValidSerialization(String preorder) {
    int n = preorder.length();
    int i = 0;
    Deque<Integer> stack = new LinkedList<>();
    stack.push(1);
    while (i < n) {
      if (stack.isEmpty()) {
        return false;
      }
      if (preorder.charAt(i) == ',') {
        i++;
      } else if (preorder.charAt(i) == '#') { // 如果是空节点,当前可用槽个数减1,如果为0则把当前结点弹出栈
        int top = stack.pop() - 1;
        if (top > 0) {
          stack.push(top);
        }
        i++;
      } else { // 如果当前结点是非空结点,则把当前对应的结点对应的槽点数减一,并把自己结点的槽点数入栈
        while (i < n && preorder.charAt(i) != ',') {
          i++;
        }
        int top = stack.pop() - 1;
        if (top > 0) {
          stack.push(top);
        }
        stack.push(2);
      }
    }
    return stack.isEmpty();
  }

  /**
   * 371. 两整数之和
   *
   * <p>给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
   */
  public int getSum(int a, int b) {
    while (b != 0) {
      int carry = (a & b) << 1;
      a ^= b;
      b = carry;
    }
    return a;
  }



  /**
   * 1524. 和为奇数的子数组数目
   *
   * <p>给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
   *
   * <p>由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
   *
   * <p>解法
   *
   * <p>当下标 ii 的位置的前缀和是偶数时，如果下标 jj 满足 j < ij<i 且下标 jj 的位置的前缀和是奇数，则从下标 j+1j+1 到下标 ii
   * 的子数组的和是奇数，因此，以下标 ii 结尾的子数组中，和为奇数的子数组的数量即为奇数前缀和的数量 \textit{odd}odd；
   *
   * <p>当下标 ii 的位置的前缀和是奇数时，如果下标 jj 满足 j < ij<i 且下标 jj 的位置的前缀和是偶数，则从下标 j+1j+1 到下标 ii
   * 的子数组的和是奇数，因此，以下标 ii 结尾的子数组中，和为奇数的子数组的数量即为偶数前缀和的数量 \textit{even}even。
   */
  public int numOfSubarrays(int[] arr) {
    int max = 1000000007;
    // 当前缀和为0是前缀和为偶数的个数为1
    int odd = 0, even = 1;
    int subArrays = 0;
    int sum = 0;
    int length = arr.length;
    for (int j : arr) {
      sum += j;
      subArrays = (subArrays + (sum % 2 == 0 ? odd : even)) % max;
      if (sum % 2 == 0) {
        even++;
      } else {
        odd++;
      }
    }
    return subArrays;
  }

  /**
   * 437. 路径总和 III
   *
   * <p>给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于
   *
   * <p>targetSum的路径的数目。
   */
  int pathSumAns = 0;
  public int pathSum(TreeNode root, int targetSum) {
    // 记录路径中某个前缀和出现的次数
    Map<Integer, Integer> map = new HashMap<>();
    //防止包含根节点的时候找不到
    map.put(0,1);
    dfs_pathSum(root,map,0,targetSum);
    return pathSumAns;
  }

  private void dfs_pathSum(TreeNode node, Map<Integer, Integer> map, int currSum, int targetSum) {
    //递归退出条件
    if(node == null){
      return;
    }
    //判断是否存在符合条件的前缀和

    currSum += node.val;
    pathSumAns+=map.getOrDefault(currSum-targetSum,0);

    //将当前前缀和记录下来
    map.put(currSum,map.getOrDefault(currSum,0)+1);

    //继续往下递归
    //左子树
    dfs_pathSum(node.left,map,currSum,targetSum);
    //右子树
    dfs_pathSum(node.right,map,currSum,targetSum);

    //回溯,恢复状态
    map.put(currSum,map.getOrDefault(currSum,0)-1);
  }

  public static void main(String[] args) {
    char[][] matrix =
            new char[][] {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'0', '0', '1', '1', '1'}
            };
    int[] arr = {7, 7, 7, 7, 7, 7, 7};
    int[][] intArr = {
            {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
    };
    //    moveZeroes(arr);
    //    MedianFinder m = new MedianFinder();
    //    m.addNum(1);
    //    m.addNum(2);
    //    NumMatrix nm = new NumMatrix(intArr);
    System.out.println(removeDuplicateLetters("bcabc"));
    //    System.out.println(());
  }
}
