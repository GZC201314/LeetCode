package org.gzc.leetcode.model;

import java.util.PriorityQueue;

/**
 * @author gzc
 */
public class SmallestInfiniteSet {

    private int max = 16;
    private final int priorSize =16;
    private final PriorityQueue<Integer> queue;

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>();
        for (int i = 1; i < priorSize; i++) {
            queue.add(i);
        }
    }

    public int popSmallest() {
        if (queue.isEmpty()){
            for (int i = max; i < max+priorSize; i++) {
                queue.add(i);
            }
            max = max+16;
        }
        assert !queue.isEmpty();
        return queue.poll();
    }

    public void addBack(int num) {
        if (num>=max||queue.contains(num)){
            return;
        }
        queue.add(num);

    }

}
