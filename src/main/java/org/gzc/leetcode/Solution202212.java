package org.gzc.leetcode;

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
            case 1769:
                System.out.println(Arrays.toString(minOperations("001011")));
                break;
            default:
                break;
        }
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
        int rightSum = (boxes.charAt(n-1) == '1' ? 1 : 0);
        for (int i = n - 2; i >= 0; i--) {
            rightArr[i] = rightSum + rightArr[i + 1];
            rightSum += (boxes.charAt(i) == '1' ? 1 : 0);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftArr[i]+rightArr[i];
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
