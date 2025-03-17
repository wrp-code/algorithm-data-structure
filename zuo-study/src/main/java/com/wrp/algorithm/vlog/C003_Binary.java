package com.wrp.algorithm.vlog;

/**
 * @author wrp
 * @since 2025-03-17 22:56
 **/
public class C003_Binary {

    // long时 num & (1L << 59)
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {

            if((num & (1 << i)) == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer i = Integer.valueOf("11010111", 2);
        System.out.println(i);
    }
}
