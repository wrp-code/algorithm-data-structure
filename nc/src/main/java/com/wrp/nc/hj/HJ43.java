package com.wrp.nc.hj;

import java.awt.*;
import java.util.*;

/**
 * @author wrp
 * @since 2025-03-08 07:35
 **/
public class HJ43 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int h = in.nextInt();
        int w = in.nextInt();
        int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        process(grid, h, w);
    }

    public static void process(int[][] grid, int h, int w) {
        Deque<Point> deque = new LinkedList<>();

        deque.offer(new Point(0, 0, null));
        grid[0][0] = 1;
        Point res = null;
        while(true) {
            res = deque.poll();
            if(res.x == h - 1 && res.y == w - 1) {
                break;
            }
            //检查上下左右
            if(res.x - 1 > -1 && grid[res.x - 1][res.y] == 0 ) {
                grid[res.x - 1][res.y] = 1;
                deque.offer(new Point(res.x - 1, res.y, res));
            }
            if(res.y - 1 > -1 && grid[res.x][res.y - 1] == 0 ) {
                grid[res.x][res.y - 1] = 1;
                deque.offer(new Point(res.x, res.y - 1, res));
            }
            if(res.x + 1 < h && grid[res.x + 1][res.y] == 0 ) {
                grid[res.x + 1][res.y] = 1;
                deque.offer(new Point(res.x + 1, res.y, res));
            }
            if(res.y + 1 < w && grid[res.x][res.y + 1] == 0 ) {
                grid[res.x][res.y + 1] = 1;
                deque.offer(new Point(res.x, res.y + 1, res));
            }
        }

        print(res);
    }

    public static void print(Point res) {
        if(res != null) {
            print(res.parent);
            System.out.println("(" + res.x + "," + res.y + ")");
        }
    }

    public static class Point {
        public int x;
        public int y;
        public Point parent;

        public Point(int x, int y, Point parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
    }
}
