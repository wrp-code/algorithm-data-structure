package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月22日 0:10
 *
 * n        1010
 * ~n       0101
 * ~n + 1   0110
 * n&(~n+1) 0010
 */
public class HJ15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = 0;
        while(n != 0) {
            int e = n & (~n + 1);
            n ^= e;
            c++;
        }
        System.out.println(c);
    }
}
