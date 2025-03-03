package com.wrp.nc.hj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wrp
 * @since 2025年02月21日 22:14
 */
public class HJ002 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        String c = in.nextLine();
//        handle(s, c);
        handle("HELLONowcoder123", "o");
    }

    private static void handle(String s, String c) {
        Map<String, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            String key = ("" + array[i]).toLowerCase();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        System.out.println(map.getOrDefault(c.toLowerCase(), 0));
    }
}
