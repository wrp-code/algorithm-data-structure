package com.wrp.algorithm.vlog;

import java.io.*;

/**
 * 小和问题
 * @author wrp
 * @since 2025-05-13 07:52
 **/
public class C022_1_SmallSum {

    public static final int MAX_N = 10000;
    public static final int[] arr = new int[MAX_N];
    public static final int[] help = new int[MAX_N];

    public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);
            StreamTokenizer in = new StreamTokenizer(bufferedReader);
            while(in.nextToken() != StreamTokenizer.TT_EOF) {
                int n = (int) in.nval;
                for (int i = 0; i < n; i++) {
                    in.nextToken();
                    arr[i] = (int) in.nval;
                }

                out.println(smallSum(0, n - 1));
            }
            out.flush();
            out.close();
            bufferedReader.close();
    }

    private static long smallSum(int l, int r) {
        if(l == r) {
            return 0;
        }
        int m = l + (r - l) / 2;
        return smallSum(0, m) + smallSum(m + 1, r) + merge(l, m, r);
    }

    private static long merge(int l , int m , int r) {
        int ans = 0;
        int i = l;
        int a = l;
        int b = m + 1;
        while(a <= m && b <= r) {
            if( arr[a] <= arr[b]) {
                help[i++] =  arr[a];
                // 计算小和
                ans += (r - b + 1) * arr[a++];
            } else {
                help[i++] = arr[b++];
            }
        }
        while(a <= m) {
            help[i++] = arr[a++];
        }
        while(b <= r) {
            help[i++] = arr[b++];
        }
        System.arraycopy(help, l, arr, l, r - l + 1);
        return ans;
    }
}
