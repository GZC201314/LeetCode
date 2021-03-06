package org.gzc.leetcode;

import java.util.*;

/**
 * @author GZC
 * @description 2022年2月份的LeetCode练习代码
 */
public class Solution202202 {
    int[][] knightDirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
    int N = 550;
    int[] p = new int[N * N];
    int m, n;
    int[][] g;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    /**
     * 查找联通的图
     *
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
     *
     * @param a
     * @param b
     * @return
     */
    boolean query(int a, int b) {
        return find(a) == find(b);
    }

    /**
     * 联通两个一维坐标
     *
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
     *
     * @param x x左边
     * @param y y坐标
     * @return 一维坐标
     */
    int getIdx(int x, int y) {
        return x * n + y + 1;
    }

    /**
     * 540. 有序数组中的单一元素
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    /**
     * 1380. 矩阵中的幸运数
     *
     * @param matrix 矩阵
     * @return 幸运数
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] minRow = new int[m];
        int[] maxCol = new int[n];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }

    /**
     * 378. 有序矩阵中第K小的元素
     *
     * @param matrix 矩阵
     * @param k      第K小
     * @return 结果
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 二分查找K
     *
     * @param matrix
     * @param mid
     * @param k
     * @param n
     * @return
     */
    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    /**
     * 688. 骑士在棋盘上的概率
     *
     * @param n      棋盘尺寸
     * @param k      步数
     * @param row    初始行
     * @param column 初始列
     * @return 在棋盘的概率
     */
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 刚开始的时候初始化 dp数组
                    if (step == 0) {
                        dp[step][i][j] = 1;
                    } else {
                        for (int[] dir : knightDirs) {
                            int ni = i + dir[0], nj = j + dir[1];
                            //如果在棋盘内
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[step][i][j] += dp[step - 1][ni][nj] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }

    /**
     * 405. 数字转换为十六进制数
     *
     * @param num 数字
     * @return 十六进制数
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    /**
     * 917. 仅仅反转字母
     *
     * @param s 要反转的字符串
     * @return 反转后的字符串
     */
    public String reverseOnlyLetters(String s) {

        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !Character.isLetter(s.charAt(left))) {
                left++;
            }
            while (left <= right && !Character.isLetter(s.charAt(right))) {
                right--;
            }
            if (left <= right) {
                char tem = chars[left];
                chars[left] = chars[right];
                chars[right] = tem;

            }
            left++;
            right--;
        }

        return new String(chars);
    }

    /**
     * 1706. 球会落何处
     *
     * @param grid 网格
     * @return 结果
     */
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = getResult(i, grid, m, n);
        }
        return ans;
    }

    int getResult(int x, int[][] grid, int m, int n) {
        int r = 0, c = x;
        while (r < m) {
            int ne = c + grid[r][c];
            if (ne < 0 || ne >= n) {
                return -1;
            }
            if (grid[r][c] != grid[r][ne]) {
                return -1;
            }
            r++;
            c = ne;
        }
        return c;
    }

    /**
     * 521. 最长特殊序列|
     * @param a 字符串a
     * @param b 字符串b
     * @return 最长特殊序列长度
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    /**
     * 409. 最长回文数
     * @param s 字符串
     * @return 最长回文数长度
     */
    public int longestPalindrome(String s) {
        int result = 0;
        char[] chars = s.toCharArray();

        Set<Character> characterSet = new HashSet<>();
        int charsLength = chars.length;
        for (char ch :
                chars) {
            if(characterSet.contains(ch)){
                characterSet.remove(ch);
                result+=2;
            }else {
                characterSet.add(ch);
            }
        }
        if(!characterSet.isEmpty()){
           result+=1;
        }
        return result;

    }

}
