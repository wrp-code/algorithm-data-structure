package com.wrp.nc.mn250304;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025-03-04 20:07
 **/
public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        long res = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'E') {
                res += Math.pow(16, s.length() - i - 3) * (ch - 'A' + 10);
            } else {
                res += Math.pow(16, s.length() - i - 3) * Integer.parseInt("" + ch);
            }
        }
        System.out.println(res);
    }
}
