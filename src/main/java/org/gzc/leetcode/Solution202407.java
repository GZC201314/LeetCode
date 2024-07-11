package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.*;


/**
 * @author GZC
 */
@Slf4j
public class Solution202407 {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 673:
                log.info(String.valueOf(findnumberoflis(new int[]{1, 3, 5, 4, 7})));
                break;
            case 3033:
                log.info(Arrays.deepToString(modifiedMatrix(new int[][]{{1, 3, 5, 4, 7}})));
                break;
            case 3099:
                log.info(String.valueOf(sumOfTheDigitsOfHarshadNumber(18)));
                break;
            case 486:
                log.info(String.valueOf(predictTheWinner(new int[]{2, 4, 55, 6, 8})));
                break;
            case 1010:
                log.info(String.valueOf(numPairsDivisibleBy60(new int[]{174, 188, 377, 437, 54, 498, 455, 239, 183, 347, 59, 199, 52, 488, 147, 82})));
                break;
            case 494:
                log.info(String.valueOf(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)));
                break;
            case 1011:
                log.info(String.valueOf(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3)));
                break;
            case 322:
                log.info(String.valueOf(coinChange(new int[]{1, 2, 5}, 11)));
                break;
            case 3039:
                log.info(lastNonEmptyString("abcd"));
                break;
            case 2998:
                log.info(String.valueOf(minimumOperationsToMakeEqual(1, 18)));
                break;
            default:
                break;

        }


    }

    /**
     * 673.最长递增子序列的个数
     */
    public static int findnumberoflis(int[] nums) {
        int n = nums.length;
        int max = 0;
        int res = 0;
        //以i结尾的最长递增子序列的长度
        int[] dp = new int[n];
        //以i结尾的最长递增子序列的个数
        int[] number = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(number, 1);
        if (n < 1) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 == dp[i]) {
                        number[i] += number[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        number[i] = number[j];
                    }
                }
                max = Math.max(dp[i], max);
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                res += number[i];
            }
        }
        return res;
    }

    /**
     * 3099.哈沙德数
     */
    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int temp = x;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        assert sum != 0;
        if (x % sum == 0) {
            return sum;
        }
        return -1;
    }

    /**
     * 486. 预测赢家
     */
    public static boolean predictTheWinner(int[] nums) {

        // 1,5,2
        int[] max = dfsPredictTheWinner(nums, 0, nums.length - 1, true, new int[]{0, 0});
        return max[0] >= max[1];
    }

    private static int[] dfsPredictTheWinner(int[] nums, int start, int end, boolean p1First, int[] max) {
        if (p1First) {
            if (start == end) {
                return new int[]{nums[start] + max[0], max[1]};
            } else if (start == end - 1) {
                if (nums[start] > nums[end]) {
                    return new int[]{nums[start] + max[0], nums[end] + max[1]};
                } else {
                    return new int[]{nums[end] + max[0], nums[start] + max[1]};
                }
            } else {

                // 两种情况，选择左边和右边
                int[] right = dfsPredictTheWinner(nums, start, end - 1, false, new int[]{max[0] + nums[end], max[1]});
                int[] left = dfsPredictTheWinner(nums, start + 1, end, false, new int[]{max[0] + nums[start], max[1]});
                if (right[0] > left[0]) {
                    return right;
                } else if (right[0] == left[0]) {
                    if (right[1] > left[1]) {
                        return left;
                    } else {
                        return right;
                    }
                }
                return left;

            }
        } else {
            // 后手，需要绝对理性
            if (start == end) {
                return new int[]{max[0], max[1] + nums[start]};
            } else if (start == end - 1) {
                if (nums[start] <= nums[end]) {
                    return new int[]{nums[start] + max[0], nums[end] + max[1]};
                } else {
                    return new int[]{nums[end] + max[0], nums[start] + max[1]};
                }
            } else {
                // 两种情况，选择左边和右边
                int[] right = dfsPredictTheWinner(nums, start, end - 1, true, new int[]{max[0], max[1] + nums[end]});
                int[] left = dfsPredictTheWinner(nums, start + 1, end, true, new int[]{max[0], max[1] + nums[start]});

                if (right[0] > left[0]) {
                    return left;
                } else if (right[0] == left[0]) {
                    if (right[1] <= left[1]) {
                        return left;
                    } else {
                        return right;
                    }
                }
                return right;
            }
        }
    }


    /**
     * 494.目标和
     */
    public static int findTargetSumWays(int[] nums, int target) {
        int[] res = new int[1];
        dfsFindTargetSumWays(nums, target, 0, 0, res);
        return res[0];

    }

    public static void dfsFindTargetSumWays(int[] nums, int target, int index, int sum, int[] res) {
        if (index == nums.length) {
            if (sum == target) {
                res[0]++;
            }
            return;
        }
        dfsFindTargetSumWays(nums, target, index + 1, sum + nums[index], res);
        dfsFindTargetSumWays(nums, target, index + 1, sum - nums[index], res);
    }


    /**
     * 3033.修改矩阵
     */
    public static int[][] modifiedMatrix(int[][] matrix) {
        // 记录矩阵中-1的位置
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            List<int[]> indexs = new ArrayList<>();
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, matrix[j][i]);
                if (matrix[j][i] == -1) {
                    indexs.add(new int[]{j, i});
                }
            }
            if (!indexs.isEmpty()) {
                for (int[] index : indexs) {
                    matrix[index[0]][index[1]] = max;
                }
            }
        }
        return matrix;

    }


    /**
     * 322.零钱兑换
     */
    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            min = Math.min(min, coin);
        }
        dp[0] = 0;
        for (int i = min; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i) {
                    if (dp[i - coin] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    /**
     * 3039.进行操作使字符串为空
     */
    public static String lastNonEmptyString(String s) {
        int length = s.length();
        int[][] map = new int[26][2];
        int[] charArr = new int[26];
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            charArr[ch - 'a']++;
            map[ch - 'a'][0] = ch;
            map[ch - 'a'][1] = i;
        }
        // 获得个数最大的字符
        int max = 0;
        List<Character> maxChars = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (charArr[i] > max) {
                max = charArr[i];
                maxChars.clear();
                maxChars.add((char) (i + 'a'));
            } else if (charArr[i] == max) {
                maxChars.add((char) (i + 'a'));
            }
        }
        List<int[]> indexs = new ArrayList<>();
        for (Character maxChar : maxChars) {
            indexs.add(map[maxChar - 'a']);
        }
        indexs.sort(Comparator.comparingInt(o -> o[1]));
        StringBuilder sb = new StringBuilder();
        for (int[] index : indexs) {
            sb.append(s.charAt(index[1]));
        }
        return sb.toString();
    }

    /**
     * 2998.使 X 和 Y 相等的最少操作次数
     */
    public static int minimumOperationsToMakeEqual(int x, int y) {
        if (x == y) {
            return 0;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        int loop = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(x);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                assert cur != null;
                if (cur % 11 == 0) {
                    int newNum = cur / 11;
                    if (newNum == y) {
                        return loop + 1;
                    }
                    if (!visited.contains(newNum)) {
                        visited.add(newNum);
                        queue.offer(newNum);
                    }
                }
                if (cur % 5 == 0) {
                    int newNum = cur / 5;
                    if (newNum == y) {
                        return loop + 1;
                    }
                    if (!visited.contains(newNum)) {
                        visited.add(newNum);
                        queue.offer(newNum);
                    }
                }
                int newNum = cur - 1;
                if (newNum == y) {
                    return loop + 1;
                }
                if (!visited.contains(newNum)) {
                    queue.offer(newNum);
                    visited.add(newNum);
                }
                newNum = cur + 1;
                if (newNum == y) {
                    return loop + 1;
                }
                if (!visited.contains(newNum)) {
                    visited.add(newNum);
                    queue.offer(newNum);
                }
            }
            loop++;
        }
        return -1;
    }

    /**
     * 1011.在 D 天内送达包裹的能力
     */
    public static int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = (left + right) / 2;
            if (validShipWithinDays(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean validShipWithinDays(int[] weights, int days, int mid) {
        int curDay = 0;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > mid) {
                curDay++;
                sum = weight;
            } else {
                sum += weight;
            }
        }
        return curDay + 1 <= days;

    }

    /**
     * 1010. 总持续时间可被 60 整除的歌曲
     */
    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : time) {
            int count = map.getOrDefault(i % 60, 0);
            ans += count;
            int needSum = (60 - (i % 60)) % 60;
            map.put(needSum, map.getOrDefault(needSum,0) + 1);
        }
        return ans;
    }


}
