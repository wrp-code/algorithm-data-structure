package com.wrp.algorithm.my.basic.chp3;

import com.wrp.algorithm.my.common.ArrayUtils;

/**
 * 堆排序
 * @author wrp
 * @since 2025-02-22 17:11
 **/
public class HeapSort {

    // index位置的元素上浮
    public static void heapInsert(int[] arr, int index) {
        // 此不等式包括了index为根节点的情况。 -1 / 2 == 0；
        while(arr[index] > arr[(index - 1) / 2]) {
            // 如果大于父节点，则交换
            ArrayUtils.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // index位置的元素下沉
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;

        // 有孩子
        while(left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ?
                    left + 1 : left;

            if(arr[largest] > arr[index]) {
                ArrayUtils.swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }
    }
}
