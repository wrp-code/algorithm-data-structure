package com.wrp.nc.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wrp
 * @since 2025年02月21日 23:38
 */
public class HJ010 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        System.out.println(set.size());
    }
}
