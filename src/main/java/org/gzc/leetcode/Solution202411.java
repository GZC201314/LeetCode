package org.gzc.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.*;


/**
 * @author GZC
 */
@Slf4j
public class Solution202411 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 2364:
                log.info(String.valueOf(countBadPairs(new int[]{1, 2, 3, 4, 5})));
                break;
            case 491:
                log.info(String.valueOf(findSubsequences(new int[]{4, 6, 7, 7})));
                break;
            case 529:
                log.info(Arrays.deepToString(updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0})));
                break;
            case 419:
                char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
                log.info(String.valueOf(countBattleships(board)));

            default:
                break;

        }


    }

    /**
     * 2364. 统计坏数对的数目
     */
    public static long countBadPairs(int[] nums) {
        int n = nums.length;
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = nums[i] - i;
            if (map.containsKey(count)) {
                res += map.get(count);
                map.put(count, map.get(count) + 1);
            } else {
                map.put(count, 1);
            }
        }
        return ((long) n * (n - 1)) / 2 - res;
    }

    /**
     * 491. 非递减子序列
     */
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsFindSubsequences(nums, 0, path, res);
        return res;
    }

    private static void dfsFindSubsequences(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        Set<Integer> childSet = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (path.size() > 0 && path.get(path.size() - 1) > nums[i]) {
                continue;
            }
            // 去重，如果集合中已经存在该元素，则跳过
            if (childSet.contains(nums[i])) {
                continue;
            }
            childSet.add(nums[i]);
            path.add(nums[i]);
            dfsFindSubsequences(nums, i + 1, path, res);
            path.remove(path.size() - 1);

        }
    }

    /**
     * 529.扫雷游戏
     */
    public static char[][] updateBoard(char[][] board, int[] click) {

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfsOpen(board, click[0], click[1], dirs);
        return board;
    }

    // 递归打开覆盖的地图
    private static void dfsOpen(char[][] board, int x, int y, int[][] dirs) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        // 如果当前块已经打开了
        if (board[x][y] != 'E' && board[x][y] != 'M') {
            return;
        }
        getDisPlay(board, x, y, dirs);
        if (board[x][y] == 'B') {
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    dfsOpen(board, newX, newY, dirs);
                }
            }
        }


    }

    private static void getDisPlay(char[][] board, int x, int y, int[][] dirs) {
        // 如果是地雷的话，更新board为X
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        //如果是空方格的话 遍历周围8个格子
        if (board[x][y] == 'E') {
            int cnt = 0;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    // 如果是地雷就加一
                    if (board[newX][newY] == 'M' || board[newX][newY] == 'X') {
                        cnt++;
                    }
                }
            }
            if (cnt > 0) {
                board[x][y] = (char) (cnt + '0');
            } else {
                board[x][y] = 'B';
            }
        }
    }

    /**
     * 419. 棋盘上的战舰
     */
    public static int countBattleships(char[][] board) {
        int res = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    res++;
                    // 扩展设置成‘.'
                    // 1. 横向扩展
                    // 1.1 向左扩展
                    int tempJ = j;
                    while (tempJ >= 0 && board[i][tempJ] == 'X') {
                        board[i][tempJ] = '.';
                        tempJ--;
                    }
                    // 1.2 向右扩展
                    board[i][j] = 'X';
                    tempJ = j;
                    while (tempJ < n && board[i][tempJ] == 'X') {
                        board[i][tempJ] = '.';
                        tempJ++;
                    }

                    // 2. 纵向扩展
                    // 2.1 向上扩展
                    board[i][j] = 'X';
                    int tempI = i;
                    while (tempI >= 0 && board[tempI][j] == 'X') {
                        board[tempI][j] = '.';
                        tempI--;
                    }
                    // 2.2 向下扩展
                    board[i][j] = 'X';
                    tempI = i;
                    while (tempI < m && board[tempI][j] == 'X') {
                        board[tempI][j] = '.';
                        tempI++;
                    }
                    j = tempJ;

                }
            }
        }

        return res;
    }
}





