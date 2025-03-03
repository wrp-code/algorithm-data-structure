package com.wrp.nc.hj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月21日 23:43
 */
public class HJ012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
    }
}
