package com.wrp.algorithm.my.improve;

/**
 * @author wrp
 * @since 2025-03-30 10:52
 **/
public class Kmp {

    public static int indexOfKMP(String source, String target) {
        if(source == null || source.isEmpty() ||
                target == null || target.isEmpty() ||
                source.length() < target.length()) {
            return -1;
        }

        int[] next = getNext(target);
        // 指向source
        int idx1 = 0;
        // 指向target
        int idx2 = 0;
        // O(N)
        while(idx1 < source.length() && idx2 < target.length()) {
            if(source.charAt(idx1) == target.charAt(idx2)) {
                // 两个指针均往前
                idx1++;
                idx2++;
            } else if(idx2 == 0) {
                // idx2已经到target的0位置了
                idx1++;
            } else {
                // idx2往前挪
                idx2 = next[idx2];
            }
        }

        // idx2越界，说明是已经找到target了。
        return idx2 == target.length() ? idx1 - idx2 : -1;
    }

    // O(M)
    private static int[] getNext(String target) {
        if(target.length() == 1) {
            return new int[] {-1};
        }
        int[] next = new int[target.length() -1];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;// 最大值； i-1位置与cn位置比较
        while( i <= next.length) {
            if(target.charAt(i) == target.charAt(cn)) {
                // 设置i位置的最大前缀 == 最大后缀数
                // 值为cn 值 + 1
                // cn + 1 位置是下一个i - 1位置的相对应位置
                next[i++] = ++cn;
            } else if(cn > 0) {
                // 往前挪
                cn = next[cn];
            } else {
                // 达到0位置后，无法往前，设置为0
                next[i++] = 0;
            }
        }
        return next;
    }

    // 暴力解
    public static int indexOf(String source, String target) {
        if(source == null || source.isEmpty() ||
            target == null || target.isEmpty() ||
            source.length() < target.length()) {
            return -1;
        }


        for (int i = 0; i < source.length() - target.length(); i++) {
            if(same(source, i, target)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean same(String source, int offset, String target) {
        for (int j = 0; j < target.length(); j++) {
            if(source.charAt(offset + j) != target.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
