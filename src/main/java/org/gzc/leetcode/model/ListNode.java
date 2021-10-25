/*
 * Copyright (c) 2021.  All Rights Reserved.FileName: ListNode.java @author: GZC@date: 2021/10/20 下午10:49@version: 1.0
 */

package org.gzc.leetcode.model;

import java.util.Objects;

/** @author GZC */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("" + val);
    ListNode nextCopy = next;
    while (nextCopy != null) {
      str.append(" ").append(nextCopy.val);
      nextCopy = nextCopy.next;
    }
    return str.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ListNode)) {
      return false;
    }
    ListNode listNode = (ListNode) o;
    return val == listNode.val && Objects.equals(next, listNode.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, next);
  }
}
