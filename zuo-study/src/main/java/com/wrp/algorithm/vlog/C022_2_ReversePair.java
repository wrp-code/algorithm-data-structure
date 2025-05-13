package com.wrp.algorithm.vlog;

import java.io.*;

/**
 * @author wrp
 * @since 2025-05-13 19:24
 **/
public class C022_2_ReversePair {

    public static final int MAX_N = 1000;

    public static final int[] arr = new int[MAX_N];
    public static final int[] help = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(System.out);
        while(in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            for (int i = 0; i < n; i++,in.nextToken()) {
                arr[i++] = (int) in.nval;
            }

            out.write(reversePair(0, n - 1));
        }
        out.flush();
    }

    public static int reversePair(int l, int r) {
        if(l == r) return 0;

        int m = l + (r - l) >> 2;
        return reversePair(l, m) + reversePair(m + 1, r) + merge(l, m, r);
    }

    public static int merge(int l, int m, int r) {
        int ans = 0;
        // 遍历左边
        for(int i = l,j = m + 1; i <= m; i++) {
            // 翻转对 arr[i] > 2 * arr[j],i < j
            while(j <= r && arr[i] > 2 * arr[j]) {
                j++;
            }
            ans += j - m - 1;
        }

        int i = l;
        int a = l;
        int b = m + 1;
        while(a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }

        while(a <= m) {
            help[i++] = arr[a++];
        }
        while(b <= r) {
            help[i++] = arr[b++];
        }

        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return ans;
    }
}
