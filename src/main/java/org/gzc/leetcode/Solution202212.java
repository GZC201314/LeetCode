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
            default:
                break;
        }
    }

    /**
     * 剑指Offer 55. 二叉树的深度
     */
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }


}
