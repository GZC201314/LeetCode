package org.gzc.leetcode;

import org.gzc.leetcode.model.*;

import java.io.IOException;
import java.util.*;

/**
 * @author GZC
 */
public class Solution202208 {
    /**
     * 判断一个二叉树是否是二叉搜索树
     */
    public static int preValue = Integer.MIN_VALUE;
    /**
     * 折纸问题
     */
    public static String paperFoldStr = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 503:
                System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));
                break;
            case 1403:
                System.out.println(minSubsequence(new int[]{4, 4, 6, 7, 7}));
                break;
            case 623:
                System.out.println(addOneRow(new TreeNode(4),1,3));
                break;
            default:
                break;
        }

    }

    /**
     * 503. 下一个更大元素||
     */
    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = i + 1; j < i + n; j++) {
                if (nums[j%n] > num) {
                    result[i] = nums[j%n];
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
        int right = n-1;
        int leftNum = 0;
        result.add(nums[right]);
        int rightNum = nums[right--];

        while(left <= right){
            if (leftNum+nums[left] < rightNum){
                leftNum += nums[left++];
            }else {
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
        if (depth == 1){
            TreeNode node = new TreeNode(val,root,null);
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int curDepth =1;
        while (!queue.isEmpty()){
            int size = queue.size();
            if (curDepth == depth-1){
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(val,left,null);
                    node.right = new TreeNode(val,null,right);
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            curDepth++;
        }


        return root;
    }


}
