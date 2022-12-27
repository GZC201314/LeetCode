package org.gzc.leetcode;

import org.gzc.leetcode.model.SmallestInfiniteSet;
import org.gzc.leetcode.model.TreeNode;

import java.util.*;

/**
 * @author GZC
 */
public class Solution202212 {

    /**
     * 1774. 最接近目标价格的甜点成本
     */
    public static int closestCostRes = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 55:
                System.out.println(maxDepth(new TreeNode(1)));
                break;
            case 106:
                System.out.println(isBipartite(new int[][]{{1}, {0, 3}, {3}, {1, 2}}));
                break;
            case 4:
                System.out.println(findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
                break;
            case 1697:
                System.out.println(Arrays.toString(distanceLimitedPathsExist(3, new int[][]{{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}}, new int[][]{{0, 1, 2}, {0, 2, 5}})));
                break;
            case 2336:
                SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
                smallestInfiniteSet.addBack(10);
                System.out.println(smallestInfiniteSet.popSmallest());
                break;
            case 1769:
                System.out.println(Arrays.toString(minOperations("001011")));
                break;
            case 1774:
                System.out.println(closestCost(new int[]{3, 10}, new int[]{2, 5}, 9));
                break;
            case 1827:
                System.out.println(minOperations(new int[]{3, 10}));
                break;
            case 1760:
                System.out.println(minimumSize(new int[]{7, 17}, 2));
                break;
            case 1785:
                System.out.println(minElements(new int[]{3, 10}, 11, -7));
                break;
            case 1805:
                System.out.println(numDifferentIntegers("a123bc34d8ef34"));
                break;
            case 1812:
                System.out.println(squareIsWhite("a2"));
                break;
            case 1781:
                System.out.println(beautySum("aabcb"));
                break;
            case 1945:
                System.out.println(getLucky("iiii", 1));
                break;
            case 1753:
                System.out.println(maximumScore(2, 4, 6));
                break;
            case 2027:
                System.out.println(minimumMoves("XOOOOOX"));
                break;
            case 2011:
                System.out.println(finalValueAfterOperations(new String[]{"++X","X++","--X"}));
                break;
            case 744:
                System.out.println(nextGreatestLetter("eeff".toCharArray(), 'f'));
                break;
            default:
                break;
        }
    }

    /**
     * 2027. 转换字符串的最少操作次数
     */
    public static int minimumMoves(String s) {
        char[] sChr = s.toCharArray();
        int len = sChr.length;
        int ans = 0;
        int index = 0;
        while (index < len){
            if (sChr[index] == 'X'){
                ans++;
                index+=3;
            }else {
                index++;
            }
        }
        return ans;
    }

    /**
     * 2011. 执行操作后的变量值
     */
    public static int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            if (operation.contains("++")){
                ans++;
            }else {
                ans--;
            }
        }
        return ans;
    }

    /**
     * 1753. 移除石子的最大得分
     */
    public static int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        int ans = 0;
        while (pq.size() >= 2) {
            Integer max = pq.poll();
            Integer minSe = pq.poll();
            Integer peek = pq.isEmpty() ? 0 : pq.peek();
            assert minSe != null;
            int rest = minSe - peek;
            rest = rest == 0 ? 1 : rest;
            if (max - rest > 0) {
                pq.offer(max - rest);
            }
            if (minSe - rest > 0) {
                pq.offer(minSe - rest);
            }
            ans += rest;
        }
        return ans;
    }

    /**
     * 1760. 袋子里最小数目的球
     */
    public static int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        if (Arrays.stream(nums).max().isPresent()) {
            right = Arrays.stream(nums).max().getAsInt();
        }
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long opt = 0;
            for (int num : nums) {
                opt += (num - 1) / mid;
            }
            if (opt <= maxOperations) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 1785. 构成特定和需要添加的最少元素
     */
    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long rest = Math.abs(goal - sum);
        return (int) ((rest + limit - 1) / limit);
    }

    /**
     * 1945. 字符串转化后的各位字符之和
     */
    public static int getLucky(String s, int k) {
        StringBuilder sb;
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 5);
        map.put('f', 6);
        map.put('g', 7);
        map.put('h', 8);
        map.put('i', 9);
        map.put('j', 10);
        map.put('k', 11);
        map.put('l', 12);
        map.put('m', 13);
        map.put('n', 14);
        map.put('o', 15);
        map.put('p', 16);
        map.put('q', 17);
        map.put('r', 18);
        map.put('s', 19);
        map.put('t', 20);
        map.put('u', 21);
        map.put('v', 22);
        map.put('w', 23);
        map.put('x', 24);
        map.put('y', 25);
        map.put('z', 26);
        sb = new StringBuilder();
        char[] sChars = s.toCharArray();
        for (char sChar : sChars) {
            sb.append(map.get(sChar));
        }
        s = sb.toString();
        int sum = 0;
        while (k > 0) {
            if (s.length() == 1 && Character.isDigit(s.charAt(0))) {
                return Integer.parseInt(s);
            }
            char[] chars = s.toCharArray();
            sum = 0;
            for (char aChar : chars) {
                sum += map.get(aChar);
            }
            s = String.valueOf(sum);
            k--;
        }
        return sum;

    }

    /**
     * 1781.所有子字符串美丽值之和
     */
    public static int beautySum(String s) {

        char[] chars = s.toCharArray();
        int n = chars.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] countArr = new int[26];
            int max = 0;
            for (int j = i; j < n; j++) {
                countArr[chars[j] - 'a']++;
                max = Math.max(max, countArr[chars[j] - 'a']);
                int min = n;
                for (int k = 0; k < 26; k++) {
                    if (countArr[k] > 0) {
                        min = Math.min(min, countArr[k]);
                    }
                }
                ans += (max - min);

            }
        }
        return ans;
    }

    /**
     * 1827. 最小操作使数组递增
     */
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int lastMax = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > lastMax) {
                lastMax = nums[i];
            } else {
                ans += lastMax + 1 - nums[i];
                lastMax = lastMax + 1;
            }
        }
        return ans;
    }

    /**
     * 744. 查找比目标字母大的最小字母
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (letters[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        if (letters[mid] <= target) {
            while (mid < letters.length) {
                if (letters[(++mid) % (letters.length)] > target) {
                    return letters[mid];
                }
            }
            return letters[0];
        } else {
            return letters[(mid) % (letters.length)];
        }
    }

    /**
     * 1812. 判断国际象棋棋盘中一个格子的颜色
     */
    public static boolean squareIsWhite(String coordinates) {
        char[] chars = coordinates.toCharArray();
        int num1 = (chars[0] - 'a' + 1);
        int num2 = chars[1] - '0';
        // 第一个是黑色
        if (num1 % 2 == 1) {
            return num2 % 2 == 0;
        } else {
            return num2 % 2 == 1;
        }
    }

    /**
     * 剑指Offer 04 二维数组中的查找
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 1805. 字符串中不同整数的数目
     */
    public static int numDifferentIntegers(String word) {
        String zero = "0";
        String[] split = word.split("[a-z]+");
        Set<String> set = new HashSet<>();
        for (String s : split) {
            if (!"".equals(s)) {
                while (s.startsWith(zero)) {
                    s = s.replaceFirst("0", "");
                }
                set.add(s);
            }
        }
        return set.size();
    }

    /**
     * 剑指Offer 106. 二分图
     */
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // 1代表一种颜色，2代表一种颜色
        int[] valid = new int[n];
        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            if (valid[i] == 0) {
                valid[i] = 1;
            }
            while (!stack.isEmpty()) {
                int size = stack.size();
                for (int j = 0; j < size; j++) {
                    Integer pop = stack.pop();
                    for (int node : graph[pop]) {
                        if (valid[node] == valid[pop]) {
                            return false;
                        }
                        if (valid[node] == 0) {
                            stack.push(node);
                        }
                        if (valid[pop] == 1) {
                            valid[node] = 2;
                        } else {
                            valid[node] = 1;
                        }
                    }

                }

            }
        }
        return true;

    }

    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int baseCost : baseCosts) {
            closestCostDfs(toppingCosts, 0, baseCost, target);
        }
        return closestCostRes;

    }

    private static void closestCostDfs(int[] toppingCosts, int i, int curCost, int target) {

        if (Math.abs(closestCostRes - target) < curCost - target) {
            return;
        }
        if (Math.abs(closestCostRes - target) >= Math.abs(curCost - target)) {
            if (Math.abs(closestCostRes - target) > Math.abs(curCost - target)) {
                closestCostRes = curCost;
            } else {
                closestCostRes = Math.min(closestCostRes, curCost);
            }
        }
        if (i == toppingCosts.length) {
            return;
        }
        closestCostDfs(toppingCosts, i + 1, curCost + toppingCosts[i] * 2, target);
        closestCostDfs(toppingCosts, i + 1, curCost + toppingCosts[i], target);
        closestCostDfs(toppingCosts, i + 1, curCost, target);
    }

    /**
     * 1769. 移动所有球到每个盒子所需的最小操作数
     */
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        int leftSum = (boxes.charAt(0) == '1' ? 1 : 0);
        for (int i = 1; i < n; i++) {
            leftArr[i] = leftSum + leftArr[i - 1];
            leftSum += (boxes.charAt(i) == '1' ? 1 : 0);
        }
        int rightSum = (boxes.charAt(n - 1) == '1' ? 1 : 0);
        for (int i = n - 2; i >= 0; i--) {
            rightArr[i] = rightSum + rightArr[i + 1];
            rightSum += (boxes.charAt(i) == '1' ? 1 : 0);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftArr[i] + rightArr[i];
        }
        return result;
    }

    /**
     * 剑指Offer 55. 二叉树的深度
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 1697. 检查边长度限制的路径是否存在
     */
    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(a -> queries[a][2]));
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        boolean[] res = new boolean[queries.length];
        int k = 0;
        for (int i : index) {
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                merge(uf, edgeList[k][0], edgeList[k][1]);
                k++;
            }
            res[i] = find(uf, queries[i][0]) == find(uf, queries[i][1]);
        }
        return res;
    }

    public static int find(int[] uf, int index) {
        if (uf[index] == index) {
            return index;
        }
        return uf[index] = find(uf, uf[index]);
    }

    public static void merge(int[] uf, int x, int y) {
        x = find(uf, x);
        y = find(uf, y);
        uf[y] = x;
    }


}
