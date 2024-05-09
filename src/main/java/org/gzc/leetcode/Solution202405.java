package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
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
            case 2105:
                log.info(String.valueOf(minimumRefill(new int[]{923,65,50,788,446,122,987,355,528,590,69,107,656,676,454,604,213,299,969,239,341,940,690,195,884,135,499,38,440,857,404,266,786,915,564,246,271,977,775,978,166,636,494,284,435,630,584,590,401,167}, 1455, 1343)));
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
        while (curPosA < curPosB) {
            while ((curCapacityA >= plants[curPosA] || curCapacityB >= plants[curPosB]) && curPosA < curPosB) {
                if (curCapacityA >= plants[curPosA]) {
                    curCapacityA -= plants[curPosA];
                    curPosA++;
                }
                if (curCapacityB >= plants[curPosB]) {
                    curCapacityB -= plants[curPosB];
                    curPosB--;
                }
            }
            if (curPosA == curPosB) {
                if (!(curCapacityA >= plants[curPosA] || curCapacityB >= plants[curPosB])) {
                    ans++;
                }
            } else if (curPosA < curPosB) {
                curCapacityA = capacityA;
                curCapacityB = capacityB;
                ans += 2;
            }

        }
        return ans;
    }

}
