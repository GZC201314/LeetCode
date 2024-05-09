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
        int indexA =0;
        int indexB =0;
        while (curPosA < curPosB) {

            if (curCapacityA >= plants[curPosA]) {
                curCapacityA -= plants[curPosA];
            }else {
                ans++;
                curCapacityA = capacityA-plants[curPosA];
                log.warn("Alice第{}次灌水，Alice当前的位置是{},当前元素是{}",++indexA,curPosA,plants[curPosA]);
            }
            curPosA++;
            if (curCapacityB >= plants[curPosB]) {
                curCapacityB -= plants[curPosB];

            }else {
                ans++;
                curCapacityB = capacityB-plants[curPosB];
                log.warn("Bob第{}次灌水，Bob当前的位置是{},当前元素是{}",++indexB,curPosB,plants[curPosB]);
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

}
