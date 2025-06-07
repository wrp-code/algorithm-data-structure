package com.wrp.algorithm.vlog;

import com.wrp.algorithm.my.common.ArrayUtils;

import java.util.PriorityQueue;


/**
 * 堆排序, 时间复杂度O(N * logN)
 *
 * 系统默认的堆实现{@link PriorityQueue}
 * @author wrp
 * @since 2025-06-07 09:59
 **/
public class C025_HeapSort {

    // 从顶到底的建堆顺序 O(N*logN)
    // 整体复杂度 O(N * logN)
    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            heapInsert(arr, i);
        }

        int size = n;
        while(size > 1) {
            ArrayUtils.swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    // 从底到顶的建堆顺序 O(N)
    // 整体复杂度 O(N * logN)
    public void heapSort2(int[] arr) {
        int n = arr.length;
        for(int i = n - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        int size = n;
        while(size > 1) {
            ArrayUtils.swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    // 向上调整
    public void heapInsert(int[] arr, int i) {
        while(arr[i] > arr[(i - 1) / 2]) {
            ArrayUtils.swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // 向下调整
    public void heapify(int[] arr, int i, int size) {
        int l = 2 * i + 1;
        while(l < size) {
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            if(arr[i] >= arr[best]) {
                return;
            }

            ArrayUtils.swap(arr, i, best);
            i = best;
            l = 2 * i + 1;
        }
    }


}
