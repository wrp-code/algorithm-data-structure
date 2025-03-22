package com.wrp.algorithm.my.improve;

/**
 * @author wrp
 * @since 2025-03-21 22:07
 **/
public class Bloom {

    public static void bitInfo() {
        int[] arr = new int[10]; // 10 * 32 位信息
        int i = 178;

        int numIndex = i / 32;
        int bitIndex = i % 32;

        // 178状态
        int s = (arr[numIndex] >>> bitIndex) & 1;
        // 将178位改成1
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);
        // 将178位改成0
        arr[numIndex] = arr[numIndex] & (~(1 << bitIndex));

    }
}
