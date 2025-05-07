package com.wrp.algorithm.vlog;

import java.io.*;

/**
 * 为什么归并排序比选择排序快？
 *      因为没有浪费比较结果
 *
 * 不要相信原地归并排序，把空间复杂度变成O(1)，这样时间复杂度会降为O(N^2)
 * @author wrp
 * @since 2025-05-07 19:28
 **/
public class C021_MergeSort {

    public static final int MAX_N = 501;
    public static int[] arr = new int[MAX_N];
    public static int[] help = new int[MAX_N];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while(in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }

            mergeSort(0, n - 1);
        }

        out.flush();
        out.close();
    }

    /**
     *
     * 递归：
     * T(N) = 2 * T(N / 2) + O(N)
     * a = 2, b = 2, c = 1
     * master公式：log(a,b) = c
     * 时间复杂度为O(N*logN)
     * 空间复杂度O(N)
     *
     */
    public static void mergeSort(int l, int r) {
        if(l == r) return;

        int m = l + (r - l) / 2;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
    }

    public static void merge(int l, int m, int r) {
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

        // 刷回arr
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
    }

    // 非递归版
    public static void mergeSort() {
        for(int l, m, r, step = 1; step < n; step >>= 1) {
            l = 0;
            while(l < n) {
                m = l + step - 1;
                if(m + 1 >= n) {
                    // 此时没有右边界了，说明本轮merge已经完成
                    break;
                }
                // 右边界可能取不足step
                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(l, m, r);
                // 下一部分的mergeSort
                l = r + 1;
            }
        }
    }
}
