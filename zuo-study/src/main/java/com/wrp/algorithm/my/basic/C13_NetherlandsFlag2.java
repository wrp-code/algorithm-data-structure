package com.wrp.algorithm.my.basic;

import com.wrp.algorithm.my.common.ArrayUtils;

import java.lang.reflect.Array;

/**
 * 荷兰国旗问题1：
 * 一个数组，一个数，小于的在左边，等于的在中间，大于的在右边。
 * 步骤：
 * 1.arr[i] < num, arr[i]和小于的边界(p1)下一位交换，边界右移，i++;
 * 2. arr[i] = num，i++
 * 2.arr[i] > num, arr[i]和大于的边界(p2)前一位交换，边界左移;
 * @author wrp
 * @since 2024-12-22 20:56
 **/
public class C13_NetherlandsFlag2 {

    public static int[] partition(int[] arr, int num) {
        if(arr == null || arr.length < 2) return new int[]{-1, -1};

        int p1 = -1;
        int p2 = arr.length;
        int i = 0;
        while(i < p2) {
            if(arr[i] < num) {
                ArrayUtils.swap(arr, ++p1, i++);
            } else if(arr[i] == num) {
                i++;
            } else {
                ArrayUtils.swap(arr, --p2, i);
            }
        }
        return new int[]{p1, p2};
    }
}
