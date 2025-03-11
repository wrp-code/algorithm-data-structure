package com.wrp.algorithm.my.basic.sort;

import com.wrp.algorithm.my.common.ArrayUtils;

/**
 * 选择排序
 * O(N²)
 * @author wrp
 * @since 2024-12-12 22:00
 **/
public class C01_SelectionSort {

    /**
     * 升序选择排序
     */
    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        int minIndex;
        // i遍历要处理的位置
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            // 在剩余的位置中选择最小的数
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            ArrayUtils.swap(arr, minIndex, i);
        }
    }
}
