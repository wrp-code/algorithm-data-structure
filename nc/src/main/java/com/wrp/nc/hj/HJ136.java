package com.wrp.nc.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wrp
 * @since 2025-03-04 20:25
 **/
public class HJ136 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();
        // 清楚换行符
        in.nextLine();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        System.out.println(max(arr, 0));
    }

    public static int max(char[][] arr, int idx) {
        if(arr.length == idx) {
            int res = 0;
            for (int j = 0; j < arr[0].length; j++) {
                boolean all1 = true;
                for (int i = 0; i < idx; i++) {
                    if(arr[i][j] == '0'){
                        all1 = false;
                        break;
                    }
                }
                if(all1) res++;
            }
            return res;
        }

        int res = 0;
        for (int i = idx; i < arr.length; i++) {
            res = Math.max(res, max(arr, idx + 1));
            // 反转第i行
            reverse(arr, idx);
            res = Math.max(res, max(arr, idx + 1));
            // 还原
            reverse(arr, idx);
        }
        return res;
    }

    public static void reverse(char[][] arr, int idx) {
        for (int i = 0; i < arr[0].length; i++) {
            arr[idx][i] = arr[idx][i] == '0' ? '1' : '0';
        }
    }
}
