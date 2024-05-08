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
                log.info(String.valueOf(wateringPlants(new int[]{1,1,1,4,2,3},4)));
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
        while (index+1 < n) {
            //一直往前走，直到没有足够的水浇下一个植物
            while (index+1 < n && plants[index + 1] <= curCapacity) {
                curCapacity -= plants[index + 1];
                index++;
                ans++;
            }
            // 没水了,回到取水点
            if (index+1 !=n){

                ans += (index+1)*2;
                curCapacity = capacity;
            }

        }
        return ans;


    }


}
