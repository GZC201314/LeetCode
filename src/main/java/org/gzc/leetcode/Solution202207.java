package org.gzc.leetcode;


import org.gzc.leetcode.model.ListNode;

import java.util.*;

/**
 * @author GZC
 */
public class Solution202207 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 390:
                System.out.println(Arrays.toString(shuffle(new int[]{12, 3, 4, 5, 6, 7, 8, 9}, 4)));
                break;
            case 6111:
                ListNode root = new ListNode(3,
                        new ListNode(0,
                                new ListNode(2,
                                        new ListNode(6,
                                                new ListNode(8,
                                                        new ListNode(1,
                                                                new ListNode(7,
                                                                        new ListNode(9,
                                                                                new ListNode(4,
                                                                                        new ListNode(2,
                                                                                                new ListNode(5,
                                                                                                        new ListNode(5,
                                                                                                                new ListNode(0)))))))))))));
                System.out.println(Arrays.deepToString(spiralMatrix(3, 5, root)));
                break;
            case 1200:
                List<List<Integer>> lists = minimumAbsDifference(new int[]{1, 2, 3, 4});
                System.out.println(lists);
                break;
            case 451:
                System.out.println(frequencySort("tree"));
                break;
            case 452:
                System.out.println(findMinArrowShots(new int[][]{{1, 2}}));
                break;
            case 454:
                System.out.println(fourSumCount(new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}));
                break;
            case 455:
                System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2}));
                break;
            case 456:
                System.out.println(find132pattern(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 10}));
                System.out.println(find132pattern1(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 10}));
                break;
            case 1217:
                System.out.println(minCostToMoveChips(new int[]{1, 2}));
                break;
            case 457:
                System.out.println(circularArrayLoop(new int[]{1, 2}));
                break;
            case 459:
                System.out.println(repeatedSubstringPattern("bb"));
                break;
            case 460:
                LFUCache lfuCache = new LFUCache(64);
                lfuCache.put(1,1);
                System.out.println(lfuCache.get(1));
                break;
            case 648:
                List<String> list = new ArrayList<>();
                System.out.println(replaceWords(list, " "));
                break;
            default:
                break;
        }

    }

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2 * n];
        int left = 0;
        int right = n;
        int index = 0;
        for (int i = 0; i < n; i++) {
            arr[index++] = nums[left++];
            arr[index++] = nums[right++];
        }
        return arr;

    }

    /**
     * 6111. 螺旋矩阵 IV
     */
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -1);
        }
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (head != null) {
            // 向右
            for (int i = left; i <= right; i++) {
                result[top][i] = head.val;
                head = head.next;
                if (head == null) {
                    return result;
                }
            }
            if (top < bottom) {
                top++;
            }

            // 向下
            for (int i = top; i <= bottom; i++) {
                result[i][right] = head.val;
                head = head.next;
                if (head == null) {
                    return result;
                }
            }
            if (left < right) {
                right--;
            }

            // 向左
            for (int i = right; i >= left; i--) {
                result[bottom][i] = head.val;
                head = head.next;
                if (head == null) {
                    return result;
                }
            }
            if (top < bottom) {
                bottom--;
            }
            // 向上
            for (int i = bottom; i >= top; i--) {
                result[i][left] = head.val;
                head = head.next;
                if (head == null) {
                    return result;
                }
            }
            if (left < right) {
                left++;
            }

        }
        return result;
    }

    /**
     * 1200. 最小绝对差
     */
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length - 2;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (min > arr[i + 1] - arr[i]) {
                result.clear();
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                result.add(list);
                min = arr[i + 1] - arr[i];

            } else if (min == arr[i + 1] - arr[i]) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                result.add(list);
            }
        }
        return result;
    }

    /**
     * 451. 根据字符出现频率排序
     */
    public static String frequencySort(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(charMap.entrySet());
        list.sort((Map.Entry<Character, Integer> en1, Map.Entry<Character, Integer> en2) -> en2.getValue() - en1.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> en1 : list) {
            int n = en1.getValue();
            for (int i = 0; i < n; i++) {
                sb.append(en1.getKey());
            }
        }
        return sb.toString();

    }

    /**
     * 452. 用最少数量的箭引爆气球
     */
    public static int findMinArrowShots(int[][] points) {

        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt((int[] point) -> point[1]));
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;

    }

    /**
     * 454. 四数相加2
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if (map.containsKey(-(num3 + num4))) {
                    count += map.get(-(num3 + num4));
                }
            }
        }
        return count;
    }

    /**
     * 455. 分发饼干
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLen = g.length;
        int sLen = s.length;
        int gIndex = 0;
        int sIndex = 0;
        int result = 0;
        while (gIndex < gLen && sIndex < sLen) {
            if (s[sIndex] >= g[gIndex]) {
                gIndex++;
                sIndex++;
                result++;
            } else {
                sIndex++;
            }
        }
        return result;

    }

    /**
     * 456. 132模式 超时 O(n^2)
     */
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            //查找左边的小于nums[i]的最小值
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (min > nums[j] && nums[j] < nums[i]) {
                    min = nums[j];
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (max < nums[j] && nums[j] < nums[i]) {
                    max = nums[j];
                }
            }
            if (max > min) {
                return true;
            }
        }
        return false;
    }

    /**
     * 456. 132模式
     */
    public static boolean find132pattern1(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }
        return false;
    }

    /**
     * 648. 单词替换
     */
    public static String replaceWords(List<String> dictionary, String sentence) {
        List<String> result = new ArrayList<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            String wordRoot = word;
            for (String dict : dictionary) {
                if (word.startsWith(dict)) {
                    if (dict.length() < wordRoot.length()) {
                        wordRoot = dict;
                    }
                }
            }
            result.add(wordRoot);
        }
        return String.join(" ", result);
    }

    /**
     * 1217. 玩筹码
     */
    public static int minCostToMoveChips(int[] position) {
        //移动到某个偶数的位置，所有奇数的个数和就是此时的代价
        int even = 0;
        int odd = 0;
        for (int pos : position) {
            if (pos % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }

    /**
     * 457. 环形数组是否存在循环
     */
    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 在nums[i] ==0 设置当前节点已经遍历过，而且没有生成环
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(nums, i);
            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    //循环的长度大于1 相遇的位置是环的起点
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    public static int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n; // 保证返回值在 [0,n) 中 }

    }

    /**
     * 459. 重复的子字符串
     */
    public static boolean repeatedSubstringPattern(String s) {
        HashSet<Integer> set = new HashSet<>();
        int len = s.length();
        for (int i = 1;i<=len/2;i++){
            if(len%i ==0){
                set.add(i);
            }
        }
        for (Integer integer : set) {
            int start =0;
            int end = integer;
            String subStr = s.substring(start,end);
            boolean flag = true;
            while (end <= len){
                if(s.substring(start,end).equals(subStr)){
                    start = end;
                    end = end+integer;
                }else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }

}