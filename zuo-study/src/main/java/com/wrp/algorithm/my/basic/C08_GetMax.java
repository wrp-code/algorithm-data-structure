package com.wrp.algorithm.my.basic;

/**
 * @author wrp
 * @since 2024-12-13 21:20
 **/
public class C08_GetMax {

    public static int getMax(int[] arr) {
        return getMax(arr, 0, arr.length - 1);
    }

    public static int getMax(int[] arr, int l, int r) {
        if(l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int lMax = getMax(arr, l, mid);
        int rMax = getMax(arr, mid + 1, r);
        return Math.max(lMax, rMax);
    }
}
