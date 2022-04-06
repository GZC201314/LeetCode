package org.gzc.leetcode.model;

import java.util.Random;

/**
 * @author GZC
 * @create 2022-04-06 17:36
 * @desc 链表随机节点
 */
public class Solution {

    ListNode root;
    Random random;


    public Solution(ListNode root) {
        this.root = root;
        this.random = new Random();
    }

    public int getRandom(){
        int i =1,ans =0;
        ListNode  node = this.root;
        while (node != null){
            if(random.nextInt(i) == 0){
                ans = node.val;
            }
            ++i;
            node = node.next;
        }
        return ans;
    }
}
