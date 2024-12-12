package com.wrp.algorithm.my.basic;

import com.wrp.algorithm.my.common.ArrayUtils;

/**
 * int[]数组
 * 情况1，有一个数为奇数个，其他数为偶数个，求奇数个的数
 * 情况2，有两个数为奇数个，其他数为偶数个，求奇数的两个数
 *
 * hash词频统计可以求算。这里使用位异或运算
 * @author wrp
 * @since 2024-12-12 22:49
 **/
public class C03_EvenTimesOddTimes {

    /**
     * 奇数个
     */
    public void oddTimes(int[] arr) {
        int e = 0;
        for (int i : arr) {
            e ^= i;
        }
        System.out.println(e);
    }

    /**
     * 偶数个，假设 a 或 b 为奇数所求值
     */
    public void evenTimes(int[] arr) {
        // e的结果是 a ^ b
        int e = 0;
        for (int i : arr) {
            e ^= i;
        }

        // 求e,最右的1
        int t = ArrayUtils.rightOne(e);

        // ei的结果是 a 或者b
        int ei = 0;
        for (int i : arr) {
            if((t & i) == 1) {
                ei ^= i;
            }
        }

        System.out.println(ei);
        // 与ei不同的另一个奇数值
        System.out.println(e ^ ei);
    }
}
