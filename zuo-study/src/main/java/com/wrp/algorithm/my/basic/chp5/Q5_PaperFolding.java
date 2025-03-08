package com.wrp.algorithm.my.basic.chp5;

/**
 * 折纸问题
 * @author wrp
 * @since 2025-03-08 16:31
 **/
public class Q5_PaperFolding {

    public static void main(String[] args) {
        int n = 7;
        printFolding(n);
    }

    public static void printFolding(int n) {
        printProcess(1, n, true);
    }

    public static void printProcess(int i, int n, boolean ao) {
        if(i > n) return;

        printProcess(i+1, n, true);
        System.out.println(ao ? "凹" : "凸");
        printProcess(i+1, n, false);
    }
}
