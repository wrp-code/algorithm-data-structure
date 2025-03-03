package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月21日 22:35
 */
public class HJ005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int res = 0;
        int idx = 0;
        int base = 0;
        for (int i = s.length() - 1; i >= 2; i--) {
            int c = s.charAt(i);
            if(c == 'A') {
                base = 10;
            } else if(c == 'B') {
                base = 11;
            } else if(c == 'C') {
                base = 12;
            } else if(c == 'D') {
                base = 13;
            } else if(c == 'E') {
                base = 14;
            } else if(c == 'F') {
                base = 15;
            } else {
                base = c - '0';
            }
//            base = switch (s.charAt(i)) {
//                case 'A' -> 10;
//                case 'B' -> 11;
//                case 'C' -> 12;
//                case 'D' -> 13;
//                case 'E' -> 14;
//                case 'F' -> 15;
//                default -> s.charAt(i) - '0';
//            };
            res += Math.pow(16, idx++) * base;
        }
        System.out.println(res);
    }
}
