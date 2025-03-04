package com.wrp.nc.bh;

import java.util.Scanner;

/**
 * 必会1
 * https://leetcode.cn/discuss/post/3162635/hua-wei-ji-shi-ti-by-yaozi-9-k4k8/
 * @author wrp
 * @since 2025-03-04 19:25
 **/
public class BH1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String k = scanner.nextLine();
            String s = scanner.nextLine();
            System.out.println(split(s, Integer.parseInt(k)));
        }
    }

    public static String split(String s, int len) {
        StringBuilder sb = new StringBuilder(s.substring(0, s.indexOf("-")));
        String str = s.substring(s.indexOf("-") + 1).replaceAll("-", "");
        int i = 0;
        for (; i < str.length(); i += len) {
            String cur = str.substring(i, Math.min(i+len, str.length()));
            sb.append("-").append(post(cur));
        }
        return sb.toString();
    }

    private static String post(String cur) {
        int big = 0;
        int small = 0;
        for (int i = 0; i < cur.length(); i++) {
            char ch = cur.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                small++;
            } else if(ch >= 'A' && ch <= 'Z') {
                big++;
            }
        }
        return big > small ? cur.toUpperCase() : (big < small ? cur.toLowerCase() : cur);
    }
}
