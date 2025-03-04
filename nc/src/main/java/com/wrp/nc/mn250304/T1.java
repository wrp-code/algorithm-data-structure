package com.wrp.nc.mn250304;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025-03-04 20:00
 **/
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if(a == 0) return;

            System.out.println(a / 2);
        }
    }
}
