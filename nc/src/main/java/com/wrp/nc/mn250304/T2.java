package com.wrp.nc.mn250304;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wrp
 * @since 2025-03-04 20:05
 **/
public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = in.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < a; i++) {
            set.add(in.nextInt());
        }
        set.stream().forEach(System.out::println);
    }
}
