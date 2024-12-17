package com.wrp.algorithm.my.basic;

/**
 * 逆序对，归并排序实现
 * @author wrp
 * @since 2024-12-17 23:31
 **/
public class C11_ReversePair {

    public static int reversePair(int[] arr) {
        if(arr == null || arr.length < 2) return 0;

        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if(l == r) {
            return 0;
        }

        int m = l + ((r - l) >> 1);
        return mergeSort(arr, l, m)
                + mergeSort(arr, m + 1, r)
                + merge(arr, l, m, r);
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;

        while(p1 <= m && p2 <= r) {
            if(arr[p1] > arr[p2]) {
                res += m - p1 + 1;
                help[i++] = arr[p2++];
            } else {
                help[i++] = arr[p1++];
            }
        }

        while(p1 <= m) {
            help[i++] = arr[p1++];
        }
        while(p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }

        return res;
    }


}
