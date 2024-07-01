package org.gzc.leetcode.model;

public class MyTree {
    int[] tree;
    public MyTree(int length) {
        this.tree = new int[length + 1];
        for (int num = 1; num <= length; num++) {
            tree[num] = num & -num;
        }
    }

    public int query(int index){
        int res = 0;
        while (index > 0) {
            res += tree[index];
            index ^= index & -index;
        }
        return res;
    }

    public void remove(int index){
        while (index < tree.length) {
            tree[index]--;
            index += index & -index;
        }
    }
}