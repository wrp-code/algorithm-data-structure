package com.wrp.algorithm.my.basic.sort;

/**
 * 归并排序
 * O(N * logN) 可以用master公式计算
 * @author wrp
 * @since 2024-12-13 22:13
 **/
public class C09_MergeSort {

    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int l , int r) {
        if(l == r) return;

        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m;
        while(p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= m) {
            help[i++] = arr[p1++];
        }
        while(p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[j] = help[j];
        }
    }
}
