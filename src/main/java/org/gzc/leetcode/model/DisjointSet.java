package org.gzc.leetcode.model;

public class DisjointSet {
    int[] parents;

    public DisjointSet(int m,int n) {
        parents = new int[m * n];
        for (int j = 0; j < parents.length; j++) {
            parents[j] = j;
        }
    }
    public int find(int x){
        if (x != parents[x]){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    public void union(int x, int y){
        parents[find(x)] = find(parents[y]);
    }
}
