package com.wrp.nc.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wrp
 * @since 2025年02月21日 23:32
 */
public class HJ009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        Set<Integer> set = new HashSet<>();
        int res = 0;
        while(n != 0) {
            int c = n % 10;
            if(!set.contains(c)) {
                set.add(c);
                res = res * 10 + c;
            }
            n /= 10;
        }
        System.out.println(res);
    }
}
