package org.gzc.leetcode;

import org.gzc.leetcode.model.Node;
import org.gzc.leetcode.model.RandomizedSet;

import java.util.*;

/**
 * @author GZC
 * @create 2022-03-03 21:59
 * @description 2022年三月 LeetCode代码练习
 */
public class Solution202203 {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int qusetionNum = input.nextInt();
        switch (qusetionNum) {
            case 414:
                System.out.println(thirdMax(new int[]{1, 2, 3, 4}));
                break;
            case 504:
                System.out.println(convertToBase7(12));
                break;
            case 389:
                RandomizedSet randomizedSet = new RandomizedSet();
                randomizedSet.insert(1);
            case 589:
                System.out.println(preorder(new Node()));
                System.out.println(preorder1(new Node()));
                break;
            default:
                break;
        }

    }

    /**
     * 414. 第三大的数
     *
     * @param nums 数据
     * @return 第三大的数
     */
    public static int thirdMax(int[] nums) {
        TreeSet<Integer> results = new TreeSet<>();
        for (int num :
                nums) {
            results.add(num);
            if (results.size() > 3) {
                results.remove(results.first());
            }
        }
        if (results.size() == 3) {
            return results.first();
        }
        return results.last();
    }

    /**
     * 504. 七进制数
     *
     * @param num 参数
     * @return 七进制数字符串
     */
    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        char flag = 0;
        if (num < 0) {
            flag = '-';
        }
        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (flag == '-') {
            sb.reverse().insert(0, '-');
        } else {
            sb.reverse();
        }
        return sb.toString();
    }

    /**
     * 589. N 叉树的前序遍历 非递归算法
     *
     * @param root 根节点
     * @return 先序遍历
     */
    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.add(root);
        while (!nodeStack.isEmpty()) {
            Node topNode = nodeStack.pop();
            result.add(topNode.val);
            for (int i = topNode.children.size() - 1; i >= 0; i--) {
                nodeStack.add(topNode.children.get(i));
            }
        }
        return result;
    }

    /**
     * 589. N 叉树的前序遍历 递归算法
     *
     * @param root 根节点
     * @return 先序遍历
     */
    public static List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);

        for (Node node1 :
                root.children) {
            result.addAll(preorder1(node1));
        }
        return result;
    }

    long maxScore = 0;
    int cnt = 0;
    int n;
    List<Integer>[] children;

    /**
     * 2049. 统计最高分的节点数目
     */
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        dfsCountHighestScoreNodes(0);
        return cnt;
    }

    public int dfsCountHighestScoreNodes(int node) {
        long score = 1;
        int size = n - 1;
        for (int c : children[node]) {
            int t = dfsCountHighestScoreNodes(c);
            score *= t;
            size -= t;
        }
        if (node != 0) {
            score *= size;
        }
        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return n - size;
    }

}
