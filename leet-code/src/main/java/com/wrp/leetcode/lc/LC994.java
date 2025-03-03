package com.wrp.leetcode.lc;

/**
 * @author wrp
 * @since 2025-03-03 18:41
 **/
public class LC994 {
    public static final int BAD_FLAG = 3;

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        new LC994().orangesRotting(grid);
    }
    public int orangesRotting(int[][] grid) {
        int m = 0;
        // 是否还有新鲜的句子
        // 扩散
        while(has(grid) && bad(grid)) {
            m++;
        }

        return has(grid) ? -1 : m;
    }

    private boolean bad(int[][] grid) {
        boolean bad = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == BAD_FLAG) {
                    // 向上扩散
                    if(j != 0 && grid[i][j-1] == 1) {
                        grid[i][j-1] = 2;
                        bad = true;
                    }
                    // 向下扩散
                    if(j < grid[0].length - 1 && grid[i][j+1] == 1) {
                        grid[i][j+1] = 2;
                        bad = true;
                    }
                    // 向左扩散
                    if(i != 0 && grid[i - 1][j] == 1) {
                        grid[i - 1][j] = 2;
                        bad = true;
                    }
                    // 向右扩散
                    if(i < grid.length - 1 && grid[i + 1][j] == 1) {
                        grid[i + 1][j] = 2;
                        bad = true;
                    }
                }
            }
        }
        return bad;
    }

    public static boolean has(int[][] grid) {
        boolean has = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!has && grid[i][j] == 1) {
                    has = true;
                }

                if(grid[i][j] == 2) {
                    // 标记本局已经腐烂的，便于扩散
                    grid[i][j] = BAD_FLAG;
                }
            }
        }
        return has;
    }
}
