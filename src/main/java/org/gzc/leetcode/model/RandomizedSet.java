package org.gzc.leetcode.model;

import javax.swing.text.StyledEditorKit;
import java.util.*;

/**
 * @author GZC
 * @create 2022-03-07 22:47
 * @description  链表随机节点
 */
public class RandomizedSet {
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }
        // 找到要删除的节点的位置，把随后一个元素移动到要删除的额位置上，然后删除最后一个元素
        Integer lastElement = list.get(list.size() - 1);
        Integer index = dict.get(val);
        dict.put(lastElement, index);
        list.set(index, lastElement);
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;

    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }


}
