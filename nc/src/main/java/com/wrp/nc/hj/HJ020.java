package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025-03-03 10:12
 **/
public class HJ020 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            boolean num = false;
            boolean bigChar = false;
            boolean smallChar = false;
            boolean spacialChar = false;
            if(s.length() < 8) {
                System.out.println("NG");
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c >= 48 && c <=57) {
                    num = true;
                } else if(c >= 65 && c <=90) {
                    bigChar = true;
                } else if(c >= 97 && c <=122) {
                    smallChar = true;
                } else {
                    spacialChar = true;
                }
            }
            int count = 0;
            if(num) count++;
            if(bigChar) count++;
            if(smallChar) count++;
            if(spacialChar) count++;

            // 检查重复子串
            if(count >= 3 && !hasSubStr(s)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    private static boolean hasSubStr(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 3+i; j < s.length(); j++) {
                if(s.substring(j).contains(s.substring(i,j))) {
                    return true;
                }
            }
        }

        return false;
    }
}
