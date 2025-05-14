package com.wrp.algorithm.vlog;

import com.wrp.algorithm.my.common.ArrayUtils;

import java.io.*;

/**
 * 荷兰国旗版随机快排，每次搞定一类数 O(N*logN) 空间复杂度O(logN)
 * @author wrp
 * @since 2025-05-14 08:02
 **/
public class C023_2_QuickSort {

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

        int x = arr[l + (int) (Math.random() * (r - l + 1))];

        Info info = partition(l, r, x);
        quickSort(l, info.l - 1);
        quickSort(info.r + 1, r);
    }

    public static Info partition(int l, int r, int x) {
        int i = l;
        int k = r;
        int j = l;
        while(j <= k) {
            if(arr[j] < x) {
                ArrayUtils.swap(arr, i++, j++);
            } else if(arr[j] > x) {
                ArrayUtils.swap(arr, j, k--);
            } else {
                j++;
            }
        }

        return new Info(i, k);
    }

    record Info(int l, int r){}

}
