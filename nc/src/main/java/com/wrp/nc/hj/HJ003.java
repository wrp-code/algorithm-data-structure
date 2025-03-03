package com.wrp.nc.hj;

import java.util.*;

/**
 * @author wrp
 * @since 2025年02月21日 22:22
 */
public class HJ003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        list.stream().distinct().sorted(Integer::compareTo).forEach(System.out::println);
    }
}
