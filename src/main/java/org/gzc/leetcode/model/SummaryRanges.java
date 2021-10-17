package org.gzc.leetcode.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * 给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，
 *
 * <p>请你将到目前为止看到的数字总结为不相交的区间列表。
 *
 * @author GZC
 * @create 2021-10-17 21:14
 */
public class SummaryRanges {
  TreeMap<Integer, Integer> intervals;

  public SummaryRanges() {
    intervals = new TreeMap<>();
  }

  public void addNum(int val) {
    /*找到右边最接近的区间*/
    Map.Entry<Integer, Integer> intervall1 = intervals.ceilingEntry(val + 1);
    /*找到左边最接近的区间*/
    Map.Entry<Integer, Integer> intervall0 = intervals.floorEntry(val);
    /*添加的数已经包含在区间中了*/
    if (intervall0 != null && intervall0.getKey() <= val && val <= intervall0.getValue()) {
      return;
    } else {
      boolean leftAside = intervall0 != null && intervall0.getValue() + 1 == val;
      boolean rightAside = intervall1 != null && intervall1.getKey() - 1 == val;

      /*如果插入的数据刚好在两个区间之间,而且可以组成一个更大的区间,则把这两个区间合并*/
      if (leftAside && rightAside) {
        int left = intervall0.getKey(), right = intervall1.getValue();
        intervals.remove(intervall0.getKey());
        intervals.remove(intervall1.getKey());
        intervals.put(left, right);
      } else if (leftAside) {
        intervals.put(intervall0.getKey(), intervall0.getValue() + 1);
      } else if (rightAside) {
        int right = intervall1.getValue();
        intervals.remove(intervall1.getKey());
        intervals.put(val, right);
      } else {
        intervals.put(val, val);
      }
    }
  }

  public int[][] getIntervals() {
    int size = intervals.size();
    int[][] ans = new int[size][2];
    int index = 0;
    for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
      int left = entry.getKey(), right = entry.getValue();
      ans[index][0] = left;
      ans[index][1] = right;
      index++;
    }
    return ans;
  }
}
