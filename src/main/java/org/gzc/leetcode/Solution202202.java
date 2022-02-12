package org.gzc.leetcode;

/**
 * @author GZC
 * @description 2022年2月份的LeetCode练习代码
 */
public class Solution202202 {
    int N = 550;
    int[] p = new int[N * N];
    int m, n;
    int[][] g;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * 查找联通的图
     * @param x
     * @return
     */
    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    /**
     * 判断两个坐标是否联通
     * @param a
     * @param b
     * @return
     */
    boolean query(int a, int b) {
        return find(a) == find(b);
    }

    /**
     * 联通两个一维坐标
     * @param a
     * @param b
     */
    void union(int a, int b) {
        p[find(a)] = find(b);
    }

    public int numEnclaves(int[][] grid) {
        g = grid;
        m = g.length;
        n = g[0].length;
        // 设置联通的图，默认都是只和自己联通
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[getIdx(i, j)] = getIdx(i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果是边缘
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    // 边缘水路和已经遍历过，跳过
                    if (g[i][j] != 1 || query(getIdx(i, j), 0)) {
                        continue;
                    }
                    //边缘是陆地，深度优先遍历联通的陆地
                    dfs(i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1 && !query(getIdx(i, j), 0)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    void dfs(int x, int y) {
        union(getIdx(x, y), 0);
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (g[nx][ny] != 1 || query(getIdx(nx, ny), 0)) {
                continue;
            }
            dfs(nx, ny);
        }
    }

    /**
     * 把二维左边转化成一维坐标
     * @param x x左边
     * @param y y坐标
     * @return 一维坐标
     */
    int getIdx(int x, int y) {
        return x * n + y + 1;
    }
}
