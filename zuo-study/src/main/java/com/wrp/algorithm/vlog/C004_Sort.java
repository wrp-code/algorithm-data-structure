package com.wrp.algorithm.vlog;


import com.wrp.algorithm.my.common.ArrayUtils;

/**
 * @author wrp
 * @since 2025-03-18 22:13
 **/
public class C004_Sort {

    // 升序选择排序
    public static void selectSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            ArrayUtils.swap(arr, i, min);
        }
    }

    // 升序冒泡排序
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    // 升序插入排序
    public static void insertSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                ArrayUtils.swap(arr, j - 1, j);
            }
        }
    }
}
