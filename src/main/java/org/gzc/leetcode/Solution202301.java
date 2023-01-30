package org.gzc.leetcode;

import org.gzc.leetcode.model.ListNode;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author GZC
 */
public class Solution202301 {


    public static Set<Integer> seen = new HashSet<>();
    public static StringBuffer ans = new StringBuffer();
    public static int highest;
    public static int k;
    /**
     * 1814. 统计一个数组中好对子的数目
     */
    public static int mod = (int) 1e9 + 7;
    /**
     * 802. 迷路的机器人
     */
    static List<List<Integer>> result = new ArrayList<>();

    /**
     * 802. 迷路的机器人
     */

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {

            case 2042:
                System.out.println(areNumbersAscending("sunset is at 7 50 pm overnight lows will be in the low 51 and 60 s"));
                break;
            case 1991:
                System.out.println(findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
                break;
            case 1806:
                System.out.println(reinitializePermutation(4));
                break;
            case 1807:
                List<List<String>> knowledge = new ArrayList<>();
                List<String> keyValue = new ArrayList<>();
                keyValue.add("name");
                keyValue.add("bob");
                List<String> keyValue1 = new ArrayList<>();
                keyValue1.add("age");
                keyValue1.add("two");
                knowledge.add(keyValue);
                knowledge.add(keyValue1);
                System.out.println(evaluate("(name)is(age)yearsold", knowledge));
                break;
            case 2283:
                System.out.println(digitCount("1210"));
                break;
            case 801:
                System.out.println(waysToStep(76));
                break;
            case 802:
                System.out.println(pathWithObstacles(new int[][]{{0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0}, {0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0}, {0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0}, {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0}, {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1}, {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1}, {0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}, {1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}));
                break;
            case 1813:
                System.out.println(areSentencesSimilar("My name is Haley", "My Haley"));
                break;
            case 753:
                System.out.println(crackSafe(4, 3));
                break;
            case 1663:
                System.out.println(getSmallestString(5, 73));
                break;
            case 2002:
                System.out.println(maxProduct("leetcodecom"));
                break;
            case 2309:
                System.out.println(greatestLetter("AbCdEfGhIjK"));
                break;
            case 1814:
                System.out.println(countNicePairs(new int[]{42, 11, 1, 97}));
                break;
            case 803:
                System.out.println(findMagicIndex(new int[]{2, 2, 2, 2}));
                break;
            case 1708:
                System.out.println(bestSeqAtIndex(new int[]{65, 70, 56, 75, 60, 68}, new int[]{100, 150, 90, 190, 95, 110}));
                break;
            case 1828:
                System.out.println(Arrays.toString(countPoints(new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}}, new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}})));
                break;
            case 1669:
                ListNode list1 = new ListNode(0,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))));
                ListNode list2 = new ListNode(1000000,new ListNode(1000001,new ListNode(1000003)));
                System.out.println(mergeInBetween(list1,3,4,list2));
                break;
            case 1802:
                System.out.println(maxValue(995610677, 934568761, 999009430));
                break;
            default:
                sort1("2019-1-10,,,2019-3-1");
                sort(new int[]{1,2,3,4});
                break;
        }
    }

    /**
     * 1669. 合并两个链表
     */
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode root = list1;
        // 找到list2中的头和尾节点
        ListNode list2Head = list2;
        ListNode list1aHead = null;
        ListNode list2Tail = null;
        ListNode list1aTail = null;
        while (list2!=null){
            list2Tail = list2;
            list2 = list2.next;
        }
        int index =0;
        while (list1 != null){
            index++;
            if (index == a){
                list1aHead = list1;
            }
            if (index == b){
                list1aTail = list1.next== null?null: list1.next.next;
                break;
            }
            list1 = list1.next;
        }
        if (list1aHead == null){
            root = list2Head;
        }else {
            list1aHead.next = list2Head;
        }
        if (list1aTail != null){
            assert list2Tail != null;
            list2Tail.next = list1aTail;
        }
        return root;
    }

    public static void sort1(String str) throws ParseException {
        List<String> dateList = new ArrayList<>();
        String[] split = str.split(",");
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (String s : split) {
            if (!"".equals(s)){
                Date parse = simpleDateFormat.parse(s);
                rightNow.setTime(parse);
                rightNow.add(Calendar.DAY_OF_YEAR,-90);
                parse = rightNow.getTime();
                simpleDateFormat.format(parse);
                dateList.add(simpleDateFormat.format(parse));
            }
        }

        System.out.println("空值占比为："+dateList.size()/(float)split.length);

        System.out.println("日期格式化输出：" + String.join(" ",dateList));
    }
    public static void sort(int[] a){

        Arrays.sort(a);
        int left =0;
        int right = a.length-1;
        StringBuilder sb = new StringBuilder();
        while (left<right){
            sb.append(a[right--]).append(",").append(a[left++]).append(",");
        }
        try {
            FileWriter fileWriter = new FileWriter("test.txt");
            fileWriter.append(sb.subSequence(0,sb.length()-1));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 2309. 兼具大小写的最好英文字母
     */
    public static String greatestLetter(String s) {
        char ans = 0;
        Set<Character> set = new HashSet<>();
        char[] sChar = s.toCharArray();
        for (char c : sChar) {
            // 如果是小写字母
            if (Character.isLowerCase(c)){
                if (!set.contains(c)){
                    char upperCase = Character.toUpperCase(c);
                    if (set.contains(upperCase)){
                        ans = ans<upperCase?upperCase:ans;
                    }
                    set.add(c);
                }
            }else {
                if (!set.contains(c)){
                    char lowerCase = Character.toLowerCase(c);
                    if (set.contains(lowerCase)){
                        ans = ans<c?c:ans;
                    }
                    set.add(c);
                }
            }
        }
        return ans==0?"":String.valueOf(ans);

    }

    /**
     * 803. 魔术索引
     */
    public static int findMagicIndex(int[] nums) {
        int ans = -1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i == nums[i]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 1663. 具有给定数值的最小字符串
     */
    public static String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('a');
        }
        int rest = k - n;
        for (int i = n - 1; i >= 0; i--) {
            if (rest > 25) {
                sb.replace(i, i + 1, "z");
                rest -= 25;
            } else {
                sb.replace(i, i + 1, (char) ('a' + rest) + "");
                break;
            }
        }
        return sb.toString();
    }

    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        result.clear();
        if (obstacleGrid[0][0] == 1) {
            return result;
        }
        pathWithObstaclesDfs(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
        return result;
    }

    public static boolean pathWithObstaclesDfs(int[][] obstacleGrid, int i, int j) {
        if (i == 0 && j == 0) {
            add(i, j);
            return true;
        }

        if (obstacleGrid[i][j] > 0) {
            return false;
        }
        obstacleGrid[i][j] = 2;
        if (i > 0 && pathWithObstaclesDfs(obstacleGrid, i - 1, j)) {
            add(i, j);
            return true;
        }
        if (j > 0 && pathWithObstaclesDfs(obstacleGrid, i, j - 1)) {
            add(i, j);
            return true;
        }
        //不取消标记
        //obstacleGrid[i][j] = 2;
        return false;
    }

    public static void add(int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        result.add(list);
    }

    /**
     * 801. 三步问题
     */
    public static int waysToStep(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i <= 3) {
                if (i == 2) {
                    dp[i] = 2;
                } else {
                    dp[i] = 4;
                }
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return (int) (dp[n] % 1000000007);
    }

    /**
     * 1708. 马戏团人塔
     */
    public static int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = height[i];
            arr[i][1] = weight[i];
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o2[0], o1[0]);
        });

        int[][] dp = new int[len + 1][2];
        dp[1] = arr[0];
        int index = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i][1] < dp[index][1]) {
                dp[++index] = arr[i];
            } else {
                int pos = find(dp, arr[i], index);
                dp[pos] = arr[i];
            }
        }

        return index;
    }

    public static int find(int[][] dp, int[] person, int index) {
        int left = 1;
        int right = index;
        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid][1] <= person[1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    /**
     * 1828. 统计一个圆中点的数目
     */
    public static int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int[] point : points) {
            // 一个点可能在多个圆中
            for (int i = 0; i < n; i++) {
                int[] query = queries[i];
                if (Math.pow(Math.abs(query[0] - point[0]), 2) + Math.pow(Math.abs(query[1] - point[1]), 2) <= Math.pow(query[2], 2)) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    /**
     * 2002. 两个回文子序列长度的最大乘积
     */
    public static int maxProduct(String s) {
        int max = 1 << s.length();
        //存储所有的回文子串的状态和长度
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < max; ++i) {
            if (check(s, i)) {
                list.add(new int[]{i, getNum1(i)});
            }
        }
        int n = list.size();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //校验两个回文串有没有重复
                if ((list.get(i)[0] & list.get(j)[0]) == 0) {
                    res = Math.max(list.get(i)[1] * list.get(j)[1], res);
                }
            }
        }
        return res;
    }

    /**
     * @param n 选择的情况
     * @return 当前情况下回文串的长度
     */
    private static int getNum1(Integer n) {

        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();

        int count = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * @param n 选择的情况
     * @return 当前情况是否是回文子串
     */
    private static boolean check(String s, int n) {
        StringBuilder ss = new StringBuilder();
        int index = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ss.append(s.charAt(index));
            }
            n = n >> 1;
            index++;
        }
        int len = ss.length();
        for (int i = 0; i * 2 < len; i++) {
            if (ss.charAt(i) != ss.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static int countNicePairs(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>(32);
        int ans = 0;
        for (int x : nums) {
            int rev = countNicePairsRev(x);
            ans = (ans + mp.getOrDefault(x - rev, 0)) % mod;
            mp.put(x - rev, mp.getOrDefault(x - rev, 0) + 1);
        }
        return ans;
    }


    public static int countNicePairsRev(int num) {
        int ans = 0;
        while (num > 0) {
            int i = num % 10;
            ans *= 10;
            ans += +i;
            num /= 10;
        }
        return ans;
    }


    /**
     * 1813. 句子相似性Ⅲ
     */
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] sentences1Arr = sentence1.split(" ");
        String[] sentences2Arr = sentence2.split(" ");
        int leftMatchCount = 0;
        int rightMatchCount = 0;
        while (leftMatchCount < sentences1Arr.length && leftMatchCount < sentences2Arr.length && sentences1Arr[leftMatchCount].equals(sentences2Arr[leftMatchCount])) {
            leftMatchCount++;
        }
        while (sentences1Arr.length - leftMatchCount > rightMatchCount && sentences2Arr.length - leftMatchCount > rightMatchCount && sentences1Arr[sentences1Arr.length - 1 - rightMatchCount].equals(sentences2Arr[sentences2Arr.length - 1 - rightMatchCount])) {
            rightMatchCount++;
        }
        return leftMatchCount + rightMatchCount == Math.min(sentences1Arr.length, sentences2Arr.length);

    }

    /**
     * 1807. 替换字符串中的括号内容
     */
    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(16);
        StringBuilder ans = new StringBuilder();
        // 状态标记为，当前是否有出现（
        boolean flag = false;
        StringBuilder curKey = new StringBuilder();
        // 把 knowledge 转换成Set
        for (List<String> keyValue : knowledge) {
            map.put(keyValue.get(0), keyValue.get(1));
        }
        char[] sChr = s.toCharArray();
        for (char c : sChr) {
            // 前面出现了（
            if (flag) {
                if (c == ')') {
                    String value = map.getOrDefault(curKey.toString(), "?");
                    ans.append(value);
                    curKey = new StringBuilder();
                    flag = false;
                } else {
                    curKey.append(c);
                }
            } else {
                if (c == '(') {
                    flag = true;
                } else {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }

    /**
     * 2283. 判断一个数的数字计数是否等于数位的值
     */
    public static boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>(16);
        char[] numArr = num.toCharArray();
        for (char c : numArr) {
            map.put(c - '0', map.getOrDefault(c - '0', 0) + 1);
        }
        int length = numArr.length;
        for (int i = 0; i < length; i++) {
            if ((numArr[i] - '0') != map.getOrDefault(i, 0)) {
                return false;
            }
        }
        return true;

    }

    /**
     * 753. 破解保险箱
     */
    public static String crackSafe(int n, int k1) {
        highest = (int) Math.pow(10, n - 1);
        k = k1;
        pathWithObstaclesDfs(0);
        for (int i = 1; i < n; i++) {
            ans.append('0');
        }
        return ans.toString();
    }

    public static void pathWithObstaclesDfs(int node) {
        for (int x = 0; x < k; ++x) {
            int nei = node * 10 + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                pathWithObstaclesDfs(nei % highest);
                ans.append(x);
            }
        }
    }


    /**
     * 1806. 还原排列的最少操作步数
     */
    public static int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] arr = new int[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        mergeArr(n, perm, arr);
        while (!validArr(perm)) {
            mergeArr(n, perm, arr);
            ans++;
        }
        return ans;

    }

    private static void mergeArr(int n, int[] perm, int[] arr) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                arr[i] = perm[n / 2 + (i - 1) / 2];
            } else {
                arr[i] = perm[i / 2];
            }
        }
        if (n >= 0) {
            System.arraycopy(arr, 0, perm, 0, n);
        }
    }

    private static boolean validArr(int[] perm) {
        int length = perm.length;
        for (int i = 0; i < length; i++) {
            if (perm[i] != i) {
                return false;
            }
        }
        return true;
    }


    /**
     * 1991. 找到数组的中间位置
     */
    public static int findMiddleIndex(int[] nums) {
        int n = nums.length;
        long[] preSum = new long[n];

        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            long leftSum = i - 1 >= 0 ? preSum[i - 1] : 0;
            long rightSum = n - i - 1 > 0 ? preSum[n - 1] - preSum[i] : 0;
            if (leftSum == rightSum) {
                return i;
            }

        }
        return -1;


    }

    /**
     * 1802. 有界数组中指定下标处的最大值
     */
    public static int maxValue(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum;
        int mid = left + (right - left) / 2;
        int ans = 0;
        while (left <= right) {
            // 当最大值为mid时，判断是否满足条件
            // 计算满足条件需要的最大最小值
            // 左边的最小值 0 -- index-1
            int leftIndex = index - 1;
            int leftNum = Math.max(mid - 1, 1);
            long leftSum = 0;
            while (leftIndex >= 0) {
                leftSum += leftNum;
                if (leftNum > 1) {
                    leftNum--;
                } else {
                    if (leftIndex > 0) {
                        leftSum += leftIndex;
                    }
                    break;
                }
                leftIndex--;
            }
            int rightIndex = index + 1;
            long rightSum = 0;
            int rightNum = Math.max(mid - 1, 1);
            while (rightIndex < n) {
                rightSum += rightNum;
                if (rightNum > 1) {
                    rightNum--;
                } else {
                    if (rightNum < n - 1) {
                        rightSum += (n - rightIndex - 1);
                    }
                    break;
                }
                rightIndex++;
            }
            if (leftSum + rightSum <= maxSum - mid) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return ans;

    }


    /**
     * 2042. 检查橘子中的数字是否递增
     */
    public static boolean areNumbersAscending(String s) {
        final char[] sChrs = s.toCharArray();
        long cur = 0;
        long preNum = Long.MIN_VALUE;
        for (char sChr : sChrs) {
            if (Character.isDigit(sChr)) {
                cur = cur * 10 + (sChr - '0');
            } else {
                if (cur != 0) {
                    if (cur <= preNum) {
                        return false;
                    }
                    preNum = cur;
                    cur = 0;
                }
            }
        }
        if (cur != 0) {
            return cur > preNum;
        }
        return true;
    }


}
