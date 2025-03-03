package com.wrp.nc;

import java.util.Arrays;

/**
 * @author wrp
 * @since 2025年02月20日 21:37
 */
public class NC10 {

    public static void main(String[] args) {
        System.out.println(solve("733064366","459309139"));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public static String solve (String s, String t) {
        // write code here
        if("0".equals(s) || "0".equals(t)){
            return "0";
        }
        int sl = s.length();
        int tl = t.length();
        int[] arr = new int[sl + tl];
        int temp;
        for (int i = sl - 1; i >= 0; i--) {
            int a = s.charAt(i) - '0';
            for (int j = tl - 1; j >= 0; j--) {
                int b = t.charAt(j) - '0';
                temp = a * b + arr[i + j + 1];
                arr[i + j + 1] = temp % 10;
                arr[i + j] += temp / 10;
            }
        }
        int first = 0;
        while(arr[first] == 0) {
            first++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = first; i < arr.length; i++) {
            res.append(arr[i]);
        }
        return res.toString();
    }
}
