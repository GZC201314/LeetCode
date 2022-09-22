package org.gzc.leetcode.model;

/**
 * @author GZC-
 * @create 2021-09-28 22:16
 */
public class UnionFind {

    private final int[] parent;
    private final double[] weight;
    private int count;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.weight = new double[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 寻找 x的最终父节点，压缩路径
     */
    public int find(int x) {
        if (parent[x] != x) {
            int oldParent = parent[x];
            parent[x] = find(parent[x]);
            weight[x] *= weight[oldParent];
        }
        return parent[x];
    }

    public void union(int x, int y,double value) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;
        weight[rootX] = weight[y] * value / weight[x];
        count--;
    }

    /**
     * 获取两个节点之间的权值
     */
    public double getWeight(int x, int y){
        return weight[x]/weight[y];
    }

}
