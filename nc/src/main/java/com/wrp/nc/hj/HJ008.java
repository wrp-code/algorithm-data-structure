package com.wrp.nc.hj;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author wrp
 * @since 2025年02月21日 23:19
 */
public class HJ008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            Integer key = in.nextInt();
            map.put(key, map.getOrDefault(key, 0) + in.nextInt());
        }
        map.keySet().forEach(k -> System.out.println(k + " " + map.get(k)));
    }
}
