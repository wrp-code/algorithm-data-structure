package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025-03-03 10:48
 **/
public class HJ023 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if(a[i] != 0) {
                min = Math.min(min, a[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(a[s.charAt(i) - 'a'] != min) {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
