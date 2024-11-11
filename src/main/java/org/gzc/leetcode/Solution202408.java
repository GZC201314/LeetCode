package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.gzc.leetcode.model.MagicDictionary;
import org.gzc.leetcode.model.TreeNode;

import java.util.*;


/**
 * @author GZC
 */
@Slf4j
public class Solution202408 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 2207:
                log.info(String.valueOf(maximumSubsequenceCount("aabb", "ab")));
                break;
            case 1954:
                log.info(String.valueOf(minimumPerimeter(13)));
                break;
            case 3129:
                log.info(String.valueOf(numberOfStableArrays(1, 2, 1)));
                break;
            case 2385:
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5))));
                log.info(String.valueOf(amountOfTime(root, 1)));
                break;
            case 2155:
                log.info(String.valueOf(maxScoreIndices(new int[]{0, 0, 0})));
                break;
            default:
                break;

        }


    }

    /**
     * 2155. 分组得分最高的所有下标
     */
    public static List<Integer> maxScoreIndices(int[] nums) {
        int[] zeroOne = new int[2];
        int ans = 0;
        Map<Integer, List<Integer>> count = new HashMap<>();
        for (int num : nums) {
            if (num == 0) {
                zeroOne[0]++;
            } else {
                zeroOne[1]++;
            }
        }
        ans = zeroOne[1];
        count.put(zeroOne[1], new ArrayList<>(Arrays.asList(0)));


        int[] curCount = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                curCount[0]++;
            } else {
                curCount[1]++;
            }
            int score = curCount[0] + zeroOne[1] - curCount[1];
            if (score > ans) {
                List<Integer> cur = new ArrayList<>();
                cur.add(i + 1);
                count.put(score, cur);
                ans = score;
            } else if (score == ans) {
                List<Integer> cur = count.get(score);
                cur.add(i + 1);
            }

        }
        return count.get(ans);
    }


    /**
     * 2207. 字符串中最多数目的子序列
     */
    public static long maximumSubsequenceCount(String text, String pattern) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == pattern.charAt(0)) {
                list1.add(i);
            }
            if (charArray[i] == pattern.charAt(1)) {
                list2.add(i);
            }
        }
        long ans = 0;
        int curIndex = 0;
        for (Integer index : list1) {
            for (int i = curIndex; i < list2.size(); i++) {
                if (index < list2.get(i)) {
                    ans += list2.size() - i;
                    curIndex = i;
                    break;
                }
            }
        }
        return ans + Math.max(list1.size(), list2.size());
    }

    /**
     * 1954. 收集足够苹果的最小花园周长
     */
    public static long minimumPerimeter(long neededApples) {
        // 前n个花园的苹果的个数 appleNum = 2i*(i+1)*(2i+1)
        long i = 0;
        while (2 * i * (i + 1) * (2 * i + 1) < neededApples) {
            i++;
        }
        return (i * 2) * 4;
    }

    /**
     * 3129. 找出所有稳定的二进制数组 I
     */
    public static int numberOfStableArrays(int zero, int one, int limit) {
        final int mod = 1_000_000_007;
        int[][][] f = new int[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(limit, zero); i++) {
            f[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(limit, one); j++) {
            f[0][j][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // + mod 保证答案非负
                f[i][j][0] = (int) (((long) f[i - 1][j][0] + f[i - 1][j][1] + (i > limit ? mod - f[i - limit - 1][j][1] : 0)) % mod);
                f[i][j][1] = (int) (((long) f[i][j - 1][0] + f[i][j - 1][1] + (j > limit ? mod - f[i][j - limit - 1][0] : 0)) % mod);
            }
        }
        return (f[zero][one][0] + f[zero][one][1]) % mod;
    }

    /**
     * 2385. 感染二叉树需要的总时间
     */
    public static int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentNode = new HashMap<>();
        Set<TreeNode> used = new HashSet<>();
        // 广度优先遍历
        TreeNode startNode = null;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        if (root.val == start) {
            startNode = root;
            used.add(startNode);
        }
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode parent = deque.pollLast();

                assert parent != null;
                TreeNode left = parent.left;
                TreeNode right = parent.right;
                if (left != null) {
                    count++;
                    parentNode.put(left, parent);
                    deque.push(left);
                    if (left.val == start) {
                        used.add(left);
                        startNode = left;
                    }
                }
                if (right != null) {
                    count++;
                    parentNode.put(right, parent);
                    deque.push(right);
                    if (right.val == start) {
                        used.add(right);
                        startNode = right;
                    }
                }
            }
        }
        // 开始感染
        int curCount = 0;
        int minutes = 0;
        Deque<TreeNode> sideNode = new LinkedList<>();
        sideNode.push(startNode);
        while (curCount < count) {
            int size = sideNode.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                // 找到子孙和父节点开始感染
                // 父节点
                TreeNode treeNode = sideNode.pollLast();
                TreeNode parent = parentNode.get(treeNode);
                if (parent != null && !used.contains(parent)) {
                    sideNode.push(parent);
                    used.add(parent);
                    curCount++;
                }
                assert treeNode != null;
                TreeNode left = treeNode.left;
                if (left != null && !used.contains(left)) {
                    sideNode.push(left);
                    used.add(left);
                    curCount++;
                }
                TreeNode right = treeNode.right;
                if (right != null && !used.contains(right)) {
                    sideNode.push(right);
                    used.add(right);
                    curCount++;
                }

            }
        }
        return minutes;


    }


}
