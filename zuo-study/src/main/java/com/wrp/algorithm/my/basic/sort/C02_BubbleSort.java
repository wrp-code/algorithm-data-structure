package com.wrp.algorithm.my.basic.sort;

import com.wrp.algorithm.my.common.ArrayUtils;

/**
 * 冒泡排序
 * O(N²)
 * @author wrp
 * @since 2024-12-12 22:15
 **/
public class C02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            // 遍历j，每次将最大的值放在i。
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }
}
