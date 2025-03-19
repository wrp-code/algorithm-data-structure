package com.wrp.algorithm.vlog;

/**
 * @author wrp
 * @since 2025-03-18 23:11
 **/
public class C006_BinarySearch {

    /**
     * 判断num是否存在于有序数组arr数组中(暴力解)
     */
    public static boolean existX(int[] arr, int num) {
        for (int j : arr) {
            if (j == num) return true;
        }
        return false;
    }

    /**
     * 判断num是否存在于有序数组arr数组中
     */
    public static boolean exist(int[] arr, int num) {
        if(arr == null || arr.length == 0) return false;
        int l = 0, m, r = arr.length - 1;
        while(l <= r) {
            m = (l + r) / 2;// 可能有溢出问题
            if(arr[m] == num) {
                return true;
            } else if(arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    /**
     * 查询 >=num 的最左位置 (暴力解)
     */
    public static int findLeftX(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= num) return i;
        }
        return -1;
    }
    /**
     * 查询 >=num 的最左位置
     */
    public static int findLeft(int[] arr, int num) {
        int l = 0, m, r = arr.length - 1, res = -1;

        while(l <= r) {
            m = l + ((r - l) >> 1);
            if(arr[m] >= num) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    /**
     * 查询 <=num 的最右位置 (暴力解)
     */
    public static int findRightX(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > num) return i - 1;
        }
        return arr.length - 1;
    }
    /**
     * 查询 <=num 的最右位置
     */
    public static int findRight(int[] arr, int num) {
        int l = 0, m, r = arr.length - 1, res = -1;

        while(l <= r) {
            m = l + ((r - l) >> 1);
            if(arr[m] <= num) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    /**
     * 返回一个峰值。没有则返回-1
     */
    public static int peek(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        int n = arr.length;
        if(n == 1 || arr[0] > arr[1]) return 0;
        if(arr[n - 1] > arr[n - 2]) return n - 1;

        int l = 1, m, r = n - 2, res = -1;
        while(l <= r) {
            m = l + ((r - l) >> 2);
            if(arr[m] < arr[m - 1]) {
                r = m - 1;
            } else if( arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                res = m;
                break;
            }
        }
        return res;
    }
}
