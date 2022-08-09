package org.gzc.leetcode.model;

import java.util.Objects;

/**
 * @author GZC
 * @create 2022-05-03 23:24
 * @desc
 */
public class Pair {

    String log;
    int index;


    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Pair(String log, int index) {
        this.log = log;
        this.index = index;
    }
}
