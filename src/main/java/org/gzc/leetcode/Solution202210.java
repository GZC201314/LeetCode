package org.gzc.leetcode;

import org.gzc.leetcode.model.ParkingSystem;
import org.gzc.leetcode.model.TreeNode;
import org.gzc.leetcode.model.UnionFind2;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author GZC
 */
public class Solution202210 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 1800:
                System.out.println(maxAscendingSum(new int[] {1, 2, 3, 4}));
                break;
            case 1601:
                System.out.println(maximumRequests(5, new int[][] {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
                break;
            case 1603:
                ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
                System.out.println(parkingSystem.addCar(1));
                System.out.println(parkingSystem.addCar(1));
                System.out.println(parkingSystem.addCar(2));
                System.out.println(parkingSystem.addCar(3));

                break;
            case 870:
                System.out
                    .println(Arrays.toString(advantageCount(new int[] {12, 24, 8, 32}, new int[] {13, 25, 32, 11})));
                break;
            case 1551:
                System.out.println(minOperations(3));
                break;
            case 952:
                System.out.println(largestComponentSize(new int[] {4, 6, 15, 9}));
                break;
            case 956:
                System.out.println(tallestBillboard(
                    new int[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 50, 50, 50, 150, 150, 150, 100, 100, 100, 123}));
                break;
            case 955:
                System.out.println(minDeletionSize(new String[] {"123", "612", "156", "913"}));
                break;
            case 951:
                TreeNode node = new TreeNode(1, new TreeNode(3), null);
                TreeNode node1 = new TreeNode(1, null, new TreeNode(3));
                System.out.println(flipEquiv(node, node1));
                break;
            default:
                break;
        }
    }

    /**
     * 956. 最高的广告牌
     */
    public static int tallestBillboardAns = 0;

    public static int tallestBillboard(int[] rods) {
        tallestBillboardDfs(rods, 0, 0, 0);
        return tallestBillboardAns;
    }

    public static void tallestBillboardDfs(int[] rods, int index, int cur1, int cur2) {

        if (index == rods.length) {
            if (cur1 == cur2) {
                tallestBillboardAns = Math.max(tallestBillboardAns, cur1);
            }
            return;
        }
        if (cur1 == cur2) {
            tallestBillboardAns = Math.max(tallestBillboardAns, cur1);
        }

        // 三个可能性
        tallestBillboardDfs(rods, index + 1, cur1 + rods[index], cur2);
        tallestBillboardDfs(rods, index + 1, cur1, cur2);
        tallestBillboardDfs(rods, index + 1, cur1, cur2 + rods[index]);
    }

    /**
     * 955. 删列造序||
     */
    public static int minDeletionSize(String[] A) {
        int N = A.length;
        int W = A[0].length();
        int ans = 0;

        String[] cur = new String[N];
        for (int j = 0; j < W; ++j) {
            String[] cur2 = Arrays.copyOf(cur, N);
            for (int i = 0; i < N; ++i) {
                cur2[i] += A[i].charAt(j);
            }

            if (isSorted(cur2)) {
                cur = cur2;
            } else {
                ans++;
            }
        }

        return ans;
    }

    public static boolean isSorted(String[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i].compareTo(A[i + 1]) > 0) {
                return false;
            }

        return true;
    }

    /**
     * 952. 按公因数计算最大组件的大小
     */
    public static int largestComponentSize(int[] nums) {
        OptionalInt max = Arrays.stream(nums).max();
        if (!max.isPresent()) {
            return -1;
        }
        int m = max.getAsInt();
        UnionFind2 uf = new UnionFind2(m + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int[] counts = new int[m + 1];
        int ans = 0;
        for (int num : nums) {
            int root = uf.find(num);
            counts[root]++;
            ans = Math.max(ans, counts[root]);
        }
        return ans;
    }

    /**
     * 951. 反转等价二叉树
     */
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return false;
        }
        if (root1.left == null && root1.right == null && root2.left == null && root2.right == null) {
            return root1.val == root2.val;
        }
        return (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
            || flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) && root1.val == root2.val;
    }

    /**
     * 1601. 最多可达成的换楼请求数目
     */
    public static int maximumRequestsAnswer = 0;

    public static int maximumRequests(int n, int[][] requests) {
        maximumRequestsDfs(new int[n], requests, 0, 0);
        return maximumRequestsAnswer;
    }

    public static void maximumRequestsDfs(int[] used, int[][] requests, int cur, int chosen) {
        if (cur == requests.length) {
            if (validUsedArr(used)) {
                maximumRequestsAnswer = Math.max(chosen, maximumRequestsAnswer);
            }
            return;
        }
        // 不选当前的request
        maximumRequestsDfs(used, requests, cur + 1, chosen);

        // 选择当前的request
        used[requests[cur][0]]--;
        used[requests[cur][1]]++;
        maximumRequestsDfs(used, requests, cur + 1, chosen + 1);
        // 回溯
        used[requests[cur][1]]--;
        used[requests[cur][0]]++;
    }

    private static boolean validUsedArr(int[] used) {
        for (int i : used) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 870. 优势洗牌
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            // 找到最小的满足数
            Integer integer = map.higherKey(nums2[i]);
            if (integer == null) {
                integer = map.firstKey();
            }
            result[i] = integer;
            if (map.get(integer) == 1) {
                map.remove(integer);
            } else {
                map.put(integer, map.get(integer) - 1);
            }
        }
        return result;
    }

    /**
     * 1551. 使数组中所有元素相等的最小操作数
     */
    public static int minOperations(int n) {
        int num = 2 * (n - 1) + 1;
        int avg = (num + 1) / 2;
        int res = 0;
        for (int i = 0; i * 2 < n; i++) {
            res += (avg - (2 * i + 1));
        }
        return res;
    }

    /**
     * 1800. 最大升序子数组和
     */
    public static int maxAscendingSum(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        int lastNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > lastNum) {
                sum += num;
            } else {
                result = Math.max(result, sum);
                sum = num;
            }
            lastNum = num;
        }
        return Math.max(result, sum);
    }

}
