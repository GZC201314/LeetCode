package org.gzc.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author GZC
 * @create 2021-12-11 21:48
 */
public class TopVotedCandidate {

    TreeMap<Integer, Integer> treeMap;

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;
        treeMap = new TreeMap<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        int maxNum = 0, person = persons[0];
        for (int i = 0; i < n; i++) {
            int num = hashMap.getOrDefault(persons[i], 0) + 1;
            hashMap.put(persons[i], num);
            if (num >= maxNum) {
                maxNum = num;
                person = persons[i];
            }
            treeMap.put(times[i], person);
        }
    }

    public int q(int t) {
        /*方法用来返回与最大键小于或等于给定的键，或者如果不存在这样的键，null关联的键 - 值映射。*/
        return treeMap.floorEntry(t).getValue();
    }

}
