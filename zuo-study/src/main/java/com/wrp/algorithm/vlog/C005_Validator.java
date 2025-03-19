package com.wrp.algorithm.vlog;

import java.util.Arrays;

/**
 * 对数器
 * @author wrp
 * @since 2025-03-18 22:42
 **/
public class C005_Validator {

    /**
     * 生成一个随机数组
     * @param n 数组长度
     * @param v 数字的最大值
     * @return 范围在 1 ~ v的 数组
     */
    public static int[] randomArray(int n, int v){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

    /**
     * 复制一个数组
     */
    public static int[] copyArray(int[] arr) {
        if(arr == null) return null;
        return Arrays.copyOf(arr, arr.length);
    }

    /**
     * 判断两个数组是否一样
     */
    public static boolean same(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null || arr1.length != arr2.length) return true;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void printArray(int[] arr) {
        if(arr == null) return;
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int n : arr) {
            str.append(n).append(",");
        }

        System.out.println(str.substring(0, str.length() - 1) + "}");
    }

    public static void main(String[] args) {
        int n = 1000;
        int v = 1000;
        int testCount = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testCount; i++) {
            int r = (int) (Math.random() * n);
            int[] arr = randomArray(r, v);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            Arrays.sort(arr);
            C004_Sort.selectSort(arr1);
            C004_Sort.bubbleSort(arr2);
            C004_Sort.insertSort(arr3);
            if(!same(arr, arr1) || !same(arr, arr2) || !same(arr, arr3) || !same(arr1, arr3)) {
                System.out.println("测试出错了，样本：");
                printArray(arr);
                return;
            }
        }
        System.out.println("测试成功");
    }
}
