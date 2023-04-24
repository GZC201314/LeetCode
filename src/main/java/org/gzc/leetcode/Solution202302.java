package org.gzc.leetcode;

import org.gzc.leetcode.model.AuthenticationManager;
import org.gzc.leetcode.model.TreeNode;

import java.text.ParseException;
import java.util.*;

/**
 * @author GZC
 */
public class Solution202302 {


    /**
     * 1026.节点与其祖先之间的最大差值
     */
    public static int maxAncestorDiffAns = 0;
    public static Map<TreeNode, int[]> cache = new HashMap<>();

    /**
     * 802. 迷路的机器人
     */

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 1797:
                AuthenticationManager authenticationManager = new AuthenticationManager(10);
                authenticationManager.generate("aaa", 10);
                authenticationManager.renew("bbb", 12);
                System.out.println(authenticationManager.countUnexpiredTokens(12));
                break;
            case 1604:
                System.out.println(alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}));
                break;
            case 1233:
                System.out.println(removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
                break;
            case 1234:
                System.out.println(balancedString("QWER"));
                break;
            case 2351:
                System.out.println(repeatedCharacter("QWER"));
                break;
            case 1124:
                System.out.println(longestwpi(new int[]{9, 9, 6, 0, 6, 6, 9}));
                break;
            case 1491:
                System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
                break;
            case 68:
                System.out.println(searchInsert(new int[]{1000, 3000, 4000, 5000}, 3000));
                break;
            case 1139:
                System.out.println(largest1BorderedSquare(new int[][]{{0, 1, 1, 1, 1, 0}, {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}}));
                break;
            case 1901:
                System.out.println(Arrays.toString(findPeakGrid(new int[][]{{1, 4}, {3, 2}})));
                break;
            case 2373:
                System.out.println(Arrays.toString(largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}})));
                break;
            case 47:
                System.out.println(maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
                break;
            case 1792:
                System.out.println(maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {1, 1}}, 4));
                break;
            case 1615:
                System.out.println(maximalNetworkRank(4, new int[][]{{1, 2}, {0, 1}, {1, 3}}));
                break;
            case 1637:
                System.out.println(maxWidthOfVerticalArea(new int[][]{{1, 2}, {0, 1}, {1, 3}}));
                break;
            case 2363:
                System.out.println(mergeSimilarItems(new int[][]{{1, 2}, {3, 5}, {1, 1}}, new int[][]{{1, 2}, {3, 5}, {1, 1}}));
                break;
            case 2341:
                System.out.println(Arrays.toString(numberOfPairs(new int[]{9, 9, 6, 0, 6, 6, 9})));
                break;
            case 1140:
                System.out.println(stoneGame2(new int[]{9, 9, 6, 0, 6, 6, 9}));
                break;
            case 2357:
                System.out.println(minimumOperations(new int[]{9, 9, 6, 0, 6, 6, 9}));
                break;
            case 1144:
                System.out.println(movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
                break;
            case 2455:
                System.out.println(averageValue(new int[]{9, 6, 1, 6, 2}));
                break;
            case 1238:
                System.out.println(circularPermutation(2, 3));
                break;
            case 1247:
                System.out.println(minimumSwap("xxxx", "yyyy"));
                break;
            case 1689:
                System.out.println(minPartitions("128"));
                break;
            case 1641:
                System.out.println(countVowelStrings(23));
                break;
            case 2469:
                System.out.println(Arrays.toString(convertTemperature(0.0)));
                break;
            case 1653:
                System.out.println(minimumDeletions("aababbab"));
                break;
            case 1638:
                System.out.println(countSubstrings("aba", "baba"));
                break;
            case 2451:
                System.out.println(oddString(new String[]{"aaa", "bob", "ccc", "ddd"}));
                break;
            case 2452:
                System.out.println(twoEditWords(new String[]{"aaa", "bob", "ccc", "ddd"}, new String[]{"aaa", "bob", "ccc", "ddd"}));
                break;
            case 2347:
                System.out.println(bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}));
                break;
            case 70:
                System.out.println(singleNonDuplicate(new int[]{1, 2, 2, 3, 3, 4, 4}));
                break;
            case 2501:
                System.out.println(longestSquareStreak(new int[]{57044, 68879, 916, 16512, 34776, 77929, 95685, 68153, 53877, 68617, 61264, 9172, 95471, 86374, 25292, 29948, 43434, 72108, 18536, 31149, 4871, 98887, 89004, 24718, 78079, 7433, 17954, 87036, 61732, 92976, 75756, 22963, 41305, 86318, 2642, 85551, 41664, 47274, 30273, 13649, 62700, 18784, 86619, 67061, 7742, 61448, 83406, 17828, 16384, 70815, 8431, 57596, 68118, 36095, 93523, 69623, 4603, 17368, 15193, 95191, 10133, 62694, 43974, 79584, 75489, 12104, 29073, 62700, 24320, 12330, 66491, 49740, 73184, 62854, 11648, 18196, 2475, 16624, 95444, 3745, 18076, 34719, 92759, 17190, 42969, 59774, 83083, 88130, 45304, 77588, 20928, 74712, 96631, 22665, 28183, 59984, 3663, 83781, 11902, 48445, 58424, 25315, 12874, 3960, 74187, 66127, 99769, 30927, 64001, 39377, 90658, 32484, 56058, 92466, 38484, 31137, 4672, 28168, 7825, 82423, 63338, 1065, 88473, 64371, 1414, 87734, 30799, 44383, 9626, 23589, 27125, 41538, 67024, 11753, 43086, 83809, 89273, 51545, 34671, 97600, 97124, 56601, 43953, 3426, 87357, 93958, 78617, 40820, 79406, 35356, 22773, 22331, 824, 13335, 87491, 45952, 64051, 4422, 32732, 54810, 58319, 80257, 8457, 38567, 23825, 90986, 53332, 80829, 42630, 84703, 92059, 71706, 82859, 10932, 44526, 75366, 94556, 63508, 97168, 93738, 50132, 97203, 37589, 25247, 91722, 78975, 46174, 18243, 31035, 35123, 68799, 90306, 37986, 54070, 74776, 81358, 68775, 58324, 89562, 2414, 25662, 89651, 32724, 1513, 7956, 99662, 43491, 87221, 78281, 18532, 85654, 27844, 94960, 12323, 69262, 77316, 1529, 96345, 54224, 31667, 11341, 74926, 81639, 22016, 15435, 21043, 75240, 44041, 41995, 63145, 31152, 11839, 44851, 41044, 25249, 85228, 32416, 19363, 59340, 92682, 8985, 34620, 19582, 34092, 44460, 75180, 30065, 87239, 82190, 65554, 21533, 17823, 4942, 74283, 85615, 98013, 77917, 91595, 13003, 47974, 71578, 90978, 85115, 90662, 24566, 94919, 12402, 16684, 367, 10186, 57090, 61947, 22330, 35424, 17835, 43363, 67607, 78103, 97290, 95214, 27559, 31675, 64594, 66189, 51482, 13368, 32055, 19302, 27842, 38091, 57168, 23314, 83867, 54887, 14179, 6793, 49643, 53522, 27599, 3919, 98308, 98405, 22269, 61504, 79522, 40657, 49053, 4709, 67769, 39429, 48828, 88834, 42535, 76393, 48147, 65246, 80079, 76512, 89293, 71234, 26528, 11235, 35342, 30643, 64679, 69718, 5338, 13441, 76133, 63183, 18984, 12510, 33658, 13884, 41050, 87905, 92799, 2178, 98761, 40606, 2992, 1268, 12352, 58325, 12272, 92713, 86555, 60458, 28896, 57882, 53824, 34237, 64917, 37947, 75421, 37784, 17352, 23495, 91134, 13002, 65928, 4803, 50925, 24483, 11272, 48590, 52836, 56399, 95390, 432, 58075, 338, 45148, 17047, 53132, 69305, 47917, 90444, 5875, 17277, 2599, 25016, 6913, 56469, 117, 4518, 1307, 53562, 53695, 50005, 80637, 19761, 99481, 48576, 41048, 7177, 74176, 99343, 97723, 16457, 80681, 12056, 3061, 89095, 82260, 58852, 33805, 20558, 45657, 18304, 269, 92630, 31192, 70905, 34505, 9195, 50200, 22082, 86326, 84806, 10492, 21917, 22761, 51636, 16320, 25925, 734, 45335, 8484, 25408, 92021, 17450, 93908, 85683, 29532, 58415, 37662, 24807, 32884, 30182, 46622, 90526, 23834, 25559, 93765, 91897, 92480, 77494, 10466, 91615, 1590, 68506, 57006, 88513, 89690, 86031, 78750, 10850, 98067, 78566, 64908, 36917, 96062, 62095, 40617, 71781, 77510, 76861, 64928, 73193, 76345, 97029, 89582, 37404, 95317, 80838, 52635, 54712, 65883, 18915, 83082, 70082, 17831, 73698, 8090, 42519, 48205, 12009, 59619, 1221, 1116, 26697, 47161, 39833, 37243, 24516, 68473, 88943, 53000, 34773, 6454, 19789, 92058, 94593, 32766, 82773, 7813, 58033, 13743, 81611, 53608, 77347, 18364, 38883, 14679, 67834, 27212, 45934, 55974, 37008, 65727, 53404, 83997, 72637, 44819, 57724, 54750, 72299, 67644, 28697, 45606, 19158, 39657, 78544, 25012, 97326, 65304, 95602, 8953, 82400, 31410, 7022, 64694, 15879, 49639, 52297, 99627, 90946, 58074, 8175, 39406, 34826, 31611, 95607, 54453, 28082, 53560, 19953, 41960, 99635, 23739, 83406, 89066, 46353, 43071, 52314, 61442, 83833, 67954, 42243, 28914, 97086, 58479, 90326, 3534, 73113, 20060, 69851, 92884, 66750, 4401, 70560, 50120, 96706, 59154, 4340, 92146, 88127, 65807, 71681, 22122, 22497, 66145, 55604, 85965, 38885, 66467, 21991, 78039, 29510, 41360, 3191, 2104, 10791, 73824, 7699, 80362, 27776, 51333, 2840, 56324, 48469, 3979, 49613, 44485, 82002, 40133}));
                break;
            case 2605:
                System.out.println(minNumber(new int[]{1, 2, 2, 3, 3, 4, 4}, new int[]{1, 2, 2, 3, 3, 4, 4}));
                break;
            case 1043:
                System.out.println(maxSumAfterPartitioning(new int[]{1, 2, 2, 3, 3, 4, 4}, 3));
                break;
            case 1026:
                System.out.println(maxAncestorDiff(new TreeNode(3)));
                break;
            case 2383:
                System.out.println(minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
                break;
            case 1605:
                System.out.println(Arrays.deepToString(restoreMatrix(new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1})));
                break;
            default:
                break;
        }
    }

    /**
     * 2501. 数组中最长的方波
     */
    public static int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Set<Long> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add((long) num);
        }
        int ans = 0;
        for (int num : nums) {
            // 以这个为开头的最大序列
            long cur = num;
            int curCount = 0;
            while (numSet.contains(cur)) {
                curCount++;
                cur = cur * cur;
            }
            ans = Math.max(ans, curCount);

        }
        return ans == 1 ? -1 : ans;
    }

    /**
     * 2605.从两个数字数组里生成最小数字
     */
    public static int minNumber(int[] nums1, int[] nums2) {
        TreeSet<Integer> num1Set = new TreeSet<>();
        for (int num1 : nums1) {
            num1Set.add(num1);
        }
        TreeSet<Integer> num2Set = new TreeSet<>();
        for (int num2 : nums2) {
            num2Set.add(num2);
        }
        for (Integer integer : num1Set) {
            if (num2Set.contains(integer)) {
                return integer;
            }
        }
        int num1 = num1Set.pollFirst();
        int num2 = num2Set.pollFirst();
        if (num1 > num2) {
            return num2 * 10 + num1;
        } else {
            return num1 * 10 + num2;
        }


    }

    /**
     * 1043. 分隔数组以得到最大和
     */

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < k; i++) {
            dp[i] = arr[i] > dp[i - 1] / i ? arr[i] * (i + 1) : dp[i - 1] / i * (i + 1);
        }
        for (int i = k; i < arr.length; i++) {
            int max = arr[i];
            for (int j = i; j > i - k; j--) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], dp[j - 1] + max * (i - j + 1));
            }
        }
        return dp[arr.length - 1];
    }

    public static int maxAncestorDiff(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.pollFirst();
            if (treeNode.left != null) {
                deque.add(treeNode.left);
                maxAncestorDiffAns = Math.max(Math.max(maxAncestorDiffAns, Math.abs(treeNode.val - maxAncestorDiffDfs(treeNode.left)[0])), Math.abs(treeNode.val - maxAncestorDiffDfs(treeNode.left)[1]));
            }
            if (treeNode.right != null) {
                deque.add(treeNode.right);
                maxAncestorDiffAns = Math.max(Math.max(maxAncestorDiffAns, Math.abs(treeNode.val - maxAncestorDiffDfs(treeNode.right)[0])), Math.abs(treeNode.val - maxAncestorDiffDfs(treeNode.right)[1]));

            }
        }
        return maxAncestorDiffAns;

    }

    // 返回当前树的最大值和最小值
    public static int[] maxAncestorDiffDfs(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        if (node.left == null && node.right == null) {
            cache.put(node, new int[]{node.val, node.val});
            return new int[]{node.val, node.val};
        }
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        int[] leftMinMax = maxAncestorDiffDfs(node.left);
        int[] rightMinMax = maxAncestorDiffDfs(node.right);

        int min = Math.min(Math.min(node.val, leftMinMax[1]), rightMinMax[1]);
        int max = Math.max(Math.max(node.val, leftMinMax[0]), rightMinMax[0]);

        cache.put(node, new int[]{max, min});
        return new int[]{max, min};
    }

    /**
     * 2452. 距离字典两次编辑以内的单词
     */
    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String query : queries) {
            for (String s : dictionary) {
                int diffCount = 0;
                int length = s.length();
                for (int i = 0; i < length; i++) {
                    if (query.charAt(i) != s.charAt(i)) {
                        diffCount++;
                    }
                }
                if (diffCount <= 2) {
                    ans.add(query);
                }
            }
        }
        return ans;

    }

    /**
     * 1637. 两点之间不包含任何点的最宽垂直区域
     */
    public static int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        List<int[]> list = new ArrayList<>(Arrays.asList(points));
        list.sort(Comparator.comparingInt(o -> o[0]));
        int[] pre = list.get(0);
        int max = 0;
        for (int i = 1; i < n; i++) {
            int[] point = list.get(i);
            max = Math.max(max, point[0] - pre[0]);
            pre = point;
        }
        return max;
    }

    /**
     * 1641. 统计字典序元音字符串的数目
     */
    public static int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][2] = dp[i][1] + dp[i - 1][2];
            dp[i][3] = dp[i][2] + dp[i - 1][3];
            dp[i][4] = dp[i][3] + dp[i - 1][4];
        }

        return Arrays.stream(dp[n]).sum();
    }

    /**
     * 剑指 Offer II 070 排序数组中只出现一次的数字
     */
    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        int mid = (right - left) / 2 + left;
        while (left < right) {
            // 三种情况 中间元素和前一个元素相同，中间元素和后一个相同，中间元素和前后两个元素都不同
            if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];

            }
            mid = (right - left) / 2 + left;
        }
        return nums[mid];
    }

    /**
     * 1638. 统计只差一个字符的子串数目
     */
    public static int countSubstrings(String s, String t) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        int sLen = s.length();
        int tLen = t.length();
        for (int i = 0; i < sLen; i++) {
            for (int j = i + 1; j <= sLen; j++) {
                String sSub = s.substring(i, j);
                if (map.containsKey(sSub)) {
                    ans += map.get(sSub);
                } else {
                    int count = 0;
                    for (int k = 0; k <= tLen - sSub.length(); k++) {
                        String tSub = t.substring(k, k + sSub.length());
                        if (diffCount(sSub, tSub) == 1) {
                            count++;
                        }
                    }
                    ans += count;
                    map.put(sSub, count);
                }
            }
        }
        return ans;

    }

    public static int diffCount(String s, String t) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 2469. 温度转换
     */

    public static double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.8 + 32};
    }

    /**
     * 2455. 可被三整除的偶数的平均值
     */
    public static int averageValue(int[] nums) {
        long sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        return count == 0 ? 0 : (int) sum / count;

    }

    /**
     * 剑指 Offer II 068查找插入位置
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
            mid = left + (right - left) / 2;
        }
        return mid;
    }

    /**
     * 1615.最大网络秩
     */
    public static int maximalNetworkRank(int n, int[][] roads) {
        int[] ans = new int[n];
        int max = 0;
        boolean[][] conn = new boolean[n][n];
        for (int[] road : roads) {
            ans[road[0]]++;
            ans[road[1]]++;
            conn[road[0]][road[1]] = true;
            conn[road[1]][road[0]] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, ans[i] + ans[j] - (conn[i][j] ? 1 : 0));
            }
        }

        return max;
    }

    /**
     * 1605. 给定行和列的和求可行矩阵
     */
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            ans[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= ans[i][j];
            colSum[j] -= ans[i][j];
            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }
        }
        return ans;
    }

    /**
     * 2383. 赢得比赛需要的最少训练时长
     */
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int needEnergy = 0;
        int needExperience = 0;
        int n = energy.length;
        for (int i = 0; i < n; i++) {
            if (initialEnergy > energy[i]) {
                initialEnergy -= energy[i];
            } else {
                needEnergy += energy[i] - initialEnergy + 1;
                initialEnergy = 1;
            }
            if (initialExperience > experience[i]) {
                initialExperience += experience[i];
            } else {
                needExperience += experience[i] - initialExperience + 1;
                initialExperience += experience[i] + (experience[i] - initialExperience + 1);
            }
        }
        return needExperience + needEnergy;
    }

    /**
     * 剑指 Offer 47. 礼物的最大价值
     */
    public static int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 2451. 差值数组不同的字符串
     */
    public static String oddString(String[] words) {

        int n = words[0].length();
        int m = words.length;
        for (int i = 0; i < n - 1; i++) {
            int diff = words[0].charAt(i + 1) - words[0].charAt(i);
            for (int j = 0; j < m; j++) {
                int curDiff = words[j].charAt(i + 1) - words[j].charAt(i);
                if (curDiff != diff) {
                    if (j == 1) {
                        // 判断第一个和第三个是不是一致
                        for (int k = 0; k < n - 1; k++) {
                            if (words[2].charAt(k + 1) - words[2].charAt(k) != words[0].charAt(k + 1) - words[0].charAt(k)) {
                                return words[0];
                            }
                        }
                    }
                    return words[j];
                }
            }
        }
        return "";

    }


    /**
     * 1653. 使字符串平衡的最少删除次数
     */
    public static int minimumDeletions(String s) {
        int dp = 0, bNum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                ++bNum;
            } else {
                dp = Math.min(dp + 1, bNum);
            }
        }
        return dp;
    }

    /**
     * 2373. 矩阵中的局部最大值
     */
    public static int[][] largestLocal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - 2][n - 2];
        //把首个矩阵放到最大堆

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                ans[i - 1][j - 1] = Math.max(grid[i - 1][j - 1], Math.max(grid[i - 1][j], Math.max(grid[i - 1][j + 1], Math.max(grid[i][j - 1], Math.max(grid[i][j], Math.max(grid[i][j + 1], Math.max(grid[i + 1][j - 1], Math.max(grid[i + 1][j], grid[i + 1][j + 1]))))))));
            }
        }
        return ans;

    }


    /**
     * 2363. 合并相似的物品
     */
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            List<Integer> list = new ArrayList<>();
            list.add(key);
            list.add(map.get(key));
            ans.add(list);
        }
        ans.sort(Comparator.comparingInt(t -> t.get(0)));
        return ans;
    }


    /**
     * 1144. 递减元素使数组呈锯齿状
     */
    public static int movesToMakeZigzag(int[] nums) {
        return Math.min(help(nums, 0), help(nums, 1));
    }

    public static int help(int[] nums, int pos) {
        int res = 0;
        for (int i = pos; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0) {
                a = Math.max(a, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                a = Math.max(a, nums[i] - nums[i + 1] + 1);
            }
            res += a;
        }
        return res;
    }

    /**
     * 1689. 十-二进制数的最少数目
     */
    public static int minPartitions(String n) {
        char[] nChar = n.toCharArray();
        char max = '0';
        for (char c : nChar) {
            if (c > max) {
                max = c;
            }
        }
        return Integer.parseInt(String.valueOf(max));
    }

    /**
     * 1247. 交换字符使得字符串相同
     */
    public static int minimumSwap(String s1, String s2) {
        int[] cnt = new int[2];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);
            if (s1Char != s2Char) {
                cnt[s1Char % 2]++;
            }
        }
        int sum = Arrays.stream(cnt).sum();
        return sum % 2 != 0 ? -1 : (sum / 2 + cnt[0] % 2);
    }

    /**
     * 2357. 使数组中所有元素都等于零
     */
    public static int minimumOperations(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }

    /**
     * 1238.循环码排列
     * 格雷码生成公式 i ^ (i >>1)
     */
    public static List<Integer> circularPermutation(int n, int start) {
        int len = (int) Math.pow(2, n), j = 0;
        int[] grey = new int[len];
        for (int i = 0; i < len; i++) {
            grey[i] = i ^ (i >> 1);
            if (grey[i] == start) {
                j = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = j; i < len + j; i++) {
            ans.add(grey[i % len]);
        }
        return ans;
    }

    /**
     * 1140. 石子游戏||
     * <p>
     * dp[i][j]表示剩余[i : len - 1]堆时，M = j的情况下，先取的人能获得的最多石子数
     */
    public static int stoneGame2(int[] piles) {
        int len = piles.length, sum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int m = 1; m <= len; m++) {
                if (i + 2 * m >= len) {
                    dp[i][m] = sum;
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

    /**
     * 1901. 寻找峰值||
     */
    public static int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int l = -1, r = m;
        while (l + 1 < r) {
            int cRow = l + (r - l) / 2;
            int maxCol = findMaxIdx(mat[cRow]);
            if (cRow == m - 1 || mat[cRow][maxCol] > mat[cRow + 1][maxCol]) {
                r = cRow;
            } else {
                l = cRow;
            }
        }
        int j = findMaxIdx(mat[r]);
        return new int[]{r, j};
    }

    private static int findMaxIdx(int[] row) {
        int n = row.length;
        int max = 0, maxIdx = -1;
        for (int i = 0; i < n; i++) {
            if (row[i] > max) {
                max = row[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    /**
     * 2347. 最好的扑克手牌
     */
    public static String bestHand(int[] ranks, char[] suits) {
        int[] count = new int[4];
        for (char suit : suits) {
            count[suit - 'a']++;
        }
        for (int i : count) {
            if (i == 5) {
                return "Flush";
            }
        }

        Map<Integer, Integer> map = new HashMap<>(16);
        for (int rank : ranks) {

            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }

        boolean three = false;
        boolean two = false;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() >= 3) {
                three = true;

            }
            if (entry.getValue() == 2) {
                two = true;

            }
        }
        if (three) {
            return "Three of a Kind";
        }
        if (two) {
            return "Pair";
        }
        return "High Card";
    }

    /**
     * 1792. 最大平均通过率
     */
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
        });
        for (int[] c : classes) {
            pq.offer(new int[]{c[0], c[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            assert arr != null;
            int pass = arr[0], total = arr[1];
            pq.offer(new int[]{pass + 1, total + 1});
        }

        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            assert arr != null;
            int pass = arr[0], total = arr[1];
            res += 1.0 * pass / total;
        }
        return res / classes.length;
    }

    /**
     * 1491.去掉最低工资和最高工资后的工资平均值
     */
    public static double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        for (int i : salary) {
            max = Math.max(i, max);
            min = Math.min(i, min);
            sum += i;
        }
        return (sum - min - max) / (salary.length - 2);
    }

    /**
     * 2351. 第一个出现两次的字母
     */
    public static char repeatedCharacter(String s) {

        char ans = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            if (!set.add(aChar)) {
                ans = aChar;
                break;
            }
        }
        return ans;
    }

    /**
     * 2341.数组能形成多少数对
     */
    public static int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
                ans[0]++;
            }
        }
        ans[1] = set.size();
        return ans;
    }

    /**
     * 1124. 表现良好的最长时间段
     */
    public static int longestwpi(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<>(64);
        int s = 0, res = 0;
        for (int i = 0; i < n; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(s - 1)) {
                    res = Math.max(res, i - map.get(s - 1));
                }
            }
            if (!map.containsKey(s)) {
                map.put(s, i);
            }
        }
        return res;
    }

    /**
     * 1234. 替换子串得到平衡字符串
     */
    public static int balancedString(String s) {
        // 使用数组来存储四个字符的出现次数（使用数组便于代码书写）
        int[] counts = new int[26];
        // 字符串长度
        int len = s.length();
        // n / 4
        int limit = len / 4;
        char ch;
        // 初始化不替换内容字符出现次数数组，即初始滑动窗口维护一个空串
        for (int i = 0; i < len; i++) {
            ch = s.charAt(i);
            counts[ch - 'A']++;
        }
        // 初始化滑动窗口左右指针，维护的子串是[left,right]的内容
        // 初始化子串为空，因此left=0，right=-1表示一个空子串
        int left = 0;
        int right = -1;
        // 最小替换子串长度，初始为整个字符串长度
        int minLength = len;
        // 滑动窗口
        while (left < len) {
            // 校验通过
            if (check(counts, limit)) {
                // 记录当前合法子串的长度并更新最小长度
                // 左指针右移，那么原本左指针指向的字符就变成不替换的内容，不替换内容多了一个字符，对应count数组中的值加1
                minLength = Math.min(minLength, right - left + 1);
                counts[s.charAt(left++) - 'A']++;
            } else if (right < len - 1) {
                // 当前子串不合法且右指针还没到头
                // 右指针右移，移动后的右指针指向的字符变成了子串的内容，不替换的内容少了一个字符，对应count数组中的值减1
                counts[s.charAt(++right) - 'A']--;
            } else {
                // 右指针到头，搜索结束
                break;
            }
        }
        return minLength;

    }

    /**
     * 校验函数，校验当前counts中四个字符的出现次数是否都小于等于limit；
     * 是返回true，否返回false
     */
    private static boolean check(int[] counts, int limit) {
        return counts['Q' - 'A'] <= limit && counts['W' - 'A'] <= limit && counts['E' - 'A'] <= limit && counts['R' - 'A'] <= limit;
    }

    /**
     * 1233. 删除子文件夹
     */
    public static List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        for (String s : folder) {

            boolean flag = true;
            for (String an : ans) {
                if (s.startsWith(an) && '/' == s.charAt(an.length())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(s);
            }
        }
        return ans;
    }

    /**
     * 1604. 警告一小时内使用相同员工卡大于等于三次的人
     */
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<>();
        Map<String, List<Integer>> mapSet = new HashMap<>(10);
        int length = keyName.length;
        for (int i = 0; i < length; i++) {
            if (mapSet.containsKey(keyName[i])) {
                String[] split = keyTime[i].split(":");
                int hour = Integer.parseInt(split[0]);
                int min = Integer.parseInt(split[1]);
                mapSet.get(keyName[i]).add(hour * 60 + min);
            } else {
                List<Integer> treeSet = new ArrayList<>();
                String[] split = keyTime[i].split(":");
                int hour = Integer.parseInt(split[0]);
                int min = Integer.parseInt(split[1]);
                treeSet.add(hour * 60 + min);
                mapSet.put(keyName[i], treeSet);
            }
        }
        Set<Map.Entry<String, List<Integer>>> entries1 = mapSet.entrySet();
        for (Map.Entry<String, List<Integer>> stringListEntry : entries1) {
            List<Integer> value = stringListEntry.getValue();
            int size = value.size();
            if (size < 3) {
                continue;
            }
            value.sort(Integer::compareTo);
            int left = 0;
            int right = 0;
            while (right < size) {
                if (value.get(right) - value.get(left) <= 60) {
                    right++;
                } else {
                    left++;
                }
                if (right - left >= 3) {
                    String key = stringListEntry.getKey();
                    ans.add(key);
                    break;
                }
            }


        }
        ans.sort(String::compareTo);
        return ans;
    }

    /**
     * 1139.最大的以 1 为边界的正方形
     */
    public static int largest1BorderedSquare(int[][] grid) {

        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] hang = new int[m][n];
        int[][] lie = new int[m][n];
        // 初始化横向数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (j >= 1) {
                        hang[i][j] = hang[i][j - 1] + 1;
                    } else {
                        hang[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1) {
                    if (j >= 1) {
                        lie[j][i] = lie[j - 1][i] + 1;
                    } else {
                        lie[j][i] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 向上找连续的1
                    int index = i;
                    int topOne = 0;
                    int leftOne = 0;
                    while (index >= 0) {
                        if (grid[index--][j] == 1) {
                            topOne++;
                        } else {
                            break;
                        }
                    }
                    index = j;
                    while (index >= 0) {
                        if (grid[i][index--] == 1) {
                            leftOne++;
                        } else {
                            break;
                        }
                    }
                    int min = Math.min(topOne, leftOne);
                    for (int k = min; k >= 0; k--) {

                        if (Math.min(hang[i - k + 1][j], lie[i][j - k + 1]) >= k) {
                            ans = Math.max(ans, k * k);
                            break;
                        }
                    }
                }
            }
        }

        return ans;
    }


}
