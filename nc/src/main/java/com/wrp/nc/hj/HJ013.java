package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月21日 23:45
 */
public class HJ013 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] arr = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}
