package com.wrp.algorithm.my.basic.recursive;

/**
 * 两个人，只能从最左或者最右拿，如何拿才会赢
 * @author wrp
 * @since 2025-03-12 21:40
 **/
public class HowWin {

    public int win(int[] arr) {
        if(arr == null || arr.length == 0) return 0;

        return Math.max(first(arr, 0, arr.length), second(arr, 0, arr.length));
    }

    public int first(int[] arr, int l, int r) {
        if(l == r) {
            return arr[l];
        }

        return Math.max(arr[l] + second(arr, l + 1, r), arr[r] + second(arr, l, r - 1));
    }

    public int second(int[] arr, int l, int r) {
        if(l == r) {
            return 0;
        }

        return Math.min(first(arr, l + 1, r), first(arr, l, r - 1));
    }
}
