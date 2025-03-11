package com.wrp.algorithm.my.basic.pretrie;

/**
 * 深度优先遍历
 * @author wrp
 * @since 2025-03-11 20:57
 **/
public class NQueue {

    public static int res(int n) {

        int[] arr = new int[n];
        return process(0, arr, n);
    }

    public static int process(int i, int[] arr, int n) {
        if(i == n) {
            return 1;
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            if(isValid(arr, i, j)) {
                arr[i] = j;
                res += process(i + 1, arr, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] arr, int i, int j) {
        for (int k = 0; k < i; k++) {
            if(arr[k] == j || Math.abs(arr[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }
}
