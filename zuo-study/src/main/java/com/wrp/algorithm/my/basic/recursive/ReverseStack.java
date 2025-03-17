package com.wrp.algorithm.my.basic.recursive;

import java.util.Stack;

/**
 * @author wrp
 * @since 2025-03-17 22:01
 **/
public class ReverseStack {

    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return ;
        }
        // 利用系统栈
        int i = lastValue(stack);
        reverse(stack);
        stack.push(i);
    }

    // 获取栈底元素
    public static int lastValue(Stack<Integer> stack) {
        Integer result = stack.pop();
        if(stack.isEmpty()) {
            // 返回最后一个元素
            return result;
        } else {
            int last = lastValue(stack);
            stack.push(result);
            // 传递最后一个元素
            return last;
        }
    }
}
