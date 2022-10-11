package org.gzc.leetcode.model;

/**
 * @author GZC
 */
public class UnionFind2 {

    int[] parent;
    int[] rank;

    public UnionFind2(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }


    /**
     * 寻找 x的最终父节点，压缩路径
     */
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int num, int i) {
        int rootx = find(num);
        int rooty = find(i);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }
}
