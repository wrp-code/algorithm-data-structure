package com.wrp.algorithm.vlog;

import java.util.Stack;

/**
 * 最小栈的实现
 * @author wrp
 * @since 2025-03-31 07:52
 **/
public class C015_MinQueue {

    class MyStack1 {
        // 系统带的栈O(1),但是常数项不好，性能慢
        Stack<Integer> data;
        Stack<Integer> min;

        public MyStack1() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if(min.isEmpty() || x <= min.peek()) {
                min.push(x);
            } else {
                min.push(min.peek());
            }
        }

        public int pop() {
            min.pop();
            return data.pop();
        }

        public int peek() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    class MyStack2 {
        // 自己实现栈
        int[] data;
        int[] min;
        int size;
        final int DEFAULT = 10000;

        public MyStack2() {
            data = new int[DEFAULT];
            min = new int[DEFAULT];
        }

        public void push(int x) {
            data[size] = x;
            if(size == 0 || x <= min[size]) {
                min[size] = x;
            } else {
                min[size] = min[size - 1];
            }
            size++;
        }

        public int pop() {
            return data[--size];
        }

        public int peek() {
            return data[size - 1];
        }

        public int getMin() {
            return min[size - 1];
        }
    }
}
