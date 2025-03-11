package com.wrp.algorithm.my.basic.pretrie;

import com.wrp.algorithm.zuo.basic.chp7.Code02_LowestLexicography;

import java.util.Arrays;

/**
 * 给一个字符串数组，如何拼接这些字符串，让结果的字典序最小
 * @author wrp
 * @since 2025-03-11 08:11
 **/
public class LowestLexicography {

    public static String append(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        Arrays.sort(strArr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", strArr);
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(append(strs1).equals(Code02_LowestLexicography.lowestString(strs1)));

        String[] strs2 = { "ba", "b" };
        System.out.println(append(strs2).equals(Code02_LowestLexicography.lowestString(strs2)));

    }
}
