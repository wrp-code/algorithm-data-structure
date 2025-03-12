package com.wrp.algorithm.my.basic.recursive;

/**
 * @author wrp
 * @since 2025-03-12 20:44
 **/
public class PrintSub {

    public static void print(String str) {
        process(str.toCharArray(), 0);
    }

    public static void process(char[] arr, int i) {
        if(i == arr.length) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == 0) {
                    continue;
                }
                System.out.print(arr[j]);
            }
            System.out.println();
            return;
        }

        process(arr, i + 1);
        char temp = arr[i];
        arr[i] = 0;
        process(arr, i + 1);
        arr[i] = temp;
    }

    public static void main(String[] args) {
        print("abc");
    }
}
