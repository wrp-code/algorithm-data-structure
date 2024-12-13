package com.wrp.algorithm.my.basic;

/**
 * 二分搜索
 * @author wrp
 * @since 2024-12-13 20:17
 **/
public class C05_BSExist {
    public static boolean exist(int[] sortedArr, int num) {
        if(sortedArr == null || sortedArr.length == 0) return false;

        int l = 0;
        int r = sortedArr.length - 1;
        int mid;
        while (l <= r) {
            mid = ((r - l) >> 1) + l;
            if(sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
