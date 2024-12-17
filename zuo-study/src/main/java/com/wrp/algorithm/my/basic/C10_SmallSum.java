package com.wrp.algorithm.my.basic;

/**
 * 小和问题
 * @author wrp
 * @since 2024-12-17 22:05
 **/
public class C10_SmallSum {

    public static int smallSum(int[] arr) {
        if(arr == null || arr.length < 2) return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if(l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        int sum1 = mergeSort(arr,l, mid);
        int sum2 = mergeSort(arr, mid + 1, r);
        int sum3 = merge(arr, l, mid, r);
        return sum1 + sum2 + sum3;
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while(p1 <= mid && p2 <= r) {
            // 先拷贝右边
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= mid) {
            help[index++] = arr[p1++];
        }

        while(p2 <= r) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

        return res;
    }
}
