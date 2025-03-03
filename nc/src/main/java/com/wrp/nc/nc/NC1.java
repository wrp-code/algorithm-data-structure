package com.wrp.nc.nc;

import java.util.Stack;

/**
 * @author wrp
 * @since 2025年02月20日 20:01
 */
public class NC1 {

    public static void main(String[] args) {
        System.out.println(solve("733064366", "459309139"));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public static String solve (String s, String t) {
        // write code here
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();
        int sum = 0;
        for (String string : s.split("")) {
            a.push(Integer.parseInt(string));
        }
        for (String string : t.split("")) {
            b.push(Integer.parseInt(string));
        }
        while(!a.empty() && !b.empty()) {
            sum += a.pop() + b.pop();
            c.push(sum % 10);
            sum /= 10;
        }

        while(!a.empty()) {
            sum += a.pop();
            c.push(sum % 10);
            sum /= 10;
        }
        while(!b.empty()) {
            sum += b.pop();
            c.push(sum % 10);
            sum /= 10;
        }
        if(sum != 0) {
            c.push(sum);
        }
        StringBuilder res = new StringBuilder();
        while(!c.isEmpty()) {
            res.append(c.pop());
        }
        return res.toString();
    }
}
