package com.wrp.algorithm.vlog;

import com.wrp.algorithm.my.common.ArrayUtils;

/**
 * @author wrp
 * @since 2025-06-05 07:51
 **/
public class C024_KthLatest {

    public static int findKthLatest(int[] arr, int k) {
        return getK(arr, arr.length - k);
    }

    static int first;
    static int last;

    public static int getK(int[] arr, int i){
        for(int l = 0, r = arr.length - 1; l <= r;) {
            partition(arr, l, r, arr[(int) (l + (Math.random() * (r - l + 1)))]);

            if(i < first) {
                r = first - 1;
            } else if(i > last) {
                l = last + 1;
            } else {
                return arr[i];
            }
        }
        return -1;
    }

    public static void partition(int[] arr, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while(i <= last) {
            if(arr[i] < x) {
                ArrayUtils.swap(arr, i++, first++);
            } else if(arr[i] > x) {
                ArrayUtils.swap(arr, i, last--);
            } else {
                i++;
            }
        }
    }
}
