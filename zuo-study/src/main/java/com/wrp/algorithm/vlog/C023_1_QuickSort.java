package com.wrp.algorithm.vlog;

import com.wrp.algorithm.my.common.ArrayUtils;

import java.io.*;

/**
 * 经典快排，每次只搞定一个数
 * @author wrp
 * @since 2025-05-14 08:02
 **/
public class C023_1_QuickSort {

    public static final int MAX_N = 1000;

    public static final int[] arr = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(System.out);
        while(in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            for (int i = 0; i < n; i++,in.nextToken()) {
                arr[i++] = (int) in.nval;
            }
            quickSort(0, n - 1);
        }
        out.flush();
    }

    public static void quickSort(int l, int r) {
        if(l >= r) return;

        int x = arr[(int) (l + Math.random() * (r - l + 1))];

        int p = partition(l, r, x);
        quickSort(l, p - 1);
        quickSort(p + 1, r);
    }

    public static int partition(int l, int r, int x) {
        int i = l;
        // 记录x的一个位置
        int ai = l;
        for (int j = l; j < r; j++) {
            if(arr[j] <= x) {
                ArrayUtils.swap(arr, i, j);
                if(arr[ai] == x) {
                    ai = j;
                }
                i++;
            }
        }

        // i-1位置放x
        ArrayUtils.swap(arr, ai, i - 1);
        return i - 1;
    }
}
