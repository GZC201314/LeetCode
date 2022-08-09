package org.gzc.leetcode;

import org.gzc.leetcode.model.*;
import org.gzc.leetcode.model.Node;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author GZC
 */
public class Solution202208 {

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
            case 123:
                morris(new Node(5,new Node(4),new Node(2)));
                break;
            case 124:
                preOrderMorris(new Node(5,null,new Node(2)));
                break;
            case 507:
                System.out.println(checkPerfectNumber(28));
                break;
            case 508:
                System.out.println(Arrays.toString(findFrequentTreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-3)))));
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
            return new TreeNode(val,root,null);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int curDepth =1;
        while (!queue.isEmpty()){
            int size = queue.size();
            if (curDepth == depth-1){
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    assert node != null;
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(val,left,null);
                    node.right = new TreeNode(val,null,right);
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
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

    /**
     * 507. 完美数
     */
    public static boolean checkPerfectNumber(int num) {

        if(num ==1){
            return false;
        }
        int sum =1;
        for (int i = 2; i*i <= num  ; i++) {
            if(num%i ==0){
                sum+=i;
                if (i*i <= num){
                    sum+=num/i;
                }
            }
        }
        return sum == num;
    }

    /**
     * 508. 出现次数最多的子树元素和
     */
    public static int[] findFrequentTreeSum(TreeNode root) {
        Map<TreeNode,Integer> sumMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        dfsCheckPerfectNumber(root, sumMap);

        sumMap.forEach((key, value) -> countMap.put(value, countMap.getOrDefault(value, 0) + 1));
        Stream<Integer> stream = countMap.values().stream();
        int max = stream.max(Integer::compareTo).get();
        List<Integer> list = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        entries.forEach((entry)->{
            if (entry.getValue() == max){
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

    public static int dfsCheckPerfectNumber(TreeNode node, Map<TreeNode,Integer> sumMap){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            sumMap.put(node, node.val);
            return node.val;
        }
        if(sumMap.containsKey(node)){
            return sumMap.get(node);
        }
        int sum = node.val+dfsCheckPerfectNumber(node.left,sumMap)+dfsCheckPerfectNumber(node.right,sumMap);
        sumMap.put(node,sum);
        return sum;
    }

    /**
     * 二叉树 morris 遍历
     */
    public static void morris(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight;
        while(cur != null){
            // mostRight 变成了cur左子树的最右的节点
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right !=cur){
                    mostRight = mostRight.right;
                }
                // 第一次访问cur
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    //第二次访问cur
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    /**
     * mirris 先序遍历
     */
    public static void preOrderMorris(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight;
        while(cur != null){
            // mostRight 变成了cur左子树的最右的节点
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right !=cur){
                    mostRight = mostRight.right;
                }
                // 第一次访问cur
                if(mostRight.right == null){
                    System.out.println(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    //第二次访问cur
                    mostRight.right = null;
                }
            }else {
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }

}
