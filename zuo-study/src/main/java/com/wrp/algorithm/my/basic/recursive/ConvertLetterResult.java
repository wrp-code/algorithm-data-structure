package com.wrp.algorithm.my.basic.recursive;

/**
 * @author wrp
 * @since 2025-03-17 21:37
 **/
public class ConvertLetterResult {

    public static int convert(String str) {
        return process(str.toCharArray(), 0);
    }

    public static int process(char[] arr, int index) {
        if(index == arr.length) {
            return 1;
        }

        if(index > arr.length || arr[index] == '0') {
            return 0;
        }

        int count = 0;
        count += process(arr, index + 1);
        if(arr[index] == '1' || (arr[index] == '2' && index + 1 < arr.length &&
                '6'>= arr[index + 1] && arr[index + 1]  >= '0')) {
            count += process(arr, index + 2);
        }
        return count;
    }
}
