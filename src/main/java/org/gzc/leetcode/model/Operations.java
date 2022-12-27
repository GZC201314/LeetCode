package org.gzc.leetcode.model;

/**
 * @author GZC
 * @create 2022-12-27 21:58
 */
public class Operations {

    /**
     * 用来获取-1
      */
    int ne = Integer.MAX_VALUE + Integer.MAX_VALUE + 1;
    /**
     * 放置 -1,-2,-4,-8...
     */
    long[] neCache = new long[32];
    /**
     * 放置 1,2,4,8...
     */
    long[] poCache = new long[32];
    /**
     *  存放乘数或除数的倍数，1*a,2*a,4*a,8*a...主要用于快速计算，不然容易超时
     */
    long[] cache = new long[32];
    /**
     *  存放乘数或除数的倍数 负数-1*a,-2*a,-4*a,-8*a
     */
    long[] cache1 = new long[32];

    public Operations() {
        neCache[0] = ne;
        poCache[0] = 1;
        for (int i = 1; i < 32; ++i) {
            neCache[i] = neCache[i + ne] + neCache[i + ne];
            poCache[i] = poCache[i + ne] + poCache[i + ne];
        }
    }

    public int minus(int a, int b) {
        if (a == b) {
            return 0;
        }
        // 从最大值开始比较
        int index = 31;
        while (b != 0) {
            if (b > 0) {
                // 如果b大于2的index次方，
                if (b >= poCache[index]) {
                    // a与b同时减
                    b += neCache[index];
                    a += neCache[index];
                } else {
                    index += ne;
                }
            } else {
                if (b <= neCache[index]) {
                    b += poCache[index];
                    a += poCache[index];
                } else {
                    index += ne;
                }
            }
        }
        return a;
    }

    public int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == 1) {
            return b;
        }
        if (b == 1) {
            return a;
        }
        if (a == ne) {
            return minus(0, b);
        }
        if (b == ne) {
            return minus(0, a);
        }
        int sign = (a > 0 && b > 0) || (a < 0 && b < 0) ? 1 : ne;
        // 把b变成正数
        if (b < 0) {
            b = minus(0, b);
        }

        cache[0] = a;
        for (int i = 1; i < 32; i++) {
            cache[i] = cache[i + ne] + cache[i + ne];
        }
        int index = 30;
        int ret = 0;
        // 记录返回值的符号
        int retSign = a > 0 ? 1 : ne;
        while (b > 0) {
            if (b >= poCache[index]) {
                b += neCache[index];
                ret += cache[index];
                // 记录返回值的符号
                retSign = ret > 0 ? 1 : ne;
            } else {
                index += ne;
            }
        }
        // 根据初始值改变返回值的符号
        if ((sign < 0 && ret > 0) || (sign > 0 && ret < 0)) {
            ret = minus(0, ret);
        }
        // 结果溢出，返回值的符号会变成相反的
        if (retSign != (a > 0 ? 1 : ne)) {
            ret = minus(0, ret);
        }
        return ret;
    }

    public int divide(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        if (b == ne) {
            return minus(0, a);
        }
        int ret = 0;
        int sign = (a > 0 && b > 0) || (a < 0 && b < 0) ? 1 : ne;
        long nb = b;
        if (b < 0) {
            b = minus(0, b);
        } else {
            nb = minus(0, b);
        }
        if (a < 0) {
            a = minus(0, a);
        }
        cache[0] = b;
        cache1[0] = nb;
        int index = 1;
        for (; index < 32; ++index) {
            cache[index] = cache[index + ne] + cache[index + ne];
            cache1[index] = cache1[index + ne] + cache1[index + ne];
            if (cache1[index] >= a) {
                break;
            }
        }
        if (index >= 32) {
            index = 31;
        }
        while (a >= b) {
            if (a >= cache[index]) {
                ret += poCache[index];
                a += cache1[index];
            } else {
                index += ne;
            }
        }
        if (sign < 0) {
            ret = minus(0, ret);
        }
        return ret;
    }
}

