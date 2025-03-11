package com.wrp.nc.cmb;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wrp
 * @since 2025-03-11 21:24
 **/
public class CMB1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if(i != arr[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
