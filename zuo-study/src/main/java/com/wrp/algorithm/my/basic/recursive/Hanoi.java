package com.wrp.algorithm.my.basic.recursive;

/**
 * @author wrp
 * @since 2025-03-12 19:58
 **/
public class Hanoi {

    public void hanoi(int n) {
        if(n > 0) {
            process(n, "左", "右", "中");
        }
    }

    public void process(int i, String from, String to, String other) {
        // base case
        if(i == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
            return;
        }
        process(i - 1, from, other, to);
        System.out.println("Move " + i + " from " + from + " to " + to);
        process(i - 1, other, to, from);
    }

    public static void main(String[] args) {
        new Hanoi().hanoi(3);
    }
}
