package com.wrp.algorithm.my.basic;

/**
 * 无序数组,相邻的数一定不同,找出一个局部最小值，O(logN)
 * @author wrp
 * @since 2024-12-13 20:40
 **/
public class C07_BSAwesome {

    public static int localMin(int[] arr) {
        if(arr == null || arr.length < 2) return -1;

        if(arr[0] < arr[arr.length - 1]) {
            return 0;
        }

        if(arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int l = 0;
        int r = arr.length - 1;
        int mid;
        while(l <= r) {
            mid = l + ((r - l) >> 2);
            // 局部最小值小于相邻的值
            if(arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                return mid;
            }

            if(arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
