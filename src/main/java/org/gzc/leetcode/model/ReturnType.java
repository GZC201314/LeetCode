package org.gzc.leetcode.model;

public class ReturnType {
    private boolean isBalance;
    private int height;

    public ReturnType(boolean isBalance, int height) {
        this.isBalance = isBalance;
        this.height = height;
    }

    public boolean isBalance() {
        return isBalance;
    }

    public void setBalance(boolean balance) {
        isBalance = balance;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
