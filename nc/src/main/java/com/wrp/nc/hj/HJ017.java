package com.wrp.nc.hj;

import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月23日 11:58
 */
public class HJ017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] split = str.split(";");
        int x = 0;
        int y = 0;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if(s.isEmpty() || s.length() == 1) {
                continue;
            }
            char direct = s.charAt(0);
            int num;
            try {
                num = Integer.parseInt(s.substring(1));
            } catch (Exception e){
                continue;
            }
            if(direct == 'A') {
                x -= num;
            }else if(direct == 'D') {
                x += num;
            }else if(direct == 'W') {
                y += num;
            }else if(direct == 'S') {
                y -= num;
            }
        }
        System.out.println(x + "," + y);
    }
}
