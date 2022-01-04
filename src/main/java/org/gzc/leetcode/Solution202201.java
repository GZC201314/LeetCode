package org.gzc.leetcode;

import org.gzc.leetcode.model.TreeNode;

import java.util.*;

/**
 * @author GZC
 * @description 十二月份的LeetCode练习代码
 */
public class Solution202201 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        int result =0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if(treeNode.left!=null){
                if(treeNode.left.left==null && treeNode.left.right == null){
                    result+= treeNode.left.val;
                }
                stack.add(treeNode.left);
            }
            if(treeNode.right!=null){
                stack.add(treeNode.right);
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }
}
