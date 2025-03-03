package com.wrp.nc.hj;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author wrp
 * @since 2025-03-03 11:33
 **/
public class HJ70 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Map<Character, Matrix> map = new TreeMap<>();
        char key = 'A';
        while(count-- != 0) {
            map.put(key, new Matrix(in.nextInt(), in.nextInt()));
            key++;
        }
        in.nextLine();
        String s = in.nextLine();
        Stack<Matrix> stack = new Stack<>();
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if(ch == '(') {
                continue;
            } else if(ch == ')') {
                // 出栈
                Matrix m1 = stack.pop();
                Matrix m2 = stack.pop();
                res += m2.m * m2.n * m1.n;
                stack.push(new Matrix(m2.m, m1.n));
            } else {
                // 入栈
                stack.push(map.get(ch));
            }
        }
        System.out.println(res);
    }

    static class Matrix {
        int m;
        int n;

        public Matrix(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }
}
