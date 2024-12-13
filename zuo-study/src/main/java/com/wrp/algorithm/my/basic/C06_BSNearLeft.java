package com.wrp.algorithm.my.basic;

/**
 * 二分搜索扩展
 * 在arr上，找满足>=value的最左位置
 * @author wrp
 * @since 2024-12-13 20:30
 **/
public class C06_BSNearLeft {
    public static int nearestIndex(int[] arr, int value) {
        int t = -1;
        if(arr == null || arr.length == 0) return t;

        int l = 0;
        int r = arr.length;
        int mid;
        while(l <= r) {
            mid = l + ((r - l) >> 1);
            if(arr[mid] >= value) {
                r = mid - 1;
                t = mid;
            } else {
                l = mid + 1;
            }
        }
        return t;
    }
}
