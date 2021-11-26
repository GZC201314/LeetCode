package org.gzc.leetcode;

import org.gzc.leetcode.model.TreeNode;

import java.util.*;

/**
 * @author GZC
 * @description 十一月份的LeetCode练习代码
 */
public class Solution11 {
    /**
     * 495. 提莫攻击
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int prisonTimeStart = 0;
        int prisonTimeEnd = 0;
        int prisonSum = 0;
        for (Integer timeSerie : timeSeries) {
            if (prisonTimeEnd <= timeSerie) {
                prisonSum += (prisonTimeEnd - prisonTimeStart);
                prisonTimeStart = timeSerie;
                prisonTimeEnd = timeSerie + duration;
            } else if (prisonTimeEnd < (timeSerie + duration)) {
                prisonTimeEnd = timeSerie + duration;
            }
        }
        prisonSum += (prisonTimeEnd - prisonTimeStart);
        return prisonSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4};
        System.out.println(findPoisonedDuration(arr, 2));
    }

    /**
     * 343. 整数拆分
     * <p>
     * 算法 动态规划
     * <p>
     * 转移方程:
     * dp[i]= 1≤j<i max{max(j×(i−j),j×dp[i−j])} 其中dp[i] 表示整数i拆分后的最大乘积
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    /**
     * 347. 前K个高频元素
     * <p>
     * map 加 桶排序
     */
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        /*使用map ,统计每个元素出现的次数*/
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num :
                nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        /*桶排序*/
        //将频率作为数组下标,对于出现频率不同的数字集合,存入对应的数组下表
        ArrayList<Integer>[] list = new ArrayList[nums.length + 1];

        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }

        //倒序遍历数组获取出现顺序从大到小的排列

        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) {
                continue;
            }
            if (res.size() + list[i].size() <= k) {
                res.addAll(list[i]);
            } else {
                int size = k - res.size();

                res.addAll(list[i].subList(0, size));
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 520. 检测大写字母
     */
    public boolean detectCapitalUse(String word) {
        //如果所有的字母都是大写字母
        if (word.toUpperCase().equals(word) || word.toLowerCase().equals(word)) {
            return true;
        }
        //如果首字母是大写
        if ('A' <= word.charAt(0) && word.charAt(0) <= 'Z') {
            String substring = word.substring(1);
            if (substring.toLowerCase().equals(substring)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 357. 计算各个位数不同的数字个数
     * <p>
     * 算法思路 动态规划
     * <p>
     * 比如，个位数中各个位数不同的数字个数为9（这里0不算个位数），
     * <p>
     * 那么两位数中各个位数不同的数字就是在这9个数的后面插入另一个不同的数字，
     * <p>
     * 所以个数为9 * 9 = 81。可能有人问，为什么只在后面插，不在前面插，这是因为会重复，
     * <p>
     * 比如1后插2等于2前面插1。而在1前面插0就不是两位数了，已经算在了个位数里。
     * <p>
     * <p>
     * 转移方程:dp[i] = dp[i-1]*(11-i);
     */
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 1;
        }
        dp[0] = 1;
        dp[1] = 9;
        int sum = dp[0] + dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * (11 - i);
            sum += dp[i];
        }

        return sum;
    }

    /**
     * 365. 水壶问题
     * <p>
     * 深度优先遍历算法 ，首先要找到所有坑你的状态变化
     */
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        Deque<int[]> stack = new LinkedList<>();
        stack.push(new int[]{0, 0});
        /*记录已经计算过的状态，防止出现环，减少计算量*/
        Set<Long> seen = new HashSet<>();
        while (!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            assert stack.peek() != null;
            seen.add(hash(stack.peek()));

            int[] state = stack.pop();
            int remainX = state[0], remainY = state[1];
            if (remainX == targetCapacity || remainY == targetCapacity || remainX + remainY == targetCapacity) {
                return true;
            }
            // 把 X 壶灌满。
            stack.push(new int[]{jug1Capacity, remainY});
            // 把 Y 壶灌满。
            stack.push(new int[]{remainX, jug2Capacity});
            // 把 X 壶倒空。
            stack.push(new int[]{0, remainY});
            // 把 Y 壶倒空。
            stack.push(new int[]{remainX, 0});
            // 把 X 壶的水灌进 Y 壶，直至灌满或倒空。
            stack.push(new int[]{remainX - Math.min(remainX, jug2Capacity - remainY), remainY + Math.min(remainX, jug2Capacity - remainY)});
            // 把 Y 壶的水灌进 X 壶，直至灌满或倒空。
            stack.push(new int[]{remainX + Math.min(remainY, jug1Capacity - remainX), remainY - Math.min(remainY, jug1Capacity - remainX)});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }

    /**
     * 368. 最大整除子集
     *
     * 算法思路：动态规划
     *
     * 状态转移方程：枚举 j = 0…i−1 的所有整数 nums[j]，如果 nums[j] 能整除 nums[i]，
     *
     *说明 nums[i] 可以扩充在以 nums[j] 为最大整数的整除子集里成为一个更大的整除子集。
     *
     * 其中 dp[i] 表示在输入数组 nums 升序排列的前提下，以 nums[i] 为最大整数的「整除子集」的大小（在这种定义下nums[i] 必须被选择）。
     *
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        /*第一步：动态规划找出最大子集的个数，最大子集中的最大整数*/
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        /*第二步：倒推获得最大子集*/
        List<Integer> res = new ArrayList<>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root ==null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
          if(stack.peek().val == val){
              return stack.pop();
          }else {
              TreeNode node = stack.pop();
              if(node.left != null){
                  stack.add(node.left);
              }
              if(node.right != null){
                  stack.add(node.right);
              }
          }
        }
        return null;
    }


}
