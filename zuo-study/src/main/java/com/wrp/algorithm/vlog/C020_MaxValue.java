package com.wrp.algorithm.vlog;

/**
 * @author wrp
 * @since 2025-05-07 07:07
 **/
public class C020_MaxValue {

    public int maxValue(int[] arr) {
        return maxValue(arr, 0, arr.length - 1);
    }

    public int maxValue(int[] arr, int l, int r) {
        if(l == r) {
            return arr[l];
        }

        int m = l + (r - l) / 2;
        int lMax = maxValue(arr, l, m);
        int rMax = maxValue(arr, m + 1, r);
        return Math.max(lMax, rMax);
    }
}
