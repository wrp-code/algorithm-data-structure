package com.wrp.nc.hj;

import java.util.*;

/**
 * @author wrp
 * @since 2025-03-03 11:49
 **/
public class HJ027 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        String x = split[split.length - 2];
        if(x.length() == 1) {
            System.out.println(0);
            return;
        }
        int num = Integer.parseInt(split[split.length - 1]);
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt(split[0]); i++) {
            if(broStr(x, split[i])) {
                list.add(split[i]);
            }
        }

        System.out.println(list.size());
        if(num <= list.size()) {
            // 字典序
            Collections.sort(list);
            System.out.println(list.get(num - 1));
        }
    }

    private static boolean broStr(String x, String s) {
        if(x.length() != s.length() || x.equals(s)) {
            return false;
        }

        //判断字符是否相同
        char[] xArr = x.toCharArray();
        char[] sArr = s.toCharArray();
        Arrays.sort(xArr);
        Arrays.sort(sArr);
        if(!Arrays.equals(xArr, sArr)) {
            return false;
        }


        return true;
    }
}