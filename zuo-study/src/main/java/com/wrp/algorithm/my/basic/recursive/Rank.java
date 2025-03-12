package com.wrp.algorithm.my.basic.recursive;


import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * @author wrp
 * @since 2025-03-12 20:51
 **/
public class Rank {

    public static final List<String> res = new ArrayList<>();

    public static void rankAll(String str) {
        process(str.toCharArray(), 0);
    }

    public static void process(char[] arr, int i) {
        if(i == arr.length) {
            res.add(String.valueOf(arr));
            return;
        }

        boolean[] visit = new boolean[26];
        for (int j = i; j < arr.length; j++) {
            // 分支限界，i位置如果出现过某字符后，就不再尝试
            if(visit[arr[j] - 'a']) {
                continue;
            }
            visit[arr[j] - 'a'] = true;
            // 任意一个j ~arr.length字符都可以在i位置
            swap(arr, j, i);
            process(arr, j + 1);
            // 还原
            swap(arr, j, i);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        rankAll("abca");
        res.stream().forEach(System.out::println);
    }
}
