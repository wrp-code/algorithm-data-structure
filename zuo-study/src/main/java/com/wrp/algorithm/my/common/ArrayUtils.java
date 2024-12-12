package com.wrp.algorithm.my.common;

/**
 * @author wrp
 * @since 2024-12-12 22:04
 **/
public class ArrayUtils {

    /**
     * 求i最右的1的值。
     */
    public static int rightOne(int i) {
        return i & (~i + 1);
    }

    /**
     * 交换数组两个位置的值
     */
    public static void swap(int[] arr, int from, int to) {
        if(arr == null) {
            return;
        }

        if(from< 0 || to < 0 || from >= arr.length || to >= arr.length) {
            throw new IllegalArgumentException();
        }

        swap1(arr, from, to);
    }

    private static void swap1(int[] arr, int from, int to) {
        // from 不能等于 to，否则结果为导致from位置值为0
        if(from == to) return;
        arr[from] = arr[from] ^ arr[to];
        arr[to] = arr[from] ^ arr[to];
        arr[from] = arr[from] ^ arr[to];
    }

    private static void swap0(int[] arr, int from, int to) {
        int t = arr[from];
        arr[from] = arr[to];
        arr[to] = arr[t];
    }
}
