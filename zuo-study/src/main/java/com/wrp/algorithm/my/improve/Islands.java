package com.wrp.algorithm.my.improve;

/**
 * @author wrp
 * @since 2025-03-30 09:39
 **/
public class Islands {

    // arr 0 1 组成的数组
    public static int islandCount(int[][] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    res++;
                    infect(arr, i, j);
                }
            }
        }
        return res;
    }

    // O(N * M)
    private static void infect(int[][] arr, int i, int j) {
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 1) {
            return;
        }

        arr[i][j] = 2;
        infect(arr, i + 1, j);
        infect(arr, i - 1, j);
        infect(arr, i, j + 1);
        infect(arr, i, j - 1);
    }
}
