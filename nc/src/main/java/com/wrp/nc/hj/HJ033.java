package com.wrp.nc.hj;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author wrp
 * @since 2025-03-03 11:08
 **/
public class HJ033 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        String[] split = ip.split("\\.");
        long res = 0;
        for (int i = 0; i < split.length; i++) {
            Long num = Long.parseLong(split[i]);
            res += num << (8 * (3 - i));
        }
        System.out.println(res);

        long l = in.nextLong();
        System.out.println((l>>>24) + "." + ((l >>> 16) % 256) + "." + ((l >>> 8) % 256) + "." + ((l % 256)));
    }
}
