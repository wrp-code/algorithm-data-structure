package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月21日 22:44
 */
public class HJ006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        for (Integer i = 2; i <= Math.sqrt(n); ) {

            if(n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            } else {
                i++;
            }
        }
        System.out.print(n);
    }
}
