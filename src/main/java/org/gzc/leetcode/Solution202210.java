package org.gzc.leetcode;

import org.gzc.leetcode.model.ParkingSystem;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author GZC
 */
public class Solution202210 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 1800:
                System.out.println(maxAscendingSum(new int[]{1, 2, 3, 4}));
                break;
            case 1601:
                System.out.println(maximumRequests(5,new int[][]{{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}}));
                break;
            case 1603:
                ParkingSystem parkingSystem = new ParkingSystem(1,1,0);
                System.out.println(parkingSystem.addCar(1));
                System.out.println(parkingSystem.addCar(1));
                System.out.println(parkingSystem.addCar(2));
                System.out.println(parkingSystem.addCar(3));

                break;
            case 870:
                System.out.println(Arrays.toString(advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
                break;
            case 1551:
                System.out.println(minOperations(3));
                break;
            default:
                break;
        }

    }

    /**
     * 1601. 最多可达成的换楼请求数目
     */
    public static int maximumRequestsAnswer = 0;
    public static int maximumRequests(int n, int[][] requests) {
        maximumRequestsdfs(new int[n],requests,0,0);
        return maximumRequestsAnswer;
    }

    public static void maximumRequestsdfs(int[] used,int[][] requests,int cur,int chosen){
        if (cur == requests.length){
            if (validUsedArr(used)){
                maximumRequestsAnswer = Math.max(chosen,maximumRequestsAnswer);
            }
            return;
        }
        // 不选当前的request
        maximumRequestsdfs(used, requests,cur+1,chosen);

        // 选择当前的request
        used[requests[cur][0]]--;
        used[requests[cur][1]]++;
        maximumRequestsdfs(used, requests,cur+1,chosen+1);
        // 回溯
        used[requests[cur][1]]--;
        used[requests[cur][0]]++;
    }

    private static boolean validUsedArr(int[] used) {
        for (int i : used) {
            if (i !=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 870. 优势洗牌
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for (int i = 0; i < n; i++) {
            // 找到最小的满足数
            Integer integer = map.higherKey(nums2[i]);
            if (integer == null){
                integer = map.firstKey();
            }
            result[i] = integer;
            if (map.get(integer) == 1){
                map.remove(integer);
            }else {
                map.put(integer, map.get(integer)-1);
            }
        }
        return result;
    }

    /**
     * 1551. 使数组中所有元素相等的最小操作数
     */
    public static int minOperations(int n) {
        int num = 2 * (n - 1) + 1;
        int avg = (num + 1) / 2;
        int res = 0;
        for (int i = 0; i * 2 < n; i++) {
            res += (avg - (2 * i + 1));
        }
        return res;
    }

    /**
     * 1800. 最大升序子数组和
     */
    public static int maxAscendingSum(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        int lastNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num>lastNum){
                sum += num;
            }else {
                result = Math.max(result, sum);
                sum =num;
            }
            lastNum = num;
        }
        return Math.max(result, sum);
    }

}