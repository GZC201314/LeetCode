package org.gzc.leetcode.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String str = "" + val;
        ListNode nextcopy = next;
        while (nextcopy != null) {
            str = str + " " + nextcopy.val;
            nextcopy = nextcopy.next;
        }
        return str;
    }
}
