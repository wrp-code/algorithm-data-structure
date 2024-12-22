package com.wrp.algorithm.my.basic;

import com.wrp.algorithm.my.common.ArrayUtils;

/**
 * 荷兰国旗问题1：
 * 一个数组，一个数，小于等于的在左边，大于的在右边。
 * 步骤：
 * 1.arr[i] <= num, arr[i]和小于等于的边界(p)下一位交换，边界右移，i++;
 * 2.arr[i] > num, i++;
 * @author wrp
 * @since 2024-12-22 20:56
 **/
public class C12_NetherlandsFlag1 {

    public static int[] partition(int[] arr, int num) {
        if(arr == null || arr.length < 2) return new int[]{-1};

        int p = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= num) {
                ArrayUtils.swap(arr, ++p, i);
            }
        }
        return new int[]{p};
    }
}
