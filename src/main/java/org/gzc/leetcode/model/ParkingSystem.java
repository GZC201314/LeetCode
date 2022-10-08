package org.gzc.leetcode.model;

/**
 * 1603. 设计停车系统
 */
public class ParkingSystem {
    private final int big;
    private final int medium;
    private final int small;
    private int curBig;
    private int curMedium;
    private int curSmall;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {

        switch (carType) {
            case 1:
                if (curBig == big) {
                    return false;
                }
                curBig++;
                return true;
            case 2:
                if (curMedium == medium) {
                    return false;
                }
                curMedium++;
                return true;
            case 3:
                if (curSmall == small) {
                    return false;
                }
                curSmall++;
                return true;
            default:
                break;
        }
        return false;
    }

}
