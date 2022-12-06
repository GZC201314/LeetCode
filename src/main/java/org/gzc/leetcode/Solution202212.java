package org.gzc.leetcode;

import org.gzc.leetcode.model.SmallestInfiniteSet;
import org.gzc.leetcode.model.TreeNode;

import java.util.*;

/**
 * @author GZC
 */
public class Solution202212 {

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
            case 1805:
                System.out.println(numDifferentIntegers("a123bc34d8ef34"));
                break;
            default:
                break;
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

    /**
     * 1774. 最接近目标价格的甜点成本
     */
    public static int closestCostRes = Integer.MAX_VALUE;

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


}
