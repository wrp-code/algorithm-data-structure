package com.wrp.algorithm.my.basic;

import com.wrp.algorithm.my.common.ArrayUtils;
import com.wrp.algorithm.my.common.ComparatorUtils;

/**
 * 快排v3 O(NlogN); 空间复杂度 O(logN),即递归的次数平均值
 * 1. 随机值一个数与最后一位交换，拿数组最后一个数，让小于这个数在数组左边，等于的在中间，大于的在右边
 * 2. 交换最后一个数和大于的右边的第一个数
 * 3. 左右两边重复1，2操作
 * @author wrp
 * @since 2024-12-22 21:13
 **/
public class C14_QuickSort3 {
    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        partition(arr, 0, arr.length - 1);
    }

    private static void partition(int[] arr, int l, int r) {
        if(l >= r) return;
        int random = (int) (l + (r - l + 1) * Math.random());
        ArrayUtils.swap(arr, random, r);
        int n = arr[r];
        int p1 = l - 1;
        int p2 = r + 1;
        int i = l;
        while(i < p2) {
            if(arr[i] < n) {
                ArrayUtils.swap(arr, ++p1, i++);
            } else if(arr[i] > n) {
                ArrayUtils.swap(arr, --p2, i);
            } else {
                i++;
            }
        }

        if(p2 < r) ArrayUtils.swap(arr, p2, r);

        partition(arr, l, p1);
        partition(arr, p2, r);
    }

    public static void main(String[] args) {
        ComparatorUtils.run(C14_QuickSort1::sort, 100000, 100, 100);
    }
}
