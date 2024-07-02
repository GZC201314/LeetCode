package org.gzc.leetcode.model;

import java.util.*;

public class RandomizedCollection {
    //存数字和该数字出现的下标集合
    Map<Integer, Set<Integer>> idx;
    //按顺序存数字
    List<Integer> nums;
    public RandomizedCollection() {
        idx = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        //末尾加入val
        nums.add(val);
        //获取val的下标集合
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        //set记录中新增val的一个下标
        set.add(nums.size() - 1);
        //更新val的下标集合
        idx.put(val, set);
        return set.size() == 1;
    }

    public boolean remove(int val) {
        //集合中不存在val
        if(!idx.containsKey(val)){
            return false;
        }
        //使用迭代器it遍历val的所有下标
        Iterator<Integer> it = idx.get(val).iterator();
        //得到最左端的一个val的下标i
        int i = it.next();
        //获取数组中的最后一个数
        int lastNum = nums.get(nums.size() - 1);
        //将最后一个数放到i位置，这里其实已经将val移除
        nums.set(i, lastNum);
        //由于i位置不再是val，因此val的下标集合中应当将i移除
        idx.get(val).remove(i);
        //由于需要将lastNum置于i位置，因此数组最后一个位置不再需要放置lastNum
        idx.get(lastNum).remove(nums.size() - 1);
        //如果i不是最后一个位置
        if(i < nums.size() - 1){
            //将lastNum的下标集合加入i
            idx.get(lastNum).add(i);
        }
        //如果val的下标集合为空，说明val不存在
        if(idx.get(val).size() == 0){
            //从idx中移除val
            idx.remove(val);
        }
        //其实这里清除的是多余的一个lastNum，并不是val，val在之前已经被覆盖
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        //按照出现的频率按概率获取元素
        return nums.get((int)(Math.random() * nums.size()));
    }
}
