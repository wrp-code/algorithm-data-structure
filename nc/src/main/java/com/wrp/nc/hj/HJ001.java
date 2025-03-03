package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月21日 22:01
 */
public class HJ001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(len(str));
    }

    public static int len(String str) {
        int i = 0;
        for (int j = str.length() - 1; j >=  0; j--,i++) {
            if(str.charAt(j) == ' ') {
                break;
            }
        }
        return i;
    }
}
