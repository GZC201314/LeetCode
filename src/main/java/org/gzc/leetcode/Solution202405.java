package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author GZC
 */
@Slf4j
public class Solution202405 {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 2079:
                log.info(String.valueOf(wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4)));
                break;
            case 994:
                log.info(String.valueOf(orangesRotting(new int[][]{{0, 2}})));
                break;
            case 2960:
                log.info(String.valueOf(countTestedDevices(new int[]{0,1,2})));
                break;
            case 2105:
                log.info(String.valueOf(minimumRefill(new int[]{274,179,789,417,293,336,133,334,569,355,813,217,80,933,961,271,294,933,49,980,685,470,186,11,157,889,299,493,215,807,588,464,218,248,391,817,32,606,740,941,505,533,289,306,490}, 996, 1172)));
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

        if (curPosA == curPosB) {
            if (!(curCapacityA >= plants[curPosA] || curCapacityB >= plants[curPosB])) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 2960. 统计已测试设备
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOrange++;
                } else if (grid[i][j] == 2) {
                    badOranges.add(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!badOranges.isEmpty()) {
            int newBadCount = 0;
            List<int[]> newBadOranges = new ArrayList<>();
            for (int[] badOrange : badOranges) {
                for (int[] dir : dirs) {
                    int newX = dir[0] + badOrange[0];
                    int newY = dir[1] + badOrange[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        freshOrange--;
                        newBadCount++;
                        newBadOranges.add(new int[]{newX, newY});
                    }
                }
            }
            if (newBadCount == 0) {
                break;
            }
            ans++;
            badOranges = newBadOranges;

        }

        return freshOrange == 0 ? ans : -1;

    }

}
