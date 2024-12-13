package com.wrp.algorithm.my.basic;

import com.wrp.algorithm.my.common.ArrayUtils;
import com.wrp.algorithm.my.common.ComparatorUtils;

/**
 * 插入排序
 * O(N²)
 * @author wrp
 * @since 2024-12-13 19:50
 **/
public class C04_InsertSort {

    public static void insertionSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j-1] > arr[j]) {
                    ArrayUtils.swap(arr, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        ComparatorUtils.run(C04_InsertSort::insertionSort);
    }
}
