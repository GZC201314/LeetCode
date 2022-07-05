package org.gzc.leetcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的日程安排表1
 */
public class MyCalendar {
    List<int[]> usedDate;
    public MyCalendar() {
        usedDate = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] date : usedDate){
           if(!(end <=date[0]||start>=date[1])){
               return false;
           }
        }
        usedDate.add(new int[]{start,end});
        return true;

    }
}
