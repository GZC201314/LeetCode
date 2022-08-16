package org.gzc.leetcode.model;

import java.util.*;

/**
 * @author GZC
 * @create 2022-08-16 22:45
 * @desc 有序流
 */
public class OrderedStream {

    private final String[] stream;
    private int ptr;

    public OrderedStream(int n) {
        stream = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        List<String> res = new ArrayList<>();
        while (ptr < stream.length && stream[ptr] != null) {
            res.add(stream[ptr++]);
        }
        return res;
    }
}
