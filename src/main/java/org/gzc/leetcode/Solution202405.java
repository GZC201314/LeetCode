package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.*;

/**
 * @author GZC
 */
@Slf4j
public class Solution202405 {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 1684:
                log.info(String.valueOf(countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"})));
                break;
            case 2079:
                log.info(String.valueOf(wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4)));
                break;
            case 826:
                log.info(String.valueOf(maxProfitAssignment(new int[]{2,4,6,8,10}, new int[]{10,20,30,40,50}, new int[]{4,5,6,7})));
                break;
            case 994:
                log.info(String.valueOf(orangesRotting(new int[][]{{0, 2}})));
                break;
            case 2589:
                log.info(String.valueOf(findMinimumTime(new int[][]{{1, 3, 2}, {2, 5, 3}, {5, 6, 2}})));
                break;
            case 2960:
                log.info(String.valueOf(countTestedDevices(new int[]{0, 1, 2})));
                break;
            case 2244:
                log.info(String.valueOf(minimumRounds(new int[]{2, 3, 3})));
                break;
            case 2105:
                log.info(String.valueOf(minimumRefill(new int[]{274, 179, 789, 417, 293, 336, 133, 334, 569, 355, 813, 217, 80, 933, 961, 271, 294, 933, 49, 980, 685, 470, 186, 11, 157, 889, 299, 493, 215, 807, 588, 464, 218, 248, 391, 817, 32, 606, 740, 941, 505, 533, 289, 306, 490}, 996, 1172)));
                break;
            default:

        }


    }


    public static int wateringPlants(int[] plants, int capacity) {
        // 当前已交水的植物坐标
        int index = -1;
        // 当前人的位置
        int ans = 0;
        int curCapacity = capacity;
        int n = plants.length;
        while (index + 1 < n) {
            //一直往前走，直到没有足够的水浇下一个植物
            while (index + 1 < n && plants[index + 1] <= curCapacity) {
                curCapacity -= plants[index + 1];
                index++;
                ans++;
            }
            // 没水了,回到取水点
            if (index + 1 != n) {

                ans += (index + 1) * 2;
                curCapacity = capacity;
            }

        }
        return ans;


    }

    /**
     * 2105. 给植物浇水 II
     *
     * @param plants    植物
     * @param capacityA Alice水壶容积
     * @param capacityB Bob水壶容积
     * @return {@link int} 灌满次数
     */
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int ans = 0;
        int curCapacityA = capacityA;
        int curCapacityB = capacityB;
        int curPosA = 0;
        int curPosB = n - 1;
        int indexA = 0;
        int indexB = 0;
        while (curPosA < curPosB) {

            if (curCapacityA >= plants[curPosA]) {
                curCapacityA -= plants[curPosA];
            } else {
                ans++;
                curCapacityA = capacityA - plants[curPosA];
                log.warn("Alice第{}次灌水，Alice当前的位置是{},当前元素是{}", ++indexA, curPosA, plants[curPosA]);
            }
            curPosA++;
            if (curCapacityB >= plants[curPosB]) {
                curCapacityB -= plants[curPosB];

            } else {
                ans++;
                curCapacityB = capacityB - plants[curPosB];
                log.warn("Bob第{}次灌水，Bob当前的位置是{},当前元素是{}", ++indexB, curPosB, plants[curPosB]);
            }
            curPosB--;
        }

        if (curPosA == curPosB && (!(curCapacityA >= plants[curPosA] || curCapacityB >= plants[curPosB]))) {
            ans++;

        }
        return ans;
    }

    /**
     * 2960. 统计已测试设备
     *
     * @param batteryPercentages 电池容量
     * @return 测试的电池个数
     */
    public static int countTestedDevices(int[] batteryPercentages) {
        int sum = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage - sum > 0) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 994. 腐烂的橘子
     */
    public static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // 统计腐烂的橘子和好的橘子
        List<int[]> badOranges = new ArrayList<>();
        int freshOrange = 0;
        freshOrange = statiscOrange(grid, m, n, badOranges, freshOrange);
        int ans = 0;
        while (!badOranges.isEmpty()) {
            List<int[]> newBadOranges = new ArrayList<>();
            for (int[] badOrange : badOranges) {
                for (int[] dir : dirs) {
                    int newX = dir[0] + badOrange[0];
                    int newY = dir[1] + badOrange[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        freshOrange--;
                        newBadOranges.add(new int[]{newX, newY});
                    }
                }
            }
            if (newBadOranges.isEmpty()) {
                break;
            }
            ans++;
            badOranges = newBadOranges;

        }

        return freshOrange == 0 ? ans : -1;

    }

    /**
     * 994. 腐烂的橘子
     */
    private static int statiscOrange(int[][] grid, int m, int n, List<int[]> badOranges, int freshOrange) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOrange++;
                } else if (grid[i][j] == 2) {
                    badOranges.add(new int[]{i, j});
                }
            }
        }
        return freshOrange;
    }

    /**
     * 2244. 完成所有任务需要的最少轮数
     */
    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> taskCount : map.entrySet()) {
            if (taskCount.getValue() == 1) {
                return -1;
            }
            ans += taskCount.getValue() / 3;
            if (taskCount.getValue() % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 1684. 统计一致字符串的数目
     */
    public static int countConsistentStrings(String allowed, String[] words) {
        int bitArr = 0;
        int ans = 0;
        for (int i = 0; i < allowed.length(); i++) {
            bitArr |= (1 << (allowed.charAt(i) - 'a'));
        }
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if ((bitArr & (1 << (word.charAt(i) - 'a'))) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;

    }

    /**
     * 2589. 完成所有任务的最少时间
     */
    public static int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        int maxIndex = tasks[tasks.length - 1][1];
        boolean[] run = new boolean[maxIndex + 1];
        int ans = 0;
        for (int[] task : tasks) {
            int start = task[0];
            int end = task[1];
            int dur = task[2];
            for (int i = start; i < end; i++) {
                if (run[i]) {
                    dur--;
                }
            }

            for (int i = end; dur > 0; i--) {
                if (!run[i]) {
                    run[i] = true;
                    dur--;
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 826.安排工作以达到最大收益
     */
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = difficulty[i];
            dp[i][1] = profit[i];
        }
        // 任务复杂度按照从小到大排列，工人能力从小到大排列
        Arrays.sort(dp, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(worker);
        int ans = 0;
        int max = 0;
        int index =0;
        for (int w : worker) {
            while (index<n){
                if (dp[index][0] <= w) {
                    max = Math.max(max, dp[index][1]);
                    index++;
                } else {
                    break;
                }
            }
            ans += max;
        }
        return ans;

    }

}
