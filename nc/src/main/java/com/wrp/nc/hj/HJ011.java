package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月21日 23:40
 */
public class HJ011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n != 0) {
            System.out.print(n % 10);
            n /= 10;
        }
    }
}
