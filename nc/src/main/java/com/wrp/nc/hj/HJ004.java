package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月21日 22:31
 */
public class HJ004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            c++;
            System.out.print(s.charAt(i));
            if(c == 8) {
                System.out.println();
                c = 0;
            }
        }
        for (int i = c; i < 8; i++) {
            System.out.print(0);
        }
    }
}
