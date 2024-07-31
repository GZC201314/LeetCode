package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.gzc.leetcode.model.UnionFind;

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
            case 978:
                log.info(String.valueOf(maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9})));
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
            case 974:
                log.info(String.valueOf(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5)));
                break;
            case 322:
                log.info(String.valueOf(coinChange(new int[]{1, 2, 5}, 11)));
                break;
            case 491:
                log.info(String.valueOf(findSubsequences(new int[]{4, 6, 7, 7})));
                break;
            case 1888:
                log.info(String.valueOf(minFlips("111000")));
                break;
            case 3039:
                log.info(lastNonEmptyString("abcd"));
                break;
            case 884:
                log.info(Arrays.toString(uncommonFromSentences("abcd", "abc d")));
                break;
            case 3112:
                log.info(Arrays.toString(minimumTime(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {0, 2, 4}}, new int[]{1, 1, 5})));
                break;
            case 2998:
                log.info(String.valueOf(minimumOperationsToMakeEqual(1, 18)));
                break;
            case 1006:
                log.info(String.valueOf(clumsy(10)));
                break;
            case 721:
                log.info(Arrays.deepToString(new List[]{accountsMerge(new ArrayList<>(Arrays.asList(
                        new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")),
                        new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")),
                        new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")))))}));
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
            map.put(needSum, map.getOrDefault(needSum, 0) + 1);
        }
        return ans;
    }

    /**
     * 1006. 笨阶乘
     */
    public static int clumsy(int n) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> optStack = new LinkedList<>();
        optStack.push('#');
        char[] opts = {'*', '/', '+', '-'};
        for (int i = n; i > 0; i--) {
            numStack.push(i);
            assert !optStack.isEmpty();
            char opt1 = optStack.peek();
            char opt2 = opts[(n - i) % 4];
            while (checkPriority(opt1, opt2)) {
                opt1 = optStack.pop();
                cal(numStack, opt1);
                assert !optStack.isEmpty();
                opt1 = optStack.peek();
            }
            if (i > 1) {
                optStack.push(opt2);
            }
        }
        while (optStack.size() > 1) {
            char opt = optStack.pop();
            cal(numStack, opt);
        }
        return numStack.pop();

    }

    private static void cal(Deque<Integer> numStack, char opt1) {
        Integer num2 = numStack.pop();
        Integer num1 = numStack.pop();
        switch (opt1) {
            case '*':
                numStack.push(num1 * num2);
                break;
            case '/':
                numStack.push(num1 / num2);
                break;
            case '+':
                numStack.push(num1 + num2);
                break;
            case '-':
                numStack.push(num1 - num2);
                break;
            default:
                break;
        }
    }

    private static boolean checkPriority(char opt1, char opt2) {
        int optNum1 = 0;
        int optNum2 = 0;
        if (opt1 == '*' || opt1 == '/') {
            optNum1 = 2;
        }
        if (opt1 == '+' || opt1 == '-') {
            optNum1 = 1;
        }
        if (opt2 == '*' || opt2 == '/') {
            optNum2 = 2;
        }
        if (opt2 == '+' || opt2 == '-') {
            optNum2 = 1;
        }
        return optNum1 >= optNum2;
    }

    /**
     * 978. 最长湍流子数组
     */
    public static int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int ans = 1;
        // 9,4,2,10,7,8,8,1,9
        int[][] dp = new int[n][2];
        // dp[i][0] 表示以 i 结尾的最后小于的湍流最大个数
        // dp[i][1] 表示以 i 结尾的最后大于的湍流最大个数
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
                ans = Math.max(ans, dp[i][0]);
            } else if (arr[i] < arr[i - 1]) {
                dp[i][0] = 1;
                dp[i][1] = dp[i - 1][0] + 1;
                ans = Math.max(ans, dp[i][1]);
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
        }
        return ans;
    }

    /**
     * 974. 和可被 K 整除的子数组
     */
    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int preSum = 0;
        int ans = 0;
        for (int elem : nums) {
            preSum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (preSum % k + k) % k;
            int same = count.getOrDefault(modulus, 0);
            ans += same;
            count.put(modulus, same + 1);
        }
        return ans;
    }

    /**
     * 721. 账户合并
     */
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 获取所有的邮箱，以及邮箱和用户对应的映射
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToIndex = new HashMap<>();
        int emailIndex = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String firstMail = account.get(i);
                if (!emailToIndex.containsKey(firstMail)) {
                    emailToIndex.put(firstMail, emailIndex++);
                    emailToName.put(firstMail, name);
                }
            }
        }
        // 构建并查集
        UnionFind unionFind = new UnionFind(emailIndex);
        for (List<String> account : accounts) {
            String firstMail = account.get(1);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                unionFind.union(emailToIndex.get(firstMail), emailToIndex.get(account.get(i)), 1);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        emailToIndex.keySet().forEach(email -> {
            int index = unionFind.find(emailToIndex.get(email));
            List<String> emails = indexToEmails.getOrDefault(index, new ArrayList<>());
            emails.add(email);
            indexToEmails.put(index, emails);
        });
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> emils : indexToEmails.entrySet()) {
            List<String> emailArr = emils.getValue();
            Collections.sort(emailArr);
            List<String> ansItem = new ArrayList<>();
            ansItem.add(emailToName.get(emailArr.get(0)));
            ansItem.addAll(emailArr);
            ans.add(ansItem);
        }
        return ans;

    }

    /**
     * 884.两句话中的不常见单词
     */
    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");
        List<String> ans = new LinkedList<>();
        Set<String> count1Set = new HashSet<>();
        Set<String> count2Set = new HashSet<>();
        Set<String> str1Set = new HashSet<>();
        Set<String> str2Set = new HashSet<>();
        for (String s : s1Arr) {
            if (!str1Set.add(s)) {
                count1Set.remove(s);
            } else {
                count1Set.add(s);
            }
        }
        for (String s : s2Arr) {
            if (!str2Set.add(s)) {
                count2Set.remove(s);
            } else {
                count2Set.add(s);
            }
        }
        for (String s : count1Set) {
            if (!str2Set.contains(s)) {
                ans.add(s);
            }
        }
        for (String s : count2Set) {
            if (!str1Set.contains(s)) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[0]);
    }

    /**
     * 3112.访问消失节点的最少时间
     */
    public static int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int length = edge[2];
            adj[u].add(new int[]{v, length});
            adj[v].add(new int[]{u, length});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int t = arr[0];
            int u = arr[1];
            if (t != answer[u]) {
                continue;
            }
            for (int[] next : adj[u]) {
                int v = next[0];
                int length = next[1];
                if (t + length < disappear[v] && (answer[v] == -1 || t + length < answer[v])) {
                    pq.offer(new int[]{t + length, v});
                    answer[v] = t + length;
                }
            }
        }
        return answer;
    }

    // 定义全局变量保存结果
    private static List<List<Integer>> res = new ArrayList<>();

    /**
     * 491. 非递减子序列
     */
    public static List<List<Integer>> findSubsequences(int[] nums) {
        // idx 初始化为 -1，开始 dfs 搜索。
        dfsFindSubsequences(nums, -1, new ArrayList<>());
        return res;
    }

    private static void dfsFindSubsequences(int[] nums, int idx, List<Integer> curList) {
        // 只要当前的递增序列长度大于 1，就加入到结果 res 中，然后继续搜索递增序列的下一个值。
        if (curList.size() > 1) {
            res.add(new ArrayList<>(curList));
        }

        // 在 [idx + 1, nums.length - 1] 范围内遍历搜索递增序列的下一个值。
        // 借助 set 对 [idx + 1, nums.length - 1] 范围内的数去重。
        Set<Integer> set = new HashSet<>();
        for (int i = idx + 1; i < nums.length; i++) {
            // 1. 如果 set 中已经有与 nums[i] 相同的值了，说明加上 nums[i] 后的所有可能的递增序列之前已经被搜过一遍了，因此停止继续搜索。
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            // 2. 如果 nums[i] >= nums[idx] 的话，说明出现了新的递增序列，因此继续 dfs 搜索（因为 curList 在这里是复用的，因此别忘了 remove 哦）
            if (idx == -1 || nums[i] >= nums[idx]) {
                curList.add(nums[i]);
                dfsFindSubsequences(nums, i, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }

    /**
     * 1888. 使二进制字符串字符交替的最少反转次数
     */
    public static int minFlips(String s) {
        int len = s.length();
        boolean isEven = (len % 2 == 1);
        // 不进行类型1操作，直接进行类型2操作，以0开头需要的最小次数
        int head0 = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    head0++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    head0++;
                }
            }
        }
        // 以0开头的操作和以1开头的操作是互斥的
        int head1 = len - head0;
        int ans = Math.min(head0, head1);
        // 进行移位操作
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                int subLen = head0 - 1;
                if (!isEven) {
                    subLen++;
                }
                head1 = subLen;
                head0 = len - head1;
            } else {
                if (isEven) {
                    head1 = head0 + 1;
                    head0 = len - head1;
                }
            }
            ans = Math.min(ans, Math.min(head0, head1));
        }
        return ans;
    }

}
