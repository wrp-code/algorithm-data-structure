package com.wrp.nc.nc;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025-03-03 16:04
 **/
public class NC037 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();

            int[] dp = new int[a + 1];
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= a; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            System.out.println(dp[a]);
        }
    }
}
