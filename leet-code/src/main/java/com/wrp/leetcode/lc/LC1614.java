package com.wrp.leetcode.lc;

/**
 * @author wrp
 * @since 2025-03-03 16:21
 **/
public class LC1614 {

    public static void main(String[] args) {
        System.out.println(maxDepth("()(())((()()))"));
    }

    public static int maxDepth(String s) {
        int maxDepth = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                temp++;
            } else if(s.charAt(i) == ')') {
                temp--;
            }
            maxDepth = Math.max(maxDepth, temp);
        }
        return maxDepth;
    }
}
